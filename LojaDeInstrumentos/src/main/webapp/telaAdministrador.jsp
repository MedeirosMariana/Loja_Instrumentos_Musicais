<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Tela Administrador</title>
		<link rel="stylesheet" href="css/style2.css">
		<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
 
	</head>
	<body>

    <div class="banner">
        <img src="imagens/FundoInstrumentos.png" alt="Banner da Loja de Instrumentos" class="banner-img">
        
    </div>
    
    <h1 class="title-adm">Painel do Administrador</h1>
    
    <div class="grid-container">
    
        <div class="grid-item">
            <button class="buttom-style" onclick="window.location.href='cadastroproduto.jsp'">Cadastrar Produtos</button>
            <button class="buttom-style" onclick="window.location.href='relatorios.jsp'">Relatórios</button>
        </div>
        <div class="grid-item">
            <button class="buttom-style" onclick="window.location.href='consultarProdutos.jsp'">Consultar Produtos</button>
            <button class="buttom-style" onclick="window.location.href='consultarClientes.jsp'">Consultar Clientes</button>
        </div>
        
    </div>
	

	</body>
</html>