package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Identidad {
	
	public Identidad() {
		
		  }
	
	public Identidad(DataSource origenDatos) {
		
		//Definimos el origenDatos para cuando sea invocado
		
				this.origenDatos=origenDatos;
	  }

	
	public Identidad(int ididentidad, String nomidentidad) {

		this.ididentidad = ididentidad;
		this.nomidentidad = nomidentidad;
		
	}

	public int getIdidentidad() {
		return ididentidad;
	}


	public void setIdidentidad(int ididentidad) {
		this.ididentidad = ididentidad;
	}


	public String getNomidentidad() {
		return nomidentidad;
	}


	public void setNomidentidad(String nomidentidad) {
		this.nomidentidad = nomidentidad;
	}
	
		private DataSource origenDatos;	
		private int ididentidad;
		private String nomidentidad;
		
		//Metodo HashMap
		
		public HashMap<String, String> drop_Identidad() throws Exception {
			
			
			HashMap<String,String> drop = new HashMap<>();
			
			try {
				
				/* Establecemos la conexion por medio de un Statement y un Resultset */
				
				
				Connection myConexion=null;
				
				Statement myStatement=null;
				
				ResultSet myResultset=null;
				
				// -----  Establecemos la Conexion con el POOL de datos ----
				
				myConexion=origenDatos.getConnection();
				
				// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
				
				String instruccionSql="select ididentidad, nomidentidad from identidad";
				
				myStatement=myConexion.createStatement();
				
				// ----- Ejecutar la sentencia SQL --------
				
				myResultset=myStatement.executeQuery(instruccionSql);
				
				// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
			
				
					while(myResultset.next()) {
						
						drop.put(myResultset.getString("ididentidad"), myResultset.getString("nomidentidad"));
					}
				
					myStatement.close();
					myConexion.close();
					
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return drop;
			
			
			}

}
