package br.com.gabrielborba.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AutorizacaoFilter implements Filter{
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest servRequest, ServletResponse servResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) servRequest;
		HttpServletResponse resp = (HttpServletResponse) servResponse;
		
		String paramAcao = req.getParameter("acao");
		
		if(paramAcao == null) {
			resp.sendRedirect("entrada?acao=LoginForm");
			return;
	    }

	
		HttpSession sessao = req.getSession();
		boolean usuarioEstaLogado = (sessao.getAttribute("usuarioLogado") != null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
	    if(!usuarioEstaLogado && ehUmaAcaoProtegida) {
	    	resp.sendRedirect("entrada?acao=LoginForm");    	
	    	return;
	    }
		
		
	    chain.doFilter(req, resp);
		
	}

}
