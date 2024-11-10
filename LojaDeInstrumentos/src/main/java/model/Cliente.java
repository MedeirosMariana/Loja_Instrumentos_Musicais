package model;

public class Cliente {
	int idCliente;
	String nome;
	String email;
	String senha;
	
	public Cliente(String nome, String email, String senha, int idCliente) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Cliente() {
		
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
		
}
