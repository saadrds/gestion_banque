package com.gestion_banque.entities;

import java.io.Serializable;

public class Admin implements Serializable {
	
	 private String id_Admin;
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
