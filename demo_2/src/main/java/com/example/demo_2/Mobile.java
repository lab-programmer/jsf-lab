package com.example.demo_2;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity


public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long id;
	String name, model, osystem;
	
	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOsystem() {
		return osystem;
	}

	public void setOsystem(String osystem) {
		this.osystem = osystem;
	}
	

}