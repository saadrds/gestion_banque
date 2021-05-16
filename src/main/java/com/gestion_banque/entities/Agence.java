package com.gestion_banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Agence  implements Serializable{
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	 private String id_Compte;
	  private String adresse;
	  
	  @OneToMany(mappedBy = "agence")
	  private Collection<Agence> agences;
	  
	public String getId_Compte() {
		return id_Compte;
	}
	public void setId_Compte(String id_Compte) {
		this.id_Compte = id_Compte;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Agence(String id_Compte, String adresse) {
		super();
		this.id_Compte = id_Compte;
		this.adresse = adresse;
	}
	

}

