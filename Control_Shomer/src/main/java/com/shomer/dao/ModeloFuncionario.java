package com.shomer.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.shomer.dto.Funcionario;
import com.shomer.oblist.FuncionarioInit;


public class ModeloFuncionario {

	//Se importa paquete Javax sql
		private DataSource origenDatos;
		
		/* Creamos un constructor para la Clase ModeloUsuario 
		 * el cual recibira por parametro el POOL de Conexiones
		 */
		
		public ModeloFuncionario(DataSource origenDatos) {
			
			//Definimos el origenDatos para cuando sea invocado
			
				this.origenDatos=origenDatos;
		}
		
		/*
		 * Se crea un metodo que pueda obtener el listado generado cuando el usuario a
		 * realizado consultas en la BBDD, el cual, devolvera la informacion por medio de
		 * una lista
		 */
		
		//Se importa paquete Java Util - Se lanza una exception para un try catch
		
		public List<FuncionarioInit> getFuncionarios() throws Exception{
			
			//Creamos una Lista que almacene los Usuarios que se le enseñan al Operador
			
			List<FuncionarioInit> funcionarios = new ArrayList<>();
			
	/* Establecemos la conexion por medio de un Statement y un Resultset */
			
			Connection myConexion=null;
			
			ResultSet myResultset=null;
			
			// -----  Establecemos la Conexion con el POOL de datos ----
			
			myConexion=origenDatos.getConnection();
			
			// ----- Se crea la sentencia SQL y Statement para obtener los registros de la BBDD ---
			
			CallableStatement myStatement=myConexion.prepareCall("{CALL funcionarioShomer()}");
			
			// ----- Ejecutar la sentencia SQL --------
			
			myResultset=myStatement.executeQuery();
			
			// ----- Recorrer el Resultset Obtenido con la consulta anterior --- 
		
			while(myResultset.next()) {
				
				int idFuncio  = myResultset.getInt("id");
				String nomFuncio  = myResultset.getString("nombre");
				String apelFuncio  = myResultset.getString("apellido");
				String telFuncio  = myResultset.getString("corporativo");
				String emailFuncio  = myResultset.getString("email");
				/* int codDepend = myResultset.getInt("coddependencia"); */
				String codDepend  = myResultset.getString("dependencia");
				
				//Agregamos los datos a un listado
				
				//Creamos una variable temporal de tipo Funcionario
				
				FuncionarioInit tempFuncionario = new FuncionarioInit(idFuncio,nomFuncio,apelFuncio,telFuncio,emailFuncio,codDepend);
			
				//Agregamos el Objeto temporal a nuestro Lista
				
				funcionarios.add(tempFuncionario);
				
			}
			
			return funcionarios;
		}

		public void agregarFuncionarioNuevo(Funcionario nuevoFuncionario) throws Exception{
			// TODO Auto-generated method stub
			
			//Para crear la Conexion creamos un objeto de tipo Connection
			
					Connection myConexion = null;
					
					//Obtener la Conexion con la BBDD
					
					try {
						
						myConexion = origenDatos.getConnection();
						
					//Crear la Instruccion SQL que Inserte el nuevo Usuario / Crear la Consulta Preparada
					
					String sql ="{CALL insertFuncionario(?,?,?,?,?)}";
						
					CallableStatement myStatement = myConexion.prepareCall(sql);
					
					//Establecer los parametros para el Usuario
					
					myStatement.setString(1, nuevoFuncionario.getNomfuncionario());
					
					myStatement.setString(2, nuevoFuncionario.getApelfuncionario());
					
					myStatement.setString(3, nuevoFuncionario.getTeloficina());
					
					myStatement.setString(4, nuevoFuncionario.getEmailfuncionario());
									
					myStatement.setInt(5, nuevoFuncionario.getCoddependencia());
					
					//Ejecutar la Instruccion SQL
					
					myStatement.execute();
					
					} catch (Exception e) {
						// TODO: handle exception
						
						e.printStackTrace();
						
					}finally {
						
						myConexion.close();
					}
		}

