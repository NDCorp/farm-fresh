package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AddressTypes")
public class AddressType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private char acronym;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getAcronym() {
		return acronym;
	}
	public void setAcronym(char acronym) {
		this.acronym = acronym;
	}
	
	
}
