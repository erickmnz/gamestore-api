package com.lz.gamestore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.domains.Game;
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
	
	//@Query("SELECT * FROM tb_game WHERE tb_game.title=?1")
	//Game findByName(Category title);
	//@Query("SELECT * FROM TB_GAME INNER JOIN TB_CATEGORY ON TB_CATEGORY.ID=TB_GAME.CATEGORY_ID WHERE TB_CATEGORY.NAME=?1")
	//List<Game> findByCategory(Category title);
	
}
