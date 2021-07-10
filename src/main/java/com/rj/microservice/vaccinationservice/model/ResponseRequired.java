package com.rj.microservice.vaccinationservice.model;

import java.util.List;

import com.rj.microservice.vaccinationservice.entity.VaccinationCenter;

public class ResponseRequired {

	private VaccinationCenter center;
	private List<Citizen> citizens;	
	
	public ResponseRequired() {
		super();
	}
	
	public ResponseRequired(VaccinationCenter center, List<Citizen> citizens) {
		super();
		this.center = center;
		this.citizens = citizens;
	}

	public VaccinationCenter getCenter() {
		return center;
	}

	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	
}
