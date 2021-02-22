package com.example.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Reservation;
import com.example.demo.domain.Trip;
import com.example.demo.domain.TripInstance;
import com.example.demo.domain.repos.CustomerRepo;
import com.example.demo.domain.repos.EmployeeRepo;
import com.example.demo.domain.repos.ReservationRepo;
import com.example.demo.domain.repos.TripInstanceRepo;
import com.example.demo.domain.repos.TripRepo;

@SpringBootApplication
public class SafariApplication {
	private static final Logger log = LoggerFactory.getLogger(SafariApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SafariApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepo custrepo, EmployeeRepo emprepo, TripRepo triprepo, TripInstanceRepo tripinrepo, 
			ReservationRepo resrepo){
		
		return(args)-> {
			//Insert test data here. 
			

		}; 	
	}

}
