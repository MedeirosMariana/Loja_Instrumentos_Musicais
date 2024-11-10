<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Produto" %>

<%	

	Produto[] produtos = (Produto[]) session.getAttribute("produtos");
	if (produtos == null) {
	    produtos = new Produto[20];
	    session.setAttribute("produtos", produtos);
	}
	
	String nomeProduto = request.getParameter("nomeProduto");
	String categoria = request.getParameter("categoria");
	String marca = request.getParameter("marca");
	String modelo = request.getParameter("modelo");
	String precoStr = request.getParameter("preco");
	String condicao = request.getParameter("condicao");
	String qtdEstoqueStr = request.getParameter("qtdEstoque");
	String descricao = request.getParameter("descricao");

	if (nomeProduto == null || nomeProduto.isEmpty() ||
            categoria == null || categoria.isEmpty() ||
            marca == null || marca.isEmpty() ||
            modelo == null || modelo.isEmpty() ||
            precoStr == null || precoStr.isEmpty() ||
            condicao == null || condicao.isEmpty() ||
            qtdEstoqueStr == null || qtdEstoqueStr.isEmpty()) {
            
            response.sendRedirect("cadastroproduto.jsp");
        }else{
        	
        	double preco = Double.parseDouble(precoStr);
            int estoque = Integer.parseInt(qtdEstoqueStr);
            
        	Produto produto = new Produto(nomeProduto, categoria, descricao, marca, modelo, condicao, estoque, preco);
        	
        	for (int i = 0; i < produtos.length; i++) {
                if (produtos[i] == null) {
                    produtos[i] = produto;
                    break;
                }
            }
        	
        	response.sendRedirect("consultarProdutos.jsp"); 
        }
	
%>