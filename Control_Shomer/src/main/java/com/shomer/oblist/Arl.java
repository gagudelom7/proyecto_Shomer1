package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Arl {
	
public Arl() {
		
	}
	
public Arl(DataSource origenDatos) {
	
	//Definimos el origenDatos para cuando sea invocado
	
			this.origenDatos=origenDatos;
	}
	
	public Arl(int idarl, String nomarl, String telarl, String dirweb) {
		
		this.idarl = idarl;
		this.nomarl = nomarl;
		this.telarl = telarl;
		this.dirweb = dirweb;
	}
		
	public int getIdarl() {
		return idarl;
	}

	public void setIdarl(int idarl) {
		this.idarl = idarl;
	}

	public String getNomarl() {
		return nomarl;
	}

	public void setNomarl(String nomarl) {
		this.nomarl = nomarl;
	}

	public String getTelarl() {
		return telarl;
	}

	public void setTelarl(String telarl) {
		this.telarl = telarl;
	}

	public String getDirweb() {
		return dirweb;
	}

	public void setDirweb(String dirweb) {
		this.dirweb = dirweb;
	}


	private DataSource origenDatos;
	private int idarl;
	private String nomarl;
	private String telarl;
	private String dirweb;
	
	//Metodo HashMap
	
			public HashMap<String, String> drop_Arl() throws Exception {
				
				
				HashMap<String,String> drop4 = new HashMap<>();
				
				try {
					
					/* Establecemos la conexion por medio de un Statement y un Resultset */
					
					
					Connection myConexion=null;
					
					Statement myStatement=null;
					
					ResultSet myResultset=null;
					
					// -----  Establecemos la Conexion con el POOL de datos ----
					
					myConexion=origenDatos.getConnection();
					
					// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
					
					String instruccionSql="select idarl, nomarl from arl";
					
					myStatement=myConexion.createStatement();
					
					// ----- Ejecutar la sentencia SQL --------
					
					myResultset=myStatement.executeQuery(instruccionSql);
					
					// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
				
					
						while(myResultset.next()) {
							
							drop4.put(myResultset.getString("idarl"), myResultset.getString("nomarl"));
						}
						
						myStatement.close();
						myConexion.close();
					
				}catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
				return drop4;
				
				}

}
