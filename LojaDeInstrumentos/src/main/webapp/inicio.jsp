<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<style>
body {
	background-color: red; /* Mudança de teste */
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
				<li style="margin-left: 20px;"><a href="#home"
					style="text-decoration: none; color: white;">Instrumentos</a></li>
				<!-- Ajuste a cor do texto -->
			</ul>
		</div>

		<div>
			<button type="submit"
				style="background: none; border: none; color: white; cursor: pointer;">
				<span class="material-icons"> shopping_cart </span>
			</button>

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


	<main>
		<div class="instrument-section">
			<div class="instrument-card">
				<img src="imagens/imgInstrumentos/cordas.png" alt="Violão">
			</div>
			<p>Cordas</p>
			<!-- Texto agora fora do "card" -->
			<button>Comprar</button>
			<!-- Botão agora fora do "card" -->
		</div>

		<div class="instrument-section">
			<div class="instrument-card">
				<img src="imagens/imgInstrumentos/percussao.png" alt="Percussão">
			</div>
			<p>Percussão</p>
			<button>Comprar</button>
		</div>

		<div class="instrument-section">
			<div class="instrument-card">
				<img src="imagens/imgInstrumentos/teclado.png" alt="Teclado">
			</div>
			<p>Teclado</p>
			<button>Comprar</button>
		</div>

		<div class="instrument-section">
			<div class="instrument-card">
				<img src="imagens/imgInstrumentos/sopro.png" alt="Sopro">
			</div>
			<p>Sopro</p>
			<button>Comprar</button>
		</div>

		<div class="instrument-section">
			<div class="instrument-card">
				<img src="imagens/imgInstrumentos/eletronicos.png" alt="Eletrônicos">
			</div>
			<p>Eletrônicos</p>
			<button>Comprar</button>
		</div>
	</main>
</body>
</html>
