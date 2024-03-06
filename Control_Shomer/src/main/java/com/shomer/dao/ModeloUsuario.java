package com.shomer.dao;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;

import com.shomer.dto.Usuario;
import com.shomer.oblist.UsuarioInit;

public class ModeloUsuario {


	/* Creamos una variable encapsulada la cual almacenara el POOL de Conexiones */
	
	//Se importa paquete Javax sql
	private DataSource origenDatos;
	
	/* Creamos un constructor para la Clase ModeloUsuario 
	 * el cual recibira por parametro el POOL de Conexiones
	 */
	
	public ModeloUsuario(DataSource origenDatos) {

		//Definimos el origenDatos para cuando sea invocado
		
		this.origenDatos=origenDatos;
		
	}
	
	/*
	 * Se crea un metodo que pueda obtener el listado generado cuando el usuario a
	 * realizado consultas en la BBDD, el cual, devolvera la informacion por medio de
	 * una lista
	 */
	
	//Se importa paquete Java Util - Se lanza una exception para un try catch
	public List<UsuarioInit> getUsuarios() throws Exception{
		
		//Creamos una Lista que almacene los Usuarios que se le enseñan al Operador
		
		List<UsuarioInit> usuarios = new ArrayList<>();
		
		/* Establecemos la conexion por medio de un Statement y un Resultset */
		
		Connection myConexion=null;
		
		ResultSet myResultset=null;
		
		// -----  Establecemos la Conexion con el POOL de datos ----
		
		myConexion=origenDatos.getConnection();
		
		// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
		
		CallableStatement myStatement=myConexion.prepareCall("{CALL usuarioShomer()}");
		// ----- Ejecutar la sentencia SQL --------
		
		myResultset=myStatement.executeQuery();
		
		// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
	
		
			while(myResultset.next()) {
				
				int idusu  = myResultset.getInt("id");
				String nomusu  = myResultset.getString("nombre");
				String apelusu  = myResultset.getString("apellido");
				String usu  = myResultset.getString("usuario");
				String contr  = myResultset.getString("password");
				String emailusu  = myResultset.getString("email");
				String movilusu  = myResultset.getString("celular");
				Date fech  = myResultset.getDate("fechaingreso");
				/* int codperf = myResultset.getInt("codperfil"); */
				String codperf  = myResultset.getString("perfil");
				/* int codrh = myResultset.getInt("codrh"); */
				String codrh  = myResultset.getString("rh");
				/* int codarl = myResultset.getInt("codarl"); */
				String codarl  = myResultset.getString("arl");
				
				//Agregamos los datos a un listado
				
				//Creamos una variable temporal de tipo Usuario
				
				UsuarioInit tempUsuario = new UsuarioInit(idusu,nomusu,apelusu,usu,contr,emailusu,movilusu,fech,codperf,codrh,codarl);
			
				//Agregamos el Objeto temporal a nuestro Lista
				
				usuarios.add(tempUsuario);
				
			}
			
			return usuarios;
			
	}

	public void agregarUsuarioNuevo(Usuario nuevoUsuario) throws Exception{
		// TODO Auto-generated method stub
		
		//Para crear la Conexion creamos un objeto de tipo Connection
		
		Connection myConexion = null;
		
		//Obtener la Conexion con la BBDD
		
		try {
			
			myConexion = origenDatos.getConnection();
			
		//Crear la Instruccion SQL que Inserte el nuevo Usuario / Crear la Consulta Preparada
		

		String sql ="{CALL insertUsuario(?,?,?,?,?,?,?,?,?,?)}";
				
		CallableStatement myStatement = myConexion.prepareCall(sql);
		
		//Establecer los parametros para el Usuario
		
		myStatement.setString(1, nuevoUsuario.getNomusu());
		
		myStatement.setString(2, nuevoUsuario.getApelusu());
		
		myStatement.setString(3, nuevoUsuario.getUsu());
		
		myStatement.setString(4, nuevoUsuario.getContr());
		
		myStatement.setString(5, nuevoUsuario.getEmailusu());
		
		myStatement.setString(6, nuevoUsuario.getMovilusu());
		
		// Convertimos el Date.Util a Date.Sql
		
		java.util.Date utilDate = nuevoUsuario.getFech();
		
		// Conversion
		
		java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
		
		myStatement.setDate(7, fechaConvertida);
		
		myStatement.setInt(8, nuevoUsuario.getCodperf());
		
		myStatement.setInt(9, nuevoUsuario.getCodrh());
		
		myStatement.setInt(10, nuevoUsuario.getCodarl());
		
		//Ejecutar la Instruccion SQL
		
		myStatement.execute();
		
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}finally {
			myConexion.close();
		}
	}

