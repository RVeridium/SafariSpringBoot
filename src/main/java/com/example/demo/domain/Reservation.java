package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	//own id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resId;
	//invoiced customer
	@ManyToOne
	@JoinColumn(name = "cusId")
	private Customer customer;
	//tripInstance, single
	@ManyToOne
	@JoinColumn(name = "tripInsId")
	private TripInstance tripInstance; 
	//pax
	private int adQty, chQty;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Customer customer, TripInstance tripInstance, int adQty, int chQty) {
		super();
		this.customer = customer;
		this.tripInstance = tripInstance;
		this.adQty = adQty;
		this.chQty = chQty;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public TripInstance getTripInstance() {
		return tripInstance;
	}

	public void setTripInstance(TripInstance tripInstance) {
		this.tripInstance = tripInstance;
	}

	public int getAdQty() {
		return adQty;
	}

	public void setAdQty(int adQty) {
		this.adQty = adQty;
	}

	public int getChQty() {
		return chQty;
	}

	public void setChQty(int chQty) {
		this.chQty = chQty;
	}

	@Override
	public String toString() {
		return "Reservation [resId=" + resId + ", customer=" + customer + ", tripInstance="
				+ tripInstance + ", adQty=" + adQty + ", chQty=" + chQty + "]";
	} 
	
	
	
	
	
	

	
	
	
	
	

}
