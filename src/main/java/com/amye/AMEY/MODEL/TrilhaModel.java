package com.amye.AMEY.MODEL;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TRILHAS")
public class TrilhaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private String imagem;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trilhas")
	private List<ConteudoTrilhaModel> conteudos;
	@ManyToMany
	@JoinTable(name = "TRILHAS_HABILIDADES",
			joinColumns = @JoinColumn(name = "TRILHAS_ID"),
			inverseJoinColumns = @JoinColumn(name = "HABILIDADES_ID"))
	private List<HabilidadeModel> habilidades;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trilhas")
	private List<TrilhasCandidatoModel> trilhasCandidato;
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

	public ProvaModel getProvas() {
		return provas;
	}

	public void setProvas(ProvaModel prova) {
		this.provas = prova;
	}

	public List<HabilidadeModel> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<HabilidadeModel> habilidades) {
		this.habilidades = habilidades;
	}
}
