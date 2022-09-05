package com.amye.AMEY.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.MODEL.VagaModel;
import com.amye.AMEY.REPOSITORY.VagaRepository;

@Service
public class VagasService {
	
	@Autowired
	VagaRepository vagaRepository;
	
	@Autowired
	HabilidadesService habilidadesService;
	
	public List<VagaModel> listarVagas(){
		List<VagaModel> vagaList = vagaRepository.findAll();
		return vagaList;
	}
	
	public void cadastrarVaga(VagaModel vaga) {
		vagaRepository.save(vaga);
	}
}
