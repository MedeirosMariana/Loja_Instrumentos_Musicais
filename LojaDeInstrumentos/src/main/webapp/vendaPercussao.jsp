<%@page import="model.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <style>
        body {
            background-color: red;
        }

        .produto-card {
            border: 1px solid #ddd;
            padding: 16px;
            margin: 10px;
            text-align: center;
            width: 200px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        .produto-card img {
            width: 100%;
            height: auto;
            border-radius: 8px;
        }

        .produto-card h3 {
            font-size: 18px;
            margin: 10px 0;
        }

        .produto-card p {
            font-size: 14px;
            color: #555;
        }

        .produto-card button {
            padding: 8px 16px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }

        .produto-card button:hover {
            background-color: #218838;
        }

        .produtos-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }
    </style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loja de Instrumentos Musicais</title>
    <link rel="stylesheet" href="css/style5.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet">
</head>

<body>

    <!-- Navbar -->
    <nav
        style="display: flex; align-items: center; justify-content: space-between; background-color: #3C2921; padding: 0.5px 20px;">
        <div style="display: flex; align-items: center;">
            <img src="imagens/logo.png" alt="Logo da Loja" class="logo">
            <!-- Ajuste a altura máxima e margem conforme necessário -->
            <ul style="list-style: none; padding: 0; margin: 0; display: flex;">
                <li style="margin-left: 20px;"><a href="inicio.jsp"
                    style="text-decoration: none; color: white;">Instrumentos</a></li>
                <!-- Ajuste a cor do texto -->
            </ul>
        </div>

        <div>
            <a href="<%= request.getContextPath() %>/carrinho/listar" style="text-decoration: none;">
                <button type="button" style="background: none; border: none; color: white; cursor: pointer;">
                    <span class="material-icons">shopping_cart</span>
                </button>
            </a>

            <button type="submit" style="background: none; border: none; color: white; cursor: pointer;">
                <span class="material-icons">
                    person
                </span>
            </button>
        </div>
    </nav>

    <!-- Banner -->
    <section class="banner">
        <img src="imagens/FundoInstrumentos.png"
            alt="Banner de Instrumentos Musicais">
        <div class="banner-text">
            <h1>Bem-vindo à Loja de Instrumentos Musicais</h1>
            <p>Encontre o instrumento perfeito para você!</p>
        </div>
    </section>

    <!-- Produtos -->
    <section class="produtos-container">
        <% 
            if (produtos != null && !produtos.isEmpty()) {
                for (Produto produto : produtos) {
        %>
                <div class="produto-card">
                    
                    <h3><%= produto.getNomeProduto() %></h3>
                    <p>Marca: <%= produto.getMarca() %></p>
                    <p>Modelo: <%= produto.getModelo() %></p>
                    <p>Preço: R$ <%= produto.getPreco() %></p>
                    <form action="<%= request.getContextPath() %>/carrinho/adicionar" method="post">
					    <input type="hidden" name="idProduto" value="<%= produto.getIdProduto() %>">
					    <button type="submit">Comprar</button>
					</form>
                </div>
        <% 
            }
        } else {
        %>
            <p>Nenhum produto disponível.</p>
        <% 
            }
        %>
    </section>

</body>
</html>