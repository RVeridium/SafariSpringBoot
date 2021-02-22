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
			log.info("Creating customers");
			custrepo.save(new Customer("Miller", false)); 
			custrepo.save(new Customer("Corey", true)); 
			log.info("Creating safaris");
			triprepo.save(new Trip("SnowVillage", "Lainiontie 2", "Lainio SnowVillage", "Helene", 
					"Curie", "040658932", "Trip to SnowVillage to see Santa", 30.50, 17.40, false)); 
			triprepo.save(new Trip("Elf village", "Könkääntie 42", "Tonttula", "Perttu", "Palovaara", 
					"023565146", "Come to see Santa and experience winter with elves", 34.80, 25.30, false)); 
			triprepo.save(new Trip("Snomobiles at night", "Levinraitti 14", "SM routes", "Sakari", "Moottori",
					"35413205", "Come drive a snowmobile at night, with warm juice and gingerbread cookies", 140.40, 0, true)); 
			log.info("Create employees"); 
			emprepo.save(new Employee("Mark", "Villiers", "0543689123")); 
			emprepo.save(new Employee("Maria", "Loponen", "0325313513")); 
			log.info("Create TripInstances");
			tripinrepo.save(new TripInstance(triprepo.findByTripName("SnowVillage"), emprepo.getByLastName("Loponen"), 
					30.50, 17.40, LocalDateTime.of(2021, 11, 27, 14, 30), LocalDateTime.of(2021, 11, 27, 16, 0))); 
			tripinrepo.save(new TripInstance(triprepo.findByTripName("Elf village"), emprepo.getByLastName("Villiers"), 
					34.80, 25.30, LocalDateTime.of(2021, 11, 28, 12, 0), LocalDateTime.of(2021, 11, 28, 15, 30))); 
			log.info("Create reservations");
			resrepo.save(new Reservation(custrepo.getByPartyName("Miller"), tripinrepo.getByEmployeeLastName("Villiers"), 2, 2));
			resrepo.save(new Reservation(custrepo.getByPartyName("Corey"), tripinrepo.getByEmployeeLastName("Loponen"), 1, 2));
			

		}; 	
	}

}
