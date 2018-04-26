package com.netsky.farmbackend.daoimpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.ItemTypeDAO;
import com.netsky.farmbackend.dto.ItemType;

@Repository("ItemTypeDAO")
@Transactional
public class ItemTypeDAOImpl implements ItemTypeDAO{
	@Autowired private SessionFactory sessionFactory;
	
	//List of all active ItemType
	public List<ItemType> list() {		
		String selectAllItemType = "FROM ItemType"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllItemType);
		
		return query.getResultList();
	}

	//Retrieve a ItemType based on its ID 
	@Override
	public ItemType get(int id) {
		return sessionFactory.getCurrentSession().get(ItemType.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(ItemType itemType) {
		try {
			//Add a ItemType to the database table
			sessionFactory.getCurrentSession().persist(itemType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(ItemType itemType) {
		try {
			//Update a ItemType to the database table
			sessionFactory.getCurrentSession().update(itemType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(ItemType itemType) {
		/*
		itemType.setActive(false);
		try {
			//Update the ItemType to the database table
			sessionFactory.getCurrentSession().update(itemType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		*/
		return false;
	}
}
