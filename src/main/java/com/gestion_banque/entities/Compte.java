package com.gestion_banque.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class Compte implements Serializable{
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id_Compte;
	private int rib;
	private String id_Agence;
	private String id_Client;
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
	public Compte(String id_Compte, int rib, String id_Agence, String id_Client) {
		super();
		this.id_Compte = id_Compte;
		this.rib = rib;
		this.id_Agence = id_Agence;
		this.id_Client = id_Client;
	}

}
