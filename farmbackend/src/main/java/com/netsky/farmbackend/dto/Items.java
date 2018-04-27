package com.netsky.farmbackend.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Items dto
@Entity
@Table(name = "Items")
// @Inheritance(strategy = InheritanceType.JOINED)
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "farmersId", referencedColumnName = "id")
	private Farmer farmer;
	@ManyToOne
	@JoinColumn(name = "promotionsId", referencedColumnName = "id")
	private Promotion promotion;
	@ManyToOne
	@JoinColumn(name = "itemTypesId", referencedColumnName = "id")
	private ItemType itemType;
	private String name;
	private String description;
	@Column(name = "quantities")
	private int quantity;
	@Column(name = "price")
	@JsonIgnore
	private double unitPrice;
	@Column(name = "isactive")
	@JsonIgnore
	private boolean active;
	private Date dateCreated;
	private Date dateDeleted;

	public Items() {
			// this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
		}

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
		return "Product [id=" + id + ", farmersId=" + farmer.getId() + ", promotionsId=" + promotion.getId()
				+ ", itemTypesId=" + itemType.getId() + ", Name=" + name + ", description=" + description
				+ ", quantity=" + quantity + ", price=" + unitPrice + ", isActive=" + active + ", dateCreated="
				+ dateCreated + ", dateDeleted=" + dateDeleted + "]";
	}

}
