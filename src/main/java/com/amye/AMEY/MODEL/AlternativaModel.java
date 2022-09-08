package com.amye.AMEY.MODEL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALTERNATIVA")
public class AlternativaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String alternativa;
	
	@ManyToOne
	private QuestaoModel questao;

	public AlternativaModel() {}
	
	public AlternativaModel(String alternativa) {
		super();
		this.alternativa = alternativa;
	}

	public AlternativaModel(String alternativa, QuestaoModel questao) {
		super();
		this.alternativa = alternativa;
		this.questao = questao;
	}

	public AlternativaModel(int id, String alternativa, QuestaoModel questao) {
		super();
		this.id = id;
		this.alternativa = alternativa;
		this.questao = questao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}

	public QuestaoModel getQuestao() {
		return questao;
	}

	public void setQuestao(QuestaoModel questao) {
		this.questao = questao;
	}
}
