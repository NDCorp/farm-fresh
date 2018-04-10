package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.FarmerTypeDAO;
import com.netsky.farmbackend.dto.Farmer;
import com.netsky.farmbackend.dto.FarmerType;

@Repository("FarmerTypeDAO")
@Transactional
public class FarmerTypeDAOimpl implements FarmerTypeDAO{

	@Autowired private SessionFactory sessionFactory;
	
	//List of all active FarmerTypes
	public List<FarmerType> list() {
		
		String selectAllFarmerType = "FROM FarmerType"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllFarmerType);
		
		return query.getResultList();
		
		//return sessionFactory.getCurrentSession().createQuery("FROM FarmerType ", Farmer.class).getResultList();
	}

	//Retrieve a FarmerType based on its ID 
	@Override
	public FarmerType get(int id) {
		return sessionFactory.getCurrentSession().get(FarmerType.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(FarmerType farmerType) {
		try {
			//Add a FarmerType to the database table
			sessionFactory.getCurrentSession().persist(farmerType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(FarmerType farmerType) {
		try {
			//Update a FarmerType to the database table
			sessionFactory.getCurrentSession().update(farmerType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	@Override
	public boolean delete(FarmerType farmerType) {
		farmerType.setActive(false);
		try {
			//Update the FarmerType to the database table
			sessionFactory.getCurrentSession().update(farmerType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	*/
}
