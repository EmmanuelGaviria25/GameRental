package com.gamesrental.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamesrental.app.models.Game;
import com.gamesrental.app.service.GameService;

@RestController
@RequestMapping("game")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping("all")
	List<Game> getAll() {		
		return gameService.getAll();
	}
	
	@PostMapping("add")
	Game add(@RequestBody Game game) {
		return gameService.save(game);
	}
}
