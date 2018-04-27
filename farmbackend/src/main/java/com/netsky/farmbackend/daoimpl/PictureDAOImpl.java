package com.netsky.farmbackend.daoimpl;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.netsky.farmbackend.dao.PictureDAO;
import com.netsky.farmbackend.dto.Picture;
import com.netsky.farmbackend.dto.Produce;

@Repository("PictureDAO")
@Transactional
public class PictureDAOImpl implements PictureDAO{
@Autowired private SessionFactory sessionFactory;
	
	//List of all active picture
	@Override
	public List<Picture> list() {
		
		String selectAllPicture = "FROM Picture"; 
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllPicture);
		
		return query.getResultList();
	}

	//List of all active picture
	@Override
	public List<Picture> listFarmerProdPicture(Set<Integer> prodIds) {
		//Produce produce = new Produce();
		/*
		String selectAllPicture = " FROM Picture AS pic JOIN Produce AS prod ON (pic.item.id = prod.id) "
				+ " WHERE prod.farmer.id =:farmerId ";*/
		
		String selectAllPicture = "FROM Picture WHERE item.id IN (:prodIds) ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllPicture);
		//query.setParameter("produceId", produce.getId());
		query.setParameter("prodIds", prodIds);
		
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
