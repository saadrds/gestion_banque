package com.gestion_banque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_banque.dao.ClientRepository;
import com.gestion_banque.dao.CompteRespository;
import com.gestion_banque.entities.Agent;
import com.gestion_banque.entities.Client;
import com.gestion_banque.entities.Compte;

@CrossOrigin("*")
@RestController
public class ClientRestService {
	@Autowired
	private ClientRepository clientRep;
	@Autowired
	private CompteRespository compteRep;
	
	
	@RequestMapping(value = "/AllClients", method =RequestMethod.GET)
	public List<Client> getAllClients(){
		return clientRep.findAll();
	}
	
	@PostMapping("/SaveClient")
	public Object SaveClients(@RequestBody Client c){
		try{
			clientRep.save(c);
			return c;
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping(value = "/getClient", method =RequestMethod.GET)
	public Client getClient(@RequestParam String id){
		return clientRep.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "/AllComptes", method =RequestMethod.GET)
	public List<Compte> getAllComptes(){
		return compteRep.findAll();
	}
	
	@PostMapping("/loginClient")
	public Object loginAgent(@RequestBody Client a){
		String email = a.getEmail();
		String mdp = a.getMdp();
		List<Client> clients = clientRep.findByEmailAndPassword(email, mdp);
		if(clients.isEmpty())
		{
			return null;
		}
		else return clients.get(0);
			
	}
	
	
	
	
	
}
