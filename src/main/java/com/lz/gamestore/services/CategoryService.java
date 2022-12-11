package com.lz.gamestore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.dtos.CategoryDTO;
import com.lz.gamestore.repositories.CategoryRepository;
import com.lz.gamestore.services.exceptions.DataIntegrityException;
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

	public Category update(Integer id, CategoryDTO catDTO) {
		Category cat = findById(id);
		cat.setName(catDTO.getName());
		
		return cRepository.save(cat);
	}

	public void delete(Integer id) {
		Category cat = findById(id);
		try {
			cRepository.deleteById(id);

		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Category can not be delete: "
					+ "Has one or more associations to it");
		}
	
	}

	
	
	
}
