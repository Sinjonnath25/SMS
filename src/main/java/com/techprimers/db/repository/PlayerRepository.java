package com.techprimers.db.repository;

import com.techprimers.db.model.Player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	List<Player> findByName(String name);
	
}
