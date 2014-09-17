package com.proyectos2.bean;

import java.io.Serializable;

public class Punto implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//private String name = "";
private int id_pun;
private double lat_pun;
private double lon_pun; 
private String ref_pun;
private int des_pun;
public int getId_pun() {
	return id_pun;
}
public void setId_pun(int id_pun) {
	this.id_pun = id_pun;
}
public double getLat_pun() {
	return lat_pun;
}
public void setLat_pun(double lat_pun) {
	this.lat_pun = lat_pun;
}
public double getLon_pun() {
	return lon_pun;
}
public void setLon_pun(double lon_pun) {
	this.lon_pun = lon_pun;
}
public String getRef_pun() {
	return ref_pun;
}
public void setRef_pun(String ref_pun) {
	this.ref_pun = ref_pun;
}
public int getDes_pun() {
	return des_pun;
}
public void setDes_pun(int des_pun) {
	this.des_pun = des_pun;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public Punto(int id_pun, double lat_pun, double lon_pun, String ref_pun,
		int des_pun) {
	super();
	this.id_pun = id_pun;
	this.lat_pun = lat_pun;
	this.lon_pun = lon_pun;
	this.ref_pun = ref_pun;
	this.des_pun = des_pun;
}
public Punto() {
	// TODO Auto-generated constructor stub
}






}
