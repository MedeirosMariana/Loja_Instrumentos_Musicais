<%@ page import="model.Produto" %>
<%@ page import="dao.ProdutoDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Produto</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <header>
        <div class="logo">
            <img src="imagens/logo.png" class="logo-img">
        </div>
        <h1>Painel Administrador – Edição de Produto</h1>
    </header>
    <div class="container">     
        <div class="container-cadastro-produto">
            <form action="produtos/atualizar" method="post" enctype="multipart/form-data">
                <% 
                    int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    Produto produto = produtoDAO.selectById(idProduto);
                %>
                <input type="hidden" name="idProduto" value="<%= produto.getIdProduto() %>">
                <div class="form-group">
                    <label for="nomeProduto">Nome do Produto</label>
                    <input type="text" id="nomeProduto" name="nomeProduto" value="<%= produto.getNomeProduto() %>" placeholder="Digite o nome do Produto">
                </div>
                <div class="form-group">
                    <label for="categoria">Categoria</label>
                    <select id="categoria" name="categoria">
                        <option value="">Escolha a categoria</option>
                        <option value="sopro" <%= "sopro".equals(produto.getCategoria()) ? "selected" : "" %>>Sopro</option>
                        <option value="cordas" <%= "cordas".equals(produto.getCategoria()) ? "selected" : "" %>>Cordas</option>
                        <option value="teclado" <%= "teclado".equals(produto.getCategoria()) ? "selected" : "" %>>Teclado</option>
                        <option value="eletronico" <%= "eletronico".equals(produto.getCategoria()) ? "selected" : "" %>>Eletrônicos</option>
                        <option value="percussão" <%= "percussão".equals(produto.getCategoria()) ? "selected" : "" %>>Percussão</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="marca">Marca</label>
                    <input type="text" id="marca" name="marca" value="<%= produto.getMarca() %>" placeholder="Digite a marca">
                </div>
                <div class="form-group">
                    <label for="modelo">Modelo</label>
                    <input type="text" id="modelo" name="modelo" value="<%= produto.getModelo() %>" placeholder="Digite o modelo">
                </div>
                <div class="form-group">
                    <label for="preco">Preço</label>
                    <input type="text" id="preco" name="preco" value="<%= produto.getPreco() %>" placeholder="Digite o preço">
                </div>
                <div class="form-group">
                    <label for="condicao">Condição</label>
                    <select id="condicao" name="condicao">
                        <option value="">Escolha a condição</option>
                        <option value="novo" <%= "novo".equals(produto.getCondicao()) ? "selected" : "" %>>Novo</option>
                        <option value="usado" <%= "usado".equals(produto.getCondicao()) ? "selected" : "" %>>Usado</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="qtdEstoque">Qtd em estoque</label>
                    <input type="number" id="qtdEstoque" name="qtdEstoque" value="<%= produto.getEstoque() %>" placeholder="Digite a qtd em estoque">
                </div>
                <div class="form-group">
                    <label for="fotos">Fotos do Produto</label>
                    <input type="file" id="fotos" name="fotos">
                </div>
                <div class="form-group descricao">
                    <label for="descricao">Descrição</label>
                    <textarea id="descricao" name="descricao" placeholder="Detalhes sobre o produto, como materiais, características técnicas."><%= produto.getDescricao() %></textarea>
                </div>
                <div class="form-group">
                    <button type="submit">Atualizar Produto</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>