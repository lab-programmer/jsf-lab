package com.example.demo_2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service


public class MobileManager {
	final MobileRepository repository;

	MobileManager(MobileRepository repository) {
		this.repository = repository;
	}
	
	public List<Mobile> getAllMobile(){
		return repository.findAll();
	}
	public Mobile getMobileById(Long id) {
		return repository.findById(id).get();
	}
	public void saveMobile(Mobile mobile) {
		repository.save(mobile);
	}
	public void deleteMobile(Long id) {
		repository.deleteById(id);
	}
	public Boolean exists(Long id) {
		return repository.existsById(id);
	}

}