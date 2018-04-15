package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Buyers")
public class Buyer extends User{
	//Will inherit from User class
	//add specific properties of Buyer here...
	private String fbBuyerId;
	
	public String getFbBuyerId() {
		return fbBuyerId;
	}
	public void setFbBuyerId(String fbBuyerId) {
		this.fbBuyerId = fbBuyerId;
	}	
}
