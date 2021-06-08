package com.gestion_banque.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_banque.dao.AgentRespository;

import com.gestion_banque.entities.Agent;
import com.gestion_banque.entities.Client;

@CrossOrigin("*")
@RestController
public class AgentRestRepository {
	@Autowired
	private AgentRespository agentRep;
	
	
	
	@RequestMapping(value = "/getAgentClients", method =RequestMethod.GET)
	public Collection<Client> getAgentClient(@RequestParam String id){
		System.out.println("gotClients mzian");
		try {
		Agent a = agentRep.findById(id).orElse(null);
		
		return a.getClients();
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@PostMapping("/loginAgent")
	public Object loginAgent(@RequestBody Agent a){
		System.out.println("bayo zaml");
		String email = a.getEmail();
		String mdp = a.getMdp();
		List<Agent> agents = agentRep.findByEmailAndPassword(email, mdp);
		if(agents.isEmpty())
		{
			return null;
		}
		else return agents.get(0);
			
	}

}
