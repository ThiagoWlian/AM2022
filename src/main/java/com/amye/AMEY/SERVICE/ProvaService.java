package com.amye.AMEY.SERVICE;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.AlternativaModel;
import com.amye.AMEY.MODEL.ProvaModel;
import com.amye.AMEY.MODEL.QuestaoModel;
import com.amye.AMEY.REPOSITORY.ProvaRepository;

@Service
public class ProvaService {
	
	@Autowired
	ProvaRepository provaRepository;
	
	@Autowired
	QuestaoService questaoService;
	
	@Autowired
	AlternativaService alternativaService;
	
	@Autowired
	TrilhaService trilhaService;
	
	public ProvaModel cadastrarProva(ProvaModel provaModel) {
		return provaRepository.save(provaModel);
	}
	
	public Optional<ProvaModel> buscarProvaPeloId(int idProva){
		return provaRepository.findById(idProva);
	}
	
	public ProvaModel obterProva(int idProva) {
		ProvaModel prova = buscarProvaPeloId(idProva).get();
		List<QuestaoModel> questoes = questaoService.buscarQuestoesPelaProva(idProva);
		prova.setQuestoes(new ArrayList<QuestaoModel>());
		for(QuestaoModel questao : questoes) {
			List<AlternativaModel> alternativas = alternativaService.buscarAlternativasPorIdQuestao(questao.getId());
			questao.setAlternativas(alternativas);
			prova.addQuestoes(questao);
		}
		return prova;
	}

	public int avaliarProvaEmPorcentagemAcertos(List<QuestaoModel> questoes) {
		int questoesCorretas = 0;
		for (QuestaoModel questao : questoes) {
			if(questao.isTipo()) {
				questoesCorretas++;
			}
		}
		return (questoesCorretas/(questoes.size()+1)) * 100;
	}

	public void envioProva() {

	}
}
