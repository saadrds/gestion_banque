package com.gestion_banque.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.gestion_banque.entities.Compte;
import com.gestion_banque.entities.Operation;


public interface OperationMetier {

	public Compte consulterCompte(String codeCpte);

    // Operation verssement
    public boolean verser( String code, double montant);

    // retirer
    public boolean retirer( String code, double montant);

    // virement on a bsoin de deux comptes Emetter, Recepteur

    public boolean virement( String cpte1, String cpte2, double montant);

    // pages oprations contient compte , pages , nbre de ligne

    public PageOperation getOperations( String codeCompte, int page, int size );
    
    public Page<Operation> listOperation(String codecpte, int page, int size);
    
    public List<Compte> ConsulterAllComptes();
    
    public Optional<Compte> consulterCompteM1(String codeCpte);
    
   

}
