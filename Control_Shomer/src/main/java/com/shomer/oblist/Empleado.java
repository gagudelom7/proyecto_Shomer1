package com.shomer.oblist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

public class Empleado {

	
	public Empleado() {
	}
	
	public Empleado(DataSource origenDatos) {
		
		//Definimos el origenDatos para cuando sea invocado
		
				this.origenDatos=origenDatos;
	}
	

	
	public Empleado(int idfuncionario, String nomfuncionario, String apelfuncionario, String teloficina,
			String emailfuncionario, int coddependencia) {
		
		this.idfuncionario = idfuncionario;
		this.nomfuncionario = nomfuncionario;
		this.apelfuncionario = apelfuncionario;
		this.teloficina = teloficina;
		this.emailfuncionario = emailfuncionario;
		this.coddependencia = coddependencia;
	}

	public DataSource getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	public int getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getNomfuncionario() {
		return nomfuncionario;
	}

	public void setNomfuncionario(String nomfuncionario) {
		this.nomfuncionario = nomfuncionario;
	}

	public String getApelfuncionario() {
		return apelfuncionario;
	}

	public void setApelfuncionario(String apelfuncionario) {
		this.apelfuncionario = apelfuncionario;
	}

	public String getTeloficina() {
		return teloficina;
	}

	public void setTeloficina(String teloficina) {
		this.teloficina = teloficina;
	}

	public String getEmailfuncionario() {
		return emailfuncionario;
	}

	public void setEmailfuncionario(String emailfuncionario) {
		this.emailfuncionario = emailfuncionario;
	}

	public int getCoddependencia() {
		return coddependencia;
	}

	public void setCoddependencia(int coddependencia) {
		this.coddependencia = coddependencia;
	}

	private DataSource origenDatos;
	private int idfuncionario;
	private String nomfuncionario;
	private String apelfuncionario;
	private String teloficina;
	private String emailfuncionario;
	private int coddependencia;
	
	//Metodo HashMap
	public HashMap<String, String> drop_Funcionario() throws Exception{
		
		
		HashMap<String,String> drop3 = new HashMap<>();
		
		try {
			
			/* Establecemos la conexion por medio de un Statement y un Resultset */
			
			
			Connection myConexion=null;
			
			Statement myStatement=null;
			
			ResultSet myResultset=null;
			
			// -----  Establecemos la Conexion con el POOL de datos ----
			
			myConexion=origenDatos.getConnection();
			
			// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
			
			String instruccionSql="select idfuncionario, CONCAT(nomfuncionario, ' ', apelfuncionario) as nombreFuncionario from funcionario";
			
			myStatement=myConexion.createStatement();
			
			// ----- Ejecutar la sentencia SQL --------
			
			myResultset=myStatement.executeQuery(instruccionSql);
			
			// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
		
			
				while(myResultset.next()) {
					
					drop3.put(myResultset.getString("idfuncionario"), myResultset.getString("nombreFuncionario"));
				}
			
				myStatement.close();
				myConexion.close();
				
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return drop3;
		
		
		}

}
