package com.codedecode.designpatterns.Factory;

public class ProfessionFactory {

	public Profession getProfession (String typeOfProfession) {
		
		if(typeOfProfession.equalsIgnoreCase("Teacher")) {
			return new Teacher();
		} else if(typeOfProfession.equalsIgnoreCase("Engineer")) {
			return new Engineer();
		}
		return null;
	}
}
