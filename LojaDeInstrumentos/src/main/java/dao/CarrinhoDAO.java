package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Carrinho;
import model.Produto;
import utils.ConnectionFactory;

public class CarrinhoDAO {

	public boolean adicionarItem(Carrinho item) throws SQLException {
	    Produto produto = buscarProdutoPorId(item.getIdProduto());
	    
	    if (produto == null) {
	        System.out.println("Produto não encontrado. ID: " + item.getIdProduto());
	        return false;
	    }
	    
	    double precoTotal = produto.getPreco() * item.getQuantidade();

	    String sql = "INSERT INTO Carrinho (id_produto, quantidade, preco_total, nome_produto) VALUES (?, ?, ?, ?)";
	    
	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, item.getIdProduto());
	        stmt.setInt(2, item.getQuantidade());
	        stmt.setDouble(3, precoTotal);  
	        stmt.setString(4, produto.getNomeProduto());

	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	            return true; 
	        } else {
	            System.out.println("Nenhuma linha inserida.");
	            return false;
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao adicionar item no carrinho: " + e.getMessage());
	        throw e; 
	    }
	}
	
	public boolean atualizarQuantidade(int idCarrinho, int novaQuantidade) throws SQLException {
        String sql = "UPDATE Carrinho SET quantidade = ? WHERE id_carrinho = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, idCarrinho);
            return stmt.executeUpdate() > 0;
        }
    }
	
	public boolean removerItem(int idCarrinho) throws SQLException {
        String sql = "DELETE FROM Carrinho WHERE id_carrinho = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCarrinho);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Carrinho> selectAll() throws SQLException {
        String sql = """
                SELECT c.id_carrinho, c.id_produto, p.nome_produto, c.quantidade, (p.preco * c.quantidade) AS preco_total
                FROM Carrinho c
                JOIN Produtos p ON c.id_produto = p.id_produto
                """;
        List<Carrinho> itens = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Carrinho item = new Carrinho();
                item.setIdCarrinho(rs.getInt("id_carrinho"));
                item.setIdProduto(rs.getInt("id_produto"));
                item.setNomeProduto(rs.getString("nome_produto"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setPrecoTotal(rs.getDouble("preco_total"));

                itens.add(item);
            }
        }
        return itens;
    }
    
    public Produto buscarProdutoPorId(int idProduto) throws SQLException {
        String sql = "SELECT id_produto, nome_produto, preco FROM Produtos WHERE id_produto = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setPreco(rs.getDouble("preco"));
                return produto;
            }
        }
        return null;
    }
}
