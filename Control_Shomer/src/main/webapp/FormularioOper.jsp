<%@page session="true" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 	
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shomer Operativo</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/menu.css" rel="stylesheet" type="text/css">

</head>

<body>
			
			<c:url var="ingFunci" value="ControladorFuncionario">
												
												<!-- ListarFuncionario -->
				<c:param name="instruccion" value="listarFuncionario"></c:param>
				
				
			</c:url>

			<c:url var="ingMensa" value="ControladorMensajeria">
												
												<!-- ListarMensajeria -->
				<c:param name="instruccion" value="listarMensajeria"></c:param>
				
				
			</c:url>

			<c:url var="ingVisit" value="ControladorVisitantes">
												
												<!-- ListarVisitante -->
				<c:param name="instruccion" value="listarVisitante"></c:param>
				
				
			</c:url>
			

 <header class="header" id="inicio">
       
       <div class="seccion">
        <%
        		session = request.getSession(false);
				String name;
				
				name = (String) session.getAttribute("Opper");
				
				out.println("Usuario Conectado: " + name);
				
		%>
		
<!-- delete it at the end of user session -->
		</div>
		
        <img src="s_resources/img/burger.svg" alt="" class="burger">
      
        <nav class="menu-navegacion">
           	<a href="${ingFunci}">Registro Funcionario</a>
            <a href="${ingMensa}">Registro Mensajeria</a>
            <a href="${ingVisit}">Registro Visitante</a>
            <a href="<%=request.getContextPath()%>/Logoutsystem">Cerrar Seccion</a>
            <a class="active" href="#about">About</a>
        </nav>

       
            <img src="s_resources/img/shomer.gif" alt="" class="logo2">
            <h1 class="titulo">Control de Visitantes SHOMER-1</h1>
            <p class="copy">Your Company, my Profession</p>
        
		
    </header>
	
		
	<script type="text/javascript" src="s_resources/js/menu.js"></script>

</body>
</html>