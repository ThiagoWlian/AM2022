package com.amye.AMEY.DTO;

import java.util.ArrayList;
import java.util.List;

import com.amye.AMEY.MODEL.AlternativaModel;
import com.amye.AMEY.MODEL.QuestaoModel;

public class QuestaoAlternativaDto {
	
	private String questao;
	private String alternativa1;
	private String alternativa2;
	private String alternativa3;
	private String alternativa4;
	
	public QuestaoAlternativaDto(String questao, String alternativa1, String alternativa2, String alternativa3,
			String alternativa4) {
		super();
		this.questao = questao;
		this.alternativa1 = alternativa1;
		this.alternativa2 = alternativa2;
		this.alternativa3 = alternativa3;
		this.alternativa4 = alternativa4;
	}

	public String getQuestao() {
		return questao;
	}
	
	public void setQuestao(String questao) {
		this.questao = questao;
	}
	
	public String getAlternativa1() {
		return alternativa1;
	}
	
	public void setAlternativa1(String alternativa1) {
		this.alternativa1 = alternativa1;
	}
	
	public String getAlternativa2() {
		return alternativa2;
	}
	
	public void setAlternativa2(String alternativa2) {
		this.alternativa2 = alternativa2;
	}
	
	public String getAlternativa3() {
		return alternativa3;
	}
	
	public void setAlternativa3(String alternativa3) {
		this.alternativa3 = alternativa3;
	}
	
	public String getAlternativa4() {
		return alternativa4;
	}
	
	public void setAlternativa4(String alternativa4) {
		this.alternativa4 = alternativa4;
	}
	
	public QuestaoModel getQuestaoModel() {
		return new QuestaoModel(questao);
	}
	
	public List<AlternativaModel> getListAlternativaModel() {
		List<AlternativaModel> listaAlternativa = new ArrayList<AlternativaModel>();
		listaAlternativa.add(new AlternativaModel(alternativa1));
		listaAlternativa.add(new AlternativaModel(alternativa2));
		listaAlternativa.add(new AlternativaModel(alternativa3));
		listaAlternativa.add(new AlternativaModel(alternativa4));
		
		return listaAlternativa;
	}
}
