package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.ItemType;
import com.netsky.farmbackend.dto.UserType;

public interface ItemTypeDAO {
	public List<ItemType> list();

	public ItemType get(int itemType);

	public ItemType getByAcronym(char acronym);
	
	public boolean add(ItemType itemType);

	public boolean update(ItemType itemType);

	public boolean delete(ItemType itemType);
}
