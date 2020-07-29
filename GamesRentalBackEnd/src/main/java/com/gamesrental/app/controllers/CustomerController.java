package com.gamesrental.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesrental.app.models.Customer;
import com.gamesrental.app.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("all")
	List<Customer> getAll() {		
		return customerService.getAll();
	}
	
	@PostMapping("add")
	Customer add(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
}
