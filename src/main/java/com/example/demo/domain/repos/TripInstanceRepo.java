package com.example.demo.domain.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.TripInstance;

public interface TripInstanceRepo extends CrudRepository<TripInstance, Long>{
	
	public TripInstance getByEmployeeLastName(String lastName); 
	

}
