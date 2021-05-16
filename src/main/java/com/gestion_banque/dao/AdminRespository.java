package com.gestion_banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_banque.entities.Admin;

public interface AdminRespository extends JpaRepository<Admin, String>{

}
