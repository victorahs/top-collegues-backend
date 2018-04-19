package com.example.topcolleguesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.topcolleguesbackend.entite.Collegue;

/**
 * @author Emmanuel
 *
 */
public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	Collegue findByNom(String nom);
	
	Boolean existsByNom(String nom);
	
}
