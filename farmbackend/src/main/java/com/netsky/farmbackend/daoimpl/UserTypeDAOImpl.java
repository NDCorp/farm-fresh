package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.UserTypeDAO;
import com.netsky.farmbackend.dto.UserType;

@Repository("UserTypeDAO")
@Transactional
public class UserTypeDAOImpl implements UserTypeDAO{

	@Autowired private SessionFactory sessionFactory;
	
	//List of all active UserType
	public List<UserType> list() {
		
		//!!! Show only Buyer and Farmer
		String selectAllUserType = "FROM UserType WHERE Acronym <> :admin"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllUserType);
		query.setParameter("admin", 'A');
		
		return query.getResultList();
		
		//return sessionFactory.getCurrentSession().createQuery("FROM UserType", Farmer.class).getResultList();
	}

	//Retrieve a UserType based on its ID 
	@Override
	public UserType get(int id) {
		return sessionFactory.getCurrentSession().get(UserType.class, Integer.valueOf(id));
	}

	//Retrieve a UserType based on its acronym 
	@Override
	public UserType getByAcronym(char acronym) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserType WHERE Acronym =:acronym "); 
		query.setParameter("acronym", acronym);
		
		return (UserType) query.getSingleResult();
	}
	
	@Override
	public boolean add(UserType userType) {
		try {
			//Add a UserType to the database table
			sessionFactory.getCurrentSession().persist(userType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(UserType userType) {
		try {
			//Update a UserType to the database table
			sessionFactory.getCurrentSession().update(userType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	@Override
	public boolean delete(UserType userType) {
		//userType.setActive(false);
		try {
			//Update the UserType to the database table
			sessionFactory.getCurrentSession().update(userType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	*/

}
