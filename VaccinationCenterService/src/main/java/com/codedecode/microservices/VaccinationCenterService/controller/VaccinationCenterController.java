package com.codedecode.microservices.VaccinationCenterService.controller;

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
import org.springframework.web.client.RestTemplate;

import com.codedecode.microservices.VaccinationCenterService.entity.VaccinationCenter;
import com.codedecode.microservices.VaccinationCenterService.model.Citizen;
import com.codedecode.microservices.VaccinationCenterService.model.VaccinationCenterCitizenDetails;
import com.codedecode.microservices.VaccinationCenterService.repository.VaccinationCenterRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

	@Autowired
	private VaccinationCenterRepo centerRepo;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/addCenter")
	public ResponseEntity<VaccinationCenter> saveCenterInfo(@RequestBody VaccinationCenter vaccinationCenter) {

		VaccinationCenter centerInfo = centerRepo.save(vaccinationCenter);
		return new ResponseEntity<VaccinationCenter>(centerInfo, HttpStatus.CREATED);
	}

	@GetMapping("/getVaccinationCenterCitizenDetails/id/{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenDowntime")
	public ResponseEntity<VaccinationCenterCitizenDetails> getVaccinationCenterCitizenDetails(
			@PathVariable Integer id) {

		VaccinationCenterCitizenDetails vaccinationCenterCitizenDetails = new VaccinationCenterCitizenDetails();
		VaccinationCenter centerInfo = centerRepo.findById(id).get();
		vaccinationCenterCitizenDetails.setCenter(centerInfo);

		List<Citizen> citizenList = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/findByVaccId/" + id, List.class);
		vaccinationCenterCitizenDetails.setCitizenList(citizenList);

		return new ResponseEntity<VaccinationCenterCitizenDetails>(vaccinationCenterCitizenDetails, HttpStatus.OK);
	}
	
	public ResponseEntity<VaccinationCenterCitizenDetails> handleCitizenDowntime(
			@PathVariable Integer id) {

		VaccinationCenterCitizenDetails vaccinationCenterCitizenDetails = new VaccinationCenterCitizenDetails();
		VaccinationCenter centerInfo = centerRepo.findById(id).get();
		vaccinationCenterCitizenDetails.setCenter(centerInfo);

		return new ResponseEntity<VaccinationCenterCitizenDetails>(vaccinationCenterCitizenDetails, HttpStatus.OK);
	}
}
