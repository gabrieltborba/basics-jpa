package br.com.gabrielborba.servlet.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceCommand {
	
	 public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
