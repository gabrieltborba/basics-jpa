package br.com.gabrielborba.servlet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabrielborba.servlet.interfaces.InterfaceCommand;

public class ControladorFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest servRequest, ServletResponse servResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) servRequest;
		HttpServletResponse resp = (HttpServletResponse) servResponse;
		
		
		List<String> nome = new ArrayList<String>() ;
		nome = Arrays.asList(execute(req, resp).split(":"));
		
		if(nome.get(0).equals("forward")) {	
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" +nome.get(1));
			rd.forward(req, resp);
		}
		
		if(nome.get(0).equals("redirect")) {
			resp.sendRedirect(nome.get(1));
			
		}	
	}
	
	private String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		String paramAcao = req.getParameter("acao");

		String packageName = "br.com.gabrielborba.servlet.services.";
		if(paramAcao.contains("Form")) {
			packageName = "br.com.gabrielborba.servlet.services.forms.";
		}
	
		 
		
		
		try {
			Class<?> classe = Class.forName(packageName + paramAcao);
			InterfaceCommand acao = (InterfaceCommand) classe.newInstance();		
			return acao.executa(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
