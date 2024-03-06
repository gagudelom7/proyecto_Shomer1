<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizacion Funcionario</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/formularios.css" rel="stylesheet" type="text/css">

</head>
<body>

<h1 class="titulo">Actualizar Funcionario</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<form name="form1" method="get" action="ControladorFuncionario">

<!-- Creamos un campo de tipo Hidden para que el usuario no lo vea con la instruccion
de actualizar la informacion en la BBDD -->

		<input type="hidden" name="instruccion" value="actualizarFuncionarioBBDD">
		<input type="hidden" name="id_Funcio" value="${FuncionarioActualizar.idfuncionario}">


		<div class="container">

			<div class="row mb-3">
				
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">ID</label> 
							<input class="form-control" type="text" readonly="readonly" name="idFuncionario" id="idFuncionario" value="${FuncionarioActualizar.idfuncionario}">

						</div>
					</div>


					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Nombre Funcionario</label> 
							<input class="form-control" type="text" name="nameFuncionario" id="nameFuncionario" value="${FuncionarioActualizar.nomfuncionario}">

						</div>
					</div>

					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Apellidos Funcionario</label>
							<input class="form-control" type="text" name="apelFuncionario" id="apelFuncionario" value="${FuncionarioActualizar.apelfuncionario}">
						</div>
					</div>

				</div>
				
				
				<div class="row mb-3">
				
					<div class="col-4 mb-3">
				
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Telefono Oficina</label>
							<input class="form-control" type="text" name="telOficina" id="telOficina" value="${FuncionarioActualizar.teloficina}">
						</div>
					</div>
					
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Email Funcionario</label>
							<input class="form-control" type="text" name="emailFuncionario" id="emailFuncionario" value="${FuncionarioActualizar.emailfuncionario}">

						</div>
					</div>


					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Dependencia</label>
							<select name="codDependencia" class="form-select" aria-label="Default select example">
							<c:forEach  var="dependencia"  items="${dependencias}"  >
								<option value="${dependencia.key}" 
								     ${dependencia.key == FuncionarioActualizar.coddependencia ? 'selected' : ''  }
								     > ${dependencia.value}</option>
							</c:forEach>
														
							</select>
						</div>

					</div>

						<div class="row mb-3">
				
							<div class="col-4 mb-3">
						
								<div class="contenedorBoton">
									<button type="submit" name="button" id="button"	class="formulario__btn">Actualizar</button>
									<button type="button" value="regresar" class="formulario__btn" onclick="history.back()">Regresar</button>
								</div>								

							</div>
					</div>
			</div>
			

		</div>

	</form>
</body>
</html>