package com.example.demo.domain.repos;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.domain.Reservation;


public interface ReservationRepo extends CrudRepository<Reservation, Long>{

	

}
