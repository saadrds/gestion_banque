package com.gestion_banque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Client implements Serializable {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
  private String id_client;
  private String Prenom;
  private String Nom;
  private String cin;
  private String tel;
  @Temporal(TemporalType.DATE)
  private Date dateCreation;
  @OneToMany(mappedBy = "clients",fetch = FetchType.EAGER)
  private Collection<Compte> comptes = new ArrayList<>();
  //constructors 
//added a comment
public Client() {
	super();
	// TODO Auto-generated constructor stub
}

public Client(String prenom, String nom, String cin, String tel, Date dateCreation) {
	super();
	Prenom = prenom;
	Nom = nom;
	this.cin = cin;
	this.tel = tel;
	this.dateCreation = dateCreation;
}

//getters and setters
public String getId_client() {
	return id_client;
}
public void setId_client(String id_client) {
	this.id_client = id_client;
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
}
