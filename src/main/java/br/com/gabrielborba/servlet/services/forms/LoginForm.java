package br.com.gabrielborba.servlet.services.forms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabrielborba.servlet.interfaces.InterfaceCommand;

public class LoginForm implements InterfaceCommand {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		return "forward:/formLogin.jsp";
	}

}
