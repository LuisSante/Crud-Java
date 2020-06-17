<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar tabla</title>
</head>
<body>

<h1>Editar tabla</h1>
	<form action="Tabla" method="post">
	<c:set var="tabla" value="${tabla}"></c:set>
		<input type="hidden" name="opcion" value="editar" >
		<input type="hidden" name="id" value="${tabla.Id }" >
		<table border ="1">
			<tr>
				<td>Nombre: </td>
				<td><input type="text" name="nombre" size="50" value="${tabla.Nombre}"></td>
			</tr>
			
			<tr>
				<td>CUI: </td>
				<td><input type="text" name="cui" size="50" value="${tabla.CUI}"></td>
			</tr>
			
			<tr>
				<td>Carrera: </td>
				<td><input type="text" name="carrera" size="50" value="${tabla.Carrera}"></td>
			</tr>
		</table>
		<input type="submit" value="Guardar">
	</form>
</body>
</html>