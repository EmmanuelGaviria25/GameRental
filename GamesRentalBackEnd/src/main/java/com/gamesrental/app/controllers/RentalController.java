package com.gamesrental.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesrental.app.models.Rental;
import com.gamesrental.app.service.RentalService;

@RestController
@RequestMapping("rental")
public class RentalController {

	@Autowired
	private RentalService rentalService;
	
	@GetMapping("all")
	List<Rental> getAll() {
		return rentalService.getAll();
	}
	
	@PostMapping("add")
	Rental add(@RequestBody Rental rental) {
		return rentalService.save(rental);
	}
}
