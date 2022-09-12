package com.amye.AMEY.DTO;

public class ConteudoTrilhaDto {
	private String nome;
	private String linkVideo;
	private String linkConteudo;

	public ConteudoTrilhaDto(String nome, String linkVideo, String linkConteudo) {
		super();
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
	
	
}
