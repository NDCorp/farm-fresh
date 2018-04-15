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
	@Column(name= "isactive")
	@JsonIgnore
	private boolean active;
	private Date dateCreated;
	private Date dateDeleted;	
}
