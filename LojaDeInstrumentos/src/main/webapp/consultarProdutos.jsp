<%@ page import="model.Produto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");

%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.google.com/icon?family-Material+Icons" rel="stylesheet" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20,400,0,0&icon_names=search" />
    <link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <title>Painel Administrador - Consulta de Produtos</title>
</head>
<body>

    <header>
        <div class="logo">
            <img src="imagens/logo.png" class="logo-img">
        </div>
        <h1>Painel Administrador – Consulta de Produtos</h1>
    </header>

    <div class="container-consulta">
        <div class="search-bar">
            <label for="nomeProduto">Nome do Produto:</label><br>
            <input style="" type="text" id="nomeProduto" name="nomeProduto" placeholder="Digite o nome do Produto...">
            <button type="submit">
                <span class="material-symbols-outlined">search</span>
            </button>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Categoria</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Condição</th>
                    <th>Estoque</th>
                    <th>Preço</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    if (produtos != null && !produtos.isEmpty()) {
                        for (Produto produto : produtos) {
                %>
                            <tr>
                                <td><%= produto.getCategoria() %></td>
                                <td><%= produto.getMarca() %></td>
                                <td><%= produto.getModelo() %></td>
                                <td><%= produto.getCondicao() %></td>
                                <td><%= produto.getEstoque() %></td>
                                <td><%= produto.getPreco() %></td>
                                <td>
                                    <form action="deletarProduto.jsp" method="post">
                                        <input type="hidden" name="produtoId" value="<%= produto.getIdProduto() %>">
                                        <button type="submit">Deletar</button>
                                    </form>
                                </td>
                            </tr>
                <% 
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="7">Nenhum produto cadastrado.</td>
                        </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>

    <!-- <footer></footer> -->

</body>
</html>