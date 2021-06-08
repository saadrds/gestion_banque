package com.gestion_banque.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/VerserSolde")
	public Object verserSolde(@RequestBody Compte c){
		String id = c.getId_compte();
		double solde = c.getSolde();
		Compte myCompte = compteRep.findById(id).orElse(null);
		
		try {
			myCompte.setSolde(myCompte.getSolde() + solde);
			return "success";
		}
		catch(Exception e) {
			return "error";
		}
			
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
