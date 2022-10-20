package br.com.gabrielborba.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabrielborba.servlet.services.EmpresaService;


@WebServlet("/entrada")
public class EmpresaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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


	@SuppressWarnings("deprecation")
	private String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		String packageName = "br.com.gabrielborba.servlet.services.";
		String paramAcao = req.getParameter("acao");
		
		if(paramAcao == null) {
	    	return "redirect:entrada?acao=LoginForm";
	    }

		HttpSession sessao = req.getSession();
		boolean usuarioEstaLogado = (sessao.getAttribute("usuarioLogado") != null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
	    if(!usuarioEstaLogado && ehUmaAcaoProtegida) {
	    	return "redirect:entrada?acao=LoginForm";
	    }
		
		try {
			Class<?> classe = Class.forName(packageName + paramAcao);
			EmpresaService acao = (EmpresaService) classe.newInstance();		
			return acao.executa(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

}
