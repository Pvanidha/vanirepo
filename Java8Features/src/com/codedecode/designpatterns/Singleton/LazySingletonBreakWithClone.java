package com.codedecode.designpatterns.Singleton;

public class LazySingletonBreakWithClone extends MyClone {

	private LazySingletonBreakWithClone() {

	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	private static LazySingletonBreakWithClone instance;

	public static LazySingletonBreakWithClone getInstance() {

		if (instance == null) {

			synchronized (LazySingletonBreakWithClone.class) {

				if (instance == null) {

					return instance = new LazySingletonBreakWithClone();
				}
			}
		}
		return instance;
	}

	public static void main(String args[]) throws CloneNotSupportedException {

		LazySingletonBreakWithClone es = LazySingletonBreakWithClone.getInstance();
		System.out.println("Lazy Singleton es: " + es.hashCode());

		LazySingletonBreakWithClone es1 = (LazySingletonBreakWithClone)es.clone();
		System.out.println("Lazy Singleton es1: " + es1.hashCode());
	}
}
