<%@page session="true" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista Visitante</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/cabecera.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

</head>

<body>


<!-- Empieza Formulario de Visitante -->
<h1 class="titulo">Tabla Visitante</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

<div id="contenedorBoton">

	<input type="button" value="Nuevo Registro" class="btn btn-outline-success" onclick="window.location.href='ControladorVisitantes?instruccion=cargarListasV'"/>
	<button type="button" value="regresar" class="btn btn-outline-success" onclick="history.back()">Regresar</button>
	<%-- <a href="${linkTemporal}"><input type="submit" class="btn btn-outline-success" value="Actualizar"></a> --%>
	
</div>
<br>

<!-- Empieza Tabla de Formulario -->

<!-- Creamos una tabla con sus etiquetas de apertura y cierre -->
<!-- <table id="tablaVisitante" class="display table table-bordered order-table"> -->

<table id="tablaShomer" class="table table-striped">

<thead class="text-center">
<tr>

<td class="cabecera">ID</td>
<td class="cabecera">Nombre</td>
<td class="cabecera">Apellido</td>
<td class="cabecera">Tipo</td>
<td class="cabecera">NumeroID</td>
<!--<td class="cabecera">Celular</td>
<td class="cabecera">Email</td>
<td class="cabecera">Dependencia</td>
<td class="cabecera">Funcionario</td>
<td class="cabecera">ARL</td>
<td class="cabecera">RH</td>
<td class="cabecera">Observacion</td>
<td class="cabecera">Aparatos</td> -->
<td class="cabecera">Ingreso</td>
<td class="cabecera">Notas</td>
<td class="cabecera">Salida</td>
<td class="cabecera">Act</td>
<td class="cabecera">Actualizar</td>
<td class="cabecera">Eliminar</td>

</tr>
</thead>

<tbody class="text-center">

<!-- Creamos un ForEach para recorreer la lista de los datos que tiene la BBDD -->
<c:forEach var="tempVisitante" items="${LISTAVISITANTES}">

<!-- Link para Actualizar Usuarios Visitantes con su campo clave -->
<c:url var="linkTemporal" value="ControladorVisitantes">

	<c:param name="instruccion" value="cargarVisitanteBBDD"></c:param>
	<c:param name="idVisi" value="${tempVisitante.idvisitante}"></c:param>

</c:url>

<!-- Link para Eliminar cada Registro de Usuario con su campo Clave -->

<c:url var="linkTempDelete" value="ControladorVisitantes">

	<c:param name="instruccion" value="eliminarVisitanteBBDD"></c:param>
	<c:param name="idVisi" value="${tempVisitante.idvisitante}"></c:param>
</c:url>


<tr>

<!-- Creamos las variables a recorrer dentro del ForEach usando las variables encapsuladas del Modelo --> 

<td class="filas">${tempVisitante.idvisitante}</td>
<td class="filas">${tempVisitante.nomvisitante}</td>
<td class="filas">${tempVisitante.apelvisitante}</td>
<td class="filas">${tempVisitante.codtipo}</td>
<td class="filas">${tempVisitante.numidentidad}</td>
<%--<td class="filas">${tempVisitante.movilvisitante}</td>
<td class="filas">${tempVisitante.emailvisitante}</td>
<td class="filas">${tempVisitante.coddependencia}</td>
<td class="filas">${tempVisitante.codfuncionario}</td>
<td class="filas">${tempVisitante.codarl}</td>
<td class="filas">${tempVisitante.codrh}</td>
<td class="filas">${tempVisitante.codobservavis}</td>
<td class="filas">${tempVisitante.codaparatos}</td> --%>
<td class="filas">${tempVisitante.fechavisitante}</td>
<td class="filas">${tempVisitante.notas}</td>
<td class="filas">${tempVisitante.fechasalida}</td>
<td><input type="checkbox" onclick="marcar(this)"/></td>
 
<td><a href="${linkTemporal}"><input type="submit" class="btn btn-outline-success" value="Actualizar"></a></td> 
<td><a href="${linkTempDelete}"><input type="submit" class="btn btn-outline-success" value="Eliminar" onclick="return confirmarDelete()"></a></td>


</tr>


</c:forEach>
</tbody>

</table>


<script type="text/javascript" src="s_resources/js/colorFila.js"></script>
<script type="text/javascript" src="s_resources/js/validaTabla.js"></script>
<script type="text/javascript" src="s_resources/js/popupDelete.js"></script>

</body>
</html>