package com.netsky.farmbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.PictureDAO;
import com.netsky.farmbackend.dto.Picture;

@Repository("PictureDAO")
@Transactional
public class PictureDAOImpl implements PictureDAO{
@Autowired private SessionFactory sessionFactory;
	
	//List of all active picture
	public List<Picture> list() {
		
		String selectAllPicture = "FROM Picture"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllPicture);
		
		return query.getResultList();
	}

	//Retrieve a Picture based on its ID 
	@Override
	public Picture get(int id) {
		return sessionFactory.getCurrentSession().get(Picture.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Picture picture) {
		try {
			//Add a Picture to the database table
			sessionFactory.getCurrentSession().persist(picture);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(Picture picture) {
		try {
			//Update a Picture to the database table
			sessionFactory.getCurrentSession().update(picture);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Picture picture) {
		/*
		picture.setActive(false);
		try {
			//Update the picture to the database table
			sessionFactory.getCurrentSession().update(picture);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		*/
		return false;
	}
}
