<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDITAR BOLETO</title>
</head>
<body>

<h2> Página de Editar Boleto</h2>


<form action="boletos" method="post">

		<p><input type="text" name="input-valor" placeholder="Digite o Valor" size="70" value="${boleto.getValor() }"/></p>
		<p><input type="text" name="input-descricao" placeholder="Descriçao" size="70" value="${boleto.getDescricao() }"/></p>
		<p><input type="text" name="input-codigo" placeholder="Codigo" size="70" value="${ boleto.getCodigo() }"/></p>

		<p><input type="submit" name="btn-salva" value="salvar"/></p>
</form>


</body>
</html>