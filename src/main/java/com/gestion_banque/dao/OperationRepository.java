package com.gestion_banque.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion_banque.entities.Compte;
import com.gestion_banque.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
    
    
    // solution 1 
    @Query("select o from Operation o where o.compte.id_compte=:x")
    public Page<Operation> getOperations( @Param("x") String code, Pageable pageable);
    
    // solution 2 
    // public Page<Operation> findByCompte(Compte cp, Pageable pageable);
    @Query(nativeQuery = true, value = "SELECT * FROM Operation o WHERE o.compte = :compte")
	List<Operation> findByCompte(String compte);
    

}
