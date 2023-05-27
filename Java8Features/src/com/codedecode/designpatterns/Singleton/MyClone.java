package com.codedecode.designpatterns.Singleton;

import java.io.Serializable;

public class MyClone implements Cloneable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
