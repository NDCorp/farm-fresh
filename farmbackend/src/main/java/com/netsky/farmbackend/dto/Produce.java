package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Produce")
public class Produce extends Item{
	//Will inherit from Item class
	//add specific properties of Pack here...
	@ManyToOne
	@JoinColumn(name="productionTypesId", referencedColumnName="id")
	private ProductionType productionType; 
	@ManyToOne
	@JoinColumn(name="produceTypesId", referencedColumnName="id") 
	private ProduceType produceType;
	@ManyToOne
	@JoinColumn(name="categoriesId", referencedColumnName="id") 
	private Category category;
	
	public ProductionType getProductionType() {
		return productionType;
	}
	public void setProductionType(ProductionType productionType) {
		this.productionType = productionType;
	}
	public ProduceType getProduceType() {
		return produceType;
	}
	public void setProduceType(ProduceType produceType) {
		this.produceType = produceType;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
