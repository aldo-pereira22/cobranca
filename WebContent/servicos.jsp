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
						<li><a href="clientes"> LISTA DE CLIENTES </a></li>
						<li><a href="cadastro-servicos.jsp"> CADASTRO DE SERVIÇOS </a></li>
						<li><a class="ativo" href="servicos"> LISTA DE SERVIÇOS </a></li>
						
					</ul>
				</nav>
				
			</div>

		</div>

	</header>

<!--  <button >	<a href="cadastro-servicos.jsp"> Novo serviço </a> </button>
  -->	
  <a class="btn" href="cadastro-servicos.jsp"> Novo serviço </a> 
	<table border="1">
		<thead>
			<tr>
				<th>NOME</th>
				<th> EDITAR </th>
				<th> EXCLUIR </th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach items="${servicos}" var="a">
 				<tr>
<%--  					<td>${a.id}</td> --%>
 					<td>${a.nome}</td>
 					<td><a href="servicos?id=${a.id}&acao=editar"> <img alt="" src="edit.png" width="25px"></a></td>
 					<td><a href="servicos?id=${a.id}&acao=excluir"> <img alt="" src="delete.png" width="25px"> </a></td>
 				</tr>
 				</c:forEach>
		</tbody>
	</table>
		<footer>
		<div class="container">
			<div class="footer_menu">
				<div class="div1"> 
									SISTEMA DE COBRANÇA || DESENVOLVIDO POR: ALDO PEREIRA E JOÃO VICTOR GONTIJO
				 </div>
				
			
			</div>
		</div>
	</footer>
</body>
</html>