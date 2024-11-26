package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.NotaFiscalDAO;

@WebServlet(name="notafiscal", urlPatterns= {"/notafiscal", "/notafiscal/novo" , "/notafiscal/cadastro"})
public class NotaFiscalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NotaFiscalDAO notaFiscalDAO = null;

    public NotaFiscalController() {
        super();
        notaFiscalDAO = new NotaFiscalDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String action = request.getServletPath();
		
		try {
			switch(action) {
			case "/notafiscal/cadastro":
				RequestDispatcher dispatcher = request.getRequestDispatcher("/gravar-nota.jsp");
				dispatcher.forward(request, response);
				break;
			case "/notafiscal/novo":
				novo(request,response);
				break;

			default:
				RequestDispatcher dispatcher2 = request.getRequestDispatcher("/gravar-nota.jsp");
				dispatcher2.forward(request, response);
				break;
			
			}
			
		}catch(SQLException ex) {
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		//Resgato a data da nota fiscal
		String dataNota = request.getParameter("dataNota");
		
		//Resgato os vetores de Ids, quantidades e Produtos
        String[] vetorIdProdutos = request.getParameterValues("vetorIdProdutos[]");
        String[] vetorQtdProdutos = request.getParameterValues("vetorQtdProdutos[]");
        String[] vetorValoresUnitarios = request.getParameterValues("vetorValoresUnitarios[]");

        
        // Chama a DAO para gravar os dados no banco e mostro o número da nota
        int numeroNota = notaFiscalDAO.salvar(dataNota, vetorIdProdutos, vetorQtdProdutos, vetorValoresUnitarios);
        
        System.out.println("Nota gravada com sucesso!");
        
        
        request.setAttribute("sucesso", "Nota fiscal nº" + numeroNota +  " cadastrada com sucesso!");
        
        request.getRequestDispatcher("/gravar-nota.jsp").forward(request, response);
        
	}

}
