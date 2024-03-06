package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Observavis {
	
public Observavis() {
	}

public Observavis(DataSource origenDatos) {
	
	//Definimos el origenDatos para cuando sea invocado
	
			this.origenDatos=origenDatos;
}
	
	public Observavis(int idobservavis, String observavis) {
		
		this.idobservavis = idobservavis;
		this.observavis = observavis;
	}
	
	
	public int getIdobservavis() {
		return idobservavis;
	}

	public void setIdobservavis(int idobservavis) {
		this.idobservavis = idobservavis;
	}

	public String getObservavis() {
		return observavis;
	}

	public void setObservavis(String observavis) {
		this.observavis = observavis;
	}

	private DataSource origenDatos;
	private int idobservavis;
	private String observavis;

	//Metodo HashMap
	
	public HashMap<String, String> drop_Observaciones() throws Exception {
		
		
		HashMap<String,String> drop6 = new HashMap<>();
		
		try {
			
			/* Establecemos la conexion por medio de un Statement y un Resultset */
			
			
			Connection myConexion=null;
			
			Statement myStatement=null;
			
			ResultSet myResultset=null;
			
			// -----  Establecemos la Conexion con el POOL de datos ----
			
			myConexion=origenDatos.getConnection();
			
			// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
			
			String instruccionSql="select idobservavis, observavis from observavis";
			
			myStatement=myConexion.createStatement();
			
			// ----- Ejecutar la sentencia SQL --------
			
			myResultset=myStatement.executeQuery(instruccionSql);
			
			// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
		
			
				while(myResultset.next()) {
					
					drop6.put(myResultset.getString("idobservavis"), myResultset.getString("observavis"));
				}
			
				myStatement.close();
				myConexion.close();
				
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return drop6;
		
		
		}
	
}
