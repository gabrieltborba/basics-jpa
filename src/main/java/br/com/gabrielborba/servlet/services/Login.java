package br.com.gabrielborba.servlet.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabrielborba.servlet.interfaces.InterfaceCommand;
import br.com.gabrielborba.servlet.modelo.Banco;
import br.com.gabrielborba.servlet.modelo.Usuario;

public class Login implements InterfaceCommand {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		System.out.println("Logando com " + login);
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login,senha);
		
		if(usuario == null) {
			return "redirect:entrada?acao=LoginForm";
		}
		
		System.out.println("Usuario: " + login + " Logado com sucesso");
		HttpSession session = req.getSession();
		session.setAttribute("usuarioLogado", usuario);
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
