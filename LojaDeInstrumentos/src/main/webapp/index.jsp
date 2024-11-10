<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="css/style4.css" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
  <title>Login</title>
</head>
<body>
  <header class="login-header">
    <img src="imagens/logo.png" alt="Logo"/>
    <h1>Faça login na sua conta</h1>
  </header>
  
  <main class="login-content">
    <form action="login" method="POST">
      <div class="login-field">
        <label for="email">E-mail</label>
        <div class="input-wrapper">
          <span class="material-icons">email</span>
          <input type="email" id="email" name="email" placeholder="Digite seu e-mail" required/>
        </div>
      </div>
      
      <div class="login-field">
        <label for="password">Senha</label>
        <div class="input-wrapper">
          <span class="material-icons">lock</span>
          <input type="password" id="password" name="password" placeholder="Digite sua senha" required/> 
        </div>
      </div>

      <div class="login-actions">
        <a href="#" class="forgot-password">Esqueceu sua senha?</a>
        <button type="submit">Entrar</button>
      </div>
    </form>
  </main>

  <footer class="login-footer">
    <span>Não tem cadastro?</span>
    <button type="button"  onclick="window.location.href='cadastroCliente.jsp'">Cadastre-se</button>
  </footer>
</body>
</html>