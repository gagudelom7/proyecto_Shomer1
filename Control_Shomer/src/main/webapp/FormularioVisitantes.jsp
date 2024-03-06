

<%@page import="java.util.HashMap"%>
<%@page import="javax.sql.DataSource"%> 
<%@page import="java.sql.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Formulario Visitante</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/formularios.css" rel="stylesheet" type="text/css">

</head>

<body>

<h1 class="titulo">Ingresar Visitante</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<form name="form1" method="get" action="ControladorVisitantes">
	

<!-- Creamos un campo de tipo Hidden para que el usuario no lo vea con la instruccion
de actualizar la informacion en la BBDD -->

		<input type="hidden" name="instruccion" value="ingresarVisitanteBBDD">
		
		<div class="container">

			<div class="row mb-3">
				
					 <div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Nombre Visitante</label> 
							<input class="form-control" type="text" name="nameVisitante" id="nameVisitante"
							onkeyup="success()" onkeypress="return soloLetras(event)" required>

						</div>
					</div>

					 <div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Apellidos Visitante</label>
							<input class="form-control" type="text" name="apelVisitante" id="apelVisitante"
							onkeyup="success()" onkeypress="return soloLetras(event)" required>
						</div>
					</div>

				
					 <div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Tipo ID</label>
							<select name="tipoId" class="form-select" aria-label="Default select example">
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop = (HashMap<String, String>)request.getAttribute("identidades");
									
									for(String i: drop.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop.get(i) + "</option>");
									} 
								%>
							</select>
						</div>

					</div>
			</div>
						

			<div class="row mb-3">
				
					 <div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Numero ID</label>
							<input class="form-control" type="text" name="numeroId" maxlength="20"
								id="numeroId" onkeyup="success()" onkeypress="return soloNumeros(event)">
						
						</div>

					</div>

					
					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Movil Visitante</label>
							<input class="form-control" type="text" name="movilVisitante" maxlength="10" id="movilVisitante" onkeyup="success()" onkeypress="return soloNumeros(event)">
						</div>

					</div>


					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Email Visitante</label>
							<input class="form-control" type="text" name="emailVisitante" maxlength="50" id="emailVisitante" 
							onkeyup="success()" data-pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">

						</div>
					</div>

			
			</div>




			<div class="row mb-3">
			
					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Dependencia</label>
							<select name="dependencia" class="form-select" aria-label="Default select example">
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop2 = (HashMap<String, String>)request.getAttribute("dependencias");
									
									for(String i: drop2.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop2.get(i) + "</option>");
									} 
								%>
								
							</select>
						</div>

					</div>

					
					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Funcionario</label>
							<select name="funcionario" class="form-select" aria-label="Default select example">
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop3 = (HashMap<String, String>)request.getAttribute("funcionarios");
									
									for(String i: drop3.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop3.get(i) + "</option>");
									} 
								%>
							</select>
						</div>

					</div>
					
					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo ARL</label>
							<select name="arlVisitante" class="form-select" aria-label="Default select example">
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop4 = (HashMap<String, String>)request.getAttribute("arls");
									
									for(String i: drop4.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop4.get(i) + "</option>");
									} 
								%>
							</select>
						</div>

					</div>
					
			</div>
			
		<div class="row mb-3">
			
				<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo RH</label>
							<select name="rhVisitante" class="form-select" aria-label="Default select example">
							<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop5 = (HashMap<String, String>)request.getAttribute("rhs");
									
									for(String i: drop5.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop5.get(i) + "</option>");
									} 
								%>
							</select>
						</div>

					</div>
					
					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Observaciones</label>
							<select name="observaciones" class="form-select" aria-label="Default select example">
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop6 = (HashMap<String, String>)request.getAttribute("observavis");
									
									for(String i: drop6.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop6.get(i) + "</option>");
									} 
								%>
							</select>
						</div>

					</div>

					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Equipos</label>
							<select name="aparatos" class="form-select" aria-label="Default select example">
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop7 = (HashMap<String, String>)request.getAttribute("equipos");
									
									for(String i: drop7.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop7.get(i) + "</option>");
									} 
								%>
							</select>
						</div>

					</div>
			</div>
			
			<div class="row mb-3">
				
					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Fecha(yyyy-mm-dd)</label> 
								<input class="form-control"	pattern="^\d{4}-\d{2}-\d{2}$" type="text" name="fechaVisitante" maxlength="10"
								id="fechaVisitante" onkeyup="success()" data-role="datepicker" required>
						</div>
					</div>
					
					<div class="col-md-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Notas</label>
							<input class="form-control" type="text" name="notas" maxlength="20" id="notas"
							onkeyup="success()">
						</div>

					</div>
					
					<div class="col-4 mb-3">

						<div class="contenedorBoton">
							<button type="submit" name="button" id="button"	class="formulario__btn" disabled>Enviar</button>
							<button type="reset" name="borrar" id="borrar"	class="formulario__btn">Resetear</button>
							<button type="button" value="regresar" class="formulario__btn" onclick="history.back()">Regresar</button>
						</div>

					</div>
			</div>
			
		</div>

	</form>
<script type="text/javascript" src="s_resources/js/validaCampo.js"></script>
<script type="text/javascript" src="s_resources/js/textScriptV.js"></script>


</body>
</html>