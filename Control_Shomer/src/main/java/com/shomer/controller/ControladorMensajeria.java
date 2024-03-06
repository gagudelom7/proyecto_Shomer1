package com.shomer.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.shomer.dao.ModeloMensajeria;
import com.shomer.dto.Mensajeria;
import com.shomer.oblist.EmpMensajeria;
import com.shomer.oblist.Empleado;
import com.shomer.oblist.EstadoMensajeria;
import com.shomer.oblist.MensajeriaInit;
import com.shomer.oblist.Observamen;
import com.shomer.oblist.TipoMensajeria;


/**
 * Servlet implementation class ControladorMensajeria
 */
@WebServlet("/ControladorMensajeria")
public class ControladorMensajeria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Creamos una variable encapsulada de tipo ModeloUsuario
		//Esta Variable permite que se puedan usar todos los metodos de la CLase ModeloUsuario
		
		private ModeloMensajeria modeloMensajeria;
		
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
				
				modeloMensajeria = new ModeloMensajeria(myPool);
				
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
				
				//Si no se envia el parametro, lista los Usuarios
				
				if(elComando==null) elComando="listarMensajeria";
				
				//Redirige el flujo de ejecucion al metodo adecuado
				
				switch(elComando) {
				
				case "listarMensajeria":
				
					//Creamos el Metodo ObtenerUsuario() el cual listara la informacion que esta en la tabla Usuario
					
					obtenerMensajeria(request, response);
					
					break;
					
				case "ingresarMensajeriaBBDD":
					
					agregarMensajeria(request, response);
					
					break;
					
				case "cargarMensajeriaBBDD":
					
					try {
						
						cargarMensajeria(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				case "actualizarMensajeriaBBDD":
					
					try {
						
						actualizaMensajeria(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				case "eliminarMensajeriaBBDD":
					
					try {
						
						eliminarMensajeria(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				/*
				 * case "buscar":
				 * 
				 * buscarMensajeria(request, response);
				 * 
				 * break;
				 */
				
				case "cargarListasM":
					
					try {
						listasMensajeria(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
									
				break;
					
				default: 
					
					//En dado caso que no se cumplan los metodos de los case se ejecutara el listado de Usuarios
					obtenerMensajeria(request, response);
				
				}
				
			}
	
	private void listasMensajeria(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TipoMensajeria tMensajeria = new TipoMensajeria(myPool);
		Empleado funcionario = new Empleado(myPool);
		EmpMensajeria empMensajeria = new EmpMensajeria(myPool);
		EstadoMensajeria estadoMensajeria = new EstadoMensajeria(myPool);
		Observamen observamen = new Observamen(myPool);
		
		Map<String, String> tMensajerias = tMensajeria.drop_TipoMensajeria();
		Map<String, String> funcionarios = funcionario.drop_Funcionario();
		Map<String, String> empMensajerias = empMensajeria.drop_EmpMensajeria();
		Map<String, String> estadoMensajerias = estadoMensajeria.drop_EstadoMensajeria();
		Map<String, String> observamens = observamen.drop_ObservaMensajeria();
		
		request.setAttribute("tMensajerias", tMensajerias);
		request.setAttribute("funcionarios", funcionarios);
		request.setAttribute("empMensajerias", empMensajerias);
		request.setAttribute("estadoMensajerias", estadoMensajerias);
		request.setAttribute("observamens", observamens);
		
		request.getRequestDispatcher("FormularioMensajeria.jsp").forward(request, response);
		
	}

	/*
	 * private void buscarMensajeria(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * String tempMensajeria = request.getParameter("txtbuscar");
	 * 
	 * 
	 * List<Mensajeria> mensajerias =
	 * modeloMensajeria.buscarMensajerias(tempMensajeria);
	 * 
	 * request.setAttribute("LISTAMENSAJERIAS", mensajerias);
	 * 
	 * RequestDispatcher myDispatcher =
	 * request.getRequestDispatcher("VistaMensajeria.jsp");
	 * 
	 * myDispatcher.forward(request, response);
	 * 
	 * }
	 */


	private void eliminarMensajeria(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//Capturar el Campo Clave del tipo de Mensajeria - Tener presente de donde viene el parametro de llamada
		
		int idMensajeria = Integer.parseInt(request.getParameter("id_Mensa"));
		
		//Borrar Mensajeria de la BBDD
				
				modeloMensajeria.eliminarMensajeria(idMensajeria);
				
				//Volver al Listado de Mensajeria
				
				obtenerMensajeria(request, response);
	}


	private void actualizaMensajeria(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//Leer la informacion que viene del Formulario
		
		int idMensajeria = Integer.parseInt(request.getParameter("idMensajeria"));
		
		int CodMensa = Integer.parseInt(request.getParameter("codMensajeria"));
		
		BigDecimal CantMensa =new BigDecimal(request.getParameter("cantMensajeria"));
		
		//Formato Fecha
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		
		Date FechaMensa = null;
		
		try {
		
			FechaMensa = formatoFecha.parse(request.getParameter("fechaMensa"));
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		
		}
		
		
		int FuncionarMensa = Integer.parseInt(request.getParameter("funcionMensa"));
		
		String RemitenMensa = request.getParameter("remiteMensa");
		
		int EmpMensa = Integer.parseInt(request.getParameter("empMensa"));
		
		int EstadMensa = Integer.parseInt(request.getParameter("estadoMensa"));
		
		int ObservaMensa = Integer.parseInt(request.getParameter("observaMensa"));
		
		//Formato Fecha
		
		SimpleDateFormat formatoFecha1 = new SimpleDateFormat("yyyy-MM-dd");
				
		Date FechaEntrega = null;
				
				try {
				
					FechaEntrega = formatoFecha1.parse(request.getParameter("fechaEntregaMensa"));
				
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				
				}
				
		String NotasMensa = request.getParameter("notasMensa");
		
		//Con la Informacion crear un objeto de tipo Usuario
		
		Mensajeria MensajeriaActualizada = new Mensajeria(idMensajeria,CodMensa,CantMensa,FechaMensa,FuncionarMensa,RemitenMensa,EmpMensa,EstadMensa,ObservaMensa,FechaEntrega,NotasMensa);
		
		//Enviar el objeto al Modelo de Usuario e Insertarlo en la BBDD a traves del parametro encapsulado ModeloUsuario
		
			modeloMensajeria.actualizarMensajeria(MensajeriaActualizada);
			
		
		//Volver a listado de Productos para validar la inserccion del Objeto
		//Llamamos al Metodo ObtenerProductos
		
		obtenerMensajeria(request, response);
		
	}


	private void cargarMensajeria(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//Leer el codigo de Mensajeria que viene del Listado
		
		int idMensajeria=Integer.parseInt(request.getParameter("id_Mensa"));
		
		//Comunicar con el modelo para que este haga una consulta a la BBDD cuyo criterio sea el codigo Usuario que le se esta ENVIANDO
		
		Mensajeria laMensajeria = modeloMensajeria.getMensajeria(idMensajeria);
		
		// Colocar atributo correspondiente al cogigo Usuario
		
		request.setAttribute("MensajeriaActualizar", laMensajeria);
		
		 // Enviar toda la informacion al Formulario de Actualizar Usuario
		
		RequestDispatcher myDispatcher = request.getRequestDispatcher("FormularioActualizarMensajeria.jsp");
		
		TipoMensajeria tMensajeria = new TipoMensajeria(myPool);
		Map<String, String> tMensajerias = tMensajeria.drop_TipoMensajeria();
		request.setAttribute("tMensajerias", tMensajerias);
		
		Empleado funcionario = new Empleado(myPool);
		Map<String, String> funcionarios = funcionario.drop_Funcionario();
		request.setAttribute("funcionarios", funcionarios);
		
		EmpMensajeria empMensajeria = new EmpMensajeria(myPool);
		Map<String, String> empMensajerias = empMensajeria.drop_EmpMensajeria();
		request.setAttribute("empMensajerias", empMensajerias);
		
		EstadoMensajeria estadoMensajeria = new EstadoMensajeria(myPool);
		Map<String, String> estadoMensajerias = estadoMensajeria.drop_EstadoMensajeria();
		request.setAttribute("estadoMensajerias", estadoMensajerias);
		
		Observamen observamen = new Observamen(myPool);
		Map<String, String> observamens = observamen.drop_ObservaMensajeria();
		request.setAttribute("observamens", observamens);
		
		myDispatcher.forward(request, response);
	}


	private void agregarMensajeria(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
			//Leer la informacion que viene del Formulario
		
				int CodMensa = Integer.parseInt(request.getParameter("codMensajeria"));
				
				BigDecimal CantMensa =new BigDecimal(request.getParameter("cantMensajeria"));
				
				//Formato Fecha
				
				SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
				
				Date FechaMensa = null;
				
				try {
				
					FechaMensa = formatoFecha.parse(request.getParameter("fechaMensa"));
				
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				
				}
				
				
				int FuncionarMensa = Integer.parseInt(request.getParameter("funcionMensa"));
				
				String RemitenMensa = request.getParameter("remiteMensa");
				
				int EmpMensa = Integer.parseInt(request.getParameter("empMensa"));
				
				int EstadMensa = Integer.parseInt(request.getParameter("estadoMensa"));
				
				int ObservaMensa = Integer.parseInt(request.getParameter("observaMensa"));
				
				String NotasMensa = request.getParameter("notasMensa");
				
				//Con la Informacion crear un objeto de tipo Usuario
				
				Mensajeria NuevaMensajeria = new Mensajeria(CodMensa,CantMensa,FechaMensa,FuncionarMensa,RemitenMensa,EmpMensa,EstadMensa,ObservaMensa,NotasMensa);
				
				//Enviar el objeto al Modelo de Usuario e Insertarlo en la BBDD a traves del parametro encapsulado ModeloUsuario
				
				try {
					
					modeloMensajeria.agregarMensajeriaNueva(NuevaMensajeria);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Volver a listado de Productos para validar la inserccion del Objeto
				//Llamamos al Metodo ObtenerProductos
				
				obtenerMensajeria(request, response);
	}


	private void obtenerMensajeria(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		//Obtener la lista de productos desde el Modelo
		
		List<MensajeriaInit> mensajerias;
		
		try {
			
			//Almacenamos en la variable usuarios de tipo Lista<Usuario> lo que nos devuelve el modelo 
			
			mensajerias = modeloMensajeria.getMensajerias();
		
		//Agregamos la lista de Productos al Request
		
			request.setAttribute("LISTAMENSAJERIAS", mensajerias);
		
		//Enviamos el Request a la Pagina JSP para visualizar la lista de Usuarios
		
			RequestDispatcher myDispatcher = request.getRequestDispatcher("VistaMensajeria.jsp");
			
			//Enviamos la Informacion al Objeto myDispatcher
			
			myDispatcher.forward(request, response);
		
			//Cierra del Try
		}catch(Exception e) {
			
			//En dado que falle el proceso que imprima la pila de llamadas
			e.printStackTrace();
			
		}
	}

}
