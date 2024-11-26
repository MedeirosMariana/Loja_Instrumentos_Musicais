package model;

public class ItemNota {

	 private int idItemNota;
	 private int idProduto;
	 private String nomeProduto;
	 private int quantidade;
	 private double precoTotal;
	 
	
	
	public ItemNota() {}
	
	
	
	public ItemNota(int idItemNota, int idProduto, int qtdProduto, float valorUnitario) {
		super();
		this.idItemNota = idItemNota;
		this.idProduto = idProduto;
		this.qtdProduto = qtdProduto;
		this.valorUnitario = valorUnitario;
	}

	public ItemNota(int idProduto, int qtdProduto, float valorUnitario) {
		super();
		this.idProduto = idProduto;
		this.qtdProduto = qtdProduto;
		this.valorUnitario = valorUnitario;
	}

	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
		
}
