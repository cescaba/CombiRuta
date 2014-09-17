package com.proyectos2.util;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static android.provider.BaseColumns._ID;


public class BaseDeDatos extends SQLiteOpenHelper {
	
	public static final String C_TABLA_DESCR = "descr";
	public static final String C_COLUMNA_COD_DESCR = "_ID";
	public static final String C_COLUMNA_DES_DESCR = "des_desc";
	
	public static final String C_TABLA_PUN = "punto";
	public static final String C_COLUMNA_COD_PUN = "_ID";
	public static final String C_COLUMNA_DES_PUN = "des_pun";
	public static final String C_COLUMNA_REF_PUN = "ref_pun";
	public static final String C_COLUMNA_LAT_PUN = "lat_pun";
	public static final String C_COLUMNA_LON_PUN = "lon_pun";
	
	public static final String C_TABLA_PAR = "paradero";
	public static final String C_COLUMNA_COD_PAR = "_ID"; 
	
	public static final String C_TABLA_PAR_POR_RUT = "paraxruta";
	public static final String C_COLUMNA_COD_PAR_MUC = "id_pun";
	public static final String C_COLUMNA_COD_RUT_MUC = "id_ruta";
	
	public static final String C_TABLA_RUTA = "ruta";
	public static final String C_COLUMNA_COD_RUT = "_ID";
	public static final String C_COLUMNA_RUT_RUT = "cod_ruta";
	
	public static final String C_TABLA_LINEA = "linea";
	public static final String C_COLUMNA_COD_LIN = "id_linea";
	public static final String C_COLUMNA_NOM_LIN = "nom_linea";
	public static final String C_COLUMNA_IMG_LIN = "imag_linea";
	public static final String C_COLUMNA_COD_RUT_LIN = "id_ruta";
	public static final String C_COLUMNA_COD_EMP_LIN = "id_emp";
	
	public static final String C_TABLA_EMPRESA = "empresa";
	public static final String C_COLUMNA_COD_EMP = "_ID";
	public static final String C_COLUMNA_NOM_EMP = "nom_emp";
	
	
	public BaseDeDatos(Context ctx){
		super(ctx,"BDProyecto2",null,1);
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "CREATE TABLE "+C_TABLA_DESCR + " ( ";
		sql = sql + C_COLUMNA_COD_DESCR + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
		sql = sql + C_COLUMNA_DES_DESCR + " TEXT);";
		db.execSQL(sql);
		
		sql = "CREATE TABLE "+ C_TABLA_PUN + " ( ";
		sql = sql + C_COLUMNA_COD_PUN +" INTEGER PRIMARY KEY AUTOINCREMENT, ";
		sql = sql + C_COLUMNA_DES_PUN + " INTEGER, ";
		sql = sql + C_COLUMNA_REF_PUN + " TEXT, ";
		sql = sql + C_COLUMNA_LAT_PUN + " INTEGER, ";
		sql = sql + C_COLUMNA_LON_PUN + " INTEGER);";
		db.execSQL(sql);
		
		sql = "CREATE TABLE "+ C_TABLA_PAR + " ( ";
		sql = sql + C_COLUMNA_COD_PAR + " INTEGER PRIMARY KEY);";
		db.execSQL(sql);
		
		sql = "CREATE TABLE "+ C_TABLA_RUTA + " ( ";
		sql = sql + C_COLUMNA_COD_RUT + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
		sql = sql + C_COLUMNA_RUT_RUT + " TEXT);";
		db.execSQL(sql);
		
		sql = "CREATE TABLE "+ C_TABLA_PAR_POR_RUT + " ( ";
		sql = sql + C_COLUMNA_COD_PAR_MUC + " INTEGER PRIMARY KEY, ";
		sql = sql + C_COLUMNA_COD_RUT_MUC + " INTEGER PRIMARY KEY);";
		db.execSQL(sql);
		
		sql = "CREATE TABLE "+ C_TABLA_EMPRESA + " ( ";
		sql = sql + C_COLUMNA_COD_EMP + " INTEGER PRIMARY KEY, ";
		sql = sql + C_COLUMNA_NOM_EMP + " TEXT);";
		db.execSQL(sql);
		
		sql = "CREATE TABLE "+ C_TABLA_LINEA + " ( ";
		sql = sql + C_COLUMNA_COD_LIN +" INTEGER PRIMARY KEY AUTOINCREMENT, ";
		sql = sql + C_COLUMNA_NOM_LIN + " TEXT, ";
		sql = sql + C_COLUMNA_IMG_LIN + " TEXT, ";
		sql = sql + C_COLUMNA_COD_RUT_LIN + " INTEGER, ";
		sql = sql + C_COLUMNA_COD_EMP_LIN + " INTEGER);";
		db.execSQL(sql);
		
		
		//Insertando datos
		 ContentValues valores = new ContentValues();
			valores.put(C_COLUMNA_DES_DESCR, "P");
			Long id_des = this.getWritableDatabase().insert(C_TABLA_DESCR, null, valores);
			
		 valores = new ContentValues();
		 valores.put(C_COLUMNA_REF_PUN,"Azul_ida_ang");	
		 valores.put(C_COLUMNA_LAT_PUN,-12.119432);	
		 valores.put(C_COLUMNA_LON_PUN,-77.028806);	
		 valores.put(C_COLUMNA_DES_PUN, id_des);
		 	Long id_pun = this.getWritableDatabase().insert(C_TABLA_PUN, null, valores);
		 valores = new ContentValues();	
		 valores.put(C_COLUMNA_COD_PAR, id_pun);
		 
		 valores = new ContentValues();
		 valores.put(C_COLUMNA_REF_PUN,"Azul_ida_ara");	
		 valores.put(C_COLUMNA_LAT_PUN,-12.114015);
		 valores.put(C_COLUMNA_LON_PUN,-77.029657);	
		 	id_pun = this.getWritableDatabase().insert(C_TABLA_PUN, null, valores);
		 valores = new ContentValues();	
		 valores.put(C_COLUMNA_COD_PAR, id_pun);
		 	
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ C_TABLA_DESCR);
		db.execSQL("DROP TABLE IF EXISTS "+ C_TABLA_PUN);
		db.execSQL("DROP TABLE IF EXISTS "+ C_TABLA_PAR);
		db.execSQL("DROP TABLE IF EXISTS "+ C_TABLA_PAR_POR_RUT);
		db.execSQL("DROP TABLE IF EXISTS "+ C_TABLA_RUTA);
		db.execSQL("DROP TABLE IF EXISTS "+ C_TABLA_LINEA);
		db.execSQL("DROP TABLE IF EXISTS "+ C_TABLA_EMPRESA);
		onCreate(db);
	}
	
	public void abrir(){
		this.getWritableDatabase();
	}
	public void cerrar(){
		this.close();
	}
	
}