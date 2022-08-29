package com.amye.AMEY.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.REPOSITORY.HabilidadesRepository;

@Service
public class HabilidadesService {
	
	@Autowired
	HabilidadesRepository habilidadesRepository;
	
	public List<HabilidadeModel> listarHabilidadesPelaVaga(){
		return habilidadesRepository.findHabilidadesPorVagaId(1);
	}
}
