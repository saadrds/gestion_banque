package com.gestion_banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agence  implements Serializable{
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	 private String id_agence;
	  private String adresse;
	  
	  @OneToMany(mappedBy = "agence")
	  @JsonIgnore
	  private Collection<Agent> agents;

	public String getId_agence() {
		return id_agence;
	}

	public void setId_agence(String id_agence) {
		this.id_agence = id_agence;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Agence( String adresse) {
		super();
		this.adresse = adresse;
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	  


}

