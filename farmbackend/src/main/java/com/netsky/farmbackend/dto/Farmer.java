package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Farmers")
public class Farmer extends User{
	//Will inherit from User class
	//add specific properties of Farmer here...
	@ManyToOne
	@JoinColumn(name="farmsId", referencedColumnName="id") 
	private Farm farm;	
	@ManyToOne
	@JoinColumn(name="farmerTypeId", referencedColumnName="id")
	private FarmerType farmerType;
	private String positionName;
	private String webSite;

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
}
