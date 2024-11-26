package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

import java.io.IOException;
import java.util.List;

@WebServlet("/consultarClientes")
public class ConsultarClienteController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro de busca enviado pelo formulário
        String searchParam = request.getParameter("searchDate");

        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes;

        // Se o parâmetro estiver vazio, busca todos os clientes
        if (searchParam == null || searchParam.trim().isEmpty()) {
            clientes = clienteDAO.selectAll();
        } else {
            try {
                // Verifica se o parâmetro é um número (busca por ID)
                int id = Integer.parseInt(searchParam);
                Cliente cliente = clienteDAO.selectById(id);
                clientes = cliente != null ? List.of(cliente) : List.of();
            } catch (NumberFormatException e) {
                // Se não for número, busca por nome
                clientes = clienteDAO.selectByNome(searchParam); // Você precisa implementar este método
            }
        }

        // Adiciona os clientes encontrados ao request
        request.setAttribute("clientes", clientes);

        // Encaminha para a página JSP
        request.getRequestDispatcher("consultarClientes.jsp").forward(request, response);
    }
}
