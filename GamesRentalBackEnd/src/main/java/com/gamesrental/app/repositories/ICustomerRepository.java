package com.gamesrental.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamesrental.app.models.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
