package com.proyectos2.controladora;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.proyectos2.bean.Ruta;
import com.proyectos2.util.BaseDeDatos;

public class RutaDAO {

	private SQLiteDatabase database;
	private BaseDeDatos dbHelper;
	
	public RutaDAO(Context ctx) {
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
	
	 private Ruta cursorToRuta(Cursor cursor) {
		 Ruta ruta = new Ruta();
		 ruta.setId_ruta(cursor.getInt(0));
		 ruta.setCod_ruta(cursor.getInt(1));
		 	return ruta;
	}

	public List<Ruta> leerRuta(int id_ruta){
		List<Ruta> rutas = new ArrayList<Ruta>();
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM ruta where _ID ='"+id_ruta+"' order by id asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Ruta ruta = cursorToRuta(c);
			rutas.add(ruta);
		}
		c.close();
		return rutas;
	}
	
	/*public long insertarPartido(Partido partido){
		ContentValues valores = new ContentValues();
		System.out.println("Entro al insertarPartido");
		//valores.put(BaseDeDatos.C_COLUMNA_ID_PAR, partido.getId());
		valores.put(BaseDeDatos.C_COLUMNA_ID_TOR_PAR,partido.getId_torneo());
		valores.put(BaseDeDatos.C_COLUMNA_ID_JUG1, partido.getId_juga1());
		valores.put(BaseDeDatos.C_COLUMNA_ID_JUG2, partido.getId_juga2());
		valores.put(BaseDeDatos.C_COLUMNA_GOL_JUG1, partido.getGol_juga1());
		valores.put(BaseDeDatos.C_COLUMNA_GOL_JUG2, partido.getGol_juga2());
		valores.put(BaseDeDatos.C_COLUMNA_ID_JUG_GAN, partido.getId_juga_gan());
		valores.put(BaseDeDatos.C_COLUMNA_NUM_FECHA, partido.getNum_fecha());
		partido.setId(database.insert(BaseDeDatos.C_TABLA_PARTIDO, null, valores));
		System.out.println("el partido tiene id: "+partido.getId());
		return partido.getId();
		
	}
	
	
	public long modificarPartido(Partido partido){
		ContentValues valores = new ContentValues();
		valores.put(BaseDeDatos.C_COLUMNA_ID_PAR, partido.getId());
		valores.put(BaseDeDatos.C_COLUMNA_ID_TOR_PAR,partido.getId_torneo());
		valores.put(BaseDeDatos.C_COLUMNA_ID_JUG1, partido.getId_juga1());
		valores.put(BaseDeDatos.C_COLUMNA_ID_JUG2, partido.getId_juga2());
		valores.put(BaseDeDatos.C_COLUMNA_GOL_JUG1, partido.getGol_juga1());
		valores.put(BaseDeDatos.C_COLUMNA_GOL_JUG2, partido.getGol_juga2());
		valores.put(BaseDeDatos.C_COLUMNA_ID_JUG_GAN, partido.getId_juga_gan());
		valores.put(BaseDeDatos.C_COLUMNA_NUM_FECHA, partido.getNum_fecha());
		String where = BaseDeDatos.C_COLUMNA_ID_PAR+" = '"+partido.getId()+"'";
		where = where + " AND "+BaseDeDatos.C_COLUMNA_ID_TOR_PAR+" = '"+partido.getId_torneo()+"'";
		long x = database.update(BaseDeDatos.C_TABLA_PARTIDO, valores,where, null);
		System.out.println("DEVOLVIO ESTO: "+x+"y el where: "+where+" y el juga_gan "+partido.getId_juga_gan());
		return x;
	}
	*/
	public Ruta obtenerxid(int id_ruta){
		Ruta ruta = null;
		System.out.println("Entro a la sentencia");
		Cursor c = database.rawQuery("SELECT * FROM ruta where id_ruta '"+id_ruta + "' order by id asc", new String [] {});
		if(c.getCount()>0){
		System.out.println("encontre");
		c.moveToFirst();
		ruta = cursorToRuta(c);
		c.close();
		}	
		return ruta;
	}
	public List<Ruta> obtenerlistadeRuta(int id_ruta){
		List<Ruta> rutas = new ArrayList<Ruta>();
		
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM ruta where id_ruta '"+id_ruta + "' order by id asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Ruta ruta = cursorToRuta(c);
			rutas.add(ruta);
		}
		c.close();
		return rutas;
	}
	
	public List<Ruta> obtenerRuta(int id_ruta){
			List<Ruta> rutas = new ArrayList<Ruta>();
		
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM ruta where id_ruta '"+id_ruta + "' order by id asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Ruta ruta = cursorToRuta(c);
			rutas.add(ruta);
		}
		c.close();
		return rutas;
	}
}
