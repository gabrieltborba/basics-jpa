package br.com.gabrielborba.servlet.services;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabrielborba.servlet.interfaces.InterfaceCommand;
import br.com.gabrielborba.servlet.modelo.Banco;
import br.com.gabrielborba.servlet.modelo.Empresa;


public class DetalhesEmpresa implements InterfaceCommand{
	
	private final long serialVersionUID = 1L;
       

	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		Integer paramId = Integer.valueOf(request.getParameter("id"));
		System.out.println(String.format("Mostra dados empresa %s",paramId));
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaById(paramId);
		
		if(empresa == null) {
			throw new ServletException();
		}
		
		request.setAttribute("empresa", empresa);
		return "forward:/formAlteraEmpresa.jsp";	
		
	}
}
