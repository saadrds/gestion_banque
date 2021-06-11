package com.gestion_banque.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_banque.dao.ClientRepository;
import com.gestion_banque.dao.CompteRespository;
import com.gestion_banque.entities.Client;
import com.gestion_banque.entities.Compte;

@CrossOrigin("*")
@RestController
public class CompteRestRepository {
	@Autowired
	CompteRespository compteRep;
	
	@Autowired
	ClientRepository clientRep;
	
	
	@RequestMapping(value = "/getClientComptes/{id}", method =RequestMethod.GET)
	public Collection<Compte> getClientComptes(String id){
		Client c = clientRep.findById(id).orElse(null);
		if(c != null)
			return c.getComptes();
		else
			return null;
	}
	
	@PostMapping("/rechargeTel/{id}")
	public Object rechargeTel(@RequestBody Compte c , int m){
		
		String id = c.getId_compte();
		double solde = c.getSolde();
		Compte myCompte = compteRep.findById(id).orElse(null);
		/*
		Compte myCompte = compteRep.findById(id_client).orElse(null);
		double mm = myCompte.getSolde();
		*/
		try {
			if(solde>m){
			     myCompte.setSolde(myCompte.getSolde() - m);
			} else {
				return "Solde insuffisant";
			}
			return "success";
		}
		catch(Exception e) {
			return "error";
		}
			
	}

	
	@PostMapping("/VerserSolde/{id}")
	public Object verserSolde(@RequestBody Compte c1 , Compte c2 , double m){
		String id1 = c1.getId_compte();
		String id = c2.getId_compte();
		double solde1 = c1.getSolde();
		double solde2 = c2.getSolde();
		Compte myCompte = compteRep.findById(id1).orElse(null);
		Compte myCompteper = compteRep.findById(id).orElse(null);
		
		try {
			myCompte.setSolde(myCompte.getSolde() - m);
			myCompteper.setSolde(myCompteper.getSolde() + m);
			return "success";
		}
		catch(Exception e) {
			return "error";
		}
			
	}
	
	@PutMapping("/UpdateComptes/{id}")
	public ResponseEntity<Client> updateTutorial(@PathVariable(value = "id") String id_client,
		   @RequestBody Client clientDetails)  {
		  
		   Client clt = new Client();
	
		   clt.setEmail(clientDetails.getEmail());
	       clt.setMdp(clientDetails.getMdp());
	        
	       final Client updatedClient = clientRep.save(clt);
	       return ResponseEntity.ok(updatedClient);
	  }
	
	
	@PostMapping("/SaveCompte")
	public void SaveClients(@RequestBody Compte c){
		compteRep.save(c);
	}
	
	@DeleteMapping(value = "/DeleteCompte?id={id}")
	public void deleteComptet(@PathVariable String id) {
		compteRep.deleteById(id);
	}
	
	

}
