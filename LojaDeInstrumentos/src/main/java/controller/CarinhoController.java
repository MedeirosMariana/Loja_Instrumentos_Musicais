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

import dao.CarrinhoDAO;
import model.Carrinho;

@WebServlet(name = "carrinho", urlPatterns = { "/carrinho", "/carrinho/adicionar", "/carrinho/listar", "/carrinho/atualizar", "/carrinho/remover" })
public class CarrinhoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CarrinhoDAO carrinhoDAO;

    public CarrinhoController() {
        carrinhoDAO = new CarrinhoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/carrinho/listar":
                    listarItens(request, response);
                    break;
                case "/carrinho/remover":
                    removerItem(request, response);
                    break;
                default:
                    listarItens(request, response);
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
                case "/carrinho/adicionar":
                    adicionarItem(request, response);
                    break;
                case "/carrinho/atualizar":
                    atualizarItem(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/carrinho/listar");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listarItens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Carrinho> itensCarrinho = carrinhoDAO.selectAll();
        request.setAttribute("itensCarrinho", itensCarrinho);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultarCarrinho.jsp");
        dispatcher.forward(request, response);
    }

    private void adicionarItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        try {
            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));

            Carrinho item = new Carrinho();
            item.setIdProduto(idProduto);
            item.setQuantidade(quantidade);

            boolean itemAdicionado = carrinhoDAO.adicionarItem(item);

            if (itemAdicionado) {
                response.sendRedirect(request.getContextPath() + "/carrinho/listar");
            } else {
                response.sendRedirect(request.getContextPath() + "/carrinho/listar?error=addFailed");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/carrinho/listar?error=invalidInput");
        }
    }

    private void atualizarItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        try {
            int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));
            int novaQuantidade = Integer.parseInt(request.getParameter("quantidade"));

            boolean itemAtualizado = carrinhoDAO.atualizarQuantidade(idCarrinho, novaQuantidade);

            if (itemAtualizado) {
                response.sendRedirect(request.getContextPath() + "/carrinho/listar");
            } else {
                response.sendRedirect(request.getContextPath() + "/carrinho/listar?error=updateFailed");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/carrinho/listar?error=invalidInput");
        }
    }

    private void removerItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        try {
            int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));

            boolean itemRemovido = carrinhoDAO.removerItem(idCarrinho);

            if (itemRemovido) {
                response.sendRedirect(request.getContextPath() + "/carrinho/listar");
            } else {
                response.sendRedirect(request.getContextPath() + "/carrinho/listar?error=removeFailed");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/carrinho/listar?error=invalidInput");
        }
    }
}