package com.netsky.farmbackend.dao;

import java.util.List;
import java.util.Set;

import com.netsky.farmbackend.dto.Farmer;
import com.netsky.farmbackend.dto.Picture;
import com.netsky.farmbackend.dto.Produce;

public interface PictureDAO {
	public List<Picture> list();

	public List<Picture> listFarmerProdPicture(Set<Integer> prodIds);
	
	public Picture get(int picture);
	
	public boolean add(Picture picture);

	public boolean update(Picture picture);

	public boolean delete(Picture picture);
}
