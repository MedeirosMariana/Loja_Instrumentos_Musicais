CREATE DATABASE loja;
USE loja;

CREATE TABLE IF NOT EXISTS Clientes(
	id_cliente INT AUTO_INCREMENT,
    email VARCHAR(300) UNIQUE NOT NULL,
	senha VARCHAR(100) NOT NULL,
    
    PRIMARY KEY (id_cliente)
);

CREATE TABLE IF NOT EXISTS Produtos(

	id_produto INT AUTO_INCREMENT,
    nome_produto VARCHAR(200) NOT NULL,
    descricao_produto VARCHAR(300) NOT NULL,
    categoria_produto VARCHAR(100) NOT NULL,
    marca_produto VARCHAR(200) NOT NULL,
    modelo_produto VARCHAR(200) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    condicao_produto VARCHAR(200) NOT NULL,
    qtd_estoque INT NOT NULL,
    imagemBase64 LONGTEXT,
    
    PRIMARY KEY (id_produto)
);