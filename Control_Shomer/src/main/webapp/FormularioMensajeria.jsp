<%@page import="java.util.HashMap"%>
<%@ page import="javax.sql.DataSource" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario mensajeria</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/formularios.css" rel="stylesheet" type="text/css">
</head>
<body>

<h1 class="titulo">Ingresar Mensajeria</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<form name="form1" method="get" action="ControladorMensajeria">

<!-- Creamos un campo de tipo Hidden para que el usuario no lo vea con la instruccion
de actualizar la informacion en la BBDD -->

		<input type="hidden" name="instruccion" value="ingresarMensajeriaBBDD">
		
		<div class="container">

			<div class="row mb-3">
			
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo</label> 
							<!-- <input class="form-control" type="text" name="codMensajeria" id="codMensajeria"> -->
							
							<select name="codMensajeria" class="form-select" aria-label="Default select example">
							
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop = (HashMap<String, String>)request.getAttribute("tMensajerias");
									
									
									for(String i: drop.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop.get(i) + "</option>");
									} 
									
								%>
							</select>
							

						</div>
					</div>

					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Cantidad</label>
							<input class="form-control" type="text" name="cantMensajeria" id="cantMensajeria"
							onkeyup="success()" onkeypress="return soloNumeros(event)" required>
						</div>
					</div>

					
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Fecha(yyyy-mm-dd)</label> 
								<input class="form-control"	pattern="^\d{4}-\d{2}-\d{2}$" type="text" name="fechaMensa" maxlength="10"
								id="fechaMensa" onkeyup="success()" data-role="datepicker" required>
						</div>
					</div>
				</div>
			
			<div class="row mb-3">
				
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Funcionario</label>
							<select name="funcionMensa" class="form-select" aria-label="Default select example">
								
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


					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Remitente</label>
							<input class="form-control" type="text" name="remiteMensa" id="remiteMensa" onkeyup="success()" required>
						</div>

					</div>
					
					
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Empresa Mensajeria</label>
							<select name="empMensa" class="form-select" aria-label="Default select example">
								
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop2 = (HashMap<String, String>)request.getAttribute("empMensajerias");
									
									
									for(String i: drop2.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop2.get(i) + "</option>");
									} 
								
								%>
							</select>
							
						</div>

					</div>
				</div>
			

			<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Estado Mensajeria</label>
							<select name="estadoMensa" class="form-select" aria-label="Default select example">
								
							<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop4 = (HashMap<String, String>)request.getAttribute("estadoMensajerias");
									
									
									for(String i: drop4.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop4.get(i) + "</option>");
									} 
									
								%>
							</select>
							
						</div>

					</div>
					
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Observaciones</label>
							<select name="observaMensa" class="form-select" aria-label="Default select example">
								
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop5 = (HashMap<String, String>)request.getAttribute("observamens");
									
									
									for(String i: drop5.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop5.get(i) + "</option>");
									} 
									
								%>
							
							</select>
						</div>

					</div>
					
				</div>
				
				<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Notas</label>
							<input class="form-control" type="text" name="notasMensa" id="notasMensa" maxlength="40" onkeyup="success()">
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
<script type="text/javascript" src="s_resources/js/textScriptM.js"></script>

</body>
</html>