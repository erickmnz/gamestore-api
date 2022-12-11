package com.lz.gamestore.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.domains.Game;
import com.lz.gamestore.services.GameService;

@RestController
@RequestMapping("/games")
public class GameResource {
	@Autowired
	private GameService gService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Game> findById(@PathVariable Integer id){
		Game g = gService.findById(id);
		return ResponseEntity.ok().body(g);
	}
	

	
	
	@GetMapping
	public ResponseEntity<List<Game>> findAll(){
		return ResponseEntity.ok().body(gService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Game> create(Game game){
		game = gService.create(game);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(game.getId()).toUri();
		return ResponseEntity.created(uri).body(game);
	}
	
	

}
