package com.netsky.farmbackend.daoimpl;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.FarmerDAO;
import com.netsky.farmbackend.dto.Buyer;
import com.netsky.farmbackend.dto.Farmer;
import com.netsky.farmbackend.dto.UserType;

@Repository("FarmerDAO")
@Transactional
public class FarmerDAOImpl implements FarmerDAO{

	@Autowired private SessionFactory sessionFactory;
	
	//List of all active farmers
	public List<Farmer> list() {
		
		String selectAllFarmer = "FROM Farmer WHERE isActive =:active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllFarmer);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	//Retrieve a farmer based on its ID 
	@Override
	public Farmer get(int id) {
		return sessionFactory.getCurrentSession().get(Farmer.class, Integer.valueOf(id));
	}

	//Retrieve a Farmer based on his email 
	@Override
	public Farmer getFarmerByEmail(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Farmer WHERE email =:email "); 
		query.setParameter("email", email);
		
		List r = query.getResultList();
		
		if (r.isEmpty())
				return null;
		else if (r.size() == 1) 
			return (Farmer)r.get(0);
		
		throw new NonUniqueResultException();
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
		farmer.setActive(false);
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
