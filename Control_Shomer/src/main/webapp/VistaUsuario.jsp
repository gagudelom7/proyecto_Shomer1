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
<title>Vista Usuario</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/cabecera.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

</head>

<body>


<!-- Empieza Formulario de Usuario -->

<h1 class="titulo">Tabla Usuario</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

<div id="contenedorBoton">

	<input type="button" value="Insertar Registro" class="btn btn-outline-success" onclick="window.location.href='ControladorUsuario?instruccion=cargarListasU'"/>
	<!-- <button type="button" value="regresar" class="btn btn-outline-success" onclick="window.location.href='FormularioAdmin.jsp'">Regresar</button> -->
	<button type="button" value="regresar" class="btn btn-outline-success" onclick="history.back()">Regresar</button>

</div>

<!-- Creamos una tabla con sus etiquetas de apertura y cierre -->
<br>
<table id="tablaShomer" class="table table-striped">

<thead class="text-center">
<tr>

<td class="cabecera">ID</td>
<td class="cabecera">Nombre</td>
<td class="cabecera">Apellido</td>
<td class="cabecera">Usuario</td>
<!-- <td class="cabecera">Password</td> -->
<td class="cabecera">Email</td>
<td class="cabecera">Celular</td>
<td class="cabecera">Fecha</td>
<td class="cabecera">Perfil</td>
<td class="cabecera">RH</td>
<td class="cabecera">ARL</td>
<td class="cabecera">Actualizar</td>
<td class="cabecera">Eliminar</td>

</tr>

</thead>

<tbody class="text-center">
<!-- Creamos un ForEach para recorreer la lista de los datos que tiene la BBDD -->

<c:forEach var="tempUsuario" items="${LISTAUSUARIOS}">

<!-- Link para Actualizar Usuario con su campo clave -->
<c:url var="linkTemp" value="ControladorUsuario">

	<c:param name="instruccion" value="cargarUsuarioBBDD"></c:param>
	<c:param name="idUsu" value="${tempUsuario.idusu}"></c:param>

</c:url>

<!-- Link para Eliminar cada Registro de Usuario con su campo Clave -->

<c:url var="linkTempDelete" value="ControladorUsuario">

	<c:param name="instruccion" value="eliminarUsuarioBBDD"></c:param>
	<c:param name="idUsu" value="${tempUsuario.idusu}"></c:param>
</c:url>

<tr>

<!-- Creamos las variables a recorrer dentro del ForEach usando las variables encapsuladas del Modelo --> 

<td class="filas">${tempUsuario.idusu}</td>
<td class="filas">${tempUsuario.nomusu}</td>
<td class="filas">${tempUsuario.apelusu}</td>
<td class="filas">${tempUsuario.usu}</td>
<%-- <td class="filas">${tempUsuario.contr}</td> --%>
<td class="filas">${tempUsuario.emailusu}</td>
<td class="filas">${tempUsuario.movilusu}</td>
<td class="filas">${tempUsuario.fech}</td>
<td class="filas">${tempUsuario.codperf}</td>
<td class="filas">${tempUsuario.codrh}</td>
<td class="filas">${tempUsuario.codarl}</td>

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