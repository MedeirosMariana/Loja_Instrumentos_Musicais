<%@ page import="model.Carrinho" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    List<Carrinho> itensCarrinho = (List<Carrinho>) request.getAttribute("itensCarrinho");
    double totalGeral = 0;
%>

<!DOCTYPE html>

<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="/LojaDeInstrumentos/css/style.css">
  <title>Carrinho de Compras</title>
</head>
<body>
  <div class="container">
    <header>
      <div class="logo">
        <img src="imagens/logo.png" alt="" />
      </div>
      <h1>Carrinho de Compras</h1>
    </header>

    <main>
      <section class="cart-items">
        <div class="item-header">
          <span>Item</span>
          <span class="label">Preço</span>
          <span class="label">Qtd</span>
    	      <span></span>
        </div>

        <%
          if (itensCarrinho != null && !itensCarrinho.isEmpty()) {
              for (Carrinho item : itensCarrinho) {
                  totalGeral += item.getPrecoTotal();
        %>
        <div class="cart-item">
          <span class="item-details"><%= item.getNomeProduto() %></span>
          <span class="label">R$ <%= String.format("%.2f", item.getPrecoTotal()) %></span>
          <div class="item-quantity">
            <form action="<%= request.getContextPath() %>/carrinho/atualizar" method="post" style="display: inline;">
              <input type="hidden" name="idCarrinho" value="<%= item.getIdCarrinho() %>">
              <button type="submit" name="quantidade" value="<%= item.getQuantidade() - 1 %>" class="quantity-btn" <%= (item.getQuantidade() > 1) ? "" : "disabled" %>>-</button>
              <input type="text" name="quantidade" value="<%= item.getQuantidade() %>" readonly />
              <button type="submit" name="quantidade" value="<%= item.getQuantidade() + 1 %>" class="quantity-btn">+</button>
            </form>
          </div>
          <div class="item-actions">
            <form action="<%= request.getContextPath() %>/carrinho/remover" method="post" style="display: inline;">
              <input type="hidden" name="idCarrinho" value="<%= item.getIdCarrinho() %>">
              <button type="submit" class="delete-btn">
                <img src="imagens/delete-icon.png" alt="Remover" />
              </button>
            </form>
          </div>
        </div>
        <% 
              }
          } else { 
        %>
        <p>Carrinho vazio.</p>
        <% } %>
      </section>

      <aside class="summary">
        <h1>Resumo</h1>
        <div class="summary-detail">
          <span>Total geral</span>
          <span>R$ <%= String.format("%.2f", totalGeral) %></span>
        </div>
        <button class="checkout-btn">Finalizar Compra</button>
      </aside>
    </main>
    <!-- RodapÃ© -->
    <footer></footer>
  </div>
</body>
</html>
