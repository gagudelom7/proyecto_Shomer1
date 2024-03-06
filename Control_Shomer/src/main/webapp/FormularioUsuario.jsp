<%@page import="java.util.HashMap"%>
<%@ page import="javax.sql.DataSource" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Usuario</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/formularios.css" rel="stylesheet" type="text/css">

</head>
<body>


<h1 class="titulo">Ingresar Usuario</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<form name="form1" method="get" action="ControladorUsuario">

<!-- Creamos un campo de tipo Hidden para que el usuario no lo vea con la instruccion
de actualizar la informacion en la BBDD -->

		<input type="hidden" name="instruccion" value="ingresarUsuarioBBDD">
		
		<div class="container">

			<div class="row mb-3">
				
					 <div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Nombre Usuario</label> 
							<input class="form-control" type="text" name="nameUsuario" id="nameUsuario"
							onkeyup="success()" onkeypress="return soloLetras(event)" required>

						</div>
					</div>

					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Apellidos Usuario</label>
							<input class="form-control" type="text" name="apelUsuario" id="apelUsuario"
							onkeyup="success()" onkeypress="return soloLetras(event)" required>
						</div>
					</div>

					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Usuario</label>
							<input class="form-control" type="text" name="userUsuario" maxlength="10"
								id="userUsuario" onkeyup="success()" required>
						</div>

					</div>
			</div>


			<div class="row mb-3">
				
					 <div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Contraseña</label>
							<input class="form-control" type="text" name="passUsuario" maxlength="100" id="passUsuario"
							onkeyup="success();this.form.passwEncrypt.value=md5(this.form.passUsuario.value);" required>
							<input type="hidden" name="passwEncrypt" maxlength="100">
						</div>
					</div>



					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Email Usuario</label>
							<input class="form-control" type="text" name="emailUsuario" maxlength="50" id="emailUsuario"
							onkeyup="success()"	data-pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">

						</div>
					</div>


					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Movil Usuario</label>
							<input class="form-control" type="text" name="movilUsuario" maxlength="10" id="movilUsuario"
							onkeyup="success()" onkeypress="return soloNumeros(event)" required>
						</div>

					</div>
			
			</div>




			<div class="row mb-3">
				
					 <div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Fecha(yyyy-mm-dd)</label> 
								<input class="form-control"	pattern="^\d{4}-\d{2}-\d{2}$" type="text" name="fechaUsuario" 
								maxlength="10" id="fechaUsuario" onkeyup="success()" data-role="datepicker" required>
						</div>
					</div>

					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo Perfil</label>
							<select name="perfilUsuario" class="form-select" aria-label="Default select example">
								<%
								@SuppressWarnings("unchecked")
									HashMap<String, String> drop9 = (HashMap<String, String>)request.getAttribute("perfiles");
									
									
									for(String i: drop9.keySet()){
										
										out.println("<option value = '" + i + "' > " + drop9.get(i) + "</option>");
									} 
									
								%>
							</select>
						</div>

					</div>


					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo RH</label>
							<select name="rhUsuario" class="form-select" aria-label="Default select example">
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
					
			</div>
			
			
			<div class="row mb-3">
				
					 <div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo ARL</label>
							<select name="arlUsuario" class="form-select" aria-label="Default select example">
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
	
	<script type="text/javascript" src="s_resources/js/md5.js"></script>
	<script type="text/javascript" src="s_resources/js/validaCampo.js"></script>
	<script type="text/javascript" src="s_resources/js/textScriptU.js"></script>
	
</body>
</html>