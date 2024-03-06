package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class TipoMensajeria {

	public TipoMensajeria() {
			}
	
	
	public TipoMensajeria(DataSource origenDatos) {
		
				this.origenDatos=origenDatos;
	}
	
	
	public TipoMensajeria(int idtipomensajeria, String referencia) {
	
		this.idtipomensajeria = idtipomensajeria;
		this.referencia = referencia;
	}
	
	
	
	public int getIdtipomensajeria() {
		return idtipomensajeria;
	}


	public void setIdtipomensajeria(int idtipomensajeria) {
		this.idtipomensajeria = idtipomensajeria;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	private DataSource origenDatos;
	private int idtipomensajeria;
	private String referencia;
	
	//Metodo HashMap
	
	public HashMap<String, String> drop_TipoMensajeria() throws Exception {
		
		
		HashMap<String,String> drop = new HashMap<>();
		
		try {
			
			/* Establecemos la conexion por medio de un Statement y un Resultset */
			
			
			Connection myConexion=null;
			
			Statement myStatement=null;
			
			ResultSet myResultset=null;
			
			// -----  Establecemos la Conexion con el POOL de datos ----
			
			myConexion=origenDatos.getConnection();
			
			// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
			
			String instruccionSql="select idtipomensajeria, referencia from tipomensajeria";
			
			myStatement=myConexion.createStatement();
			
			// ----- Ejecutar la sentencia SQL --------
			
			myResultset=myStatement.executeQuery(instruccionSql);
			
			// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
		
			
				while(myResultset.next()) {
					
					drop.put(myResultset.getString("idtipomensajeria"), myResultset.getString("referencia"));
				}
			
				
				myStatement.close();
				myConexion.close();
				
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return drop;
		
		
		}

}
