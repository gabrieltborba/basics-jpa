package br.com.gabrielborba.servlet.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static Integer primaryKey = 1;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	 static {
	        Empresa empresa;
			try {
				empresa = new Empresa(primaryKey,"Alura",sdf.parse("23/12/2021"));
				lista.add(empresa);
		        empresa = new Empresa(primaryKey+1,"Caelum",sdf.parse("22/01/1999"));  
		        lista.add(empresa);
			} catch (ParseException e) {
				e.printStackTrace();
			}	    
	    }

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.primaryKey++);
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

}
