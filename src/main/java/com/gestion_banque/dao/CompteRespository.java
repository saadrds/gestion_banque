package com.gestion_banque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion_banque.entities.Client;
import com.gestion_banque.entities.Compte;

public interface CompteRespository extends JpaRepository<Compte, String> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM Compte a WHERE a.rib = :rib LIMIT 1")
	List<Compte> findByRib(double rib);
	
	@Query(nativeQuery = true, value = "SELECT * FROM Compte c WHERE c.client_id_client = :id")
	List<Compte> FindComptes(String id);

}
