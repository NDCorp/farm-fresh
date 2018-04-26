package com.netsky.farmbackend.daoimpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.netsky.farmbackend.dao.ProduceTypeDAO;
import com.netsky.farmbackend.dto.ProduceType;

@Repository("ProduceTypeDAO")
@Transactional
public class ProduceTypeDAOImpl implements ProduceTypeDAO{
	@Autowired private SessionFactory sessionFactory;
	
	//List of all active ProduceType
	public List<ProduceType> list() {		
		String selectAllProduceType = "FROM ProduceType"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllProduceType);
		
		return query.getResultList();
	}

	//Retrieve a ProduceType based on its ID 
	@Override
	public ProduceType get(int id) {
		return sessionFactory.getCurrentSession().get(ProduceType.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(ProduceType produceType) {
		try {
			//Add a ProduceType to the database table
			sessionFactory.getCurrentSession().persist(produceType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(ProduceType produceType) {
		try {
			//Update a ProduceType to the database table
			sessionFactory.getCurrentSession().update(produceType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(ProduceType produceType) {
		/*
		produceType.setActive(false);
		try {
			//Update the ProduceType to the database table
			sessionFactory.getCurrentSession().update(produceType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		*/
		return false;
	}
}
