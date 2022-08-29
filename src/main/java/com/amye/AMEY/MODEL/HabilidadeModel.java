package com.amye.AMEY.MODEL;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HABILIDADES")
public class HabilidadeModel {
	@Id
	private int id;
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "VAGAS_HABILIDADES",
	joinColumns = @JoinColumn(name = "HABILIDADES_ID"),
	inverseJoinColumns = @JoinColumn(name = "VAGAS_ID")
	)
	private List<VagaModel> vagas;
	
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
}
