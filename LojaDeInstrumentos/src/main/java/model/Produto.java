package model;

public class Produto {
	String nomeProduto;
	String categoria;
	String descricao;
	String marca;
	String modelo;
	String condicao;
	int estoque;
	double preco;
	
	public Produto(String nomeProduto, String categoria, String descricao, String marca, String modelo, String condicao,
			int estoque, double preco) {
		this.nomeProduto = nomeProduto;
		this.categoria = categoria;
		this.descricao = descricao;
		this.marca = marca;
		this.modelo = modelo;
		this.condicao = condicao;
		this.estoque = estoque;
		this.preco = preco;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
