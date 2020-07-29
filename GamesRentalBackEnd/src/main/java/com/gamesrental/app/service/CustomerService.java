package com.gamesrental.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesrental.app.models.Customer;
import com.gamesrental.app.repositories.ICustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
}
