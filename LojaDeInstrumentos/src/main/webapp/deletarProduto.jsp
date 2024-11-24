<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Produto" %>
<%@ page import="dao.ProdutoDAO" %>
<%@ page import="java.sql.SQLException" %>

<%
    String idProdutoStr = request.getParameter("idProduto");
    if (idProdutoStr != null) {
        try {
            int idProduto = Integer.parseInt(idProdutoStr);

            ProdutoDAO produtoDAO = new ProdutoDAO();

            boolean deletado = produtoDAO.deleteById(idProduto);

            if (deletado) {
                response.sendRedirect("produtos/listar"); 
            } else {
                out.println("<p>Erro ao deletar o produto.</p>");
            }
        } catch (SQLException | NumberFormatException e) {
            out.println("<p>Erro: " + e.getMessage() + "</p>");
        }
    } else {
        out.println("<p>ID do produto não fornecido.</p>");
    }
%>