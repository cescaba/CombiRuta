package com.proyectos2.bean;

import java.io.Serializable;

public class ParaxRuta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_pun;
	private int id_ruta;
	public int getId_pun() {
		return id_pun;
	}
	public void setId_pun(int id_pun) {
		this.id_pun = id_pun;
	}
	public int getId_ruta() {
		return id_ruta;
	}
	public void setId_ruta(int id_ruta) {
		this.id_ruta = id_ruta;
	}
	public ParaxRuta(int id_pun, int id_ruta) {
		super();
		this.id_pun = id_pun;
		this.id_ruta = id_ruta;
	}
	public ParaxRuta() {
		// TODO Auto-generated constructor stub
	}
	
	

}
