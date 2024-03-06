package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class EmpMensajeria {

public EmpMensajeria() {
		}

public EmpMensajeria(DataSource origenDatos) {
	
			this.origenDatos=origenDatos;
}
	
	public EmpMensajeria(int idempmensajeria, String nomempresa, String telempresa, String dirweb) {
		
		this.idempmensajeria = idempmensajeria;
		this.nomempresa = nomempresa;
		this.telempresa = telempresa;
		this.dirweb = dirweb;
	}
	
	
	public int getIdempmensajeria() {
		return idempmensajeria;
	}

	public void setIdempmensajeria(int idempmensajeria) {
		this.idempmensajeria = idempmensajeria;
	}

	public String getNomempresa() {
		return nomempresa;
	}

	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
	}

	public String getTelempresa() {
		return telempresa;
	}

	public void setTelempresa(String telempresa) {
		this.telempresa = telempresa;
	}

	public String getDirweb() {
		return dirweb;
	}

	public void setDirweb(String dirweb) {
		this.dirweb = dirweb;
	}

	private DataSource origenDatos;
	private int idempmensajeria;
	private String nomempresa;
	private String telempresa;
	private String dirweb;
	
	//Metodo HashMap
	
		public HashMap<String, String> drop_EmpMensajeria() throws Exception{
			
			
			HashMap<String,String> drop2 = new HashMap<>();
			
			try {
				
				/* Establecemos la conexion por medio de un Statement y un Resultset */
				
				
				Connection myConexion=null;
				
				Statement myStatement=null;
				
				ResultSet myResultset=null;
				
				// -----  Establecemos la Conexion con el POOL de datos ----
				
				myConexion=origenDatos.getConnection();
				
				// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
				
				String instruccionSql="select idempmensajeria, nomempresa from empmensajeria";
				
				myStatement=myConexion.createStatement();
				
				// ----- Ejecutar la sentencia SQL --------
				
				myResultset=myStatement.executeQuery(instruccionSql);
				
				// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
			
				
					while(myResultset.next()) {
						
						drop2.put(myResultset.getString("idempmensajeria"), myResultset.getString("nomempresa"));
					}
				
					myStatement.close();
					myConexion.close();
					
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return drop2;
			
			
			}

}
