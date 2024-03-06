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

import com.shomer.dao.ModeloVisitantes;
import com.shomer.dto.Visitante;
import com.shomer.oblist.Arl;
import com.shomer.oblist.Dependencia;
import com.shomer.oblist.Empleado;
import com.shomer.oblist.Equipos;
import com.shomer.oblist.Identidad;
import com.shomer.oblist.Observavis;
import com.shomer.oblist.Rh;
import com.shomer.oblist.VisitanteInit;

/**
 * Servlet implementation class ControladorVisitantes
 */
@WebServlet("/ControladorVisitantes")
public class ControladorVisitantes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private ModeloVisitantes modeloVisitantes;
	
	@Resource(name="jdbc/shomer1")
	private DataSource myPool;

	
	@Override
	public void init() throws ServletException {
		
		super.init();
		
		try {
			
			modeloVisitantes = new ModeloVisitantes(myPool);
		
		}catch(Exception e) {
			
			throw new ServletException(e);
			
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String elComando = request.getParameter("instruccion");
		
		if(elComando==null) elComando = "listarVisitantes";
		
		switch(elComando) {
		
		case "listarVisitantes":
			
			obtenerVisitantes(request, response);
			
			break;
			
		case "ingresarVisitanteBBDD":
			
			agregarVisitantes(request, response);
		
			 break;
			 
			 
		case "cargarVisitanteBBDD":
			
			try {
				
				cargarVisitante(request, response);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			break;
			
		case "actualizarVisitanteBBDD":
		      
		      try {
		        
		        actualizaVisitante(request, response);
		        
		      } catch (Exception e) {
		        
		        e.printStackTrace();
		      }
		      
		      break;
		      
		case "eliminarVisitanteBBDD":
		      
		      try {
		        
		        eliminarVisitante(request, response);
		        
		      } catch (Exception e) {
		      
		        e.printStackTrace();
		      }
		      
		      break;
		      
		 case "cargarListasV":
		      
			try {
				listasVisitante(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		                
		      break;
		      
		    default: 
		      
		      //En dado caso que no se cumplan los metodos de los case se ejecutara el listado de Usuarios
		      obtenerVisitantes(request, response);
		      
		    }
		}
		

	private void listasVisitante(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 	Identidad identidad = new Identidad(myPool);
		    Dependencia dependencia = new Dependencia(myPool);
		    Empleado funcionario = new Empleado(myPool);
		    Arl arl = new Arl(myPool);
		    Rh rh = new Rh(myPool);
		    Observavis observacion = new Observavis(myPool);
		    Equipos equipo = new Equipos(myPool);
		    
		    Map<String, String> identidades = identidad.drop_Identidad();
		    Map<String, String> dependencias = dependencia.drop_Dependencia();
		    Map<String, String> funcionarios = funcionario.drop_Funcionario();
		    Map<String, String> arls = arl.drop_Arl();
		    Map<String, String> rhs = rh.drop_Rh();
		    Map<String, String> observavis = observacion.drop_Observaciones();
		    Map<String, String> equipos = equipo.drop_Equipos();
		    
		    request.setAttribute("identidades", identidades);
		    request.setAttribute("dependencias", dependencias);
		    request.setAttribute("funcionarios", funcionarios);
		    request.setAttribute("arls", arls);
		    request.setAttribute("rhs", rhs);
		    request.setAttribute("observavis", observavis);
		    request.setAttribute("equipos", equipos);
		    
		    request.getRequestDispatcher("FormularioVisitantes.jsp").forward(request, response);
			
	}



	private void eliminarVisitante(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 //Capturar el Campo Clave del Usuario - Tener presente de donde viene el parametro de llamada
	    
	    int IdVisit= Integer.parseInt(request.getParameter("idVisi"));
	        
	    //Borrar Usuario de la BBDD
	        
	        modeloVisitantes.eliminarVisitante(IdVisit);
	        
	        //Volver al Listado de Usuario
	        
	        obtenerVisitantes(request, response);
		
	}

	private void actualizaVisitante(HttpServletRequest request, HttpServletResponse response) throws Exception {

		   //Leer la informacion que viene del Formulario
	    
        int IdVisit= Integer.parseInt(request.getParameter("idVisitante"));
    
        String NameVisitante= request.getParameter("nameVisitante");
        
        String ApelVisitante = request.getParameter("apelVisitante");
        
        int TipoId = Integer.parseInt(request.getParameter("tipoId"));
        
        String NumeroId = request.getParameter("numeroId");
        
        String MovilVisitante = request.getParameter("movilVisitante");
        
        String EmailVisitante = request.getParameter("emailVisitante");
        
        int Dependencia = Integer.parseInt(request.getParameter("dependencia"));
        
        int Funcionario = Integer.parseInt(request.getParameter("funcionario"));
        
        int ArlVisitante = Integer.parseInt(request.getParameter("arlVisitante"));
        
        int RhVisitante = Integer.parseInt(request.getParameter("rhVisitante"));
        
        int Observaciones = Integer.parseInt(request.getParameter("observaciones"));
        
        int Aparatos = Integer.parseInt(request.getParameter("aparatos"));
        

        //Formato Fecha
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        Date FechaVisitante = null;
        
        try {
        
          FechaVisitante = formatoFecha.parse(request.getParameter("fechaVisitante"));
        
        } catch (ParseException e) {
          // TODO Auto-generated catch block
          
          e.printStackTrace();
        
        }
        
        String Notas = request.getParameter("notas");
        
        //Formato Fecha Salida
        
        SimpleDateFormat formatoFecha1 = new SimpleDateFormat("yyyy-MM-dd");
            
        Date FechaSalidaVisitante = null;
            
        try {
            
          FechaSalidaVisitante = formatoFecha1.parse(request.getParameter("fechaSalidaVisitante"));
            
        } catch (ParseException e) {
                  
          e.printStackTrace();
            
        }
        
        
        
        //Con la Informacion crear un objeto de tipo Usuario Visitante
        
        Visitante VisitanteActualizado = new Visitante(IdVisit,NameVisitante,ApelVisitante,TipoId,NumeroId,MovilVisitante,EmailVisitante,Dependencia,Funcionario,ArlVisitante,RhVisitante,Observaciones,Aparatos,FechaVisitante,Notas,FechaSalidaVisitante);
        
        //Enviar el objeto al Modelo de Visitante e Insertarlo en la BBDD a traves del parametro encapsulado ModeloUsuario
        
        try {
          
          modeloVisitantes.actualizarVisitanteNuevo(VisitanteActualizado);
          
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
        //Volver a listado de Visitantes para validar la inserccion del Objeto
        //Llamamos al Metodo ObtenerVisitantes
        
        obtenerVisitantes(request, response);
		
	}



	private void cargarVisitante(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//Leer el codigo de Usuario Visitante que viene del Listado recibiendo como parametro el name del C:param
	    
        int idVisitante=Integer.parseInt(request.getParameter("idVisi"));
        
        //Comunicar con el modelo para que este haga una consulta a la BBDD cuyo criterio sea el codigo Usuario que le se esta ENVIANDO
        
        Visitante elVisitante = modeloVisitantes.getVisitante(idVisitante);
 
        // Colocar atributo correspondiente al cogigo Usuario Visitante
        
        request.setAttribute("VisitanteActualizar", elVisitante);
        
         // Enviar toda la informacion al Formulario de Actualizar Usuario Visitante
        
        RequestDispatcher myDispatcher = request.getRequestDispatcher("FormularioActualizarVisitantes.jsp");
        
        Identidad identidad = new Identidad(myPool);
        Map<String, String> identidades = identidad.drop_Identidad();
        request.setAttribute("identidades", identidades);
        
        Dependencia dependencia = new Dependencia(myPool);
        Map<String, String> dependencias = dependencia.drop_Dependencia();
        request.setAttribute("dependencias", dependencias);
        
        Empleado funcionario = new Empleado(myPool);
        Map<String, String> funcionarios = funcionario.drop_Funcionario();
        request.setAttribute("funcionarios", funcionarios);
        
        Arl arl = new Arl(myPool);
        Map<String, String> arls = arl.drop_Arl();
        request.setAttribute("arls", arls);
        
	    Rh rh = new Rh(myPool);
	    Map<String, String> rhs = rh.drop_Rh();
	    request.setAttribute("rhs", rhs);
	    
	    Observavis observacion = new Observavis(myPool);
	    Map<String, String> observavis = observacion.drop_Observaciones();
	    request.setAttribute("observavis", observavis);
	    
	    Equipos equipo = new Equipos(myPool);
	    Map<String, String> equipos = equipo.drop_Equipos();
	    request.setAttribute("equipos", equipos);
        
        myDispatcher.forward(request, response);
		
	}



	private void agregarVisitantes(HttpServletRequest request, HttpServletResponse response) {


		 String NameVisitante= request.getParameter("nameVisitante");
		    
		    String ApelVisitante = request.getParameter("apelVisitante");
		    
		    int TipoId = Integer.parseInt(request.getParameter("tipoId"));
		    
		    String NumeroId = request.getParameter("numeroId");
		    
		    String MovilVisitante = request.getParameter("movilVisitante");
		    
		    String EmailVisitante = request.getParameter("emailVisitante");
		    
		    int Dependencia = Integer.parseInt(request.getParameter("dependencia"));
		    
		    int Funcionario = Integer.parseInt(request.getParameter("funcionario"));
		    
		    int ArlVisitante = Integer.parseInt(request.getParameter("arlVisitante"));
		    
		    int RhVisitante = Integer.parseInt(request.getParameter("rhVisitante"));
		    
		    int Observaciones = Integer.parseInt(request.getParameter("observaciones"));
		    
		    int Aparatos = Integer.parseInt(request.getParameter("aparatos"));
		    

		    //Formato Fecha
		    
		    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		    
		    Date FechaVisitante = null;
		    
		    try {
		    
		      FechaVisitante = formatoFecha.parse(request.getParameter("fechaVisitante"));
		    
		    } catch (ParseException e) {
		      // TODO Auto-generated catch block
		      
		      e.printStackTrace();
		    
		    }
		    
		    String Notas = request.getParameter("notas");
		    
		    
		    Visitante NuevoVisitante = new Visitante(NameVisitante,ApelVisitante,TipoId,NumeroId,MovilVisitante,EmailVisitante,Dependencia,Funcionario,ArlVisitante,RhVisitante,Observaciones,Aparatos,FechaVisitante,Notas);
		    //Enviar el objeto al Modelo de Visitante e Insertarlo en la BBDD a traves del parametro encapsulado ModeloUsuario
		    
		    try {
		      
		      modeloVisitantes.agregarVisitanteNuevo(NuevoVisitante);
		      
		    } catch (Exception e) {
		      
		      e.printStackTrace();
		    }
		    
		    
		    
		    //Volver a listado de Visitantes para validar la inserccion del Objeto
		    //Llamamos al Metodo ObtenerVisitantes
		    
		    obtenerVisitantes(request, response);
		    
	}


	private void obtenerVisitantes(HttpServletRequest request, HttpServletResponse response) {
		
		List<VisitanteInit> visitantes;
		
		try {
			
			visitantes = modeloVisitantes.getVisitantes();
			
			request.setAttribute("LISTAVISITANTES", visitantes);
			
			RequestDispatcher myDispatcher = request.getRequestDispatcher("VistaVisitantes.jsp");
			
			myDispatcher.forward(request, response);
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
