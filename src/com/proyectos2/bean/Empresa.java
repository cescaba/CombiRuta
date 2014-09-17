package com.proyectos2.bean;

import java.io.Serializable;

public class Empresa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_emp;
	private String nom_emp;
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}
	public String getNom_emp() {
		return nom_emp;
	}
	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}
	public Empresa(int id_emp, String nom_emp) {
		super();
		this.id_emp = id_emp;
		this.nom_emp = nom_emp;
	}
	public Empresa() {
		// TODO Auto-generated constructor stub
	}
	
	

}
