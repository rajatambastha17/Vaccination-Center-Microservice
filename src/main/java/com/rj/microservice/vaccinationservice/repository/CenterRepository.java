package com.rj.microservice.vaccinationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rj.microservice.vaccinationservice.entity.VaccinationCenter;

public interface CenterRepository extends JpaRepository<VaccinationCenter, Integer> {

}
