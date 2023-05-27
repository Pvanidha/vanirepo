package com.codedecode.microservices.EmployeeCRUDApplication.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.microservices.EmployeeCRUDApplication.custom.exception.BusinessException;
import com.codedecode.microservices.EmployeeCRUDApplication.custom.exception.EmptyInputException;
import com.codedecode.microservices.EmployeeCRUDApplication.custom.exception.NoSuchElementException;
import com.codedecode.microservices.EmployeeCRUDApplication.entity.Employee;
import com.codedecode.microservices.EmployeeCRUDApplication.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {

		if (StringUtils.isBlank(String.valueOf(employee.getName()))) {
			throw new EmptyInputException("601", "Please enter name, its blank");
		}
		try {
			Employee newEmployee = employeeRepository.save(employee);
			return newEmployee;
		} catch (Exception e) {
			throw new BusinessException("603", "something went wrong in service layer while adding employee");
		}

	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> empList = employeeRepository.findAll();
		return empList;
	}

	@Override
	public Employee findEmployeeById(Long id) {
		if(!employeeRepository.findById(id).isPresent()) {
			throw new NoSuchElementException("604", "No value present in DB, please change your request");
		}
		Employee employee = employeeRepository.findById(id).get();
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
	}
}
