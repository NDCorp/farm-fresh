package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Promotion;

public interface PromotionDAO {
	public List<Promotion> list();

	public Promotion get(int promotion);

	public boolean add(Promotion promotion);

	public boolean update(Promotion promotion);

	public boolean delete(Promotion promotion);
}
