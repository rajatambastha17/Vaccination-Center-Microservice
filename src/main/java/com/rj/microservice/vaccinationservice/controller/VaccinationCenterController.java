package com.rj.microservice.vaccinationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rj.microservice.vaccinationservice.entity.VaccinationCenter;
import com.rj.microservice.vaccinationservice.model.Citizen;
import com.rj.microservice.vaccinationservice.model.ResponseRequired;
import com.rj.microservice.vaccinationservice.repository.CenterRepository;

@RestController
@RequestMapping(path = "/vaccination-center")
public class VaccinationCenterController {
	
	@Autowired
	private CenterRepository repo; 
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter) {
		
		VaccinationCenter addedVaccinationCenter = repo.save(vaccinationCenter);
		return new ResponseEntity<>(addedVaccinationCenter, HttpStatus.OK);
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<ResponseRequired> getAllDataBasedOnCenterId(@PathVariable Integer id) {
		
		ResponseRequired response = new ResponseRequired();
		VaccinationCenter center= repo.findById(id).get();
		response.setCenter(center);
		
		List<Citizen>listOfCitizens = restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
		response.setCitizens(listOfCitizens);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
