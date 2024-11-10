package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import utils.ConnectionFactory;

public class ProdutoDAO {
	

	public boolean insert(Produto objProduto) {
		boolean retorno = false;
		String sql = "INSERT INTO Produtos (nome_produto, descricao_produto, categoria_produto, marca_produto, modelo_produto, preco, condicao_produto, qtd_estoque, imagemBase64) values(?,?,?,?,?,?,?,?,?)";
		try (Connection conexao = ConnectionFactory.getConnection();
				PreparedStatement ps = conexao.prepareStatement(sql);) {
			
			
			ps.setString(1, objProduto.getNomeProduto());
			ps.setString(2, objProduto.getDescricao());
			ps.setString(3, objProduto.getCategoria());
			ps.setString(4, objProduto.getMarca());
			ps.setString(5, objProduto.getModelo());
			ps.setDouble(6, objProduto.getPreco());
			ps.setString(7, objProduto.getCondicao());
			ps.setInt(8, objProduto.getEstoque());
			ps.setString(9, objProduto.getImagemBase64());
			
			int linhasAfetadas = ps.executeUpdate();
			if (linhasAfetadas > 0) {
				retorno = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public boolean deleteById(int idProduto) {
	    boolean retorno = false;
	    String sql = "DELETE FROM Produtos WHERE id_produto = ?";
	    
	    try (Connection conexao = ConnectionFactory.getConnection();
	         PreparedStatement ps = conexao.prepareStatement(sql)) {
	        
	        ps.setInt(1, idProduto);
	        
	        int linhasAfetadas = ps.executeUpdate();
	        if (linhasAfetadas > 0) {
	            retorno = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return retorno;
	}
	
	public List<Produto> selectAll() {
	    List<Produto> produtos = new ArrayList<>();
	    String sql = "SELECT * FROM Produtos";
	    
	    try (Connection conexao = ConnectionFactory.getConnection();
	         PreparedStatement ps = conexao.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        
	        while (rs.next()) {
	            Produto produto = new Produto();
	            produto.setIdProduto(rs.getInt("id_produto"));
	            produto.setNomeProduto(rs.getString("nome_produto"));
	            produto.setDescricao(rs.getString("descricao_produto"));
	            produto.setCategoria(rs.getString("categoria_produto"));
	            produto.setMarca(rs.getString("marca_produto"));
	            produto.setModelo(rs.getString("modelo_produto"));
	            produto.setPreco(rs.getDouble("preco"));
	            produto.setCondicao(rs.getString("condicao_produto"));
	            produto.setEstoque(rs.getInt("qtd_estoque"));
	            produto.setImagemBase64(rs.getString("imagemBase64"));
	            
	            produtos.add(produto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return produtos;
	}

	public boolean updateById(Produto objProduto) {
	    boolean retorno = false;
	    String sql = "UPDATE Produtos SET nome_produto = ?, descricao_produto = ?, categoria_produto = ?, marca_produto = ?, modelo_produto = ?, preco = ?, condicao_produto = ?, qtd_estoque = ?, imagemBase64 = ? WHERE id_produto = ?";
	    
	    try (Connection conexao = ConnectionFactory.getConnection();
	         PreparedStatement ps = conexao.prepareStatement(sql)) {
	        
	        ps.setString(1, objProduto.getNomeProduto());
	        ps.setString(2, objProduto.getDescricao());
	        ps.setString(3, objProduto.getCategoria());
	        ps.setString(4, objProduto.getMarca());
	        ps.setString(5, objProduto.getModelo());
	        ps.setDouble(6, objProduto.getPreco());
	        ps.setString(7, objProduto.getCondicao());
	        ps.setInt(8, objProduto.getEstoque());
	        ps.setString(9, objProduto.getImagemBase64());
	        ps.setInt(10, objProduto.getIdProduto());
	        
	        int linhasAfetadas = ps.executeUpdate();
	        if (linhasAfetadas > 0) {
	            retorno = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return retorno;
	}
	
	public Produto selectById(int idProduto) {
		Produto produto = null;
	    String sql = "SELECT * FROM Produtos WHERE id_produto = ?";

	    try (Connection conexao = ConnectionFactory.getConnection();
	         PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        
	        stmt.setInt(1, idProduto);

	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            
	            produto = new Produto();
	            produto.setIdProduto(rs.getInt("id_produto"));
	            produto.setNomeProduto(rs.getString("nome_produto"));
	            produto.setDescricao(rs.getString("descricao_produto"));
	            produto.setCategoria(rs.getString("categoria_produto"));
	            produto.setMarca(rs.getString("marca_produto"));
	            produto.setModelo(rs.getString("modelo_produto"));
	            produto.setPreco(rs.getDouble("preco"));
	            produto.setCondicao(rs.getString("condicao_produto"));
	            produto.setEstoque(rs.getInt("qtd_estoque"));
	            produto.setImagemBase64(rs.getString("imagemBase64"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return produto;
	}
}