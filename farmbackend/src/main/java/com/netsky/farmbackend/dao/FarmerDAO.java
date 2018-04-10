package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Farmer;

public interface FarmerDAO {
	
	public List<Farmer> list();

	public Farmer get(int id);

	public boolean add(Farmer farmer);

	public boolean update(Farmer farmer);

	public boolean delete(Farmer farmer);
}
