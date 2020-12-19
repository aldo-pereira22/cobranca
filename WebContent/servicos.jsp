<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>Serviços</title>
</head>
<body>

<h1>Servicos</h1>
	
 <button >	<a href="cadastro-servicos.jsp"> Novo serviço </a> </button>
	<table>
		<thead>
			<tr>
<!-- 				<th>ID</th> -->
				<th>NOME</th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach items="${servicos}" var="a">
 				<tr>
<%--  					<td>${a.id}</td> --%>
 					<td>${a.nome}</td>
 					<td><a href="servicos?id=${a.id}&acao=editar">editar</a></td>
 					<td><a href="servicos?id=${a.id}&acao=excluir">excluir</a></td>
 				</tr>
 				</c:forEach>
		</tbody>
	</table>
</body>
</html>