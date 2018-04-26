package com.netsky.farmfresh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.netsky.farmbackend.dao.ProductDAO;

@Controller
public class ProduceController {

	@Autowired ProductDAO produceDAO;
	
	
	@RequestMapping(value = "/createproduce", method= RequestMethod.POST)
	protected ModelAndView CreateProduce(HttpServletRequest req, HttpServletResponse resp, RedirectAttributes redirectAttributes) 
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView("redirect:/farmers");
		HttpSession session = req.getSession(true);
		
		try
		{
			
			return mv;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return new ModelAndView("redirect:/farmers");
		}
	}
}
