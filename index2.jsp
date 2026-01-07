<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.*"%>
<%@ page import="control.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content"width=device-width, initual-scale=1.0">
<title>Cadastro de Contatos</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div id="esquerda">
		<a href="/Agenda-Web-2C/">Cadastra Contato</a>
		<a href="/Agenda-Web-2C/index2.jsp">Consulta Contato</a>			    
	</div>
	<div id="direita">
		<button id="membros" onclick="membros()">Membros do Grupo</button>
	</div>
	<script>
		function membros() {
			alert(" Ana Luiza Maciel     nº01\n Kamila Sayuri          nº11\n Lorena Boechat       nº13\n Murilo Baptista        nº23")
		}
	</script>

	<h1>Agenda Web</h1>
	<form action="index" method="POST">
		<div class="container-consulta">
			<h2>Consulta de Contato</h2>
		</div>
			<div class="container-tabela">
				<table border="1">
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Telefone</th>
						<th>Endereço</th>
						<th>Complemento</th>
						<th>Cidade</th>
						<th>Estado</th>
					</tr>

					<%
					    	Contato controle = new Contato();
					    	contato model = new contato();
					    	List<contato> lista 
					    		= controle.consultaTodosContatos();
					    	
					    	for (int j=0; j<lista.size(); j++) {
					    		model = lista.get(j);
					    		%>
					<tr>
						<td><%=model.getId() %></td>
						<td><%=model.getNome() %></td>
						<td><%=model.getTelefone() %></td>
						<td><%=model.getEndereco() %></td>
						<td><%=model.getComplemento() %></td>
						<td><%=model.getCidade() %></td>
						<td><%=model.getEstado() %></td>
					</tr>
					<%
					    	}
					    %>
				</table>
			</div>
		
	</form>
</body>
</html>