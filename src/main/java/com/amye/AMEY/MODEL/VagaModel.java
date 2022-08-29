package com.amye.AMEY.MODEL;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VAGAS")
public class VagaModel {
	@Id
	private int id;
	private String nome;
	private String descricao;
	private String salario;
	
	@ManyToMany(mappedBy = "vagas")
	private List<HabilidadeModel> habilidades;
	
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
	
}
