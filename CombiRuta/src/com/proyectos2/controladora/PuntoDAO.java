package com.proyectos2.controladora;

import java.util.ArrayList;
import java.util.List;

import com.proyectos2.bean.Punto;
import com.proyectos2.util.BaseDeDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PuntoDAO {
	
	private SQLiteDatabase database;
	private BaseDeDatos dbHelper;
	
	public PuntoDAO(Context ctx) {
		dbHelper = new BaseDeDatos(ctx);
		// TODO Auto-generated constructor stub
	}

	public void abrir() {
		// TODO Auto-generated method stub
		database = dbHelper.getWritableDatabase();
	}

	public void cerrar() {
		// TODO Auto-generated method stub
		dbHelper.close();
	}
	
	 private Punto cursorToPuntos(Cursor cursor) {
		    Punto punto = new Punto();
		 	punto.setId_pun(cursor.getInt(0));
		 	punto.setDes_pun(cursor.getInt(1));
		 	punto.setRef_pun(cursor.getString(2));
		 	punto.setLat_pun(cursor.getDouble(3));
		 	punto.setLon_pun(cursor.getDouble(4));
		 	
		    return punto;
	}

	public List<Punto> leerPunto(long id_punto){
		List<Punto> puntos = new ArrayList<Punto>();
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM punto where _ID='"+id_punto+"' order by id asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Punto punto = cursorToPuntos(c);
			puntos.add(punto);
		}
		c.close();
		return puntos;
	}
	public long insertarPunto(Punto punto){
		ContentValues valores = new ContentValues();
		System.out.println("Entro al insertarPartido");
		//valores.put(BaseDeDatos.C_COLUMNA_ID_PAR, partido.getId());
		valores.put(BaseDeDatos.C_COLUMNA_COD_PUN,punto.getId_pun());
		valores.put(BaseDeDatos.C_COLUMNA_DES_PUN, punto.getDes_pun());
		valores.put(BaseDeDatos.C_COLUMNA_REF_PUN, punto.getRef_pun());
		valores.put(BaseDeDatos.C_COLUMNA_LAT_PUN, punto.getLat_pun());
		valores.put(BaseDeDatos.C_COLUMNA_LON_PUN, punto.getLon_pun());
		
		database.insert(BaseDeDatos.C_TABLA_PUN, null, valores);
		
		return punto.getId_pun();
		
	}
	public long modificarPunto(Punto punto){
		ContentValues valores = new ContentValues();
		valores.put(BaseDeDatos.C_COLUMNA_COD_PUN,punto.getId_pun());
		valores.put(BaseDeDatos.C_COLUMNA_DES_PUN, punto.getDes_pun());
		valores.put(BaseDeDatos.C_COLUMNA_REF_PUN, punto.getRef_pun());
		valores.put(BaseDeDatos.C_COLUMNA_LAT_PUN, punto.getLat_pun());
		valores.put(BaseDeDatos.C_COLUMNA_LON_PUN, punto.getLon_pun());
		String where = BaseDeDatos.C_COLUMNA_COD_PUN+" = '"+punto.getId_pun()+"'";
		//where = where + " AND "+BaseDeDatos.C_COLUMNA_ID_TOR_PAR+" = '"+partido.getId_torneo()+"'";
		long x = database.update(BaseDeDatos.C_TABLA_PUN, valores,where, null);
		//System.out.println("DEVOLVIO ESTO: "+x+"y el where: "+where+" y el juga_gan "+pun.getId_juga_gan());
		return x;
	}
	
	public Punto obtenerxid(long id_punto,long idtorneo){
		Punto punto = null;
		System.out.println("Entro a la sentencia");
		Cursor c = database.rawQuery("SELECT * FROM punto where _ID='"+id_punto+"'" , new String [] {});
		if(c.getCount()>0){
		System.out.println("encontre");
		c.moveToFirst();
		punto = cursorToPuntos(c);
		c.close();
		}	
		return punto;
	}
	public List<Punto> obtenerlistadepuntos(long id_punto){
		List<Punto> puntos = new ArrayList<Punto>();
		
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM punto where _ID='"+id_punto+"'" , new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Punto punto = cursorToPuntos(c);
			puntos.add(punto);
		}
		c.close();
		return puntos;
	}
	public List<Punto> obtenerPuntos(long id_punto){
		List<Punto> puntos = new ArrayList<Punto>();
		
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM punto where _ID='"+id_punto+"'" , new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Punto punto = cursorToPuntos(c);
			puntos.add(punto);
		}
		c.close();
		return puntos;
	}

}
