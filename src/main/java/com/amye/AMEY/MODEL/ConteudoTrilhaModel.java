package com.amye.AMEY.MODEL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRILHA_CONTEUDO")
public class ConteudoTrilhaModel {
	
	@Id
	private int id;
	private String nome;
	private String linkVideo;
	private String linkConteudo;
	@ManyToOne
	private TrilhaModel trilha;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLinkVideo() {
		return linkVideo;
	}
	
	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}
	
	public String getLinkConteudo() {
		return linkConteudo;
	}
	
	public void setLinkConteudo(String linkConteudo) {
		this.linkConteudo = linkConteudo;
	}
	
	public TrilhaModel getTrilha() {
		return trilha;
	}
	
	public void setTrilha(TrilhaModel trilha) {
		this.trilha = trilha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
