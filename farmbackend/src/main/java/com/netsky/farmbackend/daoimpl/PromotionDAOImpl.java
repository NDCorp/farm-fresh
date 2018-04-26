package com.netsky.farmbackend.daoimpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.PromotionDAO;
import com.netsky.farmbackend.dto.Promotion;

@Repository("PromotionDAO")
@Transactional
public class PromotionDAOImpl implements PromotionDAO{
@Autowired private SessionFactory sessionFactory;
	
	//List of all active Promotion
	public List<Promotion> list() {
		String selectAllPromotion = "FROM Promotion WHERE IsActive = :active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllPromotion);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	//Retrieve a Promotion based on its ID 
	@Override
	public Promotion get(int id) {
		return sessionFactory.getCurrentSession().get(Promotion.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Promotion promotion) {
		try {
			//Add a Promotion to the database table
			sessionFactory.getCurrentSession().persist(promotion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(Promotion promotion) {
		try {
			//Update a Promotion to the database table
			sessionFactory.getCurrentSession().update(promotion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Promotion promotion) {
		promotion.setActive(false);
		try {
			//Update the Promotion to the database table
			sessionFactory.getCurrentSession().update(promotion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
