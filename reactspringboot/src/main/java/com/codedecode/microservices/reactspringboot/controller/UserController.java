package com.codedecode.microservices.reactspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.microservices.reactspringboot.entity.User;
import com.codedecode.microservices.reactspringboot.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/allUserDetails")
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}
}
