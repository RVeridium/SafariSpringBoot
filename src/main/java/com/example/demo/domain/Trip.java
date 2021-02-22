package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tripId; 
	private String tripName, address, target, contactFname, contactLname, contactPhone, description;
	private double list_price_ad, list_price_ch; 
	private Boolean waiver;
	@JsonIgnore
	@OneToMany (cascade = CascadeType.ALL, mappedBy ="trip")
	private List<TripInstance> tripsList;
	
	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trip(String tripName, String address, String target, String contactFname, String contactLname,
			String contactPhone, String description, double list_price_ad, double list_price_ch, Boolean waiver) {
		super();
		this.tripName = tripName;
		this.address = address;
		this.target = target;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactPhone = contactPhone;
		this.description = description;
		this.list_price_ad = list_price_ad;
		this.list_price_ch = list_price_ch;
		this.waiver = waiver;
		this.tripsList = new ArrayList<TripInstance>(); 
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getContactFname() {
		return contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactLname() {
		return contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getList_price_ad() {
		return list_price_ad;
	}

	public void setList_price_ad(double list_price_ad) {
		this.list_price_ad = list_price_ad;
	}

	public double getList_price_ch() {
		return list_price_ch;
	}

	public void setList_price_ch(double list_price_ch) {
		this.list_price_ch = list_price_ch;
	}

	public Boolean getWaiver() {
		return waiver;
	}

	public void setWaiver(Boolean waiver) {
		this.waiver = waiver;
	}

	public List<TripInstance> getTripsList() {
		return tripsList;
	}

	public void setTripsList(List<TripInstance> tripsList) {
		this.tripsList = tripsList;
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", tripName=" + tripName + ", address=" + address + ", target=" + target
				+ ", contactFname=" + contactFname + ", contactLname=" + contactLname + ", contactPhone=" + contactPhone
				+ ", description=" + description + ", list_price_ad=" + list_price_ad + ", list_price_ch="
				+ list_price_ch + ", waiver=" + waiver + "]";
	} 
	
	
	
	
	
	
	
	
	
	
	

}
