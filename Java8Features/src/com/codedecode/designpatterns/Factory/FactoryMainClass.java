package com.codedecode.designpatterns.Factory;

public class FactoryMainClass {

	public static void main(String args[]) {
		ProfessionFactory profFactory = new ProfessionFactory();
		Profession prof = profFactory.getProfession("Engineer");
		prof.print();
	}
}
