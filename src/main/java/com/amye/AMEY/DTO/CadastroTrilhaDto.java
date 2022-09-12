package com.amye.AMEY.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amye.AMEY.MODEL.ConteudoTrilhaModel;
import com.amye.AMEY.MODEL.TrilhaModel;

public class CadastroTrilhaDto {
	
	private String nome;
	private String descricao;
	private String imagem;
	private String listaConteudo;
	
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

	public String getListaConteudo() {
		return listaConteudo;
	}

	public void setListaConteudo(String listaConteudo) {
		this.listaConteudo = listaConteudo;
	}
	
	private List<String> converteParaListString() {
		return new ArrayList<String>(Arrays.asList(listaConteudo.split(";")));
	}
	
	public List<ConteudoTrilhaModel> converterParaListaDto() {
		
		List<ConteudoTrilhaModel> listaDto = new ArrayList<ConteudoTrilhaModel>();
		
		for (String conteudo : converteParaListString()) {
			List<String> conteudos = new ArrayList<String>(Arrays.asList(conteudo.split("-")));
			listaDto.add(new ConteudoTrilhaModel(conteudos.get(0), conteudos.get(1), conteudos.get(2)));
		}
		
		return listaDto;
	}
}
