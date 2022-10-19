package br.com.gabrielborba.servlet.modelo;

import java.util.Date;

public class Empresa {
	
	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	

	public Empresa(Integer id,String nome, Date dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.dataAbertura = dataCriacao;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	

}
