package com.netsky.farmbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.netsky.farmbackend.dao.ProductDAO;
import com.netsky.farmbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.netsky.farmbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testCrudCategory() {
		
		//Add Operation
		product = new Product(); 
		
		product.setName("Vegetable");
		product.setDescription("Description for Vegetables.");
//		product.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table.", true, productDAO.add(product));
		
		product = new Product(); 
		
		product.setName("Meat");
		product.setDescription("Description for Meat.");
//		product.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table.", true, productDAO.add(product));
		
		//Fetching and updating the category
		product = productDAO.get(2);
		product.setName("Vegatables");
		
		assertEquals("Successfully updated a single category in the table.", true, productDAO.update(product));
		
		//Delete the category
		assertEquals("Successfully deleted a single category in the table.", true, productDAO.delete(product));
		
		//Fetching the list
		assertEquals("Successfully fetched the list of categories from the table.", 3, productDAO.list().size());
	}
}
