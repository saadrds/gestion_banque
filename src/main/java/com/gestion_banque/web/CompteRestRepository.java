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
import com.gestion_banque.entities.objectVersement;

@CrossOrigin("*")
@RestController
public class CompteRestRepository {
	@Autowired
	CompteRespository compteRep;
	
	@Autowired
	ClientRepository clientRep;
	
	
	@PostMapping("/getClientComptes")
	public Collection<Compte> getClientComptes(@RequestBody Client client){
		Client c = clientRep.findById(client.getId_client()).orElse(null);
		System.out.print(c);
		if(c != null) {
			return c.getComptes();}
		else
			return null;
	}
	

	@PostMapping("/rechargeTel/{id}")
	public Object rechargeTel(@RequestBody Compte c , int m){
		
		String id = c.getId_compte();
		
		double solde = c.getSolde();
		
		Compte myCompte = compteRep.findById(id).orElse(null);
		
		
		if(solde>m) {
			myCompte.setSolde(solde - m);
			compteRep.save(myCompte);
			return myCompte;
		}else {
			return "solde insuffisant";
		}
		/*
		Compte myCompte = compteRep.findById(id_client).orElse(null);
		double mm = myCompte.getSolde();
		*/
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
			System.out.print("success");
			System.out.print(rib);

			return myCompte;
			
		}
		catch(Exception e) {
			System.out.print(e.toString());
			return null;
		}
			
	}

	
	@PostMapping("/VerserSoldeClient/{id}")
	public Object verserSoldeClient(@RequestBody Compte c1 , double rib , double m){
		
		
		try {
			
			String id1 = c1.getId_compte();
			Compte c2 = compteRep.findByRib(rib).get(0);
			String id = c2.getId_compte();
			double solde1 = c1.getSolde();
			double solde2 = c2.getSolde();
			Compte myCompte = compteRep.findById(id1).orElse(null);
			Compte myCompteper = compteRep.findById(id).orElse(null);
			myCompte.setSolde(myCompte.getSolde() - m);
			myCompteper.setSolde(myCompteper.getSolde() + m);
			
			
			objectVersement ob = new objectVersement(c1,rib,m);
			
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
	
	@PostMapping("/getClientComptesid	")
	public Collection<Compte> getClientComptesid(@RequestBody String id){
		
		Client c = clientRep.findById(id).orElse(null);
		System.out.print(c);
		if(c != null) {
			return c.getComptes();}
		else
			return null;
	}
	
	

}
