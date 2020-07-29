package com.gamesrental.app.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255, nullable = false)
	private String name;
	
	@Column(nullable = false)
    @Value("0")
	private Integer availableStock;

	@Column(nullable = false)
    @Value("0")
	private Integer pricePerHour;

//    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Rental> rentals = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "supported_platform")
    private Set<Platform> platforms;
    
    @ManyToMany
    @JoinTable(name = "director_game")
    private Set<Director> directors;
    
    @ManyToMany
    @JoinTable(name = "producer_game")
    private Set<Producer> producers;
    
	public Game() {}

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

	public Integer getAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(Integer availableStock) {
		this.availableStock = availableStock;
	}

	public Integer getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Integer pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

//	public List<Rental> getRentals() {
//		return rentals;
//	}
//
//	public void setRentals(List<Rental> rentals) {
//		this.rentals = rentals;
//	}

	public Set<Platform> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(Set<Platform> platforms) {
		this.platforms = platforms;
	}

	public Set<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	public Set<Producer> getProducers() {
		return producers;
	}

	public void setProducers(Set<Producer> producers) {
		this.producers = producers;
	}
	
}
