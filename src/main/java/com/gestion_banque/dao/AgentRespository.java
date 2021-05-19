package com.gestion_banque.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion_banque.entities.Agent;


public interface AgentRespository extends JpaRepository<Agent, String> {
	@Query("select u from Agent u where u.nom = ?1")
	  Collection<Agent> findByLastname(String lastname);
	
	/*@Query("select u from Agent Where u.email = ?1 and u.mdp = ?2")
	Collection<Agent> findByEmailAndPassword(String email, String mdp);*/
	
}
