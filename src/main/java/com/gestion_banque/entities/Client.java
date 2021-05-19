package com.gestion_banque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Client implements Serializable {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
  private String id_client;
  private String prenom;
  private String nom;
  private String cin;
  private String mdp;
  private String email;
  private String tel;
  @Temporal(TemporalType.DATE)
  private Date dateCreation;

  @ManyToOne
  private Agent agent;
  
  @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
  private Collection<Compte> comptes = new ArrayList<>();
  //constructors 
//added a comment
public Client() {
	super();
	// TODO Auto-generated constructor stub
}



public Client(String prenom, String nom, String cin, String mdp, String email, String tel, Date dateCreation,
		Agent agent) {
	super();
	this.prenom = prenom;
	this.nom = nom;
	this.cin = cin;
	this.mdp = mdp;
	this.email = email;
	this.tel = tel;
	this.dateCreation = dateCreation;
	this.agent = agent;
}



//getters and setters
public String getId_client() {
	return id_client;
}
public void setId_client(String id_client) {
	this.id_client = id_client;
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
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}

public String getMdp() {
	return mdp;
}

public void setMdp(String mdp) {
	this.mdp = mdp;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}
