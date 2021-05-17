package com.gestion_banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_banque.entities.Compte;

public interface CompteRespository extends JpaRepository<Compte, String> {
	
	

}
