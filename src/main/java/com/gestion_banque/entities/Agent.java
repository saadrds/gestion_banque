package com.gestion_banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Agent implements Serializable {
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	 private String id_Agent;
	  private String prenom;
	  private String nom;
	  private String email;
	  private String mdp;
	  
	  @ManyToOne
	  private Agence agence;
	  
	  @OneToMany(mappedBy = "agent")
	  private Collection<Client> clients;
	  
	public Agent( String prenom, String nom,String email, String mdp, Agence agence) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.agence = agence;
	}
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId_Agent() {
		return id_Agent;
	}
	public void setId_Agent(String id_Agent) {
		this.id_Agent = id_Agent;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	

}
