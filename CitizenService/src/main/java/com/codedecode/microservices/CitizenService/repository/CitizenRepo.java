package com.codedecode.microservices.CitizenService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codedecode.microservices.CitizenService.entity.Citizen;

public interface CitizenRepo extends MongoRepository<Citizen, Integer>{

	public List<Citizen> findByVaccinationCenterId(Integer id);
}
