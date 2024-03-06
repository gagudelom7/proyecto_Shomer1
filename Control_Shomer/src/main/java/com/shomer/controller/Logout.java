package com.shomer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession(false);
		
		
		  if (session != null && session.getAttribute("name") != null) {
		  
			  session.invalidate();
			  
			  request.setAttribute("errMessage", "Haz Cerrado Seccion Correctamente!");
			    
		  RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
		  
		  requestDispatcher.forward(request, response);
		  
		  System.out.println("Desconectado");
		  
		  } else {
		  
		  
		  /*response.sendRedirect(request.getContextPath());*/
			  response.sendRedirect( "/Login.jsp");
		 
		  }
	}

}
