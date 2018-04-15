package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Buyers")
public class Buyer extends User{
	
	private String fbBuyerId;
	
	public String getFbBuyerId() {
		return fbBuyerId;
	}
	public void setFbBuyerId(String fbBuyerId) {
		this.fbBuyerId = fbBuyerId;
	}	
}
