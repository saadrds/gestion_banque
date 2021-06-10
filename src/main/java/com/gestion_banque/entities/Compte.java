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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compte implements Serializable{
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id_compte;
	private int rib;
	private double solde;
	
	@JsonIgnore
	@ManyToOne
	  private Client client;
	

	public int getRib() {
		return rib;
	}
	public void setRib(int rib) {
		this.rib = rib;
	}
	
	
	public String getId_compte() {
		return id_compte;
	}
	public void setId_compte(String id_compte) {
		this.id_compte = id_compte;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;

	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(int rib, double solde, Client client) {
		super();
		this.rib = rib;
		this.solde = solde;
		this.client = client;
	}
	
	
	

}