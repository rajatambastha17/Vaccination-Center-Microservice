package com.rj.microservice.vaccinationservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCenter {
	
	public VaccinationCenter() {
		super();
	}

	public VaccinationCenter(int id, String name, String centerAddress) {
		super();
		this.id = id;
		this.name = name;
		this.centerAddress = centerAddress;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String centerAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

	@Override
	public String toString() {
		return "VaccinationCenter [id=" + id + ", name=" + name + ", centerAddress=" + centerAddress + "]";
	}
	
}
