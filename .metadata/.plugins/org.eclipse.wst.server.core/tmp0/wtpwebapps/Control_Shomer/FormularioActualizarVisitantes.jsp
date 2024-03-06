<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Formulario Actualizar Visitante</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/formularios.css" rel="stylesheet" type="text/css">

</head>
<body>

<h1 class="titulo">Actualizar Visitante</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<form name="form1" method="get" action="ControladorVisitantes">

<!-- Creamos un campo de tipo Hidden para que el usuario Visitante no lo vea con la instruccion
de actualizar la informacion en la BBDD -->

		<input type="hidden" name="instruccion" value="actualizarVisitanteBBDD">
		<input type="hidden" name="idvisitante" value="${VisitanteActualizar.idvisitante}">
		
		<div class="container">

			<div class="row mb-3">
				
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Id Visitante</label> 
							<input class="form-control" type="text" readonly="readonly" name="idVisitante" id="idVisitante" value="${VisitanteActualizar.idvisitante}">

						</div>
					</div>

					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Nombre Visitante</label> 
							<input class="form-control" type="text" name="nameVisitante" id="nameVisitante" value="${VisitanteActualizar.nomvisitante}">

						</div>
					</div>

					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Apellidos Visitante</label>
							<input class="form-control" type="text" name="apelVisitante" id="apelVisitante" value="${VisitanteActualizar.apelvisitante}">
						</div>
					</div>
			</div>


			<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Tipo ID</label>
							<select name="tipoId" id="tipoId" class="form-select" aria-label="Default select example">
							<c:forEach  var="identidad"  items="${identidades}"  >
								<option value="${identidad.key}" 
								     ${identidad.key == VisitanteActualizar.codtipo ? 'selected' : ''  }
								     > ${identidad.value}</option>
							</c:forEach>
							</select>
							
						</div>

					</div>
					
					
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Numero ID</label>
							<input class="form-control" type="text" name="numeroId" maxlength="20" id="numeroId" value="${VisitanteActualizar.numidentidad}">
						</div>

					</div>

					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Movil Visitante</label>
							<input class="form-control" type="text" name="movilVisitante" maxlength="10" id="movilVisitante" value="${VisitanteActualizar.movilvisitante}">
						</div>

					</div>

			</div>

			<div class="row mb-3">
				
					<div class="col-4 mb-3">
					
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Email Visitante</label>
							<input class="form-control" type="text" name="emailVisitante" maxlength="50" id="emailVisitante" value="${VisitanteActualizar.emailvisitante}">

						</div>
					</div>
					
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Dependencia</label>
							<select name="dependencia" id="dependencia" class="form-select" aria-label="Default select example">
							<c:forEach  var="depend"  items="${dependencias}"  >
								<option value="${depend.key}" 
								     ${depend.key == VisitanteActualizar.coddependencia ? 'selected' : ''  }
								     > ${depend.value}</option>
							</c:forEach>
							
							</select>
							
						</div>

					</div>

					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Funcionario</label>
							<select name="funcionario" id="funcionario" class="form-select" aria-label="Default select example">
							<c:forEach  var="funcionar"  items="${funcionarios}"  >
								<option value="${funcionar.key}" 
								     ${funcionar.key == VisitanteActualizar.codfuncionario ? 'selected' : ''  }
								     > ${funcionar.value}</option>
							</c:forEach>
							
							</select>
							
						</div>

					</div>
					
			</div>
			
			<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo ARL</label>
							<select name="arlVisitante" id="arlVisitante" class="form-select" aria-label="Default select example">
							<c:forEach  var="arl"  items="${arls}"  >
								<option value="${arl.key}" 
								     ${arl.key == VisitanteActualizar.codarl ? 'selected' : ''  }
								     > ${arl.value}</option>
							</c:forEach>
							
							</select>
							
						</div>

					</div>
										
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo RH</label>
							<select name="rhVisitante" id="rhVisitante" class="form-select" aria-label="Default select example">
							<c:forEach  var="rh"  items="${rhs}"  >
								<option value="${rh.key}" 
								     ${rh.key == VisitanteActualizar.codrh ? 'selected' : ''  }
								     > ${rh.value}</option>
							</c:forEach>
						
							</select>
						</div>

					</div>
					
					<div class="col-4 mb-3">
					
					<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Observaciones</label>
							<select name="observaciones" id="observaciones" class="form-select" aria-label="Default select example">
							<c:forEach  var="observa"  items="${observavis}"  >
								<option value="${observa.key}" 
								     ${observa.key == VisitanteActualizar.codobservavis ? 'selected' : ''  }
								     > ${observa.value}</option>
							</c:forEach>
							
							</select>
							
						</div>

					</div>

			</div>
			
			<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Equipos</label>
							<select name="aparatos" id="aparatos" class="form-select" aria-label="Default select example">
								
							<c:forEach  var="equipo"  items="${equipos}"  >
								<option value="${equipo.key}" 
								     ${equipo.key == VisitanteActualizar.codaparatos ? 'selected' : ''  }
								     > ${equipo.value}</option>
							</c:forEach>
							
							</select>
						
						</div>

					</div>
					

					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Fecha(yyyy-mm-dd)</label> 
								<input class="form-control"	pattern="^\d{4}-\d{2}-\d{2}$" type="text" name="fechaVisitante" maxlength="10" id="fechaVisitante" value="${VisitanteActualizar.fechavisitante}">
						</div>
					</div>
					
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Notas</label>
							<input class="form-control" type="text" name="notas" id="notas" value="${VisitanteActualizar.notas}">
						</div>

					</div>
			
			</div>
			
			<div class="row mb-3">
				
					<div class="col-4 mb-3">
					
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Salida(yyyy-mm-dd)</label> 
								<input class="form-control"	pattern="^\d{4}-\d{2}-\d{2}$" type="text" name="fechaSalidaVisitante" maxlength="10" id="fechaSalidaVisitante" value="${VisitanteActualizar.fechasalida}">

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

</body>
</html>