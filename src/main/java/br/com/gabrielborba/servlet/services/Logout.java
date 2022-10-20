package br.com.gabrielborba.servlet.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabrielborba.servlet.interfaces.InterfaceCommand;

public class Logout implements InterfaceCommand {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:entrada?acao=LoginForm";
	}

}
