package com.codedecode.designpatterns.AbstractFactory;

public class TraineeProfessionAbstractFactory extends AbstractFactory {

	@Override
	Profession getProfession(String typeOfProfession) {
		if (typeOfProfession.equalsIgnoreCase("TraineeEngineer")) {
			return new TraineeEngineer();
		} else if (typeOfProfession.equalsIgnoreCase("TraineeTeacher")) {
			return new TraineeTeacher();
		}
		return null;
	}

}
