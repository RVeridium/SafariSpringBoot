package com.example.demo.domain.repos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Trip;

public interface TripRepo extends CrudRepository<Trip, Long>{
	
	public Trip findByTripName(String tripName);
	public Optional<Trip> findById(Long tripId); 
	
	  
	
	
	

}
