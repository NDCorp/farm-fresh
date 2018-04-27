package com.netsky.farmfresh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.netsky.farmbackend.dao.FarmerDAO;
import com.netsky.farmbackend.dao.FarmerTypeDAO;
import com.netsky.farmbackend.dao.UserTypeDAO;
import com.netsky.farmbackend.dto.Farm;
import com.netsky.farmbackend.dto.Farmer;
import com.netsky.farmbackend.dto.FarmerType;
import com.netsky.farmbackend.dto.UserType;
import com.netsky.farmfresh.tools.controller.ToolBox;
import com.netsky.farmbackend.dao.BuyerDAO;
import com.netsky.farmbackend.dao.FarmDAO;

@Controller
public class LoginController extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	public static final long serialVersionUID = 1L;
	
	@Autowired FarmerDAO farmerDAO;
	@Autowired BuyerDAO buyerDAO;
	@Autowired FarmDAO farmDAO;
	@Autowired FarmerTypeDAO fTypeDAO;
	@Autowired UserTypeDAO uTypeDAO;
	
	//Farmer or Admin create account (Registration)
	@RequestMapping(value = "/registration", method = RequestMethod.POST)	
	protected ModelAndView CreateUser(HttpServletRequest req, HttpServletResponse resp, RedirectAttributes redirectAttributes) 
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("redirect:/farmers");
		HttpSession session = req.getSession(true);
		String desc, pic, position, website, midName, uTypeId;
		
		try 
		{	//if a user session exists, redirect to home with a message: user already connected..
			if(session.getAttribute("username") != null)
			{
				//add a message: user already connected..
				redirectAttributes.addFlashAttribute("message", session.getAttribute("username") + " is already connected.");
			}
			else //a user session doesn't exist, so open registration form to create a new one
			{
				//** First, create a new farm: DateDeleted = null, Is Active = true
				Farm farm = new Farm();
				farm.setName(req.getParameter("m_ffname"));
				desc = req.getParameter("m_ffdescription");
				farm.setDescription((!desc.isEmpty() && desc != null)? desc: null);
				farm.setHeadLine(req.getParameter("m_ffheadline"));
				farm.setDateCreated(ToolBox.GetCurrentDate());
				pic = req.getParameter("m_fpicture");
				farm.setPicture((!pic.isEmpty() && pic != null)? pic: null);
				
				//Create a new farm
				farmDAO.add(farm);
				
				//** Second, Get the farmerType with Id = 1
				FarmerType fType = new FarmerType();
				fType = fTypeDAO.get(1);	
				
				//** Third, create a new farmer object and initialize its properties
				Farmer farmer = new Farmer();
				
				//Get the userType
				UserType uType = new UserType();
				uTypeId = req.getParameter("select-utype");
				uType = uTypeDAO.get(Integer.parseInt(uTypeId));
				
				//Create farmer
				farmer.setUserType(uType);
				farmer.setFirstName(req.getParameter("m_fname"));
				farmer.setLastName(req.getParameter("m_lname"));
				midName = req.getParameter("m_mname");
				farmer.setMiddleName((!midName.isEmpty() && midName != null)? midName: null);
				farmer.setEmail(req.getParameter("m_email"));
				farmer.setPhone(req.getParameter("m_phone"));
				farmer.setPassword(ToolBox.GetMD5(req.getParameter("m_password")));	//!!!! Annotations + Validate password m_password and m_cpassword
				pic = req.getParameter("m_upicture");
				farmer.setPicture((!pic.isEmpty() && pic != null)? pic: null);
				farmer.setDateCreated(ToolBox.GetCurrentDate());
				
				farmer.setFarm(farm);
				farmer.setFarmerType(fType);
				position = req.getParameter("m_position");
				farmer.setPositionName((!position.isEmpty() && position != null)? position: null);
				website = req.getParameter("m_website");
				farmer.setWebSite((!website.isEmpty() && website != null)? website: null);
				
				farmerDAO.add(farmer);
				
				//** Save session user variables. set session to expire in 15 min = 900sec
				session.setAttribute("username", farmer.getEmail());
				session.setAttribute("pass", farmer.getPassword());
				session.setAttribute("name", farmer.getFirstName() + " " + farmer.getLastName());
				session.setMaxInactiveInterval(900);
				
				//** Save cookie user variables. set cookie to expire in 15 min = 900sec
				Cookie userName =  new Cookie("username", farmer.getEmail());
				userName.setMaxAge(900);
				resp.addCookie(userName);
				
				//Redirect to the home page
				//resp.sendRedirect("index");
				//redirectAttributes.addFlashAttribute("message", session.getAttribute("username") + " created.");			
			}	
			
			return mv;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return new ModelAndView("redirect:/index");
		}
	}
	
	//Farmer or Admin Login 
	@RequestMapping(value = "/loguserin", method = RequestMethod.POST)	
	protected ModelAndView LogUserIn(HttpServletRequest req, HttpServletResponse resp, RedirectAttributes redirectAttributes) 
			throws ServletException, IOException {
		
		ModelAndView mv;
		HttpSession session = req.getSession(true);
		String uName = "", uPassword = "", uBDPassword ="", rememberUser = "";
		
		try
		{
			//First, get user login informations
			uName = req.getParameter("email");
			uPassword = ToolBox.GetMD5(req.getParameter("login-password"));
			rememberUser = req.getParameter("remember");
			
			//Second, find the user in the DB
			Farmer farmer = new Farmer();
			farmer = farmerDAO.getFarmerByEmail(uName);
			
			//If not found, return to login page with a message
			if (farmer == null)
			{
				mv = new ModelAndView("redirect:/login");
				redirectAttributes.addFlashAttribute("message", "Farmer or Admin account not found. Try again or create a new user.");			
			}
			else
			{
				//Validate password
				uBDPassword = farmer.getPassword();
				PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				uPassword = passwordEncoder.encode(uPassword);
				
				//password not valid
				if (!passwordEncoder.matches(uBDPassword, uPassword))
				{
					mv = new ModelAndView("redirect:/login");
					redirectAttributes.addFlashAttribute("message", "Invalid password, please try again");				
				}
				else	//User found, password valid
				{
					mv = new ModelAndView("redirect:/farmers");
					//redirectAttributes.addFlashAttribute("message", farmer.getEmail() + " connected");
					
					//** Save session user variables. set session to expire in 2 min = 900sec
					session.setAttribute("username", farmer.getEmail());
					session.setAttribute("pass", farmer.getPassword());
					session.setAttribute("name", farmer.getFirstName() + " " + farmer.getLastName());
					session.setMaxInactiveInterval(900);
					
					//** Save cookie user variables. set cookie to expire in 2 min = 900sec
					Cookie userName =  new Cookie("username", farmer.getEmail());
					userName.setMaxAge(900);
					resp.addCookie(userName);
				}
			}
			
			return mv;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return new ModelAndView("redirect:/login");
		}
		
	}
}
