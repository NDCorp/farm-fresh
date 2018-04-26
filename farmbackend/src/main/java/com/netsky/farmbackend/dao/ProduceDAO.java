package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.Produce;

public interface ProduceDAO {
	public List<Produce> list();

	public Produce get(int produce);

	public boolean add(Produce produce);

	public boolean update(Produce produce);

	public boolean delete(Produce produce);
}
