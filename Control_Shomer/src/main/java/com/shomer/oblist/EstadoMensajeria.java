package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class EstadoMensajeria {

	public EstadoMensajeria() {
			}
	
	public EstadoMensajeria(DataSource origenDatos) {
		
		this.origenDatos=origenDatos;
	}
	
	
	public EstadoMensajeria(int idestado, String estado) {

		this.idestado = idestado;
		this.estado = estado;
	}
	
	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private DataSource origenDatos;
	private int idestado;
	private String estado;
	
	
	//Metodo HashMap
	
			public HashMap<String, String> drop_EstadoMensajeria() throws Exception{
				
				
				HashMap<String,String> drop4 = new HashMap<>();
				
				try {
					
					/* Establecemos la conexion por medio de un Statement y un Resultset */
					
					
					Connection myConexion=null;
					
					Statement myStatement=null;
					
					ResultSet myResultset=null;
					
					// -----  Establecemos la Conexion con el POOL de datos ----
					
					myConexion=origenDatos.getConnection();
					
					// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
					
					String instruccionSql="select idestado, estado from estadomensajeria";
					
					myStatement=myConexion.createStatement();
					
					// ----- Ejecutar la sentencia SQL --------
					
					myResultset=myStatement.executeQuery(instruccionSql);
					
					// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
				
					
						while(myResultset.next()) {
							
							drop4.put(myResultset.getString("idestado"), myResultset.getString("estado"));
						}
					
						myStatement.close();
						myConexion.close();
						
				}catch (Exception e) {
					
					e.printStackTrace();
				}
				
				return drop4;
				
				
				}
}
