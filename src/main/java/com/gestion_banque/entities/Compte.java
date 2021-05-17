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
public class Compte implements Serializable{
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id_Compte;
	private int rib;
	private String id_Agence;
	private String id_Client;
<<<<<<< HEAD
	private double solde;
	@ManyToOne
=======
	private int solde;
	public int getSolde() {
		return solde;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}
	@OneToOne(mappedBy = "compte")
>>>>>>> branch 'master' of https://github.com/saadrds/gestion_banque.git
	  private Client client;
	
	public String getId_Compte() {
		return id_Compte;
	}
	public void setId_Compte(String id_Compte) {
		this.id_Compte = id_Compte;
	}
	public int getRib() {
		return rib;
	}
	public void setRib(int rib) {
		this.rib = rib;
	}
	public String getId_Agence() {
		return id_Agence;
	}
	public void setId_Agence(String id_Agence) {
		this.id_Agence = id_Agence;
	}
	
	public String getId_Client() {
		return id_Client;
	}
	
	public void setId_Client(String id_Client) {
		this.id_Client = id_Client;
	}
<<<<<<< HEAD
	public Compte(String id_Compte, int rib, String id_Agence, String id_Client, double solde) {
=======
	
	
	public Compte(String id_Compte, int rib, String id_Agence, String id_Client, int solde) {
>>>>>>> branch 'master' of https://github.com/saadrds/gestion_banque.git
		super();
		this.id_Compte = id_Compte;
		this.rib = rib;
		this.id_Agence = id_Agence;
		this.id_Client = id_Client;
		this.solde = solde;
<<<<<<< HEAD
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
=======
>>>>>>> branch 'master' of https://github.com/saadrds/gestion_banque.git
	}
	

}
