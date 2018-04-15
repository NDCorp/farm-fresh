package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Packs")
public class Pack extends Item{
	//Will inherit from Item class
	//add specific properties of Pack here...

	
}
