package com.codedecode.designpatterns.AbstractFactory;

public class AbstractFactoryProducer {

	public static AbstractFactory getProfession(boolean trainee) {
		
		if(trainee) {
			return new TraineeProfessionAbstractFactory();
		} else {
			return new ProfessionAbstractFactory();
		}
	}
}
