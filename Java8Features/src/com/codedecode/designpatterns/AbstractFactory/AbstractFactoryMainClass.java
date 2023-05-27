package com.codedecode.designpatterns.AbstractFactory;

public class AbstractFactoryMainClass {

	public static void main (String args[]) {
		
		AbstractFactory absFactory = AbstractFactoryProducer.getProfession(true);
		Profession prof = absFactory.getProfession("TraineeEngineer");
		prof.print();
	}
}
