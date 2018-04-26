package com.netsky.farmbackend.dao;

import java.util.List;
import com.netsky.farmbackend.dto.Pack;

public interface PackDAO {
	public List<Pack> list();

	public Pack get(int pack);

	public boolean add(Pack pack);

	public boolean update(Pack pack);

	public boolean delete(Pack pack);
}
