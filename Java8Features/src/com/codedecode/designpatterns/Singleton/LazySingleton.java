package com.codedecode.designpatterns.Singleton;

public class LazySingleton {

	private LazySingleton() {

	}

	private static LazySingleton instance;

	public static LazySingleton getInstance() {

		if (instance == null) {

			synchronized (LazySingleton.class) {

				if (instance == null) {

					return instance = new LazySingleton();
				}
			}
		}
		return instance;
	}

	public static void main(String args[]) {

		LazySingleton es = LazySingleton.getInstance();
		System.out.println("Lazy Singleton es: " + es.hashCode());

		LazySingleton es1 = LazySingleton.getInstance();
		System.out.println("Lazy Singleton es1: " + es1.hashCode());
	}
}
