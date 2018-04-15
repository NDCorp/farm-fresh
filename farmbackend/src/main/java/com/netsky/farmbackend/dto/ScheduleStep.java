package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ScheduleSteps")
public class ScheduleStep {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="productionStepsId")
	private ProductionStep productionStep;
	@ManyToOne
	@JoinColumn(name="productionSchedulesId")
	private ProductionSchedule productionSchedule;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProductionStep getProductionStep() {
		return productionStep;
	}
	public void setProductionStep(ProductionStep productionStep) {
		this.productionStep = productionStep;
	}
	public ProductionSchedule getProductionSchedule() {
		return productionSchedule;
	}
	public void setProductionSchedule(ProductionSchedule productionSchedule) {
		this.productionSchedule = productionSchedule;
	}
}
