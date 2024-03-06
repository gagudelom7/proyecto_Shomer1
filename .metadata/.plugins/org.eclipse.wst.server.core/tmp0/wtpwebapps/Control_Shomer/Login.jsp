<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1 utf-8">
<title>Login Control</title>

<link href="s_resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="s_resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="s_resources/js/bootstrap.js"></script>
<script type="text/javascript" src="s_resources/js/validaLogin.js"></script>
<script type="text/javascript" src="s_resources/js/md5.js"></script>
<link href="s_resources/css/login.css" rel="stylesheet" type="text/css">

</head>

<body onload="this.loginControl.username.focus()">
	<br>
	<br>
	<h1 style="text-align: center">
	<font face="times new roman" size=10 color=#fffff>
	<b>Control de Visitantes SHOMER-1</b>
	</font>
	</h1>

	<form name="loginControl" action="ControladorLogin" method="post" onsubmit="return validate()">

		<div class="login">
		
			<div class="login-form">

					<img src="s_resources/img/shomer.gif" alt="" class="logologin">
			
				<div class="form-group has-success">
					<input type="text" name="username" class="form-control"	id="username" placeholder="Usuario" aria-describedby="helpBlock2">
				</div>
				
				<div class="form-group has-success">
					<input type="password" name="password" class="form-control"	id="password" aria-describedby="helpBlock2" 
					 onkeyup="this.form.passwEncrypt.value=md5(this.form.password.value)" maxlength="10" placeholder="*****" required>
					 <input type="hidden" name="passwEncrypt" size="100">
				</div>
				
				<div class="formulario__grupo">
				
						<button type="submit" class="formulario__btn">Ingresar</button>
				</div>
				
				<br>
					<span style="color: #ffff">
					<%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%>
					</span>
				
				</div>

			</div>
			
			<br>
	</form>
</body>
</html>