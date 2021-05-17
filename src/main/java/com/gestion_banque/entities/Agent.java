package com.gestion_banque.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Agent implements Serializable {
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	  private String id_Agent;
	  private String Prenom;
	  private String Nom;
	  private String id_agence;
	  
	  @OneToOne(mappedBy = "agence")
	  private Agence agence;
	  
	public Agent(String id_Agent, String prenom, String nom, String id_agence) {
		super();
		this.id_Agent = id_Agent;
		Prenom = prenom;
		Nom = nom;
		this.id_agence = id_agence;
	}
	public String getId_Agent() {
		return id_Agent;
	}
	public void setId_Agent(String id_Agent) {
		this.id_Agent = id_Agent;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getId_agence() {
		return id_agence;
	}
	public void setId_agence(String id_agence) {
		this.id_agence = id_agence;
	}

}
