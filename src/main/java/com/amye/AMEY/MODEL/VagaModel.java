package com.amye.AMEY.MODEL;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VAGAS")
public class VagaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private String salario;
	private String tempo_experiencia;
	
	@ManyToMany
	@JoinTable(name = "VAGAS_HABILIDADES",
	joinColumns = @JoinColumn(name = "VAGAS_ID"),
	inverseJoinColumns = @JoinColumn(name = "HABILIDADES_ID")
	)
	private List<HabilidadeModel> habilidades;
	
	public VagaModel(String nome, String descricao, String salario, String tempo_experiencia) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.salario = salario;
		this.tempo_experiencia = tempo_experiencia;
	}
	
	public VagaModel() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public List<HabilidadeModel> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<HabilidadeModel> habilidades) {
		this.habilidades = habilidades;
	}
	public String getTempo_experiencia() {
		return tempo_experiencia;
	}
	public void setTempo_experiencia(String tempo_experiencia) {
		this.tempo_experiencia = tempo_experiencia;
	}
}
