package com.codedecode.microservices.CitizenService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Citizen")
public class Citizen {
	
	@Id
	private int id;
	private String name;
	private int vaccinationCenterId;
	
}
