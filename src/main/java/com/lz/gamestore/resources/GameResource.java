package com.lz.gamestore.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lz.gamestore.domains.Game;
import com.lz.gamestore.dtos.GameDTO;
import com.lz.gamestore.services.GameService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameResource {
	@Autowired
	private GameService gService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Game> findById(@PathVariable Integer id) {
		Game g = gService.findById(id);
		return ResponseEntity.ok().body(g);
	}

	@GetMapping
	public ResponseEntity<List<Game>> findAll() {
		return ResponseEntity.ok().body(gService.findAll());
	}

	@GetMapping(value="/cat_id{category}")
	public ResponseEntity<List<GameDTO>> findByCategoryId(@RequestParam(value = "category") Integer cat_id){
		List<Game> gList = gService.findByCategoryId(cat_id);
		List<GameDTO> dtoList = new ArrayList<>();
		for (Game g : gList) {
			dtoList.add(new GameDTO(g));
		}
		return ResponseEntity.ok().body(dtoList);
	}

	@PostMapping
	public ResponseEntity<Game> create(@RequestParam(value="category") Integer cat_id,@Valid Game game) {
		game = gService.create(cat_id,game);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(game.getId()).toUri();
		return ResponseEntity.created(uri).body(game);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Game> updateAll(@PathVariable Integer id, @Valid @RequestBody  Game game){
		Game g = gService.updateAll(id, game);
		return ResponseEntity.ok().body(g);
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<Game> update(@PathVariable Integer id, @Valid @RequestBody  Game game){
		Game g = gService.update(id, game);
		return ResponseEntity.ok().body(g);
	}
	

	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		gService.deleteById(id);
		return ResponseEntity.noContent().build();
	} 

}
