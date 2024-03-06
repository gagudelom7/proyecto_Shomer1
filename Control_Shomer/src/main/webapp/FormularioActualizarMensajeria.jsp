<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Actualizar Mensajeria</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/formularios.css" rel="stylesheet" type="text/css">

</head>
<body>

<h1 class="titulo">Actualizar Mensajeria</h1>
<img src="s_resources/img/shomer.gif" alt="" class="logo2">

	<form name="form1" method="get" action="ControladorMensajeria">

<!-- Creamos un campo de tipo Hidden para que el usuario no lo vea con la instruccion
de actualizar la informacion en la BBDD -->

		<input type="hidden" name="instruccion" value="actualizarMensajeriaBBDD">
		<input type="hidden" name="id_Mensa" value="${MensajeriaActualizar.idmensajeria}">


		<div class="container">

			<div class="row mb-3">
				
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Id Mensajeria</label> 
							<input class="form-control" type="text" readonly="readonly" name="idMensajeria" id="idMensajeria" value="${MensajeriaActualizar.idmensajeria}">

						</div>
					</div>
					
					
					<div class="form-group col-md-4">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Codigo</label> 
							<select name="codMensajeria" class="form-select" aria-label="Default select example">
								
							<c:forEach  var="tmensajeria"  items="${tMensajerias}"  >
								<option value="${tmensajeria.key}" 
								     ${tmensajeria.key == MensajeriaActualizar.codmensajeria ? 'selected' : ''  }
								     > ${tmensajeria.value}</option>
							</c:forEach>
							
							</select>
							
							
						</div>
					</div>

					<div class="form-group col-md-4">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Cantidad</label>
							<input class="form-control" type="text" name="cantMensajeria" id="cantMensajeria" value="${MensajeriaActualizar.cantidad}">
						</div>
					</div>

			</div>


			<div class="row mb-3">
				
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Fecha(yyyy-mm-dd)</label> 
								<input class="form-control"	pattern="^\d{4}-\d{2}-\d{2}$" type="text" name="fechaMensa" maxlength="10"
								id="fechaMensa" value="${MensajeriaActualizar.fechallegada}">
						</div>
					</div>
					
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Funcionario</label>
							<select name="funcionMensa" class="form-select" aria-label="Default select example">
								
							<c:forEach  var="funcionario"  items="${funcionarios}"  >
								<option value="${funcionario.key}" 
								     ${funcionario.key == MensajeriaActualizar.codfuncionario ? 'selected' : ''  }
								     > ${funcionario.value}</option>
							</c:forEach>
							
							</select>

						</div>
					</div>


					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Remitente</label>
							<input class="form-control" type="text" name="remiteMensa" id="remiteMensa" value="${MensajeriaActualizar.remitente}">
						</div>

					</div>
				
			</div>


			<div class="row mb-3">
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Empresa Mensajeria</label>
							<select name="empMensa" class="form-select" aria-label="Default select example">
							<c:forEach  var="empMensajeria"  items="${empMensajerias}"  >
								<option value="${empMensajeria.key}" 
								     ${empMensajeria.key == MensajeriaActualizar.codempremensa ? 'selected' : ''  }
								     > ${empMensajeria.value}</option>
							</c:forEach>
							
							</select>
						</div>

					</div>


					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Estado Mensajeria</label>
							<select name="estadoMensa" class="form-select" aria-label="Default select example">
							<c:forEach  var="estadoMensajeria"  items="${estadoMensajerias}"  >
								<option value="${estadoMensajeria.key}" 
								     ${estadoMensajeria.key == MensajeriaActualizar.codestadomensa ? 'selected' : ''  }
								     > ${estadoMensajeria.value}</option>
							</c:forEach>
							
							</select>
						</div>

					</div>
					
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Observaciones</label>
							<select name="observaMensa" class="form-select" aria-label="Default select example">
							<c:forEach  var="observamen"  items="${observamens}"  >
								<option value="${observamen.key}" 
								     ${observamen.key == MensajeriaActualizar.codobservaciones ? 'selected' : ''  }
								     > ${observamen.value}</option>
							</c:forEach>
							</select>
						</div>

					</div>

			</div>
			
			<div class="row mb-3">
			
					<div class="col-4 mb-3">
						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Fecha(yyyy-mm-dd)</label> 
								<input class="form-control"	pattern="^\d{4}-\d{2}-\d{2}$" type="text" name="fechaEntregaMensa" maxlength="10"
								id="fechaEntregaMensa" value="${MensajeriaActualizar.fechaentrega}">
						</div>
					</div>
				
					<div class="col-4 mb-3">

						<div class="form-group has-success">
							<label class="control-label" for="inputSuccess1">Notas</label>
							<input class="form-control" type="text" name="notasMensa" id="notasMensa" maxlength="40" value="${MensajeriaActualizar.notasmensajeria}">
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