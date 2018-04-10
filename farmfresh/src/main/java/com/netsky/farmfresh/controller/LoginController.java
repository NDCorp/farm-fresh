package com.netsky.farmfresh.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		String desc, pic, position, website, midName, uTypeId;
		
		try 
		{		
			//** First, create a new farm: DateDeleted = null, Is Active = true
			Farm farm = new Farm();
			farm.setName(req.getParameter("m_ffname"));
			desc = req.getParameter("m_ffdescription");
			farm.setDescription((!desc.isEmpty() || desc != null)? desc: null);
			farm.setHeadLine(req.getParameter("m_ffheadline"));
			farm.setDateCreated(ToolBox.GetCurrentDate());
			pic = req.getParameter("m_fpicture");
			farm.setPicture((!pic.isEmpty() || pic != null)? pic: null);
			
			//Create a new farm
			farmDAO.add(farm);
			
			//** Second, Get the farmerType with Id = 1
			FarmerType fType = new FarmerType();
			fType = fTypeDAO.get(1);	
			
			//** Third, create a new farmer object and initialize its properties
			Farmer farmer = new Farmer();
			
			//Get the userType
			UserType uType = new UserType();
			uTypeId = req.getParameter("m_utype");
			uType = uTypeDAO.get(Integer.parseInt(uTypeId));
			
			//Create farmer
			farmer.setUserType(uType);
			farmer.setFirstName(req.getParameter("m_fname"));
			farmer.setLastName(req.getParameter("m_lname"));
			midName = req.getParameter("m_mname");
			farmer.setMiddleName((!midName.isEmpty() || midName != null)? midName: null);
			farmer.setEmail(req.getParameter("m_email"));
			farmer.setPhone(req.getParameter("m_phone"));
			farmer.setPassword(ToolBox.GetMD5(req.getParameter("m_password")));	//!!!! Annotations + Validate password m_password and m_cpassword
			pic = req.getParameter("m_upicture");
			farmer.setPicture((!pic.isEmpty() || pic != null)? pic: null);
			farmer.setDateCreated(ToolBox.GetCurrentDate());
			
			farmer.setFarm(farm);
			farmer.setFarmerType(fType);
			position = req.getParameter("m_position");
			farmer.setPositionName((!position.isEmpty() || position != null)? position: null);
			website = req.getParameter("m_website");
			farmer.setWebSite((!website.isEmpty() || website != null)? website: null);
			
			farmerDAO.add(farmer);
			
			//** Save session user variables. set session to expire in 2 min = 120sec
			session.setAttribute("username", farmer.getEmail());
			session.setAttribute("pass", farmer.getPassword());
			session.setAttribute("name", farmer.getFirstName() + " " + farmer.getLastName());
			session.setMaxInactiveInterval(120);
			
			//** Save cookie user variables. set cookie to expire in 2 min = 120sec
			Cookie userName =  new Cookie("username", farmer.getEmail());
			userName.setMaxAge(120);
			resp.addCookie(userName);
			
			//session.getAttribute("username");
			//Redirect to the home page
			resp.sendRedirect("index");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();			
		}
	}
	
	
	//Add or Create a new user. redirect to login if error
	/*
	@RequestMapping(value = "/farmer/add")
	public ModelAndView addUser(@PathVariable("id") int id) {
		
		try
		{
			ModelAndView mv = new ModelAndView("login");
			
			//categoryDAO to fetch a single category
			Farmer farmer = null;
			farmer = farmerDAO.get(id);
			
			mv.addObject("title", farmer.getFirstName());
			
			//passing the list of farmer
			mv.addObject("categories", farmerDAO.list());
			
			//passing the single farmer
			mv.addObject("farmer", farmer);
			
			mv.addObject("userClickedCategoryProducts", true);
			return mv;
		}
		catch (Exception ex)
		{
			//System.err.printf("Error class: " + ex.getClass() + " || Message: " + ex.getMessage());
			ex.printStackTrace();
			return new ModelAndView("redirect:/login");
		}
		
	}
	*/
}
