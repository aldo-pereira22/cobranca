<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
		<title>Cadastro de Clientes</title>
		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
	

		<form action="clientes" method="post">

			<input type="hidden" name="id" id="id" />
			CNPJ <input required type="text" name="input-cnpj" size="30" value="${cliente.getCnpj()}" />
			Nome <input required type="text" name="input-nome" size="70" value="${cliente.getNome()}" />
			<p> Nome Fantasia <input type="text" name="input-nomeFantasia" size="70"
					value="${cliente.getNomeFantasia()}" /></p>

			<p>CEP <input type="text" name="input-cep" size="30" value="${cliente.getCep()}" />
				Logradouro <input type="text" name="input-logradouro" size="70" value="${cliente.getLogradouro()}" />
			</p>

			<p>Numero <input type="text" name="input-numero" size="30" value="${cliente.getNumero()}" />
				Complemento <input type="text" name="input-complemento" size="70" value="${cliente.getComplemento()}" />
			</p>

			<p>UF <select id="uf" name="cbx-uf" style="width:60px">
					<option selected>---></option>
				</select>

				Municipio <select required id="municipio" name="cbx-municipio" style="width:300px">
					<option selected></option>
				</select>

			</p>
			<p><input type="submit" name="btn-salva" value="salvar" /></p>

		</form>
	</body>
	<script>
		getUF();
		var data = {};
		const select_uf = document.getElementById('uf');
		const select_municipio = document.getElementById('municipio');

		select_uf.addEventListener('change', selectedItemUf)
		select_municipio.addEventListener('change', selectedItemMunicipio)
		function selectedItemUf(e) {
			let uf = select_uf.options[select_uf.selectedIndex].text;
			data = {
				...data, uf
			}
			removeOptions(select_municipio)
			getMunicipio(uf);
		}
		function selectedItemMunicipio(e) {
			let municipio = select_municipio.options[select_municipio.selectedIndex].text;
			data = {
				...data, municipio
			}
			console.log(data)
		}

		function getUF() {
			axios.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados').then(response => {
				let data = response.data;
				data.map(uf => {
					let option = document.createElement("option");
					option.text = uf.sigla
					select_uf.add(option);
				}
				);
			})
		}
		function getMunicipio(uf) {
			console.log(uf);
			let url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + uf + "/municipios";
			console.log(url);
			axios.get(url).then(response => {
				let data = response.data;
				data.map(mucipio => {
					let option = document.createElement("option");
					option.text = mucipio.nome
					select_municipio.add(option);
				}
				);
			})
		}
		function removeOptions(selectElement) {
			let i;
			let L = selectElement.options.length - 1;
			for (i = L; i >= 0; i--) {
				selectElement.remove(i);
			}
		}
	</script>

	</html>