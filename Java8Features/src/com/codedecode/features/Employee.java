package com.codedecode.features;

import java.util.List;

public class Employee {

	private int id;
	private String name;
	private String emailId;
	private List<String> phoneNoList;
	
	public Employee(int id, String name, String emailId, List<String> phoneNoList) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.phoneNoList = phoneNoList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<String> getPhoneNoList() {
		return phoneNoList;
	}
	public void setPhoneNoList(List<String> phoneNoList) {
		this.phoneNoList = phoneNoList;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", emailId=" + emailId + ", phoneNoList=" + phoneNoList + "]";
	}
	
}
