<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produtos</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <header>
        <div class="logo">
            <img src="imagens/logo.png" class="logo-img">
        </div>
        <h1>Painel Administrador – Cadastro de Produtos</h1>
    </header>
    <div class="container">     
        <div class="container-cadastro-produto">
            <form action="produtos/cadastro" method="post">
                <div class="form-group">
                    <label for="nomeProduto">Nome do Produto</label>
                    <input type="text" id="nomeProduto" name="nomeProduto" placeholder="Digite o nome do Produto">
                </div>
                <div class="form-group">
                    <label for="categoria">Categoria</label>
                    <select id="categoria" name="categoria">
                        <option value="">Escolha a categoria</option>
                        <option value="sopro">Sopro</option>
                        <option value="cordas">Cordas</option>
                        <option value="teclado">Teclado</option>
                        <option value="eletronico">Eletrônicos</option>
                        <option value="percussão">Percussão</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="marca">Marca</label>
                    <input type="text" id="marca" name="marca" placeholder="Digite a marca">
                </div>
                <div class="form-group">
                    <label for="modelo">Modelo</label>
                    <input type="text" id="modelo" name="modelo" placeholder="Digite o modelo">
                </div>
                <div class="form-group">
                    <label for="preco">Preço</label>
                    <input type="text" id="preco" name="preco" placeholder="Digite o preço">
                </div>
                <div class="form-group">
                    <label for="condicao">Condição</label>
                    <select id="condicao" name="condicao">
                        <option value="">Escolha a condição</option>
                        <option value="novo">Novo</option>
                        <option value="usado">Usado</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="qtdEstoque">Qtd em estoque</label>
                    <input type="number" id="qtdEstoque" name="qtdEstoque" placeholder="Digite a qtd em estoque">
                </div>
                <div class="form-group">
                    <label for="fotoUrl">URL da Imagem:</label>
                    <input type="text" id="fotoUrl" name="fotoUrl"><br>
                </div>
                <div class="form-group descricao">
                    <label for="descricao">Descrição</label>
                    <textarea id="descricao" name="descricao" placeholder="Detalhes sobre o produto, como materiais, características técnicas."></textarea>
                </div>
                <div class="form-group">
                    <button type="submit">Cadastrar Produto</button>
                </div>
            </form>
        </div>
    </div>
    <!-- <footer></footer> -->
</body>
</html>