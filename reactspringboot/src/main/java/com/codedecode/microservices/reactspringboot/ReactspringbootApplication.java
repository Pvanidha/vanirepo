package com.codedecode.microservices.reactspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codedecode.microservices.reactspringboot.entity.User;
import com.codedecode.microservices.reactspringboot.repository.UserRepository;

@SpringBootApplication
public class ReactspringbootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ReactspringbootApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		this.userRepository.save(new User(Long.valueOf(1), "Vanidha", "Parthiban", "VanidhaParthiban@gmail.com"));
		this.userRepository.save(new User(Long.valueOf(2), "Ashok", "sembu", "sembuashok@gmail.com"));
		this.userRepository.save(new User(Long.valueOf(3), "Sreya", "sa", "sreyasa@gmail.com"));
	}

}
