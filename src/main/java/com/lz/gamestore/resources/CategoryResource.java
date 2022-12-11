package com.lz.gamestore.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.dtos.CategoryDTO;
import com.lz.gamestore.services.CategoryService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryS;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		return ResponseEntity.ok().body(categoryS.findAll());
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		Category cat = categoryS.findById(id);
		return ResponseEntity.ok().body(cat); 
	
	}
	@GetMapping(value="/n{name}")
	public ResponseEntity<Category> findGamesByCategory(@RequestParam String name){
		Category c = categoryS.findGamesByCategory(name);
		return ResponseEntity.ok().body(c);
	}
	
	@PostMapping
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
		category = categoryS.createCategory(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).body(category);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer id, @Valid @RequestBody CategoryDTO catDTO){
		Category cat = categoryS.update(id, catDTO);
		return ResponseEntity.ok().body(new CategoryDTO(cat));
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
		categoryS.delete(id);
		return ResponseEntity.noContent().build();
	}

	

}
