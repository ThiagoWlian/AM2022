package com.amye.AMEY.MODEL;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRILHAS")
public class TrilhaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private String imagem;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trilha")
	private List<ConteudoTrilhaModel> conteudos;
	@OneToOne
	private ProvaModel provas;
	
	public TrilhaModel () {}
	
	public TrilhaModel(String nome, String descricao, String imagem) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
	}

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
	
	public List<ConteudoTrilhaModel> getConteudos() {
		return conteudos;
	}
	
	public void setConteudos(List<ConteudoTrilhaModel> conteudos) {
		this.conteudos = conteudos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProvaModel getProva() {
		return provas;
	}

	public void setProva(ProvaModel prova) {
		this.provas = prova;
	}
}
