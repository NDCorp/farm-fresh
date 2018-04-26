package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.PackDAO;
import com.netsky.farmbackend.dto.Pack;

@Repository("PackDAO")
@Transactional
public class PackDAOImpl implements PackDAO {
	@Autowired private SessionFactory sessionFactory;
	
	//List of all active Pack
	public List<Pack> list() {
		
		String selectAllPack = "FROM Pack WHERE IsActive = :active"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllPack);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	//Retrieve a Pack based on its ID 
	@Override
	public Pack get(int id) {
		return sessionFactory.getCurrentSession().get(Pack.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Pack pack) {
		try {
			//Add a Pack to the database table
			sessionFactory.getCurrentSession().persist(pack);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(Pack pack) {
		try {
			//Update a Pack to the database table
			sessionFactory.getCurrentSession().update(pack);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Pack pack) {
		pack.setActive(false);
		try {
			//Update the Pack to the database table
			sessionFactory.getCurrentSession().update(pack);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
