package com.gamesrental.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamesrental.app.models.Rental;

@Repository
public interface IRentalRepository extends JpaRepository<Rental, Long>{

}
