package com.amye.AMEY.MODEL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROVAS")
public class ProvaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prova")
	private List<QuestaoModel> questoes = new ArrayList<QuestaoModel>();
	
	public ProvaModel() {}
	
	public ProvaModel(String nome) {
		this.nome = nome;
	}

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

	public List<QuestaoModel> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<QuestaoModel> questoes) {
		this.questoes = questoes;
	}
	
	public void addQuestoes(QuestaoModel questao) {
		questoes.add(questao);
	}
}
