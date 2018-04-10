package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.FarmerType;

public interface FarmerTypeDAO {

	public List<FarmerType> list();

	public FarmerType get(int id);

	public boolean add(FarmerType farmType);

	public boolean update(FarmerType farmType);

	//public boolean delete(FarmerType farmType);
}
