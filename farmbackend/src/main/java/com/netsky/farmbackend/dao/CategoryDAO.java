package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Category;

public interface CategoryDAO {

	public List<Category> list();

	public Category get(int id);

	public boolean add(Category category);

	public boolean update(Category category);

	public boolean delete(Category category);
}
