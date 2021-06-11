package com.gestion_banque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion_banque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, String>{
	
	//@Query("select u from Agent Where u.email = ?1 and u.mdp = ?2")
		@Query(nativeQuery = true, value = "SELECT * FROM Client a WHERE a.email = :email and a.mdp = :mdp LIMIT 1")
		List<Client> findByEmailAndPassword(String email, String mdp);
		
		@Query(nativeQuery = true, value = "SELECT * FROM Client c WHERE c.agent = :id")
		List<Client> FindClients(String id);
	
}
