package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Dependencia {

public Dependencia() {
	
	}
	
public Dependencia(DataSource origenDatos) {
		
	//Definimos el origenDatos para cuando sea invocado
	
	this.origenDatos=origenDatos;
	}
	
	
	public Dependencia(int iddependencia, String nombdependencia, int codarea) {
		
		this.iddependencia = iddependencia;
		this.nombdependencia = nombdependencia;
		this.codarea = codarea;
	}
	
	
	
	
	public int getIddependencia() {
		return iddependencia;
	}

	public void setIddependencia(int iddependencia) {
		this.iddependencia = iddependencia;
	}

	public String getNombdependencia() {
		return nombdependencia;
	}

	public void setNombdependencia(String nombdependencia) {
		this.nombdependencia = nombdependencia;
	}

	public int getCodarea() {
		return codarea;
	}

	public void setCodarea(int codarea) {
		this.codarea = codarea;
	}

	private DataSource origenDatos;	
	private int iddependencia;
	private String nombdependencia;
	private int codarea;
	
	
	//Metodo HashMap
	
			public HashMap<String, String> drop_Dependencia() throws Exception{
				
				
				HashMap<String,String> drop2 = new HashMap<>();
				
				try {
					
					/* Establecemos la conexion por medio de un Statement y un Resultset */
					
					
					Connection myConexion=null;
					
					Statement myStatement=null;
					
					ResultSet myResultset=null;
					
					// -----  Establecemos la Conexion con el POOL de datos ----
					
					myConexion=origenDatos.getConnection();
					
					// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
					
					String instruccionSql="select iddependencia, nombdependencia from dependencia";
					
					myStatement=myConexion.createStatement();
					
					// ----- Ejecutar la sentencia SQL --------
					
					myResultset=myStatement.executeQuery(instruccionSql);
					
					// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
				
					
						while(myResultset.next()) {
							
							drop2.put(myResultset.getString("iddependencia"), myResultset.getString("nombdependencia"));
						}
						
						myStatement.close();
						myConexion.close();
						
						
				}catch (Exception e) {
					
					e.printStackTrace();
				}
				
				return drop2;
				
				
				}

}
