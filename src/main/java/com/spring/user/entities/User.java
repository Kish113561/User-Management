package com.spring.user.entities;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Nonnull
	private String name;
	
	@Nonnull
	private String email;
	
	private String city;
	
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	private Bank bank;
	
	
	
	public User() {
	}




	public User(String name, String email, String city, String status, Bank bank) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.status = status;
		this.bank = bank;
	}




	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	
	
}
