package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Product;

public interface ProductDAO {

	public Product get(int product);

	public List<Product> list();

	public boolean add(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	public List<Product> listActiveProducts();

	public List<Product> listActiveProductsByCategory(int categoryId);

	public List<Product> getLatestActiveProducts(int counts);

}
