package com.codedecode.microservices.VaccinationCenterService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codedecode.microservices.VaccinationCenterService.entity.VaccinationCenter;

public interface VaccinationCenterRepo extends MongoRepository<VaccinationCenter, Integer>{

}
