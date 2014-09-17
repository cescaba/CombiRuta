package com.proyectos2.bean;

import java.io.Serializable;

public class Paradero implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_pun;

	public int getId_pun() {
		return id_pun;
	}

	public void setId_pun(int id_pun) {
		this.id_pun = id_pun;
	}

	public Paradero(int id_pun) {
		super();
		this.id_pun = id_pun;
	}

	public Paradero() {
		// TODO Auto-generated constructor stub
	}

		
	

}
