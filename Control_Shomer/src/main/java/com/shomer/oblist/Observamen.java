package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Observamen {

public Observamen() {
		}

public Observamen(DataSource origenDatos) {
	
	this.origenDatos=origenDatos;
}
	
	public Observamen(int idobservamen, String observaciones) {
		
		this.idobservamen = idobservamen;
		this.observaciones = observaciones;
	}
	
	public int getIdobservamen() {
		return idobservamen;
	}

	public void setIdobservamen(int idobservamen) {
		this.idobservamen = idobservamen;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	private DataSource origenDatos;
	private int idobservamen;
	private String observaciones;
	
	//Metodo HashMap
	
	public HashMap<String, String> drop_ObservaMensajeria() throws Exception{
		
		
		HashMap<String,String> drop5 = new HashMap<>();
		
		try {
			
			/* Establecemos la conexion por medio de un Statement y un Resultset */
			
			
			Connection myConexion=null;
			
			Statement myStatement=null;
			
			ResultSet myResultset=null;
			
			// -----  Establecemos la Conexion con el POOL de datos ----
			
			myConexion=origenDatos.getConnection();
			
			// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
			
			String instruccionSql="select idobservamen, observaciones from observamen";
			
			myStatement=myConexion.createStatement();
			
			// ----- Ejecutar la sentencia SQL --------
			
			myResultset=myStatement.executeQuery(instruccionSql);
			
			// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
		
			
				while(myResultset.next()) {
					
					drop5.put(myResultset.getString("idobservamen"), myResultset.getString("observaciones"));
				}
			
				myStatement.close();
				myConexion.close();
				
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return drop5;
		
		
		}
}
