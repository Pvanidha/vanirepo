package com.codedecode.microservices.EmployeeCRUDApplication.service;

import java.util.List;

import com.codedecode.microservices.EmployeeCRUDApplication.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> findAllEmployees();

	public Employee findEmployeeById(Long id);
	
	public void deleteEmployeeById(Long id);
}
