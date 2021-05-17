package com.gestion_banque;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestion_banque.dao.AgenceRespository;
import com.gestion_banque.dao.AgentRespository;
import com.gestion_banque.dao.ClientRepository;
import com.gestion_banque.entities.Agence;
import com.gestion_banque.entities.Agent;
import com.gestion_banque.entities.Client;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository cl;
	@Autowired
	private AgenceRespository agenceRep;
	
	@Autowired
	private AgentRespository agentRep;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
<<<<<<< HEAD
		
		/*Agence agence1 = new Agence("Sidi Bouzid");
		agenceRep.save(agence1);
		
		Agent a1 = new Agent( "Khadija", "Atri","atri.kh@gmail.com", "123456",agence1);
		agentRep.save(a1);
		
		Client saad = new Client("saad", "rouddasse", "HH230550", "mdp123","saadrds@gmail.com","0649015637",df.parse("05/07/1997"),a1);
		Client safae = new Client("safae", "El Himer", "HH230550", "mdp124","safae@gmail.com","0649481722",df.parse("24/07/1999"),a1);
		//cl.save(saad);
		//cl.save(safae);
		cl.save(saad);
		cl.save(safae);*/
=======
		Client saad = new Client("saad", "rouddasse", "HH230550", "0649015637",df.parse("05/07/1997"));
		Client safae = new Client("safae", "El Himer", "HH430823", "0649481722", df.parse("24/07/1999"));
		cl.save(saad);
		cl.save(safae);
		//cl.save(new Client("khadija", "El Atri", "HH40123", "061234566", df.parse("21/03/1979")));
>>>>>>> branch 'master' of https://github.com/saadrds/gestion_banque.git
		
		//agenceRep.findOne(null)
		//Client hamza = new Client("hamza", "habibou", "HH230550", "mdp123","saadrds@gmail.com","0649015637",df.parse("05/07/1997"),a1);

		
		agentRep.findByLastname("Atri").forEach(c -> {
			System.out.println(c.getEmail());
		});
	}

}
