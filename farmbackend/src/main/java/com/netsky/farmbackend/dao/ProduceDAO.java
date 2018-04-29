package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Farmer;
import com.netsky.farmbackend.dto.Produce;
import com.netsky.farmbackend.dto.Product;

public interface ProduceDAO {
	public List<Produce> list();

	public List<Produce> listFarmerProduce(int farmer);
	
	public List<Produce> listActiveProductsByCategory(int categoryId);
	
	public Produce get(int produce);

	public boolean add(Produce produce);

	public boolean update(Produce produce);

	public boolean delete(Produce produce);
}
