package br.com.gabrielborba.servlet.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.gabrielborba.servlet.modelo.Banco;
import br.com.gabrielborba.servlet.modelo.Empresa;


@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = new Banco().getEmpresas();
		
		String valor = request.getHeader("accept");
			
		if(valor.endsWith("xml")) {
			returnToXml(response, empresas);
		}else if(valor.endsWith("json")) {
			returnToJson(response, empresas);
		}else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
	
	}

	private void returnToJson(HttpServletResponse response, List<Empresa> empresas) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(empresas);
		
		response.setContentType("application/json");
		response.getWriter().print(json);
	}
	
	private void returnToXml(HttpServletResponse response, List<Empresa> empresas) throws IOException {
		XStream xStream = new XStream();
		String xml = xStream.toXML(empresas);
		
		response.setContentType("application/xml");
		response.getWriter().print(xml);
	}

}
