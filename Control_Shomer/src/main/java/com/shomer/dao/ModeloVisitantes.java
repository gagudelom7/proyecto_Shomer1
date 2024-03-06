package com.shomer.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import com.shomer.dto.Visitante;
import com.shomer.oblist.VisitanteInit;

public class ModeloVisitantes {
	
	private DataSource origenDatos;
	
	public ModeloVisitantes(DataSource origenDatos) {
		
		this.origenDatos = origenDatos;
	}

	public List<VisitanteInit> getVisitantes() throws Exception {
		
		List<VisitanteInit> visitantes = new ArrayList<>();
		
		Connection myConexion=null;
		
		ResultSet myResultset=null;
		
		myConexion = origenDatos.getConnection();
		 
		CallableStatement myStatement=myConexion.prepareCall("{CALL visitanteShomer()}"); 
		
		myResultset = myStatement.executeQuery();
		
		while(myResultset.next()) {
			
			int idvisit = myResultset.getInt("id");
			String nomvisitante = myResultset.getString("nombre");
			String apelvisitante = myResultset.getString("apellido");
			/* int codtipo = myResultset.getInt("tipoId"); */
			String codtipo = myResultset.getString("tipoId");
			String numidentidad = myResultset.getString("identidad");
			String movilvisitante = myResultset.getString("movil");
			String emailvisitante = myResultset.getString("email");
			/* int coddependencia = myResultset.getInt("dependencia"); */
			String coddependencia = myResultset.getString("dependencia");
			/* int codfuncionario = myResultset.getInt("nomFuncionario"); */
			String codfuncionario = myResultset.getString("nomFuncionario");
			/* int codarlvisitante = myResultset.getInt("arl"); */
			String codarlvisitante = myResultset.getString("arl");
			/* int codrhvisitante = myResultset.getInt("rh"); */
			String codrhvisitante = myResultset.getString("rh");
			/* int codobservavis = myResultset.getInt("observaciones"); */
			String codobservavis = myResultset.getString("observaciones");
			/* int codaparatos = myResultset.getInt("equipos"); */
			String codaparatos = myResultset.getString("equipos");
			Date fechvisitante = myResultset.getDate("fechaLlegada");
			String notas = myResultset.getString("notas");
			Date fechsalidavisitante = myResultset.getDate("fechaSalida");
			
			VisitanteInit tempVisitante = new VisitanteInit(idvisit,nomvisitante,apelvisitante,codtipo,numidentidad,movilvisitante,emailvisitante,coddependencia,codfuncionario,codarlvisitante,codrhvisitante,codobservavis,codaparatos,fechvisitante,notas,fechsalidavisitante);
			
			
			visitantes.add(tempVisitante);
			
		}	
		
		return visitantes;
	}

