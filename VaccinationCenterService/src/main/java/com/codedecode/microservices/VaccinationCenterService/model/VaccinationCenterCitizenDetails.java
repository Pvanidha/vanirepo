package com.codedecode.microservices.VaccinationCenterService.model;

import java.util.List;

import com.codedecode.microservices.VaccinationCenterService.entity.VaccinationCenter;

public class VaccinationCenterCitizenDetails {

	private VaccinationCenter center;
	private List<Citizen> citizenList;
	
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizenList() {
		return citizenList;
	}
	public void setCitizenList(List<Citizen> citizenList) {
		this.citizenList = citizenList;
	}
	
	
}
