<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>Clientes</title>
</head>
<body>
<header>
		<div class="container">
			<div class="logo">
				<a href="index.jsp"> <img alt="" src="logo1.png">
				</a>
			</div>

			<div class="menu">

				<nav>
					<ul>
						<li><a href="index.jsp"> INICIO </a></li>
						
						<li><a href="cadastro-cliente.jsp"> CADASTRO DE CLIENTES </a></li>
						<li><a href="clientes.jsp"> LISTA DE CLIENTES </a></li>
						<li><a href="cadastro-servicos.jsp"> CADASTRO DE SERVIÇOS </a></li>
						<li><a href="servicos.jsp"> LISTA DE SERVIÇOS </a></li>
						
					</ul>
				</nav>
				
			</div>

		</div>

	</header>

	<h1>Clientes</h1>
 		<a class="btn" href="cadastro-cliente.jsp">Novo Cliente</a>  
	<table>
		
		<thead>
			<tr>
				<th>CNPJ</th>
				<th>NOME</th>
				<th>NOME FANTASIA</th>
				<th>CEP</th>
				<th>LOGRADOURO</th>
				<th>NUMERO</th>
				<th>COMPLEMENTO</th>
				<th>UF</th>
				<th>MUNICIPIO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientes}" var="a">
 				<tr>
 					<td>${a.cnpj}</td>
 					<td>${a.nome}</td>
 					<td>${a.nomeFantasia}</td>
 					<td>${a.cep}</td>
 					<td>${a.logradouro}</td>
 					<td>${a.numero}</td>
 					<td>${a.complemento}</td>
 					<td>${a.uf}</td>
 					<td>${a.municipio}</td>
 					<td><a href="clientes?cnpj=${a.cnpj}&acao=editar">editar</a></td>
 					<td><a href="clientes?cnpj=${a.cnpj}&acao=excluir">excluir</a></td>
 				</tr>
 				</c:forEach>
		</tbody>
	</table>
</body>
</html>