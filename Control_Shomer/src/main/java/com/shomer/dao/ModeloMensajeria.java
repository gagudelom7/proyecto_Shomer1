package com.shomer.dao;


import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.shomer.dto.Mensajeria;
import com.shomer.oblist.MensajeriaInit;


public class ModeloMensajeria {

	/* Creamos una variable encapsulada la cual almacenara el POOL de Conexiones */
	
	//Se importa paquete Javax sql
	private DataSource origenDatos;
	
	/* Creamos un constructor para la Clase ModeloUsuario 
	 * el cual recibira por parametro el POOL de Conexiones
	 */
	
	public ModeloMensajeria(DataSource origenDatos) {
		
		//Definimos el origenDatos para cuando sea invocado
		
				this.origenDatos=origenDatos;
		
	}
	
	/*
	 * Se crea un metodo que pueda obtener el listado generado cuando el usuario a
	 * realizado consultas en la BBDD, el cual, devolvera la informacion por medio de
	 * una lista
	 */
	
	//Se importa paquete List Java Util - Se lanza una exception para un try catch
	
	public List<MensajeriaInit> getMensajerias() throws Exception{
		
		//Creamos una Lista que almacene los objetos de Mensajeria que se le muestran al Operador
		
				List<MensajeriaInit> mensajerias = new ArrayList<>();
				
				/* Establecemos la conexion por medio de un Statement y un Resultset */
				
				Connection myConexion=null;
				
				ResultSet myResultset=null;
				
				// -----  Establecemos la Conexion con el POOL de datos ----
				
				myConexion=origenDatos.getConnection();
				
				// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
				
				CallableStatement myStatement=myConexion.prepareCall("{CALL mensajeriaShomer()}");
				
				// ----- Ejecutar la sentencia SQL --------
				
				myResultset=myStatement.executeQuery();
				
				// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
			
				
					while(myResultset.next()) {
						
						int idMensa  = myResultset.getInt("id");
						/* int codMensa = myResultset.getInt("referencia"); */
						String codMensa  = myResultset.getString("referencia");
						BigDecimal cantMensa  = myResultset.getBigDecimal("cantidad");
						Date fechaLle  = myResultset.getDate("fechallegada");
						/* int codFuncio = myResultset.getInt("nomFuncionario"); */
						String codFuncio  = myResultset.getString("nomFuncionario");
						String remiteMensa  = myResultset.getString("remitente");
						/* int codEmpreMensa = myResultset.getInt("nomEmpresa"); */
						String codEmpreMensa  = myResultset.getString("nomEmpresa");
						/* int codEstaMensa = myResultset.getInt("estado"); */
						String codEstaMensa  = myResultset.getString("estado");
						/* int codObservaMensa = myResultset.getInt("observaciones"); */
						String codObservaMensa  = myResultset.getString("observaciones");
						Date fechaEntrega  = myResultset.getDate("fechaentrega");
						String notasMensa  = myResultset.getString("notas");
						//Agregamos los datos a un listado
						
						//Creamos una variable temporal de tipo Usuario
						
						MensajeriaInit tempMensajeria = new MensajeriaInit(idMensa,codMensa,cantMensa,fechaLle,codFuncio,remiteMensa,codEmpreMensa,codEstaMensa,codObservaMensa,fechaEntrega,notasMensa);
					
						//Agregamos el Objeto temporal a nuestro Lista
						
						mensajerias.add(tempMensajeria);
						
					}
					
					return mensajerias;
		
	}

