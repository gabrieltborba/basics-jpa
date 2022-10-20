package br.com.gabrielborba.servlet.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabrielborba.servlet.modelo.Banco;
import br.com.gabrielborba.servlet.modelo.Empresa;


public class NovaEmpresaForm implements EmpresaService {
	
	private final long serialVersionUID = 1L;
       

	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		return "forward:/formNovaEmpresa.jsp";
			
	}
	

}
