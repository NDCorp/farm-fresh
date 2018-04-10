package com.netsky.farmbackend.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public abstract class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private int farmersID; 
	private int promotionsID;
	
	@ManyToOne
	private ItemType itemType;
	private String name;
	private String description; 
	private double quantities; //(10,2) 
	private double decimal; //(8,2) 
	private boolean isActive;
	private Date dateCreated;
	private Date dateDeleted;
	
}
