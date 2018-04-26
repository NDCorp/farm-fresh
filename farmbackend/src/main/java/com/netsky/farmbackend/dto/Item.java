
package com.netsky.farmbackend.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Items")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="farmersId", referencedColumnName="id")
	private Farmer farmer;
	@ManyToOne
	@JoinColumn(name="promotionsId", referencedColumnName="id")
	private Promotion promotion;
	@ManyToOne
	@JoinColumn(name="itemTypesId", referencedColumnName="id")
	private ItemType itemType;	
	private String name;
	private String description;
	@Column(name= "quantities")
	private double quantity;
	@Column(name= "price")
	@JsonIgnore
	private double unitPrice;
	@JsonIgnore
	private boolean isActive;
	private Date dateCreated;
	private Date dateDeleted;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateDeleted() {
		return dateDeleted;
	}
	public void setDateDeleted(Date dateDeleted) {
		this.dateDeleted = dateDeleted;
	}	
}
