package com.netsky.farmfresh.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netsky.farmbackend.dao.BuyerDAO;
import com.netsky.farmbackend.dao.CategoryDAO;
import com.netsky.farmbackend.dao.FarmerDAO;
import com.netsky.farmbackend.dao.PictureDAO;
import com.netsky.farmbackend.dao.ProduceDAO;
import com.netsky.farmbackend.dao.ProduceTypeDAO;
import com.netsky.farmbackend.dao.ProductDAO;
import com.netsky.farmbackend.dao.ProductionTypeDAO;
import com.netsky.farmbackend.dao.UserTypeDAO;
import com.netsky.farmbackend.dto.Buyer;
import com.netsky.farmbackend.dto.Category;
import com.netsky.farmbackend.dto.Farmer;
import com.netsky.farmbackend.dto.Picture;
import com.netsky.farmbackend.dto.Produce;
import com.netsky.farmbackend.dto.UserType;
import com.netsky.farmfresh.exception.ProductNotFoundException;
import com.netsky.farmfresh.tools.controller.ToolBox;

import antlr.collections.List;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired CategoryDAO categoryDAO;
	@Autowired ProductDAO productDAO;
	@Autowired ProduceDAO produceDAO;
	@Autowired PictureDAO pictureDAO;
	@Autowired ProduceTypeDAO produceTypeDAO;
	@Autowired ProductionTypeDAO productionTypeDAO;
	@Autowired UserTypeDAO userTypeDAO;
	@Autowired BuyerDAO buyerDAO;
	@Autowired FarmerDAO farmerDAO;
	@Autowired ServletContext context;
	
	@RequestMapping(value = {"/", "/home", "/index"})	//, method = RequestMethod.GET
	public ModelAndView index(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController Index Method");
		logger.debug("Inside PageController Index Method");
		
		try
		{
			//Get the session and manage the user connected with oAuth fb 
			HttpSession session = req.getSession(true);
			
			//get the fb user access token
			String access_token = (String) req.getParameter("access_token");
			
			//Create a new user object buyer
			Buyer buyer = new Buyer();
			ToolBox tools = new ToolBox();
			
			if (access_token != null && !access_token.isEmpty()) {
				buyer = GetFBData(access_token);
				
				//** Save session user variables. set session to expire in 2 min = 120sec
				session.setAttribute("username", buyer.getEmail());
				session.setAttribute("pass", buyer.getPassword());	//fake password
				session.setAttribute("name", buyer.getFirstName());
				session.setMaxInactiveInterval(120);
				
				//** Save cookie user variables. set cookie to expire in 2 min = 120sec
				Cookie userName =  new Cookie("username", buyer.getEmail());
				userName.setMaxAge(120);
				resp.addCookie(userName); 
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		//passing the list of category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickedHome", true);
		return mv;
	}	

	/*
	 * Methods to get data from facebook API
	 * */
	public Buyer GetFBData(String access_token) throws Exception {
		
		try
		{
			String url = "https://graph.facebook.com/v2.12/me?fields=id%2Cname%2C%20picture%2C%20email&access_token="+access_token;

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//Define get method to get data from fb
			con.setRequestMethod("GET");
			//add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			con.setReadTimeout(10000);

			//Read data
			InputStreamReader strReader = new InputStreamReader(con.getInputStream());
			BufferedReader in = new BufferedReader(strReader);
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			}
			in.close();
	
			//** create a new buyer using fb data
			Buyer buyer = new Buyer();
			JSONObject myResponse = new JSONObject(response.toString());
			//test.getJsonString(response.toString());
	
			//Get the buyer from DB
			buyer = buyerDAO.getByFbBuyerId(myResponse.getString("id"));
			
			//If not found
			if (buyer == null) {
				//Read JSON response
				buyer = new Buyer();
				
				//May be I can encrypt fb id. in that case change field size in mysql to 40
				buyer.setFbBuyerId(myResponse.getString("id"));	
				buyer.setFirstName(myResponse.getString("name"));
				buyer.setLastName(myResponse.getString("name"));
				buyer.setPassword(ToolBox.GetMD5("123freshfarm"));
				//System.out.println("Name: " + myResponse.getString("name"));
		
				buyer.setEmail(myResponse.getString("email"));
				buyer.setDateCreated(ToolBox.GetCurrentDate());
				buyer.setActive(true);
				
				//Get the userType		
				UserType uType = new UserType();
				uType = userTypeDAO.getByAcronym('B');
				buyer.setUserType(uType);
				
				/*
				JSONObject pict_response = myResponse.getJSONObject("picture");
				JSONObject data_response = pict_response.getJSONObject("data");
				buyer.setPicture(data_response.getString("url"));
				*/
				
				//Add a new buyer in the db with fb data
				buyerDAO.add(buyer);			
			}
			
			//avoid to return a buyer, use session variables
			return buyer; 
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null; 
		}		
	}

	/*
	 * Methods to load all login
	 * */
	@RequestMapping(value = "/login")
	public ModelAndView Login(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ModelAndView mv;
		
		try
		{
			//Get the session to avoid the login page if the user is connected
			HttpSession session = req.getSession(true);
			
			//if session exists and user connected, Redirect to home with a message: user already connected..
			if(session.getAttribute("username") != null) 
			{
				//add a message: user already connected..
				mv = new ModelAndView("redirect:/index");
				mv.addObject("message", "User " + session.getAttribute("username") + " already connected.");
				return mv;
			}
			else //if a user is not connected, open the view Login
			{
				mv = new ModelAndView("login");
				mv.addObject("title", "Login");
				//mv.addObject("msglogin", "test");
				
				//passing the list of userTypes for registration form
				mv.addObject("userTypes", userTypeDAO.list());
				mv.addObject("userClickedLogin", true);
				return mv;
			}			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return new ModelAndView("redirect:/index");
		}	
	}

	/*
	 * Methods to load all logout
	 * */
	//@RequestMapping(value = "/logout")
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String Logout(HttpSession session) {		
		session.invalidate();
        return "redirect:/index";
	}
	
	/*
	 * Methods to load farmer account
	 * */
	@RequestMapping(value = "/farmers")
	public ModelAndView farmers(HttpServletRequest req, HttpServletResponse resp) {
		//Get the session and manage the user connected with oAuth fb 
		HttpSession session = req.getSession(true);
		
		//Redirect to index if not connected
		if (session.getAttribute("username") == null)
			new ModelAndView("redirect:/index");
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Farmers");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("produceTypes", produceTypeDAO.list());
		mv.addObject("productionTypes", productionTypeDAO.list());
		
		//get farmer's produce
		Farmer farmer = new Farmer();
		farmer = farmerDAO.getFarmerByEmail(session.getAttribute("username").toString());
		
		//get produce list for this farmer
		java.util.List<Produce> prodList = new ArrayList<Produce>();
		prodList = produceDAO.listFarmerProduce(farmer.getId());
		mv.addObject("produces", prodList);
		
		//get produce ids for this farmer
		Set<Integer> prodIds = new HashSet<Integer>();
		for (Produce prod : prodList) {
			prodIds.add(prod.getId());
		}
		
		//get pictures for all farmer's produce
		mv.addObject("pictures", pictureDAO.listFarmerProdPicture(prodIds));
		
		//Get repository
		String userFolder = "user_" + farmer.getId();
		String pictPathDir = context.getContextPath(); //getRealPath("\\src\\main\\webapp\\assets\\images")
		pictPathDir += File.separator + "images" + File.separator
    					+ "upload"+ File.separator + userFolder;

    	mv.addObject("pictPathDir", pictPathDir);
    	
		mv.addObject("userClickedFarmers", true);
		return mv;
	}
	
	/*
	 * Methods to load all buyers
	 * */
	@RequestMapping(value = "/buyers")
	public ModelAndView Buyers() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Buyers");
		mv.addObject("userClickedBuyers", true);
		return mv;
	}
	
	/*
	 * Methods to load all Order History
	 * */
	@RequestMapping(value = "/orderHistory")
	public ModelAndView OrderHistory() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Order History");
		mv.addObject("userClickedOrderHistory", true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickedAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickedContact", true);
		return mv;
	}
	
	/*
	 * Methods to load all the products and based on category
	 * */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		//passing the list of category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickedAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		//categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		//passing the list of category
		mv.addObject("categories", categoryDAO.list());
		
		//passing the single category
		mv.addObject("category", category);
		
		mv.addObject("userClickedCategoryProducts", true);
		return mv;
	}
	
	/*
	 * Viewing a single product
	 * */
	/*
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product == null) {
			throw new ProductNotFoundException();
		}
		
		//update the view count
		product.setViews(product.getViews()+1);		
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct", true);
				
		return mv;
	}
	*/
	
}
