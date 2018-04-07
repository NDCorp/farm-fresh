package com.netsky.farmbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.CategoryDAO;
import com.netsky.farmbackend.dto.Categories;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired private SessionFactory sessionFactory;

	//private static List<Category> categories = new ArrayList<>();

	public List<Categories> list() {
		
		String selectActiveCategory = "FROM Categories WHERE IsActive = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
		
		//return sessionFactory.getCurrentSession().createQuery("FROM Categories ", Categories.class).getResultList();
	
	}

	//Getting single category based on ID 
	@Override
	public Categories get(int id) {
		return sessionFactory.getCurrentSession().get(Categories.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Categories category) {
		try {
			//Add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Categories category) {
		try {
			//Update the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Categories category) {
		category.setActive(false);
		try {
			//Update the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
