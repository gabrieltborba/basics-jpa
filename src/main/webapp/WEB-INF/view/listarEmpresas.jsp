<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.gabrielborba.servlet.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada?acao=RemoveEmpresa&" var="deletaEmpresa"/>
<c:url value="/entrada?acao=DetalhesEmpresa&" var="detalhesEmpresa"/>
<c:url value="/entrada?acao=NovaEmpresaForm" var="linkAdicionaEmpresa"/>
<c:url value="/entrada?acao=Logout" var="linkLogout"/>
   
<!DOCTYPE html>
<meta charset="ISO-8859-1">
<title>Sistema de Empresas - Menu</title>
<html>
	<body>
		<c:if test="${not empty empresa}">
			Empresa ${empresa} cadastrada com sucesso!
			<br />
		</c:if>
		
	Usuario Logado : ${usuarioLogado.login} &nbsp; <a href="${linkLogout}">Sair</a> 
	<br>
	<br>

		
	Lista de empresas: <br />
	 <ul>
 		<c:forEach items="${empresas}" var="empresa">
			<li>
			${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
			<a href="${deletaEmpresa}id=${empresa.id}"> remove</a>
			<a href="${detalhesEmpresa}id=${empresa.id}"> editar</a>
			</li>
 		</c:forEach>
	 </ul>	 
	 
	 </br> <a href="${linkAdicionaEmpresa}"> Adicionar Nova Empresa</a>
	 </body>
 </html>