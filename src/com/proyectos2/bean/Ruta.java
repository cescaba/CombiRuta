package com.proyectos2.bean;

import java.io.Serializable;

public class Ruta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_ruta;
	private int cod_ruta;
	public int getId_ruta() {
		return id_ruta;
	}
	public void setId_ruta(int id_ruta) {
		this.id_ruta = id_ruta;
	}
	public int getCod_ruta() {
		return cod_ruta;
	}
	public void setCod_ruta(int cod_ruta) {
		this.cod_ruta = cod_ruta;
	}
	public Ruta(int id_ruta, int cod_ruta) {
		super();
		this.id_ruta = id_ruta;
		this.cod_ruta = cod_ruta;
	}
	public Ruta() {
		// TODO Auto-generated constructor stub
	}

	


}
