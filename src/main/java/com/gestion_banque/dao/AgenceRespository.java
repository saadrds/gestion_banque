package com.gestion_banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_banque.entities.Agence;

public interface AgenceRespository extends JpaRepository<Agence, String>{

}
