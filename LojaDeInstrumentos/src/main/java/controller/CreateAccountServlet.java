package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

import java.io.IOException;

import dao.ClienteDAO;

@WebServlet("/createAccountServelet")
public class CreateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("name");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setSenha(senha);

        ClienteDAO clienteDAO = new ClienteDAO();
        boolean clienteCadastrado = clienteDAO.insert(cliente);

        if (clienteCadastrado) {
            response.sendRedirect("index.jsp");
        }else if (clienteDAO.selectByEmail(cliente.getEmail()) != null) {
            request.setAttribute("errorMessage", "Este e-mail já está em uso.");
            request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
            return;
        } else {
            request.setAttribute("errorMessage", "Erro ao cadastrar cliente.");
            request.getRequestDispatcher("cadastroCliente.jsp").forward(request, response);
        }
    }
}