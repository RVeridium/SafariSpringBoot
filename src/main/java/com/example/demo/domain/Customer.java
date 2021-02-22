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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long custId; 
	private String partyName; 
	private Boolean walkIn;
	
	@JsonIgnore
	@OneToMany (cascade = CascadeType.ALL, mappedBy ="customer")
	private List<Reservation> resList; 
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String partyName, Boolean walkIn) {
		super();
		this.partyName = partyName;
		this.walkIn = walkIn;
		this.resList = new ArrayList<Reservation>(); 
		
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public Boolean getWalkIn() {
		return walkIn;
	}

	public void setWalkIn(Boolean walkIn) {
		this.walkIn = walkIn;
	}

	public List<Reservation> getResList() {
		return resList;
	}

	public void setResList(List<Reservation> resList) {
		this.resList = resList;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", partyName=" + partyName + ", walkIn=" + walkIn + ", resList=" + resList
				+ "]";
	}
	
	
	
	

}
