package com.codedecode.features;

@FunctionalInterface
public interface FunctionalInterfaceDemo {

	//single abstract method and any no of static and default methods
	void singleAbstractMethod();
	
	default void printName() {
		System.out.println("Welcome to print name");
	}
	
	static void printName2() {
	
		System.out.println("Welcome to print name 2");
	}
}
