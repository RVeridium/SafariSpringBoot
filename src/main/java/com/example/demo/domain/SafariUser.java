package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SafariUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long userId; 
	@Column(name = "username", nullable = false, unique = true)
	private String username; 
	@Column(name = "password", nullable = false)
	private String pwHashed; 
	@Column(name = "role", nullable = false)
	private String role;
	public SafariUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SafariUser(String username, String pwHashed, String role) {
		super();
		this.username = username;
		this.pwHashed = pwHashed;
		this.role = role;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwHashed() {
		return pwHashed;
	}
	public void setPwHashed(String pwHashed) {
		this.pwHashed = pwHashed;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
