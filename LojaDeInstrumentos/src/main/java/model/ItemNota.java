package model;

public class ItemNota {

    private int idItemNota;
    private int idProduto;
    private String nomeProduto;
    private int qtdProduto;  
    private double precoTotal;  

    public ItemNota() {}

    public ItemNota(int idItemNota, int idProduto, String nomeProduto, int qtdProduto, double precoTotal) {
        this.idItemNota = idItemNota;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.qtdProduto = qtdProduto;
        this.precoTotal = precoTotal;
    }

    public ItemNota(int idProduto, String nomeProduto, int qtdProduto, double precoTotal) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.qtdProduto = qtdProduto;
        this.precoTotal = precoTotal;
    }

    public int getIdItemNota() {
        return idItemNota;
    }

    public void setIdItemNota(int idItemNota) {
        this.idItemNota = idItemNota;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
