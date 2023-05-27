package com.codedecode.springbootaws.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aws")
public class SpringBootAWSController {

	@RequestMapping("/get")
	public ResponseEntity<String> displayStringInAWS() {
		return new ResponseEntity<String>(
				"Congratulations!! Successfully deployed Spring boot app into AWS EC2 instance", HttpStatus.OK);
	}
}
