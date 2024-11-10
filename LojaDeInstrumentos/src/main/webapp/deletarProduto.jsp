<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Produto" %>
<%
    String indiceStr = request.getParameter("indice");
    int indice = Integer.parseInt(indiceStr);


    Produto[] produtos = (Produto[]) session.getAttribute("produtos");

    if (produtos != null && indice >= 0 && indice < produtos.length) {
        produtos[indice] = null; 
    }

    response.sendRedirect("consultarProdutos.jsp");
%>