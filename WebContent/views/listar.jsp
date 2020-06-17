<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar tabla</title>
</head>
<body>
	<h1>Listar tabla</h1>
		<table border ="1">
			<tr>
				<td>Id: </td>
				<td>Nombre: </td>
				<td>CUI: </td>
				<td>Carrera: </td>
				<td>Accion: </td>
			</tr>
			<c:forEach var="tabla" items="${lista}">
				<tr>
					<td><a href="Tabla?opcion=meditar&Id=<c:out value="${tabla.Id}"></c:out>"><c:out value="${tabla.Id}"></c:out></a></td>
					<td><c:out value="${tabla.Nombre}"></c:out></td>
					<td><c:out value="${tabla.CUI}"></c:out></td> 
					<td><c:out value="${tabla.Carrera}"></c:out></td>
					<td><a href="Tabla?opcion=eliminar&Id=<c:out value="${tabla.Id}"></c:out>">Eliminar : </a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>