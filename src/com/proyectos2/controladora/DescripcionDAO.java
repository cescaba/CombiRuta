package com.proyectos2.controladora;

import java.util.ArrayList;
import java.util.List;

import com.proyectos2.bean.Descripcion;
import com.proyectos2.util.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DescripcionDAO {

	private SQLiteDatabase database;
	private BaseDeDatos dbHelper;
	

	private String[] colum_descripcion = new String[]{BaseDeDatos.C_COLUMNA_COD_DESCR,BaseDeDatos.C_COLUMNA_DES_DESCR};
	
	public DescripcionDAO(Context ctx) {
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
	
	public List<Descripcion> leerDescripcion(int id_descripcion){
		List<Descripcion> descripciones = new ArrayList<Descripcion>();
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT _ID, des_desc" +
				"FROM descr where _ID='"+id_descripcion+ "' order by numero asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Descripcion descripciones1 = cursorToDescripcion(c);
			descripciones.add(descripciones1);
		}
		c.close();
		return descripciones;
	}
	//V1.5 CJCA INI
	public List<Descripcion> leerDescripcionTabla(int id_descripcion){
		List<Descripcion> descripciones = new ArrayList<Descripcion>();
		Cursor c = database.rawQuery("SELECT _ID, des_desc" +
				"FROM descr where _ID='"+id_descripcion+ "' order by numero asc", new String [] {});
		
		System.out.println("Tabla de posiciones");
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Descripcion descripciones1 = cursorToDescripcion(c);
			descripciones.add(descripciones1);
		}
		c.close();
		return descripciones;
	}
	//V1.5 CJCA FIN
	 private Descripcion cursorToDescripcion(Cursor cursor) {
		 Descripcion descripcion = new Descripcion();
		 descripcion.setId(cursor.getInt(0));
		 descripcion.setDes_desc(cursor.getString(1));
		    
		    return descripcion;
	}
	public void insertarDescripcion(String nombre, long idtorneo, int q){
		/*ContentValues valores = new ContentValues();
		valores.put(BaseDeDatos.C_COLUMNA_NOM_JUG, nombre);
		valores.put(BaseDeDatos.C_COLUMNA_ID_TOR,idtorneo);
		int i = 1;
		while(obtenerxnumero(i)!=null){
			i =  (int)(Math.random()*(q-1+1)+1); 
		}
		valores.put(BaseDeDatos.C_COLUMNA_NUMERO,i);
		database.insert(BaseDeDatos.C_TABLA_JUGADOR, null, valores);
		//valores.put("nom_jugador", nombre);
		//database.insert("jugador",null, valores);
		//System.out.println("insertarJugador("+nombre+")");
		//database.execSQL("INSERT INTO jugador(nom_jo¿ugador) values ('"+nombre+"')");*/
	}
	public Descripcion obtenerxid(int id){
		Cursor c = database.rawQuery("SELECT _ID, des_desc" +
				"FROM descr where _ID='"+id+"'", new String [] {});
		Descripcion descripcion = null;
		if(c.getCount()>0){
		c.moveToFirst();
		descripcion = cursorToDescripcion(c);
		c.close();
		}
		return descripcion;
	}
	/*public void deleteJugador(Jugador jugador){
		long id = jugador.getId();
		database.delete(BaseDeDatos.C_TABLA_JUGADOR, BaseDeDatos.C_COLUMNA_ID_JUG + " = "+ id, null);
	}
	
	public String obtenerxid(long id){
		Cursor c = database.rawQuery("SELECT _ID, id_torneo, nom_jugador, par_gan, par_emp, par_per" +
				", gol_afa, gol_enc, numero FROM jugador where _ID='"+num+"' and id_torneo ='"+id_torneo+"'", new String [] {});
		Jugador jugador = null;
		if(c.getCount()>0){
		c.moveToFirst();
		jugador = cursorToJugador(c);
		c.close();
		}
		return jugador.getName();
	}*/
}
