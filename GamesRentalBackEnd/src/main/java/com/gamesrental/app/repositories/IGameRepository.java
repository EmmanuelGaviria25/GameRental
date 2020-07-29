package com.gamesrental.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamesrental.app.models.Game;

@Repository
public interface IGameRepository extends JpaRepository<Game, Long>{

}
