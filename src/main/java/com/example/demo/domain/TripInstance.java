package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TripInstance {
	//own id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tripInsId; 
	//multiple reservations, make List
	@JsonIgnore
	@OneToMany
	(cascade = CascadeType.ALL, mappedBy ="tripInstance")
	private List<Reservation> resList; 
	//many-to-one
	@ManyToOne
	@JoinColumn(name = "tripId")
	private Trip trip; 
	//single employee/guide
	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee employee; 
	//invoicing-price
	private double price_ad, price_ch; 
	//predicted start/end time. 
	private LocalDateTime startTime, endTime;
	
	public TripInstance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TripInstance(Trip trip, Employee employee, double price_ad, double price_ch, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.trip = trip;
		this.employee = employee;
		this.price_ad = price_ad;
		this.price_ch = price_ch;
		this.startTime = startTime;
		this.endTime = endTime;
		this.resList = new ArrayList<Reservation>(); 
	}

	public Long getTripInsId() {
		return tripInsId;
	}

	public void setTripInsId(Long tripInsId) {
		this.tripInsId = tripInsId;
	}

	public List<Reservation> getResList() {
		return resList;
	}

	public void setResList(List<Reservation> resList) {
		this.resList = resList;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getPrice_ad() {
		return price_ad;
	}

	public void setPrice_ad(double price_ad) {
		this.price_ad = price_ad;
	}

	public double getPrice_ch() {
		return price_ch;
	}

	public void setPrice_ch(double price_ch) {
		this.price_ch = price_ch;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public int adultQ() {
		int result = 0; 
		for (int i = 0; i <resList.size(); i++) {
			result += resList.get(i).getAdQty(); 
		}
		return result; 
	}
	
	public int childQ() {
		int result = 0; 
		for (int i = 0; i <resList.size(); i++) {
			result += resList.get(i).getChQty();  
		}
		return result; 
	}

	@Override
	public String toString() {
		return "TripInstance [tripInsId=" + tripInsId + ", resList=" + resList + ", trip=" + trip + ", employee="
				+ employee + ", price_ad=" + price_ad + ", price_ch=" + price_ch + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	} 
	
	
	
	
	

}
