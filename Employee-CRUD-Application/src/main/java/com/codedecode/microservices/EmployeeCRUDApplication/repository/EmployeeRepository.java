package com.codedecode.microservices.EmployeeCRUDApplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codedecode.microservices.EmployeeCRUDApplication.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

}
