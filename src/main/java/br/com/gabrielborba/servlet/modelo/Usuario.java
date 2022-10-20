package br.com.gabrielborba.servlet.modelo;

public class Usuario {
	
	private String login;
	private String senha;
	
	Usuario(String login, String senha){
		this.login = login;
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	
	public boolean checkSenha(String login, String senha) {
		if(!this.login.equals(login)) {
			return false;
		}
		
		if(!this.senha.equals(senha)) {
			return false;
		}
		
		return true;
	}

}
