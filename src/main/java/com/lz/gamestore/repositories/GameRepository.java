package com.lz.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lz.gamestore.domains.Game;
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