	public void agregarMensajeriaNueva(Mensajeria nuevaMensajeria) throws Exception {
		// TODO Auto-generated method stub
		
	//Para crear la Conexion creamos un objeto de tipo Connection
		
		Connection myConexion = null;
		
		//Obtener la Conexion con la BBDD
		
		try {
			
			myConexion = origenDatos.getConnection();
			
		//Crear la Instruccion SQL que Inserte el nuevo Usuario / Crear la Consulta Preparada
		
		//NOTA CAMBIAR A STORE PROCEDURE
		/*
		 * String sql =
		 * "Insert into Mensajeria (codmensajeria,cantidad,fechallegada,codfuncionario,remitente,codempremensa,codestadomensa,codobservaciones,notasmensajeria)"
		 * + "Values (?,?,?,?,?,?,?,?,?)";
		 */
		
			String sql ="{CALL insertMensajeria(?,?,?,?,?,?,?,?,?)}";
			
			CallableStatement myStatement = myConexion.prepareCall(sql);
			
		
		//Establecer los parametros para el Usuario
		
		myStatement.setInt(1, nuevaMensajeria.getCodmensajeria());
		
		myStatement.setBigDecimal(2, nuevaMensajeria.getCantidad());
		
		// Convertimos el Date.Util a Date.Sql
		
		java.util.Date utilDate = nuevaMensajeria.getFechallegada();
				
		// Conversion
				
		java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
				
		myStatement.setDate(3, fechaConvertida);
		
		myStatement.setInt(4, nuevaMensajeria.getCodfuncionario());
		
		myStatement.setString(5, nuevaMensajeria.getRemitente());
		
		myStatement.setInt(6, nuevaMensajeria.getCodempremensa());
		
		myStatement.setInt(7, nuevaMensajeria.getCodestadomensa());
		
		myStatement.setInt(8, nuevaMensajeria.getCodobservaciones());
		
		// Convertimos el Date.Util a Date.Sql
		
		/*
		 * java.util.Date utilDate1 = nuevaMensajeria.getFechaentrega();
		 * 
		 * java.sql.Date fechaConvertida1 = new java.sql.Date(utilDate1.getTime());
		 * 
		 * myStatement.setDate(9, fechaConvertida1);
		 */
		
		myStatement.setString(9, nuevaMensajeria.getNotasmensajeria());
				
		//Ejecutar la Instruccion SQL
		
		myStatement.execute();
		
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}finally {
			
			/* myStatement.close(); */
			myConexion.close();
		}
		
	}

	public Mensajeria getMensajeria(int idMensajeria) throws Exception {
		// TODO Auto-generated method stub

		Mensajeria laMensajeria = null;
		
		Connection myConexion = null;
		
		PreparedStatement myStatement = null;
		
		ResultSet myResultset = null;
		
		int Idmensajeria = idMensajeria;
		
		try {
		
		//Establecer la Conexion con la BBDD
		
		myConexion = origenDatos.getConnection();
		
		//Crear el SQL que busque el Usuario con el codigo Usuario enviado
		
		String sql = "SELECT * FROM mensajeria WHERE idmensajeria=?";
		
		//Crear la Consulta Preparada
		
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los parametros de la consulta
		
		myStatement.setInt(1, Idmensajeria);
		
		//Ejecutar la Consulta
		
		myResultset = myStatement.executeQuery();
		
		//Obtener los datos de Respuesta
		
		if(myResultset.next()) {
			
			int idMensa  = myResultset.getInt("idmensajeria");
			int codMensa  = myResultset.getInt("codmensajeria");
			BigDecimal cantMensa  = myResultset.getBigDecimal("cantidad");
			Date fechaLle  = myResultset.getDate("fechallegada");
			int codFuncio  = myResultset.getInt("codfuncionario");
			String remiteMensa  = myResultset.getString("remitente");
			int codEmpreMensa  = myResultset.getInt("codempremensa");
			int codEstaMensa  = myResultset.getInt("codestadomensa");
			int codObservaMensa  = myResultset.getInt("codobservaciones");
			Date fechaEntrega  = myResultset.getDate("fechaentrega");
			String notasMensa  = myResultset.getString("notasmensajeria");
			//Agregamos los datos a un listado
			
			//Creamos una variable temporal de tipo Mensajeria
			
			laMensajeria = new Mensajeria(idMensa,codMensa,cantMensa,fechaLle,codFuncio,remiteMensa,codEmpreMensa,codEstaMensa,codObservaMensa,fechaEntrega,notasMensa);
		
			
		} else {
			
			//En dado caso que no exista el Codigo Usuario lanza una exception
			throw new Exception("No hemos encontrado el Usuario con el codigo " + Idmensajeria);
			
		}
		
		
		}catch (Exception e) {
			// TODO: handle exception
		
			e.printStackTrace();
			
		}finally {
			
			myConexion.close();
		}
		
		return laMensajeria;
	}

