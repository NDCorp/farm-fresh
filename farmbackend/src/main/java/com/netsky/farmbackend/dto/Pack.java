package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Packs")
public class Pack extends Item{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private int itemsId;
}
