package com.lz.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lz.gamestore.domains.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
	
	@Query("select u from Category u where u.name=?1")
	Category findGamesByCategory(String name);
}
