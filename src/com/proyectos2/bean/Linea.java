package com.proyectos2.bean;

import java.io.Serializable;

public class Linea implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_linea;
	private int id_ruta;
	private String nom_linea;
	private String imag_linea;
	private int id_emp;
	public int getId_linea() {
		return id_linea;
	}
	public void setId_linea(int id_linea) {
		this.id_linea = id_linea;
	}
	public int getId_ruta() {
		return id_ruta;
	}
	public void setId_ruta(int id_ruta) {
		this.id_ruta = id_ruta;
	}
	public String getNom_linea() {
		return nom_linea;
	}
	public void setNom_linea(String nom_linea) {
		this.nom_linea = nom_linea;
	}
	public String getImag_linea() {
		return imag_linea;
	}
	public void setImag_linea(String imag_linea) {
		this.imag_linea = imag_linea;
	}
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Linea(int id_linea, int id_ruta, String nom_linea,
			String imag_linea, int id_emp) {
		super();
		this.id_linea = id_linea;
		this.id_ruta = id_ruta;
		this.nom_linea = nom_linea;
		this.imag_linea = imag_linea;
		this.id_emp = id_emp;
	}
	public Linea() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
