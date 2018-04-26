package com.netsky.farmfresh.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
import com.netsky.farmfresh.tools.controller.UploadPicture;

import antlr.collections.List;

@WebServlet(urlPatterns={"/myservlet"})
@MultipartConfig
@Controller
public class ProduceController extends HttpServlet {

	public static final long serialVersionUID = 1L;
	private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 80 * 80 * 80;
    private static final int MAX_REQUEST_SIZE = 256 * 256;
	
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
		String desc, pic, userFolder, fieldName, fieldValue;
		
		try
		{
			// Save file on system
		      
			
			
			//Check if the request exists 
	        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
	        if (!isMultipart) 
	        {
	        	return new ModelAndView("redirect:/farmers");
	        }
	        
	        //Create a new produce if the user is connected
			if (session.getAttribute("username") != null)
			{
				//*** 1. Create farmer
				Farmer farmer = new Farmer();
				farmer = farmerDAO.getFarmerByEmail(session.getAttribute("username").toString());	            				
    			
				//Get the userid
				userFolder = "user_" + farmer.getId();
				//call the method to upload pictures
				UploadPicture fileInput = new UploadPicture();
				fileInput.GetPicture(req, resp, userFolder);
				
				//*** 2. Create item type
				ItemType itemType = new ItemType();
				itemType = itemTypeDAO.getByAcronym('M');
				
				//*** 3. Create promotion (optional, null)
				Promotion promotion = new Promotion();
				
				//*** 4. Create production type
				ProductionType productionType = new ProductionType();
				
				//*** 5. Create category
				Category cat = new Category();

				//*** 6. Create produce type
				ProduceType produceType = new ProduceType();
				
				//*** 7. Create the produce record
				Produce p = new Produce();
				
				//*** 8. Upload picture
				Picture picture = new Picture();
				
		        // Create a factory
		        DiskFileItemFactory factory = new DiskFileItemFactory();
	
		        // Sets the size threshold beyond which files are written directly to disk.
		        factory.setSizeThreshold(MAX_MEMORY_SIZE);
	
		        // Sets the directory used to temporarily store files that are larger than the configured size threshold.
		        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	
		        // constructs the folder where uploaded file will be stored
		        //String uploadFolder = getServletContext().getRealPath("") + File.separator + DATA_DIRECTORY;
	
		        // Create a new file upload handler
		        ServletFileUpload upload = new ServletFileUpload(factory);
	
		        // Set overall request size constraint
		        upload.setSizeMax(MAX_REQUEST_SIZE);
		
		     	// Parse the request
	            java.util.List items = upload.parseRequest(req);
	            Iterator iter = ((java.util.List) items).iterator(); 
				
	            while (iter.hasNext()) 
	            {
	                FileItem item = (FileItem) iter.next();
	                
	                // If the field is not a file input, loop to set all fields for produce and picture
	                if (item.isFormField())
	                {
	                	fieldName = item.getFieldName();
	                	fieldValue = item.getString();
	                	switch (fieldName)
	                	{
	                		case ("select-pptype"):
	            				productionType = productionTypeDAO.get(Integer.parseInt(fieldValue));
	                			break;
							case ("select-pcat"):
								cat = categoryDAO.get(Integer.parseInt(item.getString()));               			
								break;
							case ("select-ptype"):
								produceType = produceTypeDAO.get(Integer.parseInt(fieldValue));
								break;
							case ("prodName"):
								p.setName(fieldValue);
								break;
							case ("m_fproddesc"):
								p.setDescription((!fieldValue.isEmpty() && fieldValue != null)? fieldValue: null);
								break;
							case ("prodQty"):
								p.setQuantity(Double.parseDouble(fieldValue));
								break;
							case ("prodPrice"):
								p.setUnitPrice(Double.parseDouble(fieldValue));
								break;	  
							case ("m_prodpicture"):
								//loop for all pictures
								picture.setPicture((!fieldValue.isEmpty() && fieldValue != null)? fieldValue: null);
								picture.setAlternateTextId("Produce " + fieldValue);
								break;	
	                	}
	                }
	                else if (!item.isFormField())
	                {
	                	fieldValue = item.getName();
	                	
	                	//loop for all pictures
						picture.setPicture((!fieldValue.isEmpty() && fieldValue != null)? fieldValue: null);
						picture.setAlternateTextId("Produce " + fieldValue);
	                }
	            }

				//*** Set values for produce			
				p.setFarmer(farmer);
				p.setItemType(itemType);
				//p.setPromotion(promotion);	//can be null	
				p.setActive(true);
				p.setDateCreated(ToolBox.GetCurrentDate());
				p.setProductionType(productionType);
				p.setCategory(cat);
				p.setProduceType(produceType);		
				
				produceDAO.add(p);
				redirectAttributes.addFlashAttribute("message", "Produce " + p.getName() + " created.");
				
				//*** Set Value for Picture
				picture.setItem(p);
			
				
	
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
