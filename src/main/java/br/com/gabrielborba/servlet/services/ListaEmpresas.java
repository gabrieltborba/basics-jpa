package br.com.gabrielborba.servlet.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabrielborba.servlet.interfaces.InterfaceCommand;
import br.com.gabrielborba.servlet.modelo.Banco;
import br.com.gabrielborba.servlet.modelo.Empresa;


public class ListaEmpresas implements InterfaceCommand {
	
	private final long serialVersionUID = 1L;
	

	    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	    
    	System.out.println("listando empresas pelo executa");
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		req.setAttribute("empresas", lista);
		
		return "forward:/listarEmpresas.jsp";

	}

}
