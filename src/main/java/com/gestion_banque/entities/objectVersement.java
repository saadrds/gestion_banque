package com.gestion_banque.entities;

public class objectVersement {
	private Compte c1;
	private double rib;
	private double m;
	public Compte getC1() {
		return c1;
	}
	public void setC1(Compte c1) {
		this.c1 = c1;
	}
	public double getRib() {
		return rib;
	}
	public void setRib(int rib) {
		this.rib = rib;
	}
	public double getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public objectVersement(Compte c1, double rib, double m) {
		super();
		this.c1 = c1;
		this.rib = rib;
		this.m = m;
	}
	
	public objectVersement(Compte c1, double m) {
		super();
		this.c1 = c1;
		this.m = m;
	}

}
