<%@ page import="model.Cliente" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar Clientes</title>
<link href="https://fonts.google.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20,400,0,0&icon_names=search" />
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
</head>
<body>

	<header>
		<div class="logo">
			<img src="imagens/logo.png" class="logo-img">
		</div>
		<h1>Painel Administrador - Consulta de Clientes</h1>
	</header>

	<div class="container">
		<!-- Seção de busca -->
		<div class="search-section">
			<form action="<%= request.getContextPath() %>/consultarClientes" method="post">
				<label for="searchDate"
					style="font-size: 30px; color: #8C441B; font-weight: 700;">Consulte clientes por nome ou ID</label><br>
				<input type="text" id="searchDate" name="searchDate"
					placeholder="Digite a informação sobre o cliente"
					style="width: 90%; border: 2px solid #8b4d2d; border-radius: 20px; background-color: #F3E4CF; color: #8C441B; font-size: 15px; font-weight: 500; padding: 10px 20px; margin-bottom: 20px">
				<button type="submit"
					style="padding: 8px 8px 6px 8px; border: none; background-color: #8b4d2d; color: white; border-radius: 5px; cursor: pointer; font-size: 16px; margin-left: 10px;">
					<span class="material-symbols-outlined">search</span>
				</button>
			</form>
		</div>

		<!-- Tabela de clientes -->
		<table>
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Senha</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (clientes != null && !clientes.isEmpty()) {
						for (Cliente cliente : clientes) {
				%>
							<tr>
								<td><%= cliente.getNome() %></td>
								<td><%= cliente.getEmail() %></td>
								<td><%= cliente.getSenha() %></td>
								<td>
									<a href="<%= request.getContextPath() %>/clientes/editar?idCliente=<%= cliente.getIdCliente() %>">Editar</a>
									<form action="<%= request.getContextPath() %>/clientes/deletar" method="post" style="display:inline;">
										<input type="hidden" name="idCliente" value="<%= cliente.getIdCliente() %>">
										<button type="submit">Deletar</button>
									</form>
								</td>
							</tr>
				<%
						}
					} else {
				%>
						<tr>
							<td colspan="4" style="text-align: center; color: #8C441B;">Nenhum cliente encontrado.</td>
						</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
