package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.ProduceDAO;
import com.netsky.farmbackend.dto.Farmer;
import com.netsky.farmbackend.dto.Produce;
import com.netsky.farmbackend.dto.Product;

@Repository("ProduceDAO")
@Transactional
public class ProduceDAOImpl implements ProduceDAO{
	@Autowired private SessionFactory sessionFactory;
	
	//List of all active produce
	@Override
	public List<Produce> list() {
		
		String selectAllProduce = "FROM Produce WHERE IsActive =:active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllProduce);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	//List of all active produce for a farmer
	@Override
	public List<Produce> listFarmerProduce(int farmerId) {
		
		String selectAllProduce = "FROM Produce WHERE IsActive =:active AND farmer.id =:farmerId"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllProduce);
		query.setParameter("active", true);
		query.setParameter("farmerId", farmerId);
		
		return query.getResultList();
	}
	
	@Override
	public List<Produce> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Produce WHERE IsActive = :active AND category.id = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Produce.class)
						.setParameter("active", true)
						.setParameter("categoryId", categoryId)
							.getResultList();
	}
	
	//Retrieve a Produce based on its ID 
	@Override
	public Produce get(int id) {
		return sessionFactory.getCurrentSession().get(Produce.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Produce produce) {
		try {
			//Add a Produce to the database table
			sessionFactory.getCurrentSession().persist(produce);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(Produce produce) {
		try {
			//Update a Produce to the database table
			sessionFactory.getCurrentSession().update(produce);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Produce produce) {
		produce.setActive(false);
		try {
			//Update the Produce to the database table
			sessionFactory.getCurrentSession().update(produce);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
