package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);
}
