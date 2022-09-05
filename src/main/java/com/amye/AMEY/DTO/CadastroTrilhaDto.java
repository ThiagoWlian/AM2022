package com.amye.AMEY.DTO;

import com.amye.AMEY.MODEL.TrilhaModel;

public class CadastroTrilhaDto {
	
	private String nome;
	private String descricao;
	private String imagem;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public TrilhaModel converterParaTrilhaModel() {
		return new TrilhaModel(nome, descricao, imagem);
	}
}
