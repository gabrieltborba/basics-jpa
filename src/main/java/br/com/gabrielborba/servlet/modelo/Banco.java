package br.com.gabrielborba.servlet.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList<>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	 static {    
			try {
				lista.add(new Empresa(getSizeEmpresa() + 1,"Alura",sdf.parse("23/12/2021")));
		        lista.add(new Empresa(getSizeEmpresa()  +1,"Caelum",sdf.parse("22/01/1999")));
		        
		        listaUsuario.add(new Usuario("gabriel", "9999"));
		        listaUsuario.add(new Usuario("millena", "8888"));
		       
			} catch (ParseException e) {
				e.printStackTrace();
			}	    
	    }

	public void adiciona(Empresa empresa) {	
		empresa.setId(getSizeEmpresa() + 1);
		Banco.lista.add(empresa);
	}
	
	public void remove(Integer idEmpresa) {
		Optional<Empresa> aux = Banco.lista.stream()
				.filter(empresa -> empresa.getId()
						.equals(idEmpresa)).findFirst();
		
		if(aux.isPresent())
			Banco.lista.remove(aux.get());
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;

	}

	public Empresa getEmpresaById(Integer idEmpresa) {
		Optional<Empresa> aux = Banco.lista.stream()
				.filter(empresa -> empresa.getId()
						.equals(idEmpresa)).findFirst();
		
		if(!aux.isPresent())
			return null;		
		
		return aux.get();
		
	}

	public void alteraEmpresa(Empresa empresa) {

		Optional<Empresa> aux = Banco.lista.stream()
				.filter(empresaAux -> empresaAux.getId()
						.equals(empresa.getId())).findFirst();
		
		if(aux.isPresent()) {
			Banco.lista.remove(aux.get());
			Banco.lista.add(empresa);
		}
			
	}

	private static int getSizeEmpresa() {
		return Banco.lista.size();
	}

	public Usuario existeUsuario(String login, String senha) {
		Optional<Usuario> aux = Banco.listaUsuario.stream()
				.filter(usuario -> usuario.checkSenha(login, senha)).findFirst();
		
		if(!aux.isPresent())
			return null;	
		
		return aux.get();
	}
}
