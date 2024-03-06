package com.shomer.controller;

import java.io.IOException;
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

import com.shomer.dao.ModeloUsuario;
import com.shomer.dto.Usuario;
import com.shomer.oblist.Arl;
import com.shomer.oblist.Perfil;
import com.shomer.oblist.Rh;
import com.shomer.oblist.UsuarioInit;

/**
 * Servlet implementation class ControladorUsuario
 */
@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Creamos una variable encapsulada de tipo ModeloUsuario
	// Esta Variable permite que se puedan usar todos los metodos de la CLase
	// ModeloUsuario

	private ModeloUsuario modeloUsuario;

	// Creamos el Pool de Conexiones a la BBDD

	@Resource(name = "jdbc/shomer1")
	private DataSource myPool;

	// Creamos el Metodo INIT() del servlet el cual se va a ejecutar siempre en
	// primer lugar
	// Source - Override Implement Methods - GenericServlets - Method Init()

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		try {

			// Instanciamos la variable con el Pool de Conexiones del Modelo

			modeloUsuario = new ModeloUsuario(myPool);

		} catch (Exception e) {

			throw new ServletException(e);

		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// Leer el parametro que llega del FormularioUsuario.jsp

		String elComando = request.getParameter("instruccion");

		// Si no se envia el parametro, lista los Usuarios

		if (elComando == null)
			elComando = "listarUsuario";

		// Redirige el flujo de ejecucion al metodo adecuado

		switch (elComando) {

		case "listarUsuario":

			// Creamos el Metodo ObtenerUsuario() el cual listara la informacion que esta en
			// la tabla Usuario

			obtenerUsuario(request, response);

			break;

		case "ingresarUsuarioBBDD":

			agregarUsuario(request, response);

			break;

		case "cargarUsuarioBBDD":

			try {

				cargarUsuario(request, response);

			} catch (Exception e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "actualizarUsuarioBBDD":

			try {

				actualizaUsuario(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		case "eliminarUsuarioBBDD":

			try {

				eliminarUsuario(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
			
		/*
		 * case "buscar":
		 * 
		 * buscarUsuario(request, response);
		 * 
		 * break;
		 */
		
		case "cargarListasU":
			
			try {
				listasUsuario(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							
		break;

		default:

			// En dado caso que no se cumplan los metodos de los case se ejecutara el
			// listado de Usuarios
			obtenerUsuario(request, response);

		}

	}

	private void listasUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Perfil peril = new Perfil(myPool);
		Rh rh = new Rh(myPool);
		Arl arl = new Arl(myPool);
		
		Map<String, String> perfiles = peril.drop_Perfil();
		Map<String, String> rhs = rh.drop_Rh();
		Map<String, String> arls = arl.drop_Arl();
		
		request.setAttribute("perfiles", perfiles);
		request.setAttribute("rhs", rhs);
		request.setAttribute("arls", arls);
		
		request.getRequestDispatcher("FormularioUsuario.jsp").forward(request, response);
		
	}

	/*
	 * private void buscarUsuario(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * String tempUsuario = request.getParameter("txtbuscar");
	 * 
	 * List<Usuario> usuarios = modeloUsuario.buscarUsuarios(tempUsuario);
	 * 
	 * 
	 * request.setAttribute("LISTAUSUARIOS", usuarios);
	 * 
	 * RequestDispatcher myDispatcher =
	 * request.getRequestDispatcher("VistaUsuario.jsp");
	 * 
	 * myDispatcher.forward(request, response);
	 * 
	 * }
	 */

	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// Capturar el Campo Clave del Usuario - Tener presente de donde viene el
		// parametro de llamada

		int IdUsuario = Integer.parseInt(request.getParameter("idUsu"));

		// Borrar Usuario de la BBDD

		modeloUsuario.eliminarUsuario(IdUsuario);

		// Volver al Listado de Usuario

		obtenerUsuario(request, response);
	}

	private void actualizaUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// Leer los datos que llegan del formulario de Actualizar Usuario

		int IdUsuario = Integer.parseInt(request.getParameter("idUsuario"));

		String NameUsuario = request.getParameter("nameUsuario");

		String ApelUsuario = request.getParameter("apelUsuario");

		String UserUsuario = request.getParameter("userUsuario");

		 String PassUsuario = request.getParameter("passwEncryptI"); 
		
		String EmailUsuario = request.getParameter("emailUsuario");

		String MovilUsuario = request.getParameter("movilUsuario");

		// Formato Fecha

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

		Date FechaUsuario = null;

		try {

			FechaUsuario = formatoFecha.parse(request.getParameter("fechaUsuario"));

		} catch (ParseException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		int PerfilUsuario = Integer.parseInt(request.getParameter("perfilUsuario"));

		int RhUsuario = Integer.parseInt(request.getParameter("rhUsuario"));

		int ArlUsuario = Integer.parseInt(request.getParameter("arlUsuario"));

		// Crear un objeto de tipo Usuario con la Info del Formulario

		Usuario UsuarioActualizado = new Usuario(IdUsuario, NameUsuario, ApelUsuario, UserUsuario, PassUsuario,
				EmailUsuario, MovilUsuario, FechaUsuario, PerfilUsuario, RhUsuario, ArlUsuario);

		// Actualizar la BBDD con la Info del objeto Usuario

		modeloUsuario.actualizarUsuario(UsuarioActualizado);

		// Volver al Listado con la info Actualizada

		obtenerUsuario(request, response);
	}

	/*
	 * Se modifica el metodo haciendo que lance una exception en el caso de obtener
	 * la informacion del producto del modelo desde la BBDD y este no exista o que
	 * ocurra un fallo en la conexion que el programa no caiga
	 */
	private void cargarUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		// Leer el codigo de Usuario que viene del Listado

		int idUsuario = Integer.parseInt(request.getParameter("idUsu"));

		// Comunicar con el modelo para que este haga una consulta a la BBDD cuyo
		// criterio sea el codigo Usuario que le se esta ENVIANDO

		Usuario elUsuario = modeloUsuario.getUsuario(idUsuario);

		// Colocar atributo correspondiente al cogigo Usuario

		request.setAttribute("UsuarioActualizar", elUsuario);

		// Enviar toda la informacion al Formulario de Actualizar Usuario

		RequestDispatcher myDispatcher = request.getRequestDispatcher("FormularioActualizarUsuario.jsp");

		Perfil peril = new Perfil(myPool);
		Map<String, String> perfiles = peril.drop_Perfil();
		request.setAttribute("perfiles", perfiles);
		
		Rh rh = new Rh(myPool);
		Map<String, String> rhs = rh.drop_Rh();
		request.setAttribute("rhs", rhs);
		
		Arl arl = new Arl(myPool);
		Map<String, String> arls = arl.drop_Arl();
		request.setAttribute("arls", arls);
		
		myDispatcher.forward(request, response);
	}

	private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// Leer la informacion que viene del Formulario

		String NameUsuario = request.getParameter("nameUsuario");

		String ApelUsuario = request.getParameter("apelUsuario");

		String UserUsuario = request.getParameter("userUsuario");

		String PassUsuario = request.getParameter("passwEncrypt");
		
		String EmailUsuario = request.getParameter("emailUsuario");

		String MovilUsuario = request.getParameter("movilUsuario");

		// Formato Fecha

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

		Date FechaUsuario = null;

		try {

			FechaUsuario = formatoFecha.parse(request.getParameter("fechaUsuario"));

		} catch (ParseException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		int PerfilUsuario = Integer.parseInt(request.getParameter("perfilUsuario"));

		int RhUsuario = Integer.parseInt(request.getParameter("rhUsuario"));

		int ArlUsuario = Integer.parseInt(request.getParameter("arlUsuario"));

		// Con la Informacion crear un objeto de tipo Usuario

		Usuario NuevoUsuario = new Usuario(NameUsuario, ApelUsuario, UserUsuario, PassUsuario, EmailUsuario,
				MovilUsuario, FechaUsuario, PerfilUsuario, RhUsuario, ArlUsuario);

		// Enviar el objeto al Modelo de Usuario e Insertarlo en la BBDD a traves del
		// parametro encapsulado ModeloUsuario

		try {

			modeloUsuario.agregarUsuarioNuevo(NuevoUsuario);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Volver a listado de Productos para validar la inserccion del Objeto
		// Llamamos al Metodo ObtenerProductos

		obtenerUsuario(request, response);

	}

	private void obtenerUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// Obtener la lista de productos desde el Modelo

		List<UsuarioInit> usuarios;

		try {

			// Almacenamos en la variable usuarios de tipo Lista<Usuario> lo que nos
			// devuelve el modelo

			usuarios = modeloUsuario.getUsuarios();

			// Agregamos la lista de Productos al Request

			request.setAttribute("LISTAUSUARIOS", usuarios);

			// Enviamos el Request a la Pagina JSP para visualizar la lista de Usuarios

			RequestDispatcher myDispatcher = request.getRequestDispatcher("VistaUsuario.jsp");

			// Enviamos la Informacion al Objeto myDispatcher

			myDispatcher.forward(request, response);

			// Cierra del Try
		} catch (Exception e) {

			// En dado que falle el proceso que imprima la pila de llamadas
			e.printStackTrace();

		}

	}

}
