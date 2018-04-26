package com.netsky.farmfresh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.netsky.farmbackend.dao.CategoryDAO;
import com.netsky.farmbackend.dao.FarmerDAO;
import com.netsky.farmbackend.dao.ItemTypeDAO;
import com.netsky.farmbackend.dao.PackDAO;
import com.netsky.farmbackend.dao.ProduceDAO;
import com.netsky.farmbackend.dao.ProduceTypeDAO;
import com.netsky.farmbackend.dao.ProductionTypeDAO;
import com.netsky.farmbackend.dto.Category;
import com.netsky.farmbackend.dto.Farmer;
import com.netsky.farmbackend.dto.ItemType;
import com.netsky.farmbackend.dto.Picture;
import com.netsky.farmbackend.dto.Produce;
import com.netsky.farmbackend.dto.ProduceType;
import com.netsky.farmbackend.dto.ProductionType;
import com.netsky.farmbackend.dto.Promotion;
import com.netsky.farmfresh.tools.controller.ToolBox;

@Controller
public class ProduceController extends HttpServlet {

	public static final long serialVersionUID = 1L;
	
	@Autowired ProduceDAO produceDAO;
	@Autowired PackDAO packDAO;
	@Autowired FarmerDAO farmerDAO;
	@Autowired ItemTypeDAO itemTypeDAO;
	@Autowired ProductionTypeDAO productionTypeDAO;
	@Autowired CategoryDAO categoryDAO;
	@Autowired ProduceTypeDAO produceTypeDAO;
	
	//*** Create a new produce
	@RequestMapping(value = "/createproduce", method= RequestMethod.POST)
	protected ModelAndView CreateProduce(HttpServletRequest req, HttpServletResponse resp, RedirectAttributes redirectAttributes) 
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView("redirect:/farmers");
		HttpSession session = req.getSession(true);
		String desc, pic;
		
		try
		{
			//Create a new produce if the user is connected
			if (session.getAttribute("username") != null)
			{
				//*** 1. Create farmer
				Farmer farmer = new Farmer();
				farmer = farmerDAO.getFarmerByEmail(session.getAttribute("username").toString());
				
				//*** 2. Create item type
				ItemType itemType = new ItemType();
				itemType = itemTypeDAO.getByAcronym('M');
				
				//*** 3. Create promotion (optional, null)
				Promotion promotion = new Promotion();
				
				//*** 4. Create production type
				ProductionType productionType = new ProductionType();
				productionType = productionTypeDAO.get(Integer.parseInt(req.getParameter("select-pptype")));
				
				//*** 5. Create category
				Category cat = new Category();
				cat = categoryDAO.get(Integer.parseInt(req.getParameter("select-pcat")));
								
				//*** 6. Create produce type
				ProduceType produceType = new ProduceType();
				produceType = produceTypeDAO.get(Integer.parseInt(req.getParameter("select-ptype")));
				
				//*** 7. Create the produce record
				Produce p = new Produce();
				p.setFarmer(farmer);
				p.setItemType(itemType);
				p.setPromotion(promotion);	//can be null
				p.setName(req.getAttribute("prodName").toString());
				desc = req.getParameter("m_fproddesc");
				p.setDescription((!desc.isEmpty() && desc != null)? desc: null);
				p.setQuantity(Double.parseDouble(req.getParameter("prodQty")));
				p.setUnitPrice(Double.parseDouble(req.getParameter("prodPrice")));
				p.setDateCreated(ToolBox.GetCurrentDate());
				p.setProductionType(productionType);
				p.setCategory(cat);
				p.setProduceType(produceType);		
				
				produceDAO.add(p);
				
				//*** 8. Create picture
				Picture picture = new Picture();
				picture.setItem(p);
				pic = req.getParameter("m_prodpicture").toString();
				picture.setPicture((!pic.isEmpty() && pic != null)? pic: null);
				picture.setAlternateTextId("Produce " + pic);
				redirectAttributes.addFlashAttribute("message", "Produce " + p.getName() + " created.");
			}
			
			return mv;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return new ModelAndView("redirect:/farmers");
		}
	}
}
