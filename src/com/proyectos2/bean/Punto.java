package com.proyectos2.bean;

import java.io.Serializable;

public class Punto implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//private String name = "";
private int id;
private double latitud;
private double longitud;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getLatitud() {
	return latitud;
}
public void setLatitud(double latitud) {
	this.latitud = latitud;
}
public double getLongitud() {
	return longitud;
}
public void setLongitud(double longitud) {
	this.longitud = longitud;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public Punto(int id, double latitud, double longitud) {
	super();
	this.id = id;
	this.latitud = latitud;
	this.longitud = longitud;
}



}
