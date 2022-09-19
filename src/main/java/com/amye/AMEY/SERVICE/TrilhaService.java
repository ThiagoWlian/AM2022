package com.amye.AMEY.SERVICE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.ConteudoTrilhaModel;
import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.MODEL.ProvaModel;
import com.amye.AMEY.MODEL.TrilhaModel;
import com.amye.AMEY.REPOSITORY.ConteudoTrilhaRepository;
import com.amye.AMEY.REPOSITORY.TrilhaRepository;

@Service
public class TrilhaService {
	
	@Autowired
	TrilhaRepository trilhaRepository;
	
	@Autowired
	ConteudoTrilhaRepository conteudoTrilhaRepository;
	
	public List<TrilhaModel> listarTrilhas(){
		return trilhaRepository.findAll();
	}

	public List<TrilhaModel> listarTrilhas(int id, boolean status){
		return trilhaRepository.findByTrilhasCandidatoCandidatoIdAndTrilhasCandidatoStatus(id, status);
	}

	public Optional<TrilhaModel> buscarTrilhaPorProva(int idProva) {
		return trilhaRepository.findByProvasId(idProva);
	}
	
	public void cadastrarTrilha(TrilhaModel trilhaModel, List<ConteudoTrilhaModel> listaConteudos, List<HabilidadeModel> habilidades) {
		trilhaModel.setHabilidades(habilidades);
		TrilhaModel trilha = trilhaRepository.save(trilhaModel);
		List<ConteudoTrilhaModel> conteudoTrans = new ArrayList<ConteudoTrilhaModel>();
		
		for (int i = 0; i < listaConteudos.size(); i++) {
			ConteudoTrilhaModel t = listaConteudos.get(i);
			t.setTrilha(trilha);
			conteudoTrans.add(t);
		}
		conteudoTrilhaRepository.saveAll(conteudoTrans);
	}
	
	public Optional<TrilhaModel> buscarTrilhaPorId(int id) {
		return trilhaRepository.findById(id);
	}
	
	public List<ConteudoTrilhaModel> listarConteudoTrilhaPorIdProva(int id){
		return conteudoTrilhaRepository.findByTrilhasId(id);
	}
	
	public void atualizarProvaTrilha(int idTrilha, ProvaModel provaModel) {
		Optional<TrilhaModel> trilhaModel = this.buscarTrilhaPorId(idTrilha);
		if(trilhaModel.isPresent()) {
			trilhaModel.get().setProvas(provaModel);
			trilhaRepository.save(trilhaModel.get());
		}
	}

	public List<Optional<TrilhaModel>> buscarTrilhasPorHabilidades(List<HabilidadeModel> listaHabilidades) {
		return listaHabilidades.stream().map(e -> trilhaRepository.findByHabilidadesId(e.getId())).collect(Collectors.toList());
	}
}
