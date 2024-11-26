<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gravar Nota Fiscal</title>
</head>
<body>

	<c:if test="${not empty sucesso}">
		<div style="color: green;">${sucesso}</div>
	</c:if>

    <h2>Cadastro de Nota Fiscal</h2>
    
    <form action="novo" method="post">
        <!-- Campo para data da nota -->
        <label for="dataNota">Data da Nota:</label>
        <input type="date" name="dataNota" id="dataNota" required><br><br>

        <h3>Produtos</h3>
        <div id="produtos">
            <div class="produto">
                <label for="idProduto">ID do Produto:</label>
                <input type="text" name="vetorIdProdutos[]" required>
                <label for="qtdProduto">Quantidade:</label>
                <input type="number" name="vetorQtdProdutos[]" required>
                <label for="precoTotal">Preço Total:</label>
                <input type="number" name="vetorPrecoTotal[]" required>
                <br><br>
            </div>
        </div>
        
        <!-- Botão para adicionar mais produtos -->
        <button type="button" onclick="adicionarProduto()">Adicionar Produto</button><br><br>

        <!-- Botão de envio -->
        <input type="submit" value="Gravar Nota Fiscal">
    </form>

    <script>
        function adicionarProduto() {
            var div = document.createElement("div");
            div.className = "produto";
            
            div.innerHTML = `
                <label for="idProduto">ID do Produto:</label>
                <input type="text" name="vetorIdProdutos[]" required>
                
                <label for="qtdProduto">Quantidade:</label>
                <input type="number" name="vetorQtdProdutos[]" required>
                
                <label for="precoTotal">Preço Total:</label>
                <input type="number" name="vetorPrecoTotal[]" required>
                
                <br><br>
            `;
            document.getElementById("produtos").appendChild(div);
        }
    </script>
</body>
</html>
