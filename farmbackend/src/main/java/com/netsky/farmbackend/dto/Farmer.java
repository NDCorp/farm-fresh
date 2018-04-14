package com.netsky.farmbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Farmers")
//@PrimaryKeyJoinColumn(name="usersId")
public class Farmer extends User{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	//private int usersId; 
	
	@ManyToOne
	@JoinColumn(name="farmsId") //, referencedColumnName="id"
	private Farm farm;
	
	@ManyToOne
	@JoinColumn(name="farmerTypeId") //, referencedColumnName="id"
	private FarmerType farmerType;
	private String positionName;
	private String webSite;
	/*
	@OneToOne
	@JoinColumn(name="usersId") //, referencedColumnName="id"
	private User user; 
	*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
	public FarmerType getFarmerType() {
		return farmerType;
	}
	public void setFarmerType(FarmerType farmerType) {
		this.farmerType = farmerType;
	}
	/*
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	*/
	
	
}
