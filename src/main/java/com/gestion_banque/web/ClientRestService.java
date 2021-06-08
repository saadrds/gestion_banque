package com.gestion_banque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public void SaveClients(@RequestBody Client c){
		clientRep.save(c);
	}
	
	@RequestMapping(value = "/getClient/{id}", method =RequestMethod.GET)
	public Client getClient(@PathVariable String id){
		return clientRep.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "/AllComptes", method =RequestMethod.GET)
	public List<Compte> getAllComptes(){
		return compteRep.findAll();
	}
}
