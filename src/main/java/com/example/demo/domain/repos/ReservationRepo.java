package com.example.demo.domain.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Reservation;
import com.example.demo.domain.TripInstance;

public interface ReservationRepo extends CrudRepository<Reservation, Long>{

	

}
