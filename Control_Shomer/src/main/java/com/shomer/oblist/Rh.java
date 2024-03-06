package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Rh {

	public Rh() {
			}

	public Rh(DataSource origenDatos) {
		
		//Definimos el origenDatos para cuando sea invocado
		
				this.origenDatos=origenDatos;
}

	public Rh(int idrh, String rhnombre) {
		
		this.idrh = idrh;
		this.rhnombre = rhnombre;
	}
	
	public int getIdrh() {
		return idrh;
	}

	public void setIdrh(int idrh) {
		this.idrh = idrh;
	}

	public String getRhnombre() {
		return rhnombre;
	}

	public void setRhnombre(String rhnombre) {
		this.rhnombre = rhnombre;
	}




	private DataSource origenDatos;
	private int idrh;
	private String rhnombre;
	
	
	//Metodo HashMap
	
	public HashMap<String, String> drop_Rh() throws Exception {
		
		
		HashMap<String,String> drop5 = new HashMap<>();
		
		try {
			
			/* Establecemos la conexion por medio de un Statement y un Resultset */
			
			
			Connection myConexion=null;
			
			Statement myStatement=null;
			
			ResultSet myResultset=null;
			
			// -----  Establecemos la Conexion con el POOL de datos ----
			
			myConexion=origenDatos.getConnection();
			
			// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
			
			String instruccionSql="select idrh, rhnombre from rh";
			
			myStatement=myConexion.createStatement();
			
			// ----- Ejecutar la sentencia SQL --------
			
			myResultset=myStatement.executeQuery(instruccionSql);
			
			// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
		
			
				while(myResultset.next()) {
					
					drop5.put(myResultset.getString("idrh"), myResultset.getString("rhnombre"));
				}
			
				myStatement.close();
				myConexion.close();
				
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return drop5;
		
		
		}

}
