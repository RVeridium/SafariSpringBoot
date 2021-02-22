package com.example.demo.domain.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long>{
	
	public Employee getByLastName(String lastName); 

}
