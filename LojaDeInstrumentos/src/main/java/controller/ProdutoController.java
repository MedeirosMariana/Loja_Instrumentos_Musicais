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
            if ("/produtos/cadastro".equals(action)) {
                cadastrarProduto(request, response);
            } else if ("/produtos/atualizar".equals(action)) {
                atualizarProduto(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editarProduto.jsp");
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

        String fotoBase64 = null;
        Part fotoPart = request.getPart("fotos");
        if (fotoPart != null) {
            InputStream inputStream = fotoPart.getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            fotoBase64 = Base64.getEncoder().encodeToString(bytes);
        }

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

        boolean produtoCadastrado = produtoDAO.insert(produto);

        if (produtoCadastrado) {
            response.sendRedirect("produtos/listar");
        } else {
            response.sendRedirect("produtos/novo?error=true");
        }
    }

    private void atualizarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
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

        boolean produtoAtualizado = produtoDAO.updateById(produto);

        if (produtoAtualizado) {
            response.sendRedirect("produtos/listar");
        } else {
            response.sendRedirect("produtos/atualizar?idProduto=" + idProduto + "&error=true");
        }
    }
}