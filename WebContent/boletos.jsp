<%@page import="cobranca.entidade.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>BOLETO CLIENTE</title>
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
						<li><a href="cadastro-servicos.jsp"> CADASTRO DE SERVI�OS </a></li>
						<li><a href="servicos"> LISTA DE SERVI�OS </a></li>						
					</ul>
				</nav>
				
			</div>

		</div>

	</header>
	
		<h1 style="margin-left: 10px" >BOLETOS</h1> 
		<h1 style="margin-left: 10px"> Cliente: ${contrato.getCliente().getNome()}  </h1> 
	<table class="tbl" border="1">
		
		<thead>
			<tr> 	
				<th>NUMERO DO CONTRATO</th>
				<th>DESCRI��O</th>
				<th> SERVICO </th>
				<th> VALOR </th>



			</tr>
		</thead>
		
		<tbody>
			
 				<tr class="tblhover">
 					<td>${contrato.getCodigo()}</td> 	
 					<td>${contrato.getDescricao()}</td>
 					<td>${contrato.getServico().getNome()}</td>
 					<td>${contrato.getValor() }</td>
 					<!--  <td>  <a class="editar" href="contrato?cnpj=${cliente.cnpj}&acao=editar&codigo=${a.codigo}&id=${a.id}&cnpj=${cliente.cnpj}"> <img alt="" src="edit.png" width="25px"> </a></td> -->
 				<!--  	<td>  <a class="excluir" href="contrato?cnpj=${cliente.cnpj}&acao=excluir&codigo=${a.codigo}&id=${a.id}"> <img alt="" src="delete.png" width="25px"> </a></td> -->
 					 					 										
 				</tr>
 		
		</tbody>
		 
	</table>
	<a class="btn" href="boleto?acao=gerar&id=${contrato.getId()}">GERAR PDF</a>  
<!--  	<a class="btn" href="contrato?acao=novoContrato&cnpj=${cliente.cnpj}">BOLETOS EM LOTE</a> -->
</body>
</html>