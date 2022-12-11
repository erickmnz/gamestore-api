package com.lz.gamestore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.domains.Game;
import com.lz.gamestore.repositories.CategoryRepository;
import com.lz.gamestore.repositories.GameRepository;

@Service
public class DBService {
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void instantiateDB() {
		Category c1 = new Category(null, "Horror");
		Category c2 = new Category(null, "Fantasy");
		
		Game g1 = new Game(null, "Resident Evil","lore","Capcom", c1);
		Game g2 = new Game(null, "Dead space", "lore","EA Games",c1);
		Game g3 = new Game(null, "Lord of the Rings War in the North", "lore", "EA Games",c2);

		
		c1.getGames().addAll(Arrays.asList(g1,g2));
		c2.getGames().addAll(Arrays.asList(g3));
		


		
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		gameRepository.saveAll(Arrays.asList(g1, g2, g3));
		}
}
