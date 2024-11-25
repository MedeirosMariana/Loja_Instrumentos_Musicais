package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

@WebServlet(name = "produtos", urlPatterns = { "/produtos", "/produtos/novo", "/produtos/cadastro", "/produtos/listar", "/produtos/deletar", "/produtos/editar", "/produtos/atualizar" })
public class ProdutoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        produtoDAO = new ProdutoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
        	switch (action) {
            case "/produtos/cadastro":
                cadastrarProduto(request, response);
                break;
            case "/produtos/atualizar":
                atualizarProduto(request, response);
                break;
            case "/produtos/deletar":
                deletarProduto(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/produtos/listar");
                break;
        }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	List<Produto> produtos = produtoDAO.selectAll();
        request.setAttribute("produtos", produtos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultarProdutos.jsp");
        dispatcher.forward(request, response);
    }

    private void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        Produto produto = produtoDAO.selectById(idProduto);
        request.setAttribute("produto", produto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editarproduto.jsp");
        dispatcher.forward(request, response);
    }

    private void deletarProduto(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

    	int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        boolean deleted = produtoDAO.deleteById(idProduto);

        if (deleted) {
        	response.sendRedirect(request.getContextPath() + "/produtos/listar");
        } else {
            response.sendRedirect("produtos/listar?error=true");
        }
    }

    private void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroProduto.jsp");
        dispatcher.forward(request, response);
    }

    private void cadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String nomeProduto = request.getParameter("nomeProduto");
        String categoria = request.getParameter("categoria");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String preco = request.getParameter("preco");
        String condicao = request.getParameter("condicao");
        String qtdEstoque = request.getParameter("qtdEstoque");
        String descricao = request.getParameter("descricao");
        String fotoUrl = request.getParameter("fotoUrl");
        
        Produto produto = new Produto();
        produto.setNomeProduto(nomeProduto);
        produto.setCategoria(categoria);
        produto.setMarca(marca);
        produto.setModelo(modelo);
        produto.setPreco(Double.parseDouble(preco));
        produto.setCondicao(condicao);
        produto.setEstoque(Integer.parseInt(qtdEstoque));
        produto.setDescricao(descricao);
        produto.setImagemBase64(fotoUrl);

        boolean produtoCadastrado = produtoDAO.insert(produto);

        if (produtoCadastrado) {
        	response.sendRedirect(request.getContextPath() + "/produtos/listar");
            
        } else {
            response.sendRedirect("produtos/novo?error=true");
        }
    }

    private void atualizarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        try {
            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
            String nomeProduto = request.getParameter("nomeProduto");
            String categoria = request.getParameter("categoria");
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String preco = request.getParameter("preco");
            String condicao = request.getParameter("condicao");
            String qtdEstoque = request.getParameter("qtdEstoque");
            String descricao = request.getParameter("descricao");
            String fotoUrl = request.getParameter("fotoUrl");

            if (nomeProduto == null || nomeProduto.isEmpty() || preco == null || preco.isEmpty()) {
                throw new IllegalArgumentException("Nome e preço são obrigatórios.");
            }

            Produto produto = new Produto();
            produto.setIdProduto(idProduto);
            produto.setNomeProduto(nomeProduto);
            produto.setCategoria(categoria);
            produto.setMarca(marca);
            produto.setModelo(modelo);
            produto.setPreco(Double.parseDouble(preco));
            produto.setCondicao(condicao);
            produto.setEstoque(qtdEstoque != null && !qtdEstoque.isEmpty() ? Integer.parseInt(qtdEstoque) : 0);
            produto.setDescricao(descricao);
            produto.setImagemBase64(fotoUrl);

            boolean produtoAtualizado = produtoDAO.updateById(produto);

            if (produtoAtualizado) {
                response.sendRedirect(request.getContextPath() + "/produtos/listar");
            } else {
                response.sendRedirect(request.getContextPath() + "/produtos/atualizar?idProduto=" + idProduto + "&error=true");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/produtos/listar?error=invalidNumber");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/produtos/listar?error=missingFields");
        }
    }
}