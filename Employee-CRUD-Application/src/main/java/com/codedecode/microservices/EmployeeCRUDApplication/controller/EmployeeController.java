package com.codedecode.microservices.EmployeeCRUDApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codedecode.microservices.EmployeeCRUDApplication.entity.Employee;
import com.codedecode.microservices.EmployeeCRUDApplication.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		
		List<Employee> empList = employeeService.findAllEmployees();
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}
	
	@GetMapping("/getById/id/{id}")
	public ResponseEntity<?> findEmpById(@PathVariable Long id) {

			Employee employee = employeeService.findEmployeeById(id);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmpById/id/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable Long id) {
		
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.ACCEPTED);
	}
	
	
}
