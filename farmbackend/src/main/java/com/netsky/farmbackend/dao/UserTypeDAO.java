package com.netsky.farmbackend.dao;

import java.util.List;

import com.netsky.farmbackend.dto.UserType;

public interface UserTypeDAO {
	
	public List<UserType> list();

	public UserType get(int id);
	
	public UserType getByAcronym(char acronym);

	public boolean add(UserType userType);

	public boolean update(UserType userType);

	//public boolean delete(UserType userType);
}
