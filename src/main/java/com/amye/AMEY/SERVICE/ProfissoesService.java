package com.amye.AMEY.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.ProfissoesModel;
import com.amye.AMEY.REPOSITORY.ProfissoesRepository;

@Service
public class ProfissoesService {

	@Autowired
	ProfissoesRepository profissoesRepository;
	
	public void cadastraProfissao(ProfissoesModel profissao) {
		profissoesRepository.save(profissao);
	}
	
	public ProfissoesModel getProfissaoPorId(int id) {
		Optional<ProfissoesModel> profissoesOptional = profissoesRepository.findById(id);
		if(profissoesOptional.isPresent()) {
			return profissoesOptional.get();
		}
		return null;
	}
	
	public List<ProfissoesModel> listarProfissoes(){
		return profissoesRepository.findAll();
	}
}
