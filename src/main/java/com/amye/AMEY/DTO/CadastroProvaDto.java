package com.amye.AMEY.DTO;

import com.amye.AMEY.MODEL.ProvaModel;

public class CadastroProvaDto {
	private String nome;
	private int id;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public ProvaModel converterParaProvaModel() {
		return new ProvaModel(nome);
	}
}
