package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Buyers")
//@PrimaryKeyJoinColumn(name="usersId")
public class Buyer extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	//private int usersId; 
	
	private String fbBuyerId;
	
	@OneToOne
	@JoinColumn(name="usersId")	//, referencedColumnName="id"
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFbBuyerId() {
		return fbBuyerId;
	}
	public void setFbBuyerId(String fbBuyerId) {
		this.fbBuyerId = fbBuyerId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
