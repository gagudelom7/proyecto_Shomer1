package com.shomer.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.shomer.dao.ModeloUsuario;
import com.shomer.dto.Usuario;

/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorLogin")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Creamos una variable encapsulada de tipo ModeloUsuario
		//Esta Variable permite que se puedan usar todos los metodos de la CLase ModeloUsuario
		
		private ModeloUsuario modeloUsuario;
		
		//Creamos el Pool de Conexiones a la BBDD
		
		@Resource(name="jdbc/shomer1")
		private DataSource myPool;

		
		//Creamos el Metodo INIT() del servlet el cual se va a ejecutar siempre en primer lugar
		//Source - Override Implement Methods - GenericServlets - Method Init()
		
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			
			try {
			
				//Instanciamos la variable con el Pool de Conexiones del Modelo
				
				modeloUsuario = new ModeloUsuario(myPool);
				
			}catch(Exception e) {
				
				throw new ServletException(e);
				
			}
			
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String usu = request.getParameter("username");
			String contr = request.getParameter("passwEncrypt"); 
			
			Usuario loginBean = new Usuario(); 
			
			loginBean.setUsu(usu);
			loginBean.setContr(contr);
			
			try {
				
			String userValidate = modeloUsuario.authenticateUser(loginBean); 
			
			if(userValidate.equals("Admin_Role")) 
			{
				
				/* Variable de Session */
				
				String name;

				name=request.getParameter("username");
				
				HttpSession session=request.getSession();
				session.setAttribute("Admmin", name);
				request.setAttribute("usu", usu); 
				
				request.getRequestDispatcher("/FormularioAdmin.jsp").forward(request, response);
				
				
			}
			else if(userValidate.equals("Oper_Role"))
			{
				
				String name;

				name=request.getParameter("username");
				
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(900);
				session.setAttribute("Opper", name);
				request.setAttribute("usu", usu); 
				
				request.getRequestDispatcher("/FormularioOper.jsp").forward(request, response);
				
			}else {
				
			System.out.println("Error message = " + userValidate);
			request.setAttribute("errMessage", userValidate); 
			
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			
			}
			}catch(IOException e) {
				
				e.printStackTrace();
			
			}catch(Exception a) {
				
				a.printStackTrace();
			}
			
			
		}

}
