package com.example.demo.domain.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.SafariUser;

public interface SafUserRepo extends CrudRepository<SafariUser, Long>{
	
	SafariUser findByUsername(String username); 

}
