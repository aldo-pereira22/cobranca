<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<title>Cadastro de Boletos</title>
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


	
	<form action="boletos" method="post">
		<input type="hidden" name="id" id="id" />
		<p><input type="text" name="input-valor" placeholder="Digite o Valor" size="70" value="${boleto.getValor() }"/></p>
		<p><input type="text" name="input-descricao" placeholder="Descri�ao" size="70" value="${boleto.getDescricao() }"/></p>
		<p><input type="text" name="input-codigo" placeholder="Codigo" size="70" value="${ boleto.getCodigo() }"/></p>
		
		
		

		<p><input type="submit" name="btn-salva" value="salvar"/></p>
	</form>
	
		<footer>
		<div class="container">
			<div class="footer_menu">
				<div class="div1"> 
									SISTEMA DE COBRAN�A || DESENVOLVIDO POR: ALDO PEREIRA E JO�O VICTOR GONTIJO
				 </div>
				
			
			</div>
		</div>
	</footer>
</body>
</html>