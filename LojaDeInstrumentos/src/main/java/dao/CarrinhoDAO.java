package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Carrinho;
import utils.ConnectionFactory;

public class CarrinhoDAO {

    public boolean adicionarItem(Carrinho item) throws SQLException {
        String sql = "INSERT INTO Carrinho (id_produto, quantidade) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getIdProduto());
            stmt.setInt(2, item.getQuantidade());
            return stmt.executeUpdate() > 0;
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
}
