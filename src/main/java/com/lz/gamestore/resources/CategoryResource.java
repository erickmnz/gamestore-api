package com.lz.gamestore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.services.CategoryService;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryS;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok().body(categoryS.findAll());
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		Category cat = categoryS.findById(id);
		return ResponseEntity.ok().body(cat); 
	
	}
	
	
	


	

}
