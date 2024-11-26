package controller;

import java.io.IOException;

import dao.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final String EMAIL_ADM = "adm@example.com";
    private static final String PASSWORD_ADM = "adm123";
    
    public LoginServlet() {
    	super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        if (EMAIL_ADM.equals(email) && PASSWORD_ADM.equals(senha)) {
            response.sendRedirect(request.getContextPath() + "/telaAdministrador.jsp");
        } else {
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.selectByEmail(email);

            if (cliente != null && cliente.getSenha().equals(senha)) {
                response.sendRedirect("inicio.jsp");
            } else {
                request.setAttribute("errorMessage", "E-mail ou senha inválidos.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }
}