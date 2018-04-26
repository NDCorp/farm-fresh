package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.ItemType;

public interface ItemTypeDAO {
	public List<ItemType> list();

	public ItemType get(int itemType);

	public boolean add(ItemType itemType);

	public boolean update(ItemType itemType);

	public boolean delete(ItemType itemType);
}
