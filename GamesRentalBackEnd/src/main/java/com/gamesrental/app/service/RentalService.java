package com.gamesrental.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesrental.app.models.Rental;
import com.gamesrental.app.repositories.IRentalRepository;

@Service
public class RentalService {

	@Autowired
	private IRentalRepository rentalRepository;
	
	public List<Rental> getAll() {
		return rentalRepository.findAll();
	}
	
	public Rental save(Rental rental) {
		return rentalRepository.save(rental);
	}
}
