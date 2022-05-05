<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
        fieldset{
		    margin-right: 40%;
		    margin-left: 40%;
		}
		h1{
			text-align: center;
		}
    </style>
</head>
<body>
	<h1>Formación</h1>
	<fieldset>
		<legend>Login</legend>
		<form action="Login" method="POST">
			Usuario: <input type="text" name="usuario">
		<br>
			Contraseña: <input type="password" name="password">
		<br><br>
			<input type="submit" value="Entrar">
		</form>
		</fieldset>
	
</body>
</html>