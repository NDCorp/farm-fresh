package com.netsky.farmbackend.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Items dto
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int farmersId;
	private int promotionsId;
	private int itemTypesId;
	
	private String name;
	private String description;
	@Column(name= "quantities")
	private int quantity;
	@Column(name= "price")
	@JsonIgnore
	private double unitPrice;
	@Column(name= "isactive")
	@JsonIgnore
	private boolean active;
	private Date dateCreated;
	private Date dateDeleted;
	
	public Product() {
		//this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFarmersId() {
		return farmersId;
	}

	public void setFarmersId(int farmersId) {
		this.farmersId = farmersId;
	}

	public int getPromotionsId() {
		return promotionsId;
	}

	public void setPromotionsId(int promotionsId) {
		this.promotionsId = promotionsId;
	}

	public int getItemTypesId() {
		return itemTypesId;
	}

	public void setItemTypesId(int itemTypesId) {
		this.itemTypesId = itemTypesId;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", farmersId=" + farmersId + ", promotionsId=" + promotionsId + ", itemTypesId=" + itemTypesId + ", Name="
				+ name + ", description=" + description + ", quantity=" + quantity + ", price=" + unitPrice
				+ ", isActive=" + active + ", dateCreated=" + dateCreated + ", dateDeleted=" + dateDeleted + "]";
	}
	
	/*
	private String code;
	private String brand;
	@Column(name= "category_id")
	@JsonIgnore
	private int categoryId;
	@Column(name= "supplier_id")
	@JsonIgnore
	private int supplierId;
	private int purchases;
	private int views;
	*/

	/*
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	*/

	
	
}
