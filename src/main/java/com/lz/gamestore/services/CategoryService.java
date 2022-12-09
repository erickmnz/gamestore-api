package com.lz.gamestore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepository;
	
	
	public List<Category> findAll(){
		return cRepository.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> cat = cRepository.findById(id);
		return cat.get();
	}
	

	
	
	
}
