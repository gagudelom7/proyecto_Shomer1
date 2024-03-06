<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizacion Usuario</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/formularios.css" rel="stylesheet" type="text/css">

</head>
<body>

<h1 class="titulo">Actualizar Usuario</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<form name="form1" method="get" action="ControladorUsuario">

<!-- Creamos un campo de tipo Hidden para que el usuario no lo vea con la instruccion
de actualizar la informacion en la BBDD -->

		<input type="hidden" name="instruccion" value="actualizarUsuarioBBDD">
		<input type="hidden" name="id_Usu" value="${UsuarioActualizar.idusu}">


		<div class="container">

			<div class="row mb-3">
				
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Id Usuario</label> 
							<input class="form-control" type="text" readonly="readonly" name="idUsuario" id="idUsuario" value="${UsuarioActualizar.idusu}">

						</div>
					</div>


					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Nombre Usuario</label> 
							<input class="form-control" type="text" name="nameUsuario" id="nameUsuario" onkeypress="return soloLetras(event)"
								value="${UsuarioActualizar.nomusu}">

						</div>
					</div>

					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Apellidos Usuario</label>
							<input class="form-control" type="text" name="apelUsuario" onkeypress="return soloLetras(event)"
								id="apelUsuario" value="${UsuarioActualizar.apelusu}">
						</div>
					</div>

			</div>


			<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Usuario</label>
							<input class="form-control" type="text" name="userUsuario" id="userUsuario" value="${UsuarioActualizar.usu}">
						</div>

					</div>
					
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Contraseña</label>
							<input class="form-control" type="text" name="passUsuario" onkeyup="this.form.passwEncryptI.value=md5(this.form.passUsuario.value)" 
								id="passUsuario" value="${UsuarioActualizar.contr}">
							<input type="hidden" name="passwEncryptI" size="100">
						</div>
					</div>



					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Email Usuario</label>
							<input class="form-control" type="text" name="emailUsuario" id="emailUsuario" value="${UsuarioActualizar.emailusu}">

						</div>
					</div>
			</div>




			<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Movil Usuario</label>
							<input class="form-control" type="text" name="movilUsuario" id="movilUsuario" onkeypress="return soloNumeros(event)" value="${UsuarioActualizar.movilusu}">
						</div>

					</div>
					
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Fecha
								(yyyy-mm-dd)</label> <input class="form-control"
								pattern="^\d{4}-\d{2}-\d{2}$" type="text" name="fechaUsuario" id="fechaUsuario" value="${UsuarioActualizar.fech}">
						</div>
					</div>

					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo Perfil</label>
							<select name="perfilUsuario" class="form-select" aria-label="Default select example">
							<c:forEach  var="perfil"  items="${perfiles}"  >
								<option value="${perfil.key}" 
								     ${perfil.key == UsuarioActualizar.codperf ? 'selected' : ''  }
								     > ${perfil.value}</option>
							</c:forEach>
							
							</select>
							
						</div>

					</div>

			</div>
			
			<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo RH</label>
							<select name="rhUsuario" class="form-select" aria-label="Default select example">
							<c:forEach  var="rh"  items="${rhs}"  >
								<option value="${rh.key}" 
								     ${rh.key == UsuarioActualizar.codrh ? 'selected' : ''  }
								     > ${rh.value}</option>
							</c:forEach>
														
							</select>
						</div>

					</div>
					
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo ARL</label>
							<select name="arlUsuario" class="form-select" aria-label="Default select example">
							<c:forEach  var="arl"  items="${arls}"  >
								<option value="${arl.key}" 
								     ${arl.key == UsuarioActualizar.codarl ? 'selected' : ''  }
								     > ${arl.value}</option>
							</c:forEach>						
							</select>
						</div>

					</div>

				<div class="col-4 mb-3">
			
				<div class="contenedorBoton">
					<button type="submit" name="button" id="button"	class="formulario__btn">Actualizar</button>
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