	public Usuario getUsuario(int id_Usu) throws Exception {
		// TODO Auto-generated method stub
		
		Usuario elUsuario = null;
		
		Connection myConexion = null;
		
		PreparedStatement myStatement = null;
		
		ResultSet myResultset = null;
		
		int idUsuario = id_Usu;
		
		try {
		
		//Establecer la Conexion con la BBDD
		
		myConexion = origenDatos.getConnection();
		
		//Crear el SQL que busque el Usuario con el codigo Usuario enviado
		
		String sql = "SELECT * FROM usuario WHERE IDUSUARIO=?";
		
		//Crear la Consulta Preparada
		
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los parametros de la consulta
		
		myStatement.setInt(1, idUsuario);
		
		//Ejecutar la Consulta
		
		myResultset = myStatement.executeQuery();
		
		//Obtener los datos de Respuesta
		
		if(myResultset.next()) {
			
			int idusu  = myResultset.getInt("idusuario");
			String nomusu  = myResultset.getString("nomusuario");
			String apelusu  = myResultset.getString("apelusuario");
			String usu  = myResultset.getString("usuario");
			String contr  = myResultset.getString("contra");
			String emailusu  = myResultset.getString("emailusuario");
			String movilusu  = myResultset.getString("movilusuario");
			Date fech  = myResultset.getDate("fecha");
			int codperf  = myResultset.getInt("codperfil");
			int codrh  = myResultset.getInt("codrh");
			int codarl  = myResultset.getInt("codarl");
			
			//Creamos una variable temporal de tipo Usuario
			
			elUsuario = new Usuario(idusu,nomusu,apelusu,usu,contr,emailusu,movilusu,fech,codperf,codrh,codarl);
		
		} else {
			
			//En dado caso que no exista el Codigo Usuario lanza una exception
			throw new Exception("No hemos encontrado el Usuario con el codigo " + idUsuario);
			
		}
		
		
		}catch (Exception e) {
			// TODO: handle exception
		
			e.printStackTrace();
			
		}finally {
			
			myConexion.close();
		}
		
		return elUsuario;
	}

	public void actualizarUsuario(Usuario usuarioActualizado) throws Exception{
		// TODO Auto-generated method stub
		
		Connection myConexion = null;

		PreparedStatement myStatement = null;
		
		//Establecer la Conexion con la BBDD

		
		try {
			
		myConexion = origenDatos.getConnection();
			
		//Crear la Sentencia SQL
			
		String sql = "Update Usuario Set nomusuario=?,apelusuario=?,usuario=?,contra=?,emailusuario=?,movilusuario=?,fecha=?,codperfil=?,codrh=?,codarl=? WHERE IDUSUARIO=?";
			
		//Crear la Consulta Preparada
			
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los Parametros o  Actualizar los registros
			
		myStatement.setString(1, usuarioActualizado.getNomusu());
		myStatement.setString(2, usuarioActualizado.getApelusu());
		myStatement.setString(3, usuarioActualizado.getUsu());
		myStatement.setString(4, usuarioActualizado.getContr());
		myStatement.setString(5, usuarioActualizado.getEmailusu());
		myStatement.setString(6, usuarioActualizado.getMovilusu());
		
		// Convertimos el Date.Util a Date.Sql
		
		java.util.Date utilDate = usuarioActualizado.getFech();
				
		// Conversion
				
		java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
				
		myStatement.setDate(7, fechaConvertida);

		myStatement.setInt(8, usuarioActualizado.getCodperf());
		myStatement.setInt(9, usuarioActualizado.getCodrh());
		myStatement.setInt(10, usuarioActualizado.getCodarl());
		myStatement.setInt(11, usuarioActualizado.getIdusu());
		
		//Ejecutar la Sentencia SQL
			
		myStatement.execute();
			
		}catch (Exception e) {
			// TODO: handle exception
		
			e.printStackTrace();
			
		}finally {
				
			myStatement.close();
			myConexion.close();
			  
		}
	}

	public void eliminarUsuario(int idUsuario) throws Exception{
		// TODO Auto-generated method stub
		
		Connection myConexion = null;

		PreparedStatement myStatement = null;
		
		//Establecer la Conexion con la BBDD

		try {
			
		myConexion = origenDatos.getConnection();
		
		
		//Crear la Instruccion SQL de Eliminacion
		
		String sql = "Delete from Usuario Where IDUSUARIO=?"; 
		
		//Preparar la Consulta
		
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los parametros de Consulta
		
		myStatement.setInt(1, idUsuario);
		
		//Ejecutar la Sentencia SQL
		
		myStatement.execute();
		
		}finally {
			  
			myStatement.close();
			myConexion.close();
			  
		}
		
		
	}

	/* Metodo de Autenticacion de Usuario */
	
	
	public String authenticateUser(Usuario loginBean) {
		
		String usu = loginBean.getUsu(); 
		String contr = loginBean.getContr();

		Connection myConexion = null;
		
		PreparedStatement myStatement = null;
		
		ResultSet myResultSet = null;

		String userNameDB = "";
		String passwordDB = "";
		String roleDB="";

		try
		{
			myConexion = origenDatos.getConnection(); 

			/* CallableStatement myStatement=myConexion.prepareCall("call LOGIN_USER"); */
			
			String sqlLogin = "SELECT * FROM usuario WHERE usuario=? AND contra=?"; 
			
			myStatement = myConexion.prepareStatement(sqlLogin);
			
			//Establecer los parametros de la COnsulta
			
				myStatement.setString(1, usu); 
				myStatement.setString(2, contr);
			
			myResultSet=myStatement.executeQuery(); 
			
			
			while(myResultSet.next()) 
			{
				userNameDB = myResultSet.getString("usuario");
				passwordDB = myResultSet.getString("contra");
				roleDB=myResultSet.getString("codperfil");

				if(usu.equals(userNameDB) && contr.equals(passwordDB) && roleDB.equals("1"))
				{
					myConexion.close();
					return "Admin_Role"; 
					
				}else if(usu.equals(userNameDB) && contr.equals(passwordDB) && roleDB.equals("2")) {
					
					myConexion.close();
					return "Oper_Role";
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Credenciales de Usuario invalidas";
		
	}
	
}
