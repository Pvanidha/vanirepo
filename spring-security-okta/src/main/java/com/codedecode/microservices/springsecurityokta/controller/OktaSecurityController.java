package com.codedecode.microservices.springsecurityokta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/okta")
public class OktaSecurityController {

	@GetMapping("/secured")
	public ResponseEntity<String> getResponseByPassingToken() {

		return new ResponseEntity<String>("Congratulations!! Your access token is valid Go ahead!!", HttpStatus.OK);
	}
}
