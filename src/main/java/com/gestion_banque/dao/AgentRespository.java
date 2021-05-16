package com.gestion_banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_banque.entities.Agent;

public interface AgentRespository extends JpaRepository<Agent, String> {

}
