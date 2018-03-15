package com.netsky.farmbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.netsky.farmbackend.dao.CategoryDAO;
import com.netsky.farmbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
//		first category
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Description for Television.");
		category.setImageURL("CAT_1.png");
		categories.add(category);

//		Secomd category
		category = new Category();		
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description for Mobile.");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
//		Second category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description for Laptop.");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	
	}


	public List<Category> list() {
		return categories;
	}


	@Override
	public Category get(int id) {
		for(Category category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
