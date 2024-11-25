package controller;

import dao.CarrinhoDAO;
import model.ItemCarrinho;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.gson.Gson;

@WebServlet("/carrinho")
public class CarrinhoServlet extends HttpServlet {

    private final CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
    private final Gson gson = new Gson(); 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Adicionar item no carrinho
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ItemCarrinho item = gson.fromJson(request.getReader(), ItemCarrinho.class); 
        try {
            carrinhoDAO.adicionarItem(item);
            response.getWriter().write("{\"message\": \"Item adicionado com sucesso!\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Erro ao adicionar item: " + e.getMessage() + "\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Atualizar quantidade de item no carrinho
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ItemCarrinho item = gson.fromJson(request.getReader(), ItemCarrinho.class); // Leitura do JSON do corpo da requisição

        try {
            carrinhoDAO.atualizarQuantidade(item);
            response.getWriter().write("{\"message\": \"Quantidade do item atualizada!\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Erro ao atualizar item: " + e.getMessage() + "\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Remover item do carrinho
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho")); // Obtendo o id do carrinho da URL

        try {
            carrinhoDAO.removerItem(idCarrinho);
            response.getWriter().write("{\"message\": \"Item removido com sucesso!\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Erro ao remover item: " + e.getMessage() + "\"}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Listar itens do carrinho
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            // Convertendo a lista de itens para JSON
            String jsonResponse = gson.toJson(carrinhoDAO.listarItens());
            response.getWriter().write(jsonResponse);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Erro ao listar itens: " + e.getMessage() + "\"}");
        }
    }
}
