package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Farm;

public interface FarmDAO {

	public List<Farm> list();

	public Farm get(int id);

	public boolean add(Farm farm);

	public boolean update(Farm farm);

	public boolean delete(Farm farm);
}