		public Funcionario getFuncionario(int idFuncionario) throws Exception {
			// TODO Auto-generated method stub
			
			Funcionario elFuncionario = null;
			
			Connection myConexion = null;
			
			PreparedStatement myStatement = null;
			
			ResultSet myResultset = null;
			
			int IdFuncionario = idFuncionario;
			
			try {
			
			//Establecer la Conexion con la BBDD
			
			myConexion = origenDatos.getConnection();
			
			//Crear el SQL que busque el Usuario con el codigo Usuario enviado
			
			String sql = "SELECT * FROM Funcionario WHERE IDFUNCIONARIO=?";
			
			//Crear la Consulta Preparada
			
			myStatement = myConexion.prepareStatement(sql);
			
			//Establecer los parametros de la consulta
			
			myStatement.setInt(1, IdFuncionario);
			
			//Ejecutar la Consulta
			
			myResultset = myStatement.executeQuery();
			
			//Obtener los datos de Respuesta
			
			if(myResultset.next()) {
				
				int idFuncio  = myResultset.getInt("idfuncionario");
				String nomFuncio  = myResultset.getString("nomfuncionario");
				String apelFuncio  = myResultset.getString("apelfuncionario");
				String telFuncio  = myResultset.getString("teloficina");
				String emailFuncio  = myResultset.getString("emailfuncionario");
				int codDepend  = myResultset.getInt("coddependencia");
				
				//Agregamos los datos a un listado
				
				//Creamos una variable temporal de tipo Funcionario
				
				elFuncionario = new Funcionario(idFuncio,nomFuncio,apelFuncio,telFuncio,emailFuncio,codDepend);
			
			} else {
				
				//En dado caso que no exista el Codigo Usuario lanza una exception
				throw new Exception("No hemos encontrado el Funcionario con el codigo " + IdFuncionario);
				
			}
			
			
			}catch (Exception e) {
				// TODO: handle exception
			
				e.printStackTrace();
				
			}finally {
				
				myConexion.close();
			}
			
			return elFuncionario;
		}

		public void actualizarFuncionario(Funcionario funcionarioActualizado) throws Exception {
			// TODO Auto-generated method stub
			
			Connection myConexion = null;

			PreparedStatement myStatement = null;
			
			//Establecer la Conexion con la BBDD

			
			try {
				
			myConexion = origenDatos.getConnection();
				
			//Crear la Sentencia SQL
				
			String sqlFuncionario = "UPDATE FUNCIONARIO SET nomfuncionario=?,apelfuncionario=?,teloficina=?,emailfuncionario=?,coddependencia=? WHERE IDFUNCIONARIO=?";
			
			//Crear la Consulta Preparada
				
			myStatement = myConexion.prepareStatement(sqlFuncionario);
			
			//Establecer los Parametros o  Actualizar los registros
			
			myStatement.setString(1, funcionarioActualizado.getNomfuncionario());
			
			myStatement.setString(2, funcionarioActualizado.getApelfuncionario());
			
			myStatement.setString(3, funcionarioActualizado.getTeloficina());
			
			myStatement.setString(4, funcionarioActualizado.getEmailfuncionario());
							
			myStatement.setInt(5, funcionarioActualizado.getCoddependencia());
			
			myStatement.setInt(6, funcionarioActualizado.getIdfuncionario());
			
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

		public void eliminarFuncionario(int idFuncionario) throws Exception {
			// TODO Auto-generated method stub
			
			
			Connection myConexion = null;

			PreparedStatement myStatement = null;
			
			//Establecer la Conexion con la BBDD

			try {
				
			myConexion = origenDatos.getConnection();
			
			
			//Crear la Instruccion SQL de Eliminacion
			
			String sql = "Delete from FUNCIONARIO Where IDFUNCIONARIO=?"; 
			
			//Preparar la Consulta
			
			myStatement = myConexion.prepareStatement(sql);
			
			//Establecer los parametros de Consulta
			
			myStatement.setInt(1, idFuncionario);
			
			//Ejecutar la Sentencia SQL
			
			myStatement.execute();
			
			}finally {
				  
				myStatement.close();
				myConexion.close();
				  
			}
		}

		/*
		 * public List<Funcionario> buscarFuncionarios(String tempFuncionario) {
		 * 
		 * List<Funcionario> funcionarios = new ArrayList<>();
		 * 
		 * String instruccionSql;
		 * 
		 * instruccionSql="SELECT * FROM FUNCIONARIO WHERE IDFUNCIONARIO LIKE '%"
		 * +tempFuncionario+"%' OR NOMFUNCIONARIO LIKE '%" +tempFuncionario+"%'";
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
		 * Funcionario funci = new Funcionario();
		 * 
		 * funci.setIdfuncionario(myResultset.getInt("idfuncionario"));
		 * funci.setNomfuncionario(myResultset.getString("nomfuncionario"));
		 * funci.setApelfuncionario(myResultset.getString("apelfuncionario"));
		 * funci.setTeloficina(myResultset.getString("teloficina"));
		 * funci.setEmailfuncionario(myResultset.getString("emailfuncionario"));
		 * funci.setCoddependencia(myResultset.getInt("coddependencia"));
		 * 
		 * funcionarios.add(funci); } } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * return funcionarios; }
		 */
}
