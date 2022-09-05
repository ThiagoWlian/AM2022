package com.amye.AMEY.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.ProvaModel;
import com.amye.AMEY.MODEL.TrilhaModel;
import com.amye.AMEY.REPOSITORY.TrilhaRepository;

@Service
public class TrilhaService {
	
	@Autowired
	TrilhaRepository trilhaRepository;
	
	public List<TrilhaModel> listarTrilhas(){
		return trilhaRepository.findAll();
	}
	
	public void cadastrarTrilha(TrilhaModel trilhaModel) {
		trilhaRepository.save(trilhaModel);
	}
	
	private Optional<TrilhaModel> buscarTrilhaPorId(int id) {
		return trilhaRepository.findById(id);
	}
	
	public void atualizarProvaTrilha(int idTrilha, ProvaModel provaModel) {
		Optional<TrilhaModel> trilhaModel = this.buscarTrilhaPorId(idTrilha);
		if(trilhaModel.isPresent()) {
			trilhaModel.get().setProva(provaModel);
			trilhaRepository.save(trilhaModel.get());
		}
	}
}
