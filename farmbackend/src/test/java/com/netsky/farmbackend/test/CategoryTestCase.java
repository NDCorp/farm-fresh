package com.netsky.farmbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.netsky.farmbackend.dao.CategoryDAO;
import com.netsky.farmbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.netsky.farmbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category(); 
//		
//		category.setName("Fruits");
//		category.setDescription("Description for Fruits.");
//		category.setImageURL("CAT_1.png");
//		
//		assertEquals("Successfully added a category inside the table.", true, categoryDAO.add(category));
//	}
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(1); 
//		
//		assertEquals("Successfully fetched a single category from the table.", "Fruits", category.getName());
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(1);
//		category.setName("Lentils");
//		
//		assertEquals("Successfully updated a single category in the table.", true, categoryDAO.update(category));
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(1);
//		assertEquals("Successfully deleted a single category in the table.", true, categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testListCategory() {
//		
//		assertEquals("Successfully fetched the list of categories from the table.", 0, categoryDAO.list().size());
//	}
	
	@Test
	public void testCrudCategory() {
		
		//Add Operation
		category = new Category(); 
		
		category.setName("Vegetable");
		category.setDescription("Description for Vegetables.");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table.", true, categoryDAO.add(category));
		
		category = new Category(); 
		
		category.setName("Meat");
		category.setDescription("Description for Meat.");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table.", true, categoryDAO.add(category));
		
		//Fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("Vegatables");
		
		assertEquals("Successfully updated a single category in the table.", true, categoryDAO.update(category));
		
		//Delete the category
		assertEquals("Successfully deleted a single category in the table.", true, categoryDAO.delete(category));
		
		//Fetching the list
		assertEquals("Successfully fetched the list of categories from the table.", 3, categoryDAO.list().size());
	}
	

}
