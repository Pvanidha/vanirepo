package com.codedecode.microservices.CitizenService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.microservices.CitizenService.entity.Citizen;
import com.codedecode.microservices.CitizenService.repository.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

	@Autowired
	private CitizenRepo citizenRepo;
	
	@PostMapping("/addCitizen")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
		
		Citizen newCitizen = citizenRepo.save(citizen);
		return new ResponseEntity<Citizen>(newCitizen, HttpStatus.CREATED);
	}
	
	@GetMapping("/findByVaccId/{id}")
	public ResponseEntity<List<Citizen>> getAllCitizenDetails(@PathVariable Integer id) {
		
		List<Citizen> citizenList = citizenRepo.findByVaccinationCenterId(id);
		return new ResponseEntity<>(citizenList, HttpStatus.OK);
	}
}
