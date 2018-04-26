package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.ProductionTypeDAO;
import com.netsky.farmbackend.dto.ProductionType;

@Repository("ProductionTypeDAO")
@Transactional
public class ProductionTypeDAOImpl implements ProductionTypeDAO{
@Autowired private SessionFactory sessionFactory;
	
	//List of all active ProductionType
	public List<ProductionType> list() {		
		String selectAllProductionType = "FROM ProductionType"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllProductionType);
		
		return query.getResultList();
	}

	//Retrieve a ProductionType based on its ID 
	@Override
	public ProductionType get(int id) {
		return sessionFactory.getCurrentSession().get(ProductionType.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(ProductionType productionType) {
		try {
			//Add a ProductionType to the database table
			sessionFactory.getCurrentSession().persist(productionType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(ProductionType productionType) {
		try {
			//Update a ProductionType to the database table
			sessionFactory.getCurrentSession().update(productionType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(ProductionType productionType) {
		/*
		productionType.setActive(false);
		try {
			//Update the ProductionType to the database table
			sessionFactory.getCurrentSession().update(productionType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		*/
		return false;
	}
}
