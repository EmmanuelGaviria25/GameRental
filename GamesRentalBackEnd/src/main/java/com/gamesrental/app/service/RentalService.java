package com.gamesrental.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gamesrental.app.models.Customer;
import com.gamesrental.app.models.Rental;
import com.gamesrental.app.repositories.IRentalRepository;

@Service
public class RentalService {

	@Autowired
	private IRentalRepository rentalRepository;
	
	public List<Rental> getAll() {
		return rentalRepository.findAll(Sort.by(Sort.Direction.ASC, "finalDate"));
	}
	
	public Rental save(Rental rental) {
		return rentalRepository.save(rental);
	}

	public List<Rental> getByCustomer(Customer customer) {
		return rentalRepository.findByCustomer(customer);

	}
}
