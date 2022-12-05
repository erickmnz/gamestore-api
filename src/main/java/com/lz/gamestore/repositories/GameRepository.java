package com.lz.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lz.gamestore.domains.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
