package com.amye.AMEY.SERVICE;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.ProvaModel;
import com.amye.AMEY.REPOSITORY.ProvaRepository;

@Service
public class ProvaService {
	
	@Autowired
	ProvaRepository provaRepository;
	
	@Autowired
	TrilhaService trilhaService;
	
	public ProvaModel cadastrarProva(ProvaModel provaModel) {
		return provaRepository.save(provaModel);
	}
}