	public void actualizarMensajeria(Mensajeria mensajeriaActualizada) throws Exception {
		// TODO Auto-generated method stub
		
		Connection myConexion = null;

		PreparedStatement myStatement = null;
		
		//Establecer la Conexion con la BBDD

		
		try {
			
		myConexion = origenDatos.getConnection();
			
		//Crear la Sentencia SQL
			
		String sql = "Update Mensajeria Set codmensajeria=?,cantidad=?,fechallegada=?,codfuncionario=?,remitente=?,codempremensa=?,codestadomensa=?,codobservaciones=?,fechaentrega=?,notasmensajeria=? WHERE IDMENSAJERIA=?";
			
		//Crear la Consulta Preparada
			
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los Parametros o  Actualizar los registros
			
		myStatement.setInt(1, mensajeriaActualizada.getCodmensajeria());
		
		myStatement.setBigDecimal(2, mensajeriaActualizada.getCantidad());
		
		// Convertimos el Date.Util a Date.Sql
		
		java.util.Date utilDate = mensajeriaActualizada.getFechallegada();
				
		// Conversion
				
		java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
				
		myStatement.setDate(3, fechaConvertida);
		
		myStatement.setInt(4, mensajeriaActualizada.getCodfuncionario());
		
		myStatement.setString(5, mensajeriaActualizada.getRemitente());
		
		myStatement.setInt(6, mensajeriaActualizada.getCodempremensa());
		
		myStatement.setInt(7, mensajeriaActualizada.getCodestadomensa());
		
		myStatement.setInt(8, mensajeriaActualizada.getCodobservaciones());
		
		// Convertimos el Date.Util a Date.Sql
		
		java.util.Date utilDate1 = mensajeriaActualizada.getFechaentrega();
						
		// Conversion
						
		java.sql.Date fechaConvertida1 = new java.sql.Date(utilDate1.getTime());
						
		myStatement.setDate(9, fechaConvertida1);
		
		myStatement.setString(10, mensajeriaActualizada.getNotasmensajeria());
		
		myStatement.setInt(11, mensajeriaActualizada.getIdmensajeria());
		
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

	public void eliminarMensajeria(int idMensajeria) throws Exception {
		// TODO Auto-generated method stub
		
		Connection myConexion = null;

		PreparedStatement myStatement = null;
		
		//Establecer la Conexion con la BBDD

		try {
			
		myConexion = origenDatos.getConnection();
		
		
		//Crear la Instruccion SQL de Eliminacion
		
		String sql = "Delete from Mensajeria Where IDMENSAJERIA=?"; 
		
		//Preparar la Consulta
		
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los parametros de Consulta
		
		myStatement.setInt(1, idMensajeria);
		
		//Ejecutar la Sentencia SQL
		
		myStatement.execute();
		
		}finally {
			  
			myStatement.close();
			myConexion.close();
			  
		}
		
	}

	/*
	 * public List<Mensajeria> buscarMensajerias(String tempMensajeria) {
	 * 
	 * List<Mensajeria> mensajerias = new ArrayList<>();
	 * 
	 * String instruccionSql;
	 * 
	 * instruccionSql="SELECT * FROM MENSAJERIA WHERE CODMENSAJERIA LIKE '%"
	 * +tempMensajeria+"%' OR FECHALLEGADA LIKE '%" +tempMensajeria+"%'";
	 * 
	 * try {
	 * 
	 * Connection myConexion=null;
	 * 
	 * PreparedStatement myPrepareste = null;
	 * 
	 * ResultSet myResultset=null;
	 * 
	 * myConexion=origenDatos.getConnection();
	 * 
	 * myPrepareste = myConexion.prepareStatement(instruccionSql);
	 * 
	 * myResultset = myPrepareste.executeQuery();
	 * 
	 * 
	 * while(myResultset.next()) {
	 * 
	 * Mensajeria mensa = new Mensajeria();
	 * 
	 * mensa.setIdmensajeria(myResultset.getInt("idmensajeria"));
	 * mensa.setCodmensajeria(myResultset.getInt("codmensajeria"));
	 * mensa.setCantidad(myResultset.getBigDecimal("cantidad"));
	 * mensa.setFechallegada(myResultset.getDate("fechallegada"));
	 * mensa.setCodfuncionario(myResultset.getInt("codfuncionario"));
	 * mensa.setRemitente(myResultset.getString("remitente"));
	 * mensa.setCodempremensa(myResultset.getInt("codempremensa"));
	 * mensa.setCodestadomensa(myResultset.getInt("codestadomensa"));
	 * mensa.setCodobservaciones(myResultset.getInt("codobservaciones"));
	 * mensa.setFechaentrega(myResultset.getDate("fechaentrega"));
	 * mensa.setNotasmensajeria(myResultset.getString("notasmensajeria"));
	 * 
	 * mensajerias.add(mensa); } } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * return mensajerias; }
	 */

}
