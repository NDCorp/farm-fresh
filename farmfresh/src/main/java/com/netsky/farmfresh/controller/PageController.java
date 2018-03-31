package com.netsky.farmfresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.netsky.farmbackend.dao.CategoryDAO;
import com.netsky.farmbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		//passing the list of category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickedHome", true);
		return mv;
	}	

	/*
	 * Methods to load all login
	 * */
	@RequestMapping(value = "/login")
	public ModelAndView Login() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Login");
		mv.addObject("userClickedLogin", true);
		return mv;
	}

	/*
	 * Methods to load all farmers
	 * */
	@RequestMapping(value = "/farmers")
	public ModelAndView farmers() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Farmers");
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
}
