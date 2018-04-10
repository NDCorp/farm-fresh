package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.FarmDAO;
import com.netsky.farmbackend.dto.Farm;
import com.netsky.farmbackend.dto.Farmer;

@Repository("FarmDAO")
@Transactional
public class FarmDAOimpl implements FarmDAO{

	@Autowired private SessionFactory sessionFactory;
	
	//List of all active farms
	public List<Farm> list() {
		
		String selectAllFarm = "FROM Farm WHERE IsActive = :active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllFarm);
		query.setParameter("active", true);
		
		return query.getResultList();
		
		//return sessionFactory.getCurrentSession().createQuery("FROM Farm ", Farmer.class).getResultList();
	}

	//Retrieve a farm based on its ID 
	@Override
	public Farm get(int id) {
		return sessionFactory.getCurrentSession().get(Farm.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Farm farm) {
		try {
			//Add a farm to the database table
			sessionFactory.getCurrentSession().persist(farm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(Farm farm) {
		try {
			//Update a farm to the database table
			sessionFactory.getCurrentSession().update(farm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Farm farm) {
		farm.setActive(false);
		try {
			//Update the farm to the database table
			sessionFactory.getCurrentSession().update(farm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
