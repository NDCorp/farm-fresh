package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Categories;

public interface CategoryDAO {

	public List<Categories> list();

	public Categories get(int id);

	public boolean add(Categories category);

	public boolean update(Categories category);

	public boolean delete(Categories category);
}
