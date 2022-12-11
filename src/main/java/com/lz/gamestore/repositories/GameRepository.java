package com.lz.gamestore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lz.gamestore.domains.Game;
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

	@Query("SELECT i from Game i WHERE i.category.id=?1 ORDER BY i.title")
	List<Game> findByCategoryId( Integer cat_id);
	
}
