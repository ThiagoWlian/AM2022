package com.amye.AMEY.SERVICE;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.AlternativaModel;
import com.amye.AMEY.REPOSITORY.AlternativaRepository;

@Service
public class AlternativaService {
	
	@Autowired
	AlternativaRepository alternativaRepository;
	
	public void cadastrarAlternativa(AlternativaModel alternativa) {
		alternativaRepository.save(alternativa);
	}
	
	@Transactional
	public List<AlternativaModel> salvarListaAlternativasModel(List<AlternativaModel> alternativas){
		return alternativas.stream().map(alternativaRepository:: save).collect(Collectors.toList());
	}
	
	public List<AlternativaModel> buscarAlternativasPorIdQuestao(int idQuestao) {
		return alternativaRepository.findAllByQuestao(idQuestao);
	}
}
