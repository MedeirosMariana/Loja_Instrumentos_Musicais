package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final String EMAIL = "user@example.com";
    private static final String PASSWORD = "password123";
    private static final String EMAIL_ADM = "adm@example.com";
    private static final String PASSWORD_ADM = "adm123";
    
    public LoginServlet() {
    	super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (EMAIL.equals(email) && PASSWORD.equals(password)) {
        	response.sendRedirect(request.getContextPath() + "/inicio.jsp");
        }else if(EMAIL_ADM.equals(email) && PASSWORD_ADM.equals(password)) {
        	response.sendRedirect(request.getContextPath() + "/telaAdministrador.jsp");
        }
        else {
            request.setAttribute("errorMessage", "Email ou senha inválidos.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}