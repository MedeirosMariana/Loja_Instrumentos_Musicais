CREATE DATABASE loja;
USE loja;

CREATE TABLE IF NOT EXISTS Clientes(
	id_cliente INT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
	senha VARCHAR(100) NOT NULL,
    
    PRIMARY KEY (id_cliente)
);

CREATE TABLE IF NOT EXISTS Produtos(

	id_produto INT AUTO_INCREMENT,
    nome_produto VARCHAR(255) NOT NULL,
    descricao_produto VARCHAR(255) NOT NULL,
    categoria_produto VARCHAR(100) NOT NULL,
    marca_produto VARCHAR(255) NOT NULL,
    modelo_produto VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    condicao_produto VARCHAR(200) NOT NULL,
    qtd_estoque INT NOT NULL,
    imagemBase64 LONGTEXT,
    
    PRIMARY KEY (id_produto)
);


CREATE TABLE IF NOT EXISTS Carrinho (
    id_carrinho INT AUTO_INCREMENT,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_carrinho),
    FOREIGN KEY (id_produto) REFERENCES Produtos(id_produto)
);
