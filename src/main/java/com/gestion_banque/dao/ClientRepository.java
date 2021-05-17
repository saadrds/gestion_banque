package com.gestion_banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_banque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, String>{
	
	
}
