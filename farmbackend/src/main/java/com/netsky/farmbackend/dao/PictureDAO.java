package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Picture;

public interface PictureDAO {
	public List<Picture> list();

	public Picture get(int picture);

	public boolean add(Picture picture);

	public boolean update(Picture picture);

	public boolean delete(Picture picture);
}
