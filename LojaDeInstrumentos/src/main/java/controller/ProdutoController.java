package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

import dao.ProdutoDAO;

@WebServlet(name="produtos", urlPatterns={"/produtos","/produtos/novo","/produtos/cadastro","/produtos/listar"})
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDAO produtoDAO;

    public ProdutoController() {
        // TODO Auto-generated constructor stub
    	produtoDAO = new ProdutoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
            switch (action) {
                case "/produtos/listar":
                    listar(request, response);
                    break;
                case "/produtos/deletar":
                    deletarProduto(request, response);
                    break;
                case "/produtos/novo":
                    novoProduto(request, response);
                    break;
                case "/produtos/editar":
                    editarProduto(request, response);
                    break;
                default:
                    listar(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Produto> produtos = produtoDAO.selectAll();
        request.setAttribute("produtos", produtos); 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos/consultarProdutos.jsp"); 
        dispatcher.forward(request, response);
    }
	
	private void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    int idProduto = Integer.parseInt(request.getParameter("idProduto"));
	    Produto produto = produtoDAO.selectById(idProduto);
	    request.setAttribute("produto", produto);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos/editarProduto.jsp");
	    dispatcher.forward(request, response);
	}
	
	private void deletarProduto(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        boolean deleted = produtoDAO.deleteById(idProduto);
        
        if (deleted) {
            response.sendRedirect("produtos/listar");
        } else {
            response.sendRedirect("produtos/listar?error=true");
        }
    }
	
	private void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos/cadastroProduto.jsp");
        dispatcher.forward(request, response);
    }
	
	private void cadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeProduto = request.getParameter("nomeProduto");
        String categoria = request.getParameter("categoria");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String preco = request.getParameter("preco");
        String condicao = request.getParameter("condicao");
        String qtdEstoque = request.getParameter("qtdEstoque");
        String descricao = request.getParameter("descricao");
        
        // Processando a foto (convertendo para Base64)
        String fotoBase64 = null;
        Part fotoPart = request.getPart("fotos");
        if (fotoPart != null) {
            InputStream inputStream = fotoPart.getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            fotoBase64 = Base64.getEncoder().encodeToString(bytes);
        }
        
        // Criando o produto e setando os valores
        Produto produto = new Produto();
        produto.setNomeProduto(nomeProduto);
        produto.setCategoria(categoria);
        produto.setMarca(marca);
        produto.setModelo(modelo);
        produto.setPreco(Double.parseDouble(preco));
        produto.setCondicao(condicao);
        produto.setEstoque(Integer.parseInt(qtdEstoque));
        produto.setDescricao(descricao);
        produto.setImagemBase64(fotoBase64);
        
        // Salvando o produto no banco
        ProdutoDAO produtoDAO = new ProdutoDAO();
        boolean produtoCadastrado = produtoDAO.insert(produto);
        
        // Verificando se a inserção foi bem-sucedida
        if (produtoCadastrado) {
            response.sendRedirect("produtos/listar");
        } else {
            response.sendRedirect("produtos/novo?error=true");
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
        if ("/produtos/cadastro".equals(action)) {
            cadastrarProduto(request, response);
        } else if ("/produtos/atualizar".equals(action)) {
            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
            String nomeProduto = request.getParameter("nomeProduto");
            String categoria = request.getParameter("categoria");
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String preco = request.getParameter("preco");
            String condicao = request.getParameter("condicao");
            String qtdEstoque = request.getParameter("qtdEstoque");
            String descricao = request.getParameter("descricao");
            
            String fotoBase64 = null;
            Part fotoPart = request.getPart("fotos");
            if (fotoPart != null) {
                InputStream inputStream = fotoPart.getInputStream();
                byte[] bytes = inputStream.readAllBytes();
                fotoBase64 = Base64.getEncoder().encodeToString(bytes);
            }
            
            Produto produto = new Produto();
            produto.setIdProduto(idProduto);
            produto.setNomeProduto(nomeProduto);
            produto.setCategoria(categoria);
            produto.setMarca(marca);
            produto.setModelo(modelo);
            produto.setPreco(Double.parseDouble(preco));
            produto.setCondicao(condicao);
            produto.setEstoque(Integer.parseInt(qtdEstoque));
            produto.setDescricao(descricao);
            produto.setImagemBase64(fotoBase64);
            
            ProdutoDAO produtoDAO = new ProdutoDAO();
            boolean produtoAtualizado = produtoDAO.updateById(produto);

            if (produtoAtualizado) {
                response.sendRedirect("produtos/listar");
            } else {
                response.sendRedirect("produtos/atualizar?idProduto=" + idProduto + "&error=true");
            }
        }
	}

}
