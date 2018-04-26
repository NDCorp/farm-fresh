package com.netsky.farmbackend.dao;

import java.util.List;
import com.netsky.farmbackend.dto.ProduceType;

public interface ProduceTypeDAO {
	public List<ProduceType> list();

	public ProduceType get(int produceType);

	public boolean add(ProduceType produceType);

	public boolean update(ProduceType produceType);

	public boolean delete(ProduceType produceType);
}
