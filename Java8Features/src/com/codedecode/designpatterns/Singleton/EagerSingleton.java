package com.codedecode.designpatterns.Singleton;

public class EagerSingleton {

	private EagerSingleton() {

	}

	private static final EagerSingleton instance = new EagerSingleton();

	public static EagerSingleton getInstance() {
		return instance;
	}

	public static void main(String args[]) {

		EagerSingleton es = EagerSingleton.getInstance();
		System.out.println("eager Singleton es: " + es.hashCode());

		EagerSingleton es1 = EagerSingleton.getInstance();
		System.out.println("eager Singleton es1: " + es1.hashCode());
	}
}
