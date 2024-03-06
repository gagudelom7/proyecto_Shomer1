package com.shomer.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.shomer.dao.ModeloFuncionario;
import com.shomer.dto.Funcionario;
import com.shomer.oblist.Dependencia;
import com.shomer.oblist.FuncionarioInit;


/**
 * Servlet implementation class ControladorFuncionario
 */
@WebServlet("/ControladorFuncionario")
public class ControladorFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Creamos una variable encapsulada de tipo ModeloUsuario
		//Esta Variable permite que se puedan usar todos los metodos de la CLase ModeloUsuario
		
		private ModeloFuncionario modeloFuncionario;
		
		//Creamos el Pool de Conexiones a la BBDD
		
		@Resource(name="jdbc/shomer1")
		private DataSource myPool;

		//Creamos el Metodo INIT() del servlet el cual se va a ejecutar siempre en primer lugar
		//Source - Override Implement Methods - GenericServlets - Method Init()
		
		@Override
		public void init() throws ServletException {
			
			super.init();
			
			try {
				
				//Instanciamos la variable con el Pool de Conexiones del Modelo
				
				modeloFuncionario = new ModeloFuncionario(myPool);
				
			}catch(Exception e) {
				
				throw new ServletException(e);
				
			}
		}
		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Leer el parametro que llega del FormularioUsuario.jsp
		
				String  elComando = request.getParameter("instruccion");
				
				//Si no se envia el parametro, lista los Funcionarios
				
				if(elComando==null) elComando="listarFuncionario";
				
				//Redirige el flujo de ejecucion al metodo adecuado
				
				switch(elComando) {
				
				case "listarFuncionario":
				
					//Creamos el Metodo ObtenerUsuario() el cual listara la informacion que esta en la tabla Funcionario
					
					obtenerFuncionario(request, response);
					
					break;
					
				case "ingresarFuncionarioBBDD":
					
					agregarFuncionario(request, response);
					
					break;
					
				case "cargarFuncionarioBBDD":
					
					try {
						
						cargarFuncionario(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				case "actualizarFuncionarioBBDD":
					
					try {
						
						actualizaFuncionario(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				case "eliminarFuncionarioBBDD":
					
					try {
						
						eliminarFuncionario(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				/*
				 * case "buscar":
				 * 
				 * buscarFuncionario(request, response);
				 * 
				 * break;
				 */
				
				case "cargarListasF":
					
					try {
						listasFuncionario(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
									
				break;
				
				default: 
					
					//En dado caso que no se cumplan los metodos de los case se ejecutara el listado de Funcionarios
					obtenerFuncionario(request, response);
				
				}
		
	}


	private void listasFuncionario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Dependencia dependencia = new Dependencia(myPool);
		
		Map<String, String> dependencias = dependencia.drop_Dependencia();
		
		request.setAttribute("dependencias", dependencias);
		
		request.getRequestDispatcher("FormularioFuncionario.jsp").forward(request, response);
	}


	/*
	 * private void buscarFuncionario(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * String tempFuncionario = request.getParameter("txtbuscar");
	 * 
	 * 
	 * List<Funcionario> funcionarios =
	 * modeloFuncionario.buscarFuncionarios(tempFuncionario);
	 * 
	 * request.setAttribute("LISTAFUNCIONARIOS", funcionarios);
	 * 
	 * RequestDispatcher myDispatcher =
	 * request.getRequestDispatcher("VistaFuncionario.jsp");
	 * 
	 * myDispatcher.forward(request, response);
	 * 
	 * }
	 */


	private void eliminarFuncionario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//Capturar el Campo Clave del tipo de Mensajeria - Tener presente de donde viene el parametro de llamada
		
				int IdFuncionario = Integer.parseInt(request.getParameter("id_Funcio"));
				
				//Borrar Mensajeria de la BBDD
						
						modeloFuncionario.eliminarFuncionario(IdFuncionario);
						
						//Volver al Listado de Mensajeria
						
						obtenerFuncionario(request, response);
		
	}


	private void actualizaFuncionario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//Leer la informacion que viene del Formulario
		
		int IdFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
		
		String NameFuncionario = request.getParameter("nameFuncionario");
		
		String ApelFuncionario = request.getParameter("apelFuncionario");
		
		String TelOficina = request.getParameter("telOficina");
		
		String EmailFuncionario = request.getParameter("emailFuncionario");
		
		int CodDependencia = Integer.parseInt(request.getParameter("codDependencia"));
				
		//Crear un objeto de tipo Usuario con la Info del Formulario
		
		Funcionario FuncionarioActualizado = new Funcionario(IdFuncionario,NameFuncionario,ApelFuncionario,TelOficina,EmailFuncionario,CodDependencia);
				
				//Actualizar la BBDD con la Info del objeto Usuario
				
		modeloFuncionario.actualizarFuncionario(FuncionarioActualizado);
				
				//Volver al Listado con la info Actualizada
				
				
		obtenerFuncionario(request, response);
		
	}


	private void cargarFuncionario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//Leer el codigo de Usuario que viene del Listado
		
				int idFuncionario=Integer.parseInt(request.getParameter("id_Funcio"));
				
				//Comunicar con el modelo para que este haga una consulta a la BBDD cuyo criterio sea el codigo Usuario que le se esta ENVIANDO
				
				Funcionario elFuncionario = modeloFuncionario.getFuncionario(idFuncionario);
				
				// Colocar atributo correspondiente al cogigo Usuario
				
				request.setAttribute("FuncionarioActualizar", elFuncionario);
				
				 // Enviar toda la informacion al Formulario de Actualizar Usuario
				
				RequestDispatcher myDispatcher = request.getRequestDispatcher("FormularioActualizarFuncionario.jsp");
				
				Dependencia dependencia = new Dependencia(myPool);
				Map<String, String> dependencias = dependencia.drop_Dependencia();
				request.setAttribute("dependencias", dependencias);
				
				myDispatcher.forward(request, response);
	}


	private void agregarFuncionario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//Leer la informacion que viene del Formulario
		
				String NameFuncionario = request.getParameter("nameFuncionario");
				
				String ApelFuncionario = request.getParameter("apelFuncionario");
				
				String TelOficina = request.getParameter("telOficina");
				
				String EmailFuncionario = request.getParameter("emailFuncionario");
				
				int CodDependencia = Integer.parseInt(request.getParameter("codDependencia"));
				
				//Con la Informacion crear un objeto de tipo Usuario
				
				Funcionario NuevoFuncionario = new Funcionario(NameFuncionario,ApelFuncionario,TelOficina,EmailFuncionario,CodDependencia);
				
				//Enviar el objeto al Modelo de Usuario e Insertarlo en la BBDD a traves del parametro encapsulado ModeloUsuario
				
				try {
					
					modeloFuncionario.agregarFuncionarioNuevo(NuevoFuncionario);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Volver a listado de Productos para validar la inserccion del Objeto
				//Llamamos al Metodo ObtenerProductos
				
				obtenerFuncionario(request, response);
	}


	private void obtenerFuncionario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		//Obtener la lista de productos desde el Modelo
		
		List<FuncionarioInit> funcionarios;
		
		try {
			
			//Almacenamos en la variable usuarios de tipo Lista<Usuario> lo que nos devuelve el modelo 
			
			funcionarios = modeloFuncionario.getFuncionarios();
		
		//Agregamos la lista de Productos al Request
		
			request.setAttribute("LISTAFUNCIONARIOS", funcionarios);
		
		//Enviamos el Request a la Pagina JSP para visualizar la lista de Usuarios
		
			RequestDispatcher myDispatcher = request.getRequestDispatcher("VistaFuncionario.jsp");
			
			//Enviamos la Informacion al Objeto myDispatcher
			
			myDispatcher.forward(request, response);
		
			//Cierra del Try
		}catch(Exception e) {
			
			//En dado que falle el proceso que imprima la pila de llamadas
			e.printStackTrace();
			
		}
	}

	

}
