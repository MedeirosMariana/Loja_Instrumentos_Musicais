package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ClienteDAO;

@WebServlet("/clientes/*")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            if ("/listar".equals(action)) {
                listarClientes(request, response);
            } else {
                listarClientes(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        System.out.println("Cheguei no do get");
        List<Cliente> clientes = clienteDAO.selectAll();
        System.out.println("Clientes encontrados: " + clientes.size());
        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultarClientes.jsp");
        dispatcher.forward(request, response);
    }

}
