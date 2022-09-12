package com.amye.AMEY.MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRILHA_CONTEUDO")
public class ConteudoTrilhaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Column(name = "LINK_VIDEO")
	private String linkVideo;
	@Column(name = "LINK_CONTEUDO")
	private String linkConteudo;
	@ManyToOne
	private TrilhaModel trilhas;
	
	public ConteudoTrilhaModel() {}
	
	public ConteudoTrilhaModel(String nome, String linkVideo, String linkConteudo) {
		this.nome = nome;
		this.linkVideo = linkVideo;
		this.linkConteudo = linkConteudo;
	}

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
		return trilhas;
	}
	
	public void setTrilha(TrilhaModel trilha) {
		this.trilhas = trilha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
