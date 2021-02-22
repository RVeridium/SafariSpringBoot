package com.example.demo.domain.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long>{
	
	public Customer getByPartyName(String partyName); 
	
	

}
