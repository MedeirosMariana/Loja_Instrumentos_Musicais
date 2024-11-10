<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="css/style3.css" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
  <title>Criar conta</title>
</head>

<body>
  <div class="container">
    <div class="welcome-section">
      <img src="imagens/logo.png" alt="Logo"/>

			<div>
				<h2>Bem-vindo de volta!</h2>
				<p>Acesse sua conta agora mesmo.</p>
			</div>

			<div class="btn-welcome-container"> 
				<button onclick="window.location.href='index.jsp'" class="btn-primary">Entrar</button>
				<a class="forgot-password">Esqueci minha senha</a>
			</div>
    </div>
    
    <div class="create-account-section">
      <h1>Crie sua conta</h1>
      <p>Preencha seus dados</p>

      <form action="<%= request.getContextPath() %>/createAccountServelet" method="POST">
        <div class="input-group">
          <span class="material-icons">person</span>
          <input type="text" name="name" placeholder="Nome" required/>
        </div>
				
        <div class="input-group">
          <span class="material-icons">email</span>
          <input type="email" name="email" placeholder="Email" required/>
        </div>

        <div class="input-group">
          <span class="material-icons">lock</span>
          <input type="password" name="password" placeholder="Senha" required/>
        </div>

        <button type="submit" class="btn-form-button">Cadastrar</button>
      </form>
      
      <div class="error-message">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
      </div>
    </div>
  </div>
</body>
</html>