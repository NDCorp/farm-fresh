package com.netsky.farmbackend.dao;

import java.util.List;
import com.netsky.farmbackend.dto.ProductionType;

public interface ProductionTypeDAO {
	public List<ProductionType> list();

	public ProductionType get(int productionType);

	public boolean add(ProductionType productionType);

	public boolean update(ProductionType productionType);

	public boolean delete(ProductionType productionType);
}
