package com.proyectos2.controladora;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.proyectos2.bean.Linea;
import com.proyectos2.util.BaseDeDatos;

public class LineaDAO {

	private SQLiteDatabase database;
	private BaseDeDatos dbHelper;
	
	public LineaDAO(Context ctx) {
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
	
	 private Linea cursorToLinea(Cursor cursor) {
		 Linea linea = new Linea();
		 linea.setId_linea(cursor.getInt(0));
		 linea.setId_ruta(cursor.getInt(3));
		 linea.setNom_linea(cursor.getString(1));
		 linea.setImag_linea(cursor.getString(2));
		 linea.setId_emp(cursor.getInt(4));
		 	return linea;
	}

	public List<Linea> leerLineas(int id_linea){
		List<Linea> lineas = new ArrayList<Linea>();
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM linea where id_linea ='"+id_linea+"' order by id asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Linea linea = cursorToLinea(c);
			lineas.add(linea);
		}
		c.close();
		return lineas;
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
	public Linea obtenerxid(int id_linea){
		Linea linea = null;
		System.out.println("Entro a la sentencia");
		Cursor c = database.rawQuery("SELECT * FROM linea where id_linea ='"+id_linea+"' order by id asc", new String [] {});
		if(c.getCount()>0){
		System.out.println("encontre");
		c.moveToFirst();
		linea = cursorToLinea(c);
		c.close();
		}	
		return linea;
	}
	public List<Linea> obtenerlistadeRuta(int id_linea){
		List<Linea> lineas = new ArrayList<Linea>();
		
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM linea where id_linea ='"+id_linea+"' order by id asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Linea linea = cursorToLinea(c);
			lineas.add(linea);
		}
		c.close();
		return lineas;
	}
	
	public List<Linea> obtenerLinea(int id_linea){
		List<Linea> lineas = new ArrayList<Linea>();
		
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT * FROM linea where id_linea ='"+id_linea+"' order by id asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Linea linea = cursorToLinea(c);
			lineas.add(linea);
		}
		c.close();
		return lineas;
	}
}
