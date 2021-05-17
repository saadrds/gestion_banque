package com.gestion_banque.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Admin implements Serializable {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	 private String id_Admin;
	  public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String Mdp;
	public String getId_Admin() {
		return id_Admin;
	}
	public void setId_Admin(String id_Admin) {
		this.id_Admin = id_Admin;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
	public Admin(String id_Admin, String mdp) {
		super();
		this.id_Admin = id_Admin;
		Mdp = mdp;
	}
	  
}
