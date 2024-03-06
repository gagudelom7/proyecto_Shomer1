package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Equipos {
	
	
public Equipos() {
	}
	
public Equipos(DataSource origenDatos) {
	
	//Definimos el origenDatos para cuando sea invocado
	
			this.origenDatos=origenDatos;
}
	
	
	public Equipos(int idaparatos, String nomaparatos) {
		
		this.idaparatos = idaparatos;
		this.nomaparatos = nomaparatos;
	}
	
	
	
	public int getIdaparatos() {
		return idaparatos;
	}

	public void setIdaparatos(int idaparatos) {
		this.idaparatos = idaparatos;
	}

	public String getNomaparatos() {
		return nomaparatos;
	}

	public void setNomaparatos(String nomaparatos) {
		this.nomaparatos = nomaparatos;
	}

	private DataSource origenDatos;
	private int idaparatos;
	private String nomaparatos;
	
	//Metodo HashMap
	
		public HashMap<String, String> drop_Equipos() throws Exception{
			
			
			HashMap<String,String> drop7 = new HashMap<>();
			
			try {
				
				/* Establecemos la conexion por medio de un Statement y un Resultset */
				
				
				Connection myConexion=null;
				
				Statement myStatement=null;
				
				ResultSet myResultset=null;
				
				// -----  Establecemos la Conexion con el POOL de datos ----
				
				myConexion=origenDatos.getConnection();
				
				// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
				
				String instruccionSql="select idaparatos, nomaparatos from aparatos";
				
				myStatement=myConexion.createStatement();
				
				// ----- Ejecutar la sentencia SQL --------
				
				myResultset=myStatement.executeQuery(instruccionSql);
				
				// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
			
				
					while(myResultset.next()) {
						
						drop7.put(myResultset.getString("idaparatos"), myResultset.getString("nomaparatos"));
					}
					
					myStatement.close();
					myConexion.close();
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return drop7;
			
			
			}
		

}
