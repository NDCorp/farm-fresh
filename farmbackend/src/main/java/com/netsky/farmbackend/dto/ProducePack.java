package com.netsky.farmbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ProducePacks")
public class ProducePack {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="produceId", referencedColumnName="id")
	private Produce produce;
	@ManyToOne
	@JoinColumn(name="packsId", referencedColumnName="id")
	private Pack pack;
	@Column(name="Quantities")
	private double quantity;	//decimal(10,2)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produce getProduce() {
		return produce;
	}
	public void setProduce(Produce produce) {
		this.produce = produce;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
