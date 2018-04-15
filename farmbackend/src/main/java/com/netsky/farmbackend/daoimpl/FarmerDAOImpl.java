package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.FarmerDAO;
import com.netsky.farmbackend.dto.Farmer;

@Repository("FarmerDAO")
@Transactional
public class FarmerDAOImpl implements FarmerDAO{

	@Autowired private SessionFactory sessionFactory;
	
	//List of all active farmers
	public List<Farmer> list() {
		
		String selectAllFarmer = "FROM Farmer WHERE IsActive = :active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllFarmer);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	//Retrieve a farmer based on its ID 
	@Override
	public Farmer get(int id) {
		return sessionFactory.getCurrentSession().get(Farmer.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Farmer farmer) {
		try {
			//Add a farmer to the database table
			sessionFactory.getCurrentSession().persist(farmer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Farmer farmer) {
		try {
			//Update a farmer to the database table
			sessionFactory.getCurrentSession().update(farmer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Farmer farmer) {
		farmer.setActif(false);
		try {
			//Update the farmer to the database table
			sessionFactory.getCurrentSession().update(farmer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
