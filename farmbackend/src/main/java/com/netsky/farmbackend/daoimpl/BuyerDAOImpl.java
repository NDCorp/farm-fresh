package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.BuyerDAO;
import com.netsky.farmbackend.dto.Buyer;

@Repository("BuyerDAO")
@Transactional
public class BuyerDAOImpl implements BuyerDAO{


	@Autowired private SessionFactory sessionFactory;
	
	//List of all active Buyers
	public List<Buyer> list() {
		
		String selectAllBuyer = "FROM Buyer WHERE IsActive = :active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllBuyer);
		query.setParameter("active", true);
		
		return query.getResultList();
		
		//return sessionFactory.getCurrentSession().createQuery("FROM Buyer", Buyer.class).getResultList();
	}

	//Retrieve a buyer based on its ID 
	@Override
	public Buyer get(int id) {
		return sessionFactory.getCurrentSession().get(Buyer.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Buyer buyer) {
		try {
			//Add a buyer to the database table
			sessionFactory.getCurrentSession().persist(buyer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Buyer buyer) {
		try {
			//Update a buyer to the database table
			sessionFactory.getCurrentSession().update(buyer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Buyer buyer) {
		buyer.setActif(false);
		try {
			//Update the buyer to the database table
			sessionFactory.getCurrentSession().update(buyer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
