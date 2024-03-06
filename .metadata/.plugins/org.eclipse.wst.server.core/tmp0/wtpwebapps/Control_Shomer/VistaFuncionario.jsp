<%@page session="true" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <!-- Importamos los archivos Javax.Servlet.JSP.JSTL que se requieren para el proceso -->
    
    <!-- Importamos la libreria Tag bajo el core de tipo C -->
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista Funcionario</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/cabecera.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

</head>

<body>

<!-- Empieza Formulario de Funcionario -->

<h1 class="titulo">Ingresar Funcionario</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<div id="contenedorBoton">

		<input type="button" value="Nuevo Registro" class="btn btn-outline-success" onclick="window.location.href='ControladorFuncionario?instruccion=cargarListasF'"/>
		<!-- <button type="button" value="regresar" class="btn btn-outline-success" onclick="window.location.href='FormularioAdmin.jsp'">Regresar</button> -->
		<button type="button" value="regresar" class="btn btn-outline-success" onclick="history.back()">Regresar</button>
		
	</div>


		<!-- Empieza Tabla de Formulario -->

<!-- Creamos una tabla con sus etiquetas de apertura y cierre -->
<br>

<table id="tablaShomer" class="table table-striped">

<thead class="text-center">
<tr>

<td class="cabecera">ID</td>
<td class="cabecera">Nombre</td>
<td class="cabecera">Apellido</td>
<td class="cabecera">Telefono Oficina</td>
<td class="cabecera">Email</td>
<td class="cabecera">Dependencia</td>

<td class="cabecera">Actualizar</td>
<td class="cabecera">Eliminar</td>

</tr>

</thead>

<tbody class="text-center">
<!-- Creamos un ForEach para recorreer la lista de los datos que tiene la BBDD -->

<c:forEach var="tempFuncionario" items="${LISTAFUNCIONARIOS}">

<!-- Link para Actualizar Usuario con su campo clave -->
<c:url var="linkTemp" value="ControladorFuncionario">

	<c:param name="instruccion" value="cargarFuncionarioBBDD"></c:param>
	<c:param name="id_Funcio" value="${tempFuncionario.idfuncionario}"></c:param>

</c:url>

<!-- Link para Eliminar cada Registro de Usuario con su campo Clave -->

<c:url var="linkTempDelete" value="ControladorFuncionario">

	<c:param name="instruccion" value="eliminarFuncionarioBBDD"></c:param>
	<c:param name="id_Funcio" value="${tempFuncionario.idfuncionario}"></c:param>
</c:url>

<tr> 
<!-- Creamos las variables a recorrer dentro del ForEach usando las variables encapsuladas del Modelo --> 

<td class="filas">${tempFuncionario.idfuncionario}</td>
<td class="filas">${tempFuncionario.nomfuncionario}</td>
<td class="filas">${tempFuncionario.apelfuncionario}</td>
<td class="filas">${tempFuncionario.teloficina}</td>
<td class="filas">${tempFuncionario.emailfuncionario}</td>
<td class="filas">${tempFuncionario.coddependencia}</td>

<td><a href="${linkTemp}"><input type="submit" class="btn btn-outline-success" value="Actualizar"></a></td> 
			
<td><a href="${linkTempDelete}"><input type="submit" class="btn btn-outline-success" value="Eliminar" onclick="return confirmarDelete()"></a></td>

</tr>

</c:forEach>

</tbody>

</table>
	
<script type="text/javascript" src="s_resources/js/validaTabla.js"></script>
 <script type="text/javascript" src="s_resources/js/popupDelete.js"></script>
</body>
</html>