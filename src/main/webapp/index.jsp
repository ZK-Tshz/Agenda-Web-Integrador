<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="control.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html lang="pt-br">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content"width=device-width, initual-scale=1.0">
	    <title>Cadastro de Contatos</title>
	    <link rel="stylesheet" href="css/styles.css">
	</head>
	<body>
	        <h1>Agenda Web</h1>
	
	        <form action="index" method="POST">
	            <div class="container">
	                <h2>Cadastro de Contato</h2>
	                <div class="form-group">
	                    <label for="id">Id</label>
	                    <input type="text" id="txtId" name="txtId" class="id" 
	                        value="${sessionScope.model.id}" readonly>
	                </div>
	
	                <div class="form-group">
	                    <label for="nome">Nome</label>
	                    <input type="text" id="txtNome" name="txtNome" 
	                        value="${sessionScope.model.nome}">
	                </div>
	
	                <div class="form-group">
	                    <label for="telefone">Telefone</label>
	                    <input type="text" id="txtTelefone" name="txtTelefone" 
	                        value="${sessionScope.model.telefone}">
	                </div>
	
	                <div class="form-group">
	                    <label for="endereco">Endereço</label>
	                    <input type="text" id="txtEndereco" name="txtEndereco" 
	                        value="${sessionScope.model.endereco}">
	                </div>
	
	                <div class="form-group">
	                    <label for="complemento">Complemento</label>
	                    <input type="text" id="txtComplemento" name="txtComplemento"
	                        value="${sessionScope.model.complemento}">
	                </div>
	
	                <div class="form-group">
	                    <label for="cidade">Cidade</label>
	                    <input type="text" id="txtCidade" name="txtCidade" 
	                        value="${sessionScope.model.cidade}">
	                </div>
	
	                <div class="form-group">
	                    <label for="estado">Estado</label>
	                    <input type="text" id="txtEstado" name="txtEstado" 
	                        value="${sessionScope.model.estado}">
	                </div>
	
	                <div class="button-group">
	                    <button type="submit" name="action" value="excluir" class="excluir">Excluir</button>
	                    <button type="submit" name="action" value="primeiro" class="navegacao"><</button>
	                    <button type="submit" name="action" value="anterior" class="navegacao"><-</button>
	                    <button type="submit" name="action" value="novo" class="novo">Novo</button>
	                    <button type="submit" name="action" value="proximo" class="navegacao">-></button>
	                    <button type="submit" name="action" value="ultimo" class="navegacao">></button>
	                    <button type="submit" name="action" value="salvar" class="salvar">Salvar</button>
	                </div>
	            </div>	            
		    </form>
		</body>
	</html>