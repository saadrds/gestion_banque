package com.gestion_banque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_banque.dao.ClientRepository;
import com.gestion_banque.entities.Client;


@RestController
public class ClientRestService {
	@Autowired
	private ClientRepository clientRep;
	
	@RequestMapping(value = "/AllClients", method =RequestMethod.GET)
	public List<Client> getAllClients(){
		return clientRep.findAll();
	}
}
