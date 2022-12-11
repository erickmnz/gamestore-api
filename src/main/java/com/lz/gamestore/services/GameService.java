package com.lz.gamestore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lz.gamestore.domains.Game;
import com.lz.gamestore.dtos.GameDTO;
import com.lz.gamestore.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gRepository;
	@Autowired
	private CategoryService catService;

	public Game findById(Integer id) {
		Optional<Game> g = gRepository.findById(id);
		return g.orElse(null);
	}

	public List<Game> findAll() {

		return gRepository.findAll();
	}

	public Game create(Game game) {
		game.setId(null);
		return gRepository.save(game);
	}



	public void deleteById(Integer id) {
		Game game = findById(id);

		gRepository.deleteById(id);

	}

	public List<Game> findByCategoryId(Integer cat_id) {
		catService.findById(cat_id);
		return gRepository.findByCategoryId(cat_id);
	}



	public Game updateTitle(Integer id, GameDTO game) {
		Game g = findById(id);
		return gRepository.save(g);
	}

}
