package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Buyer;

public interface BuyerDAO {

	public List<Buyer> list();

	public Buyer get(int id);

	public boolean add(Buyer buyer);

	public boolean update(Buyer buyer);

	public boolean delete(Buyer buyer);
	
}
