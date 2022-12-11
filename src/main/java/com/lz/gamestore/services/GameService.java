package com.lz.gamestore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.domains.Game;
import com.lz.gamestore.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gRepository;
	
	public Game findById(Integer id) {
		Optional<Game> g = gRepository.findById(id);
		return g.orElse(null);
	}
	

	
	public List<Game> findAll(){
		
		return gRepository.findAll();
	}
	
	public Game create(Game game) {
		game.setId(null);
		return gRepository.save(game);
	}
	


}
