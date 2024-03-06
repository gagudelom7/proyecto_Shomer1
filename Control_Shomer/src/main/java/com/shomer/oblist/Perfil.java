package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Perfil {

public Perfil() {
		
	}

public Perfil(DataSource origenDatos) {
	
	this.origenDatos=origenDatos;
}
	
	
	public Perfil(int idperfil, String nomperfil) {
		
		this.idperfil = idperfil;
		this.nomperfil = nomperfil;
	}
	
	
	public int getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(int idperfil) {
		this.idperfil = idperfil;
	}

	public String getNomperfil() {
		return nomperfil;
	}

	public void setNomperfil(String nomperfil) {
		this.nomperfil = nomperfil;
	}




	private DataSource origenDatos;
	private int idperfil;
	private String nomperfil;
	
public HashMap<String, String> drop_Perfil() throws Exception {
		
		
		HashMap<String,String> drop9 = new HashMap<>();
		
		try {
			
			/* Establecemos la conexion por medio de un Statement y un Resultset */
			
			
			Connection myConexion=null;
			
			Statement myStatement=null;
			
			ResultSet myResultset=null;
			
			// -----  Establecemos la Conexion con el POOL de datos ----
			
			myConexion=origenDatos.getConnection();
			
			// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
			
			String instruccionSql="select idperfil, nomperfil from perfil";
			
			myStatement=myConexion.createStatement();
			
			// ----- Ejecutar la sentencia SQL --------
			
			myResultset=myStatement.executeQuery(instruccionSql);
			
			// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
		
			
				while(myResultset.next()) {
					
					drop9.put(myResultset.getString("idperfil"), myResultset.getString("nomperfil"));
				}
			
				myStatement.close();
				myConexion.close();
				
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return drop9;
		
		
		}

	
}