	public void agregarVisitanteNuevo(Visitante nuevoVisitante) throws Exception {
		
		Connection myConexion = null;
		
		//Obtener la Conexion con la BBDD
		
		try {
			
			myConexion = origenDatos.getConnection();
			
		//Crear la Instruccion SQL que Inserte el nuevo Usuario / Crear la Consulta Preparada
		
		//NOTA CAMBIAR A STORE PROCEDURE
		
		String sql ="{CALL insertVisitante(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		CallableStatement myStatement = myConexion.prepareCall(sql);
		
		//Establecer los parametros para el Usuario Visitante
		
		myStatement.setString(1, nuevoVisitante.getNomvisitante());
		
		myStatement.setString(2, nuevoVisitante.getApelvisitante());
		
		myStatement.setInt(3, nuevoVisitante.getCodtipo());
		
		myStatement.setString(4, nuevoVisitante.getNumidentidad());
		
		myStatement.setString(5, nuevoVisitante.getMovilvisitante());
		
		myStatement.setString(6, nuevoVisitante.getEmailvisitante());
		
		myStatement.setInt(7, nuevoVisitante.getCoddependencia());
		
		myStatement.setInt(8, nuevoVisitante.getCodfuncionario());
		
		myStatement.setInt(9, nuevoVisitante.getCodarl());
		
		myStatement.setInt(10, nuevoVisitante.getCodrh());
		
		myStatement.setInt(11, nuevoVisitante.getCodobservavis());
		
		myStatement.setInt(12, nuevoVisitante.getCodaparatos());
		
		// Convertimos el Date.Util a Date.Sql
		
		java.util.Date utilDate = nuevoVisitante.getFechavisitante();
		
		// Conversion
		
		java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
		
		myStatement.setDate(13, fechaConvertida);
		
		myStatement.setString(14, nuevoVisitante.getNotas());
		
		// Fin de Conversion del campo Fecha Salida
		
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
	
	public Visitante getVisitante(int idVisitante) throws Exception {

		Visitante elVisitante = null;
		
		Connection myConexion = null;
		
		PreparedStatement myStatement = null;
		
		ResultSet myResultset = null;
		
		//int idVisitante = idvisitante;
		
		int idvisitante = idVisitante;
		
		try {
		
		//Establecer la Conexion con la BBDD
		
		myConexion = origenDatos.getConnection();
		
		//Crear el SQL que busque el Usuario con el codigo Usuario enviado
		
		String sql = "SELECT * FROM VISITANTE WHERE IDVISITANTE=?";
		
		//Crear la Consulta Preparada
		
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los parametros de la consulta
		
		myStatement.setInt(1, idvisitante);
		
		//Ejecutar la Consulta
		
		myResultset = myStatement.executeQuery();
		
		//Obtener los datos de Respuesta
		
		if(myResultset.next()) {
			
			int idvisit = myResultset.getInt("idvisitante");
			String nomvisitante = myResultset.getString("nomvisitante");
			String apelvisitante = myResultset.getString("apelvisitante");
			int codtipo = myResultset.getInt("codtipo");
			String numidentidad = myResultset.getString("numidentidad");
			String movilvisitante = myResultset.getString("movilvisitante");
			String emailvisitante = myResultset.getString("emailvisitante");
			int coddependencia = myResultset.getInt("coddependencia");
			int codfuncionario = myResultset.getInt("codfuncionario");
			int codarlvisitante = myResultset.getInt("codarl");
			int codrhvisitante = myResultset.getInt("codrh");
			int codobservavis = myResultset.getInt("codobservavis");
			int codaparatos = myResultset.getInt("codaparatos");
			Date fechvisitante = myResultset.getDate("fechavisitante");
			String notas = myResultset.getString("notas");
			Date fechsalidavisitante = myResultset.getDate("fechasalida");
			
			//Creamos una variable temporal de tipo Visitante
			
			elVisitante = new Visitante(idvisit,nomvisitante,apelvisitante,codtipo,numidentidad,movilvisitante,emailvisitante,coddependencia,codfuncionario,codarlvisitante,codrhvisitante,codobservavis,codaparatos,fechvisitante,notas,fechsalidavisitante);
		
		} else {
			
			//En dado caso que no exista el Codigo Usuario Visitante lanza una exception
			throw new Exception("No hemos encontrado el Usuario Visitante con el codigo " + idVisitante);
			
		}
		
		
		}catch (Exception e) {
			// TODO: handle exception
		
			e.printStackTrace();
			
		}finally {
			
			myConexion.close();
		}
		
		return elVisitante;
	}

	public void actualizarVisitanteNuevo(Visitante visitanteActualizado) throws Exception  {
		
		Connection myConexion = null;

		PreparedStatement myStatement = null;
		
		//Establecer la Conexion con la BBDD

		
		try {
			
		myConexion = origenDatos.getConnection();
			
		//Crear la Sentencia SQL
			
		String sql = "Update Visitante Set nomvisitante=?,apelvisitante=?,codtipo=?,numidentidad=?,movilvisitante=?,emailvisitante=?,coddependencia=?,codfuncionario=?,codarl=?,codrh=?,codobservavis=?,codaparatos=?,fechavisitante=?,notas=?,fechasalida=? WHERE IDVISITANTE=?";
			
		//Crear la Consulta Preparada
			
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los parametros para el Usuario Visitante
		
		myStatement.setString(1, visitanteActualizado.getNomvisitante());
		
		myStatement.setString(2, visitanteActualizado.getApelvisitante());
		
		myStatement.setInt(3, visitanteActualizado.getCodtipo());
		
		myStatement.setString(4, visitanteActualizado.getNumidentidad());
		
		myStatement.setString(5, visitanteActualizado.getMovilvisitante());
		
		myStatement.setString(6, visitanteActualizado.getEmailvisitante());
		
		myStatement.setInt(7, visitanteActualizado.getCoddependencia());
		
		myStatement.setInt(8, visitanteActualizado.getCodfuncionario());
		
		myStatement.setInt(9, visitanteActualizado.getCodarl());
		
		myStatement.setInt(10, visitanteActualizado.getCodrh());
		
		myStatement.setInt(11, visitanteActualizado.getCodobservavis());
		
		myStatement.setInt(12, visitanteActualizado.getCodaparatos());
		
		// Convertimos el Date.Util a Date.Sql
		
		java.util.Date utilDate = visitanteActualizado.getFechavisitante();
		
		// Conversion
		
		java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
		
		myStatement.setDate(13, fechaConvertida);
		
		myStatement.setString(14, visitanteActualizado.getNotas());
		
		// FechaSalidaVisitante = Date.Util a Date.Sql
		
		java.util.Date utilDate1 = visitanteActualizado.getFechasalida();
				
		// Conversion
				
		java.sql.Date fechaSalidaConvertida = new java.sql.Date(utilDate1.getTime());
				
		myStatement.setDate(15, fechaSalidaConvertida);
		
		// Fin de Conversion del campo Fecha Salida
				
		myStatement.setInt(16, visitanteActualizado.getIdvisitante());
		
		
		//Ejecutar la Instruccion SQL
		
		myStatement.execute();
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			myStatement.close();
			myConexion.close();
		}
		
	}

	public void eliminarVisitante(int idVisit) throws Exception {
		
		Connection myConexion = null;

		PreparedStatement myStatement = null;
		
		//Establecer la Conexion con la BBDD

		try {
			
		myConexion = origenDatos.getConnection();
		
		
		//Crear la Instruccion SQL de Eliminacion
		
		String sql = "Delete from Visitante Where IDVISITANTE=?"; 
		
		//Preparar la Consulta
		
		myStatement = myConexion.prepareStatement(sql);
		
		//Establecer los parametros de Consulta
		
		myStatement.setInt(1, idVisit);
		
		//Ejecutar la Sentencia SQL
		
		myStatement.execute();
		
		}finally {
			  
			myStatement.close();
			myConexion.close();
			  
		}
		
	}
	
	

}
