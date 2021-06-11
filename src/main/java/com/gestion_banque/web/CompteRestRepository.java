package com.gestion_banque.web;

import java.util.Collection;
import java.util.Date;
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
import com.gestion_banque.dao.OperationRepository;
import com.gestion_banque.entities.Client;
import com.gestion_banque.entities.Compte;
import com.gestion_banque.entities.Operation;

@CrossOrigin("*")
@RestController
public class CompteRestRepository {
	@Autowired
	CompteRespository compteRep;
	
	@Autowired
	ClientRepository clientRep;
	
	@Autowired
	OperationRepository operationRep;
	
	
	@PostMapping("/getClientComptes")
	public Collection<Compte> getClientComptes(@RequestBody Client client){
		Client c = clientRep.findById(client.getId_client()).orElse(null);
		if(c != null) {
			return c.getComptes();}
		else
			return null;
	}
	
	@PostMapping("/verserSolde")
	public Object verserSolde(@RequestBody Compte compte){
		System.out.print("verser done");
		double rib = compte.getRib();
		double solde = compte.getSolde();
		try {
			List<Compte> comptes =  compteRep.findByRib(rib);
			Compte myCompte = comptes.get(0);
			myCompte.setSolde(myCompte.getSolde() + solde);
			compteRep.save(myCompte);
			Operation operation = new Operation();
			operation.setCompte(myCompte);
			operation.setMontant(solde);
			operation.setDateOperation(new Date());
			operationRep.save(operation);
			System.out.print("success");
			System.out.print(rib);

			return myCompte;
			
		}
		catch(Exception e) {
			System.out.print(e.toString());
			return null;
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
