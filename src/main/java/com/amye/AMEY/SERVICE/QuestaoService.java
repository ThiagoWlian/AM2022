package com.amye.AMEY.SERVICE;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.QuestaoModel;
import com.amye.AMEY.REPOSITORY.AlternativaRepository;
import com.amye.AMEY.REPOSITORY.QuestaoRepository;

@Service
public class QuestaoService {
	
	@Autowired
	private QuestaoRepository questaoRepository;
	
	public QuestaoModel salvarQuestaoModel(QuestaoModel questaoModel) {
		return questaoRepository.save(questaoModel);
	}
	
	public List<QuestaoModel> buscarQuestoesPelaProva(int idProva){
		return questaoRepository.findByProvaId(idProva);
	}
}
