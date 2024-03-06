<%@page import="java.util.HashMap"%>
<%@ page import="javax.sql.DataSource" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Funcionario</title>
<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/formularios.css" rel="stylesheet" type="text/css">
</head>
<body>


<h1 class="titulo">Ingresar Funcionario</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<form name="form1" method="get" action="ControladorFuncionario">

<!-- Creamos un campo de tipo Hidden para que el usuario no lo vea con la instruccion
de actualizar la informacion en la BBDD -->

		<input type="hidden" name="instruccion" value="ingresarFuncionarioBBDD">
		
		<div class="container">

			<div class="row mb-3">
			
					<div class="col-4 mb-3">
						<div class="form-group has-success">
						
							<label class="control-label" for="inputSuccess1">Nombre Funcionario</label> 
							<input class="form-control" type="text" name="nameFuncionario" id="nameFuncionario"
							onkeyup="success()" onkeypress="return soloLetras(event)" required>

						</div>
					</div>

					<div class="form-group col-md-4">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Apellidos Funcionario</label>
							<input class="form-control" type="text" name="apelFuncionario" id="apelFuncionario"
							onkeyup="success()" onkeypress="return soloLetras(event)" required>
						</div>
					</div>

					<div class="form-group col-md-4">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Telefono Oficina</label>
							<input class="form-control" type="text" name="telOficina" id="telOficina" onkeyup="success()" onkeypress="return soloNumeros(event)">
						</div>

					</div>
				</div>

			<div class="row mb-3">
			
					<div class="col-4 mb-3">
					
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Email Funcionario</label>
							<input class="form-control" type="text" name="emailFuncionario" maxlength="50" id="emailFuncionario"
							onkeyup="success()"	data-pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">

						</div>
					</div>


					<div class="form-group col-md-4">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Dependencia</label>
							<select name="codDependencia" class="form-select" aria-label="Default select example">
								
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
<script type="text/javascript" src="s_resources/js/textScriptF.js"></script>
</body>
</html>