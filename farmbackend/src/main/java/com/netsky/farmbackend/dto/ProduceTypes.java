package com.netsky.farmbackend.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProduceTypes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Category category;
	private String name;
	private String description;
}
