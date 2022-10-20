package br.com.gabrielborba.servlet.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabrielborba.servlet.interfaces.InterfaceCommand;
import br.com.gabrielborba.servlet.modelo.Banco;
import br.com.gabrielborba.servlet.modelo.Empresa;


public class AlterarEmpresa implements InterfaceCommand{
	
	private final long serialVersionUID = 1L;
       

	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		Empresa empresa = parseEmpresa(request);
		Banco banco = new Banco();
		System.out.println("Alterando empresa " + empresa.getId());
		banco.alteraEmpresa(empresa);
		return "redirect:entrada?acao=ListaEmpresas";
	
		
	}
	
	private Empresa parseEmpresa(HttpServletRequest request) throws ServletException {
		Integer paramId = Integer.valueOf(request.getParameter("id"));
		String paramNome = request.getParameter("nome");
		String paramData = request.getParameter("data");
		
		Date dataCriacao = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataCriacao = sdf.parse(paramData);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(paramId,paramNome,dataCriacao);
		return empresa;
	}

}
