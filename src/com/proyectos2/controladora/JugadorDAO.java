//MAH INI
package com.proyectos2.controladora;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.provider.BaseColumns._ID;


public class JugadorDAO{
	
	/*private SQLiteDatabase database;
	private BaseDeDatos dbHelper;
	

	private String[] colum_jugador = new String[]{BaseDeDatos.C_COLUMNA_ID_JUG,BaseDeDatos.C_COLUMNA_ID_TOR, BaseDeDatos.C_COLUMNA_NOM_JUG,
			BaseDeDatos.C_COLUMNA_PAR_GAN, BaseDeDatos.C_COLUMNA_PAR_EMP, BaseDeDatos.C_COLUMNA_PAR_PER,
			BaseDeDatos.C_COLUMNA_GOL_AFA,BaseDeDatos.C_COLUMNA_GOL_ENC, BaseDeDatos.C_COLUMNA_NUMERO};
	
	public JugadorDAO(Context ctx) {
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
	
	public List<Jugador> leerJugadores(long id_torneo){
		List<Jugador> jugadores = new ArrayList<Jugador>();
		//Cursor c = database.query(BaseDeDatos.C_TABLA_JUGADOR, colum_jugador,null,null,null,null,null);
		Cursor c = database.rawQuery("SELECT _ID, id_torneo, nom_jugador, par_gan, par_emp, par_per, gol_afa," +
				" gol_enc, numero FROM jugador where id_torneo='"+id_torneo+"' order by numero asc", new String [] {});
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Jugador jugador = cursorToJugador(c);
			System.out.println("jugador: "+ c.getInt(0) +" "+jugador.getName());
			jugadores.add(jugador);
		}
		c.close();
		return jugadores;
	}
	//V1.5 CJCA INI
	public List<Jugador> leerJugadoresTabla(long id_torneo){
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Cursor c = database.rawQuery("SELECT _ID, id_torneo, nom_jugador, par_gan, par_emp, par_per, gol_afa," +
				" gol_enc, numero FROM jugador where id_torneo='"+id_torneo+"' order by par_gan*3 + par_emp, gol_afa - gol_enc", new String [] {});
		System.out.println("Tabla de posiciones");
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			Jugador jugador = cursorToJugador(c);
			System.out.println("jugador: "+ c.getInt(0) +" "+jugador.getName());
			jugadores.add(jugador);
		}
		c.close();
		return jugadores;
	}
	//V1.5 CJCA FIN
	 private Jugador cursorToJugador(Cursor cursor) {
		    Jugador jugador = new Jugador();
		    jugador.setId(cursor.getInt(0));
		    jugador.setId_torneo(cursor.getInt(1));
		    jugador.setName(cursor.getString(2));
		    jugador.setPar_gan(cursor.getInt(3));
		    jugador.setPar_emp(cursor.getInt(4));
		    jugador.setPar_per(cursor.getInt(5));
		    jugador.setGol_afa(cursor.getInt(6));
		    jugador.setGol_enc(cursor.getInt(7));
		    jugador.setNumero(cursor.getInt(8));
		    return jugador;
	}
	public void insertarJugador(String nombre, long idtorneo, int q){
		ContentValues valores = new ContentValues();
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
		//database.execSQL("INSERT INTO jugador(nom_jo¿ugador) values ('"+nombre+"')");
	}
	public Jugador obtenerxnumero(int num){
		Cursor c = database.rawQuery("SELECT _ID, id_torneo, nom_jugador, par_gan, par_emp, par_per" +
				", gol_afa, gol_enc, numero FROM jugador where numero='"+num+"'", new String [] {});
		Jugador jugador = null;
		if(c.getCount()>0){
		c.moveToFirst();
		jugador = cursorToJugador(c);
		c.close();
		}
		return jugador;
	}
	public void deleteJugador(Jugador jugador){
		long id = jugador.getId();
		database.delete(BaseDeDatos.C_TABLA_JUGADOR, BaseDeDatos.C_COLUMNA_ID_JUG + " = "+ id, null);
	}
	public String obtenerxid(long num, long id_torneo){
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
