package com.amye.AMEY.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.amye.AMEY.MODEL.ProvaModel;

public class CadastroProvaDto {
	private String nome;
	private String questoes;
	private int id;
	
	public String getQuestoes() {
		return questoes;
	}

	public void setQuestoes(String questoes) {
		this.questoes = questoes;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	private List<String> transformaEmListaQuestaoTexto() {
		return new ArrayList<String>(Arrays.asList(questoes.split(";")));
	}
	
	private QuestaoAlternativaDto converteStringParaQuestaoAlternativaDto(String questao) {
		String[] questaoAlternativa = questao.split("-");
		return questaoAlternativa.length >= 4 ? new QuestaoAlternativaDto(questaoAlternativa[0], questaoAlternativa[1], questaoAlternativa[2], questaoAlternativa[3], questaoAlternativa[4]) : null;
	}
	
	public List<QuestaoAlternativaDto> listaQuestaoAlternativaDto() {
		List<QuestaoAlternativaDto> listaAlternativas = new ArrayList<QuestaoAlternativaDto>();
		
		for(String questaoAlternativa : transformaEmListaQuestaoTexto()) {
			listaAlternativas.add(converteStringParaQuestaoAlternativaDto(questaoAlternativa));
		}
		
		return listaAlternativas;
	}
	
	public ProvaModel converterParaProvaModel() {
		return new ProvaModel(nome);
	}
}
