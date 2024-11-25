<!DOCTYPE html>

<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/cart-style.css">
  <title>Carrinho de Compras</title>
</head>
<body>
  <div class="container">
    <!-- Cabeçalho -->
    <header>
      <div class="logo">
        <img src="imagens/logo.png" alt="" />
      </div>
      <h1>Carrinho de Compras</h1>
    </header>

    <!-- Conteúdo Principal -->
    <main>
      <section class="cart-items">
        <div class="item-header">
          <span>Item</span>
          <span class="label">Preço</span>
          <span class="label">Qtd</span>
          <span></span>
        </div>

        <div class="cart-item">
          <span class="item-details">Guitarra Tagima Woodstock TW-61 – Fiesta Red</span>

          <span class="label">R$ 1.385,10</span>

          <div class="item-quantity">
            <button class="quantity-btn">-</button>
            <input type="text" value="1" readonly />
            <button class="quantity-btn">+</button>
          </div>

          <div class="item-actions">
            <button class="edit-btn">
              <img src="imagens/edit-icon.png' />" alt="" />
            </button>

            <button class="delete-btn">
              <img src="imagens/delete-icon.png' />" alt="" />
            </button>
          </div>
        </div>
      </section>

      <!-- Resumo -->
      <aside class="summary">
        <h1>Resumo</h1>

        <div class="summary-detail">
          <span>Sub-total</span>
          <span>R$ 1.385,10</span>
        </div>

        <div class="summary-total">
          <span>Total geral</span>
          <span>R$ 1.385,10</span>
        </div>
        <button class="checkout-btn">Finalizar Compra</button>
      </aside>
    </main>

    <!-- Rodapé -->
    <footer></footer>
  </div>
</body>
</html>
