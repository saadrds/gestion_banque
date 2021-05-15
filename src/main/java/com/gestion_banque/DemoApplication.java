package com.gestion_banque;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestion_banque.dao.ClientRepository;
import com.gestion_banque.entities.Client;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository cl;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Client saad = new Client("saad", "rouddasse", "HH230550", "0649015637",df.parse("05/07/1997"));
		Client safae = new Client("safae", "El Himer", "HH430823", "0649481722", df.parse("24/07/1999"));
		//cl.save(saad);
		//cl.save(safae);
		cl.save(new Client("khadija", "El Atri", "HH40123", "061234566", df.parse("21/03/1979")));
		
		cl.findAll().forEach(c -> {
			System.out.println(c.getNom());
		});
	}

}
