package com.amye.AMEY.MODEL;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTAO")
public class QuestaoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String questao;
	@ManyToOne
	private ProvaModel prova;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questao")
	private List<AlternativaModel> alternativas;
	
	public QuestaoModel() {}
		
	public QuestaoModel(String questao, ProvaModel prova, List<AlternativaModel> alternativas) {
		super();
		this.questao = questao;
		this.prova = prova;
		this.alternativas = alternativas;
	}

	public QuestaoModel(int id, String questao, ProvaModel prova, List<AlternativaModel> alternativas) {
		super();
		this.id = id;
		this.questao = questao;
		this.prova = prova;
		this.alternativas = alternativas;
	}

	public QuestaoModel(String questao) {
		super();
		this.questao = questao;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuestao() {
		return questao;
	}
	
	public void setQuestao(String questao) {
		this.questao = questao;
	}
	
	public ProvaModel getProva() {
		return prova;
	}
	
	public void setProva(ProvaModel prova) {
		this.prova = prova;
	}
	
	public List<AlternativaModel> getAlternativas() {
		return alternativas;
	}
	
	public void setAlternativas(List<AlternativaModel> alternativas) {
		this.alternativas = alternativas;
	}
}
