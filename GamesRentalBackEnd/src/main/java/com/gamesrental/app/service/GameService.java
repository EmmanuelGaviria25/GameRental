package com.gamesrental.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamesrental.app.models.Game;
import com.gamesrental.app.repositories.IGameRepository;

@Service
public class GameService {

	@Autowired
	private IGameRepository gameRepository;
	
	public List<Game> getAll() {
		return gameRepository.findAll();
	}
	
	public Game save(Game game) {
		return gameRepository.save(game);
	}
}
