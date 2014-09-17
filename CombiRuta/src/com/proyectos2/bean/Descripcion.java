package com.proyectos2.bean;

import java.io.Serializable;

public class Descripcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String des_desc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDes_desc() {
		return des_desc;
	}
	public void setDes_desc(String des_desc) {
		this.des_desc = des_desc;
	}
	
	public Descripcion(int id, String des_desc) {
		super();
		this.id = id;
		this.des_desc = des_desc;
	}
	public Descripcion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
