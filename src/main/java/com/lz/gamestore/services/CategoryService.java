package com.lz.gamestore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.dtos.CategoryDTO;
import com.lz.gamestore.repositories.CategoryRepository;
import com.lz.gamestore.services.exceptions.ObjNotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepository;
	
	
	public List<CategoryDTO> findAll(){
		List<CategoryDTO> allCat = new ArrayList<>();
		for(Category cat: cRepository.findAll()) {
			allCat.add(new CategoryDTO( cat));
		}
		return allCat;
	}
	
	public Category findById(Integer id) {
		Optional<Category> cat = cRepository.findById(id);
		return cat.orElseThrow(()-> new ObjNotFoundException("Object not found! id:"+id));
	}
	
	public Category createCategory(Category category) {
		category.setId(null);
		return cRepository.save(category);
		
	}

	
	
	
}
