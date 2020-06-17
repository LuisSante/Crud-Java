<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear tabla</title>
</head>
<body>

	<h1>Crear tabla</h1>
	<form action="Tabla" method="post">
	<input type="hidden" name="opcion" value="guardar" >
		<table border ="1">
			<tr>
				<td>Nombre: </td>
				<td><input type="text" name="nombre" size="50" ></td>
			</tr>
			
			<tr>
				<td>CUI: </td>
				<td><input type="text" name="nombre" size="50" ></td>
			</tr>
			
			<tr>
				<td>Carrera: </td>
				<td><input type="text" name="nombre" size="50" ></td>
			</tr>
		</table>
		<input type="submit" value="Guardar">
	</form>

</body>
</html>