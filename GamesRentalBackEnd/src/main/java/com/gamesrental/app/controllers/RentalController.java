package com.gamesrental.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesrental.app.controllers.exceptions.ControledException;
import com.gamesrental.app.models.Customer;
import com.gamesrental.app.models.Rental;
import com.gamesrental.app.service.CustomerService;
import com.gamesrental.app.service.RentalService;
import com.mysql.cj.util.StringUtils;

@RestController
@RequestMapping("rental")
public class RentalController {

	@Autowired
	private RentalService rentalService;
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("all")
	List<Rental> getAll() {
		return rentalService.getAll();
	}

	@PostMapping("add")
	Rental add(@RequestBody Rental rental) {
		return rentalService.save(rental);
	}

	@GetMapping("byCustomerDocument/{customerDocument}")
	List<Rental> getByCustomer(@PathVariable("customerDocument") String document) throws ControledException {
		Customer customer = customerService.findByDocument(document);
		if(customer == null)
			throw new ControledException("The customer has not registered.");
		
		return rentalService.getByCustomer(customer);
	}
}
