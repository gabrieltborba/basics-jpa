package br.com.gabrielborba.servlet.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabrielborba.servlet.interfaces.InterfaceCommand;
import br.com.gabrielborba.servlet.modelo.Banco;


public class RemoveEmpresa implements InterfaceCommand{

	private final long serialVersionUID = 1L;
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer paramId = Integer.valueOf(request.getParameter("id"));
		System.out.println(String.format("Removendo empresa %s",paramId));
		
		Banco banco = new Banco();
		banco.remove(paramId);
		
		return "redirect:entrada?acao=ListaEmpresas";
	
	}

}
