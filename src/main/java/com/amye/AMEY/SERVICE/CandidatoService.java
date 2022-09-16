package com.amye.AMEY.SERVICE;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.CandidatoModel;
import com.amye.AMEY.MODEL.ProfissoesModel;
import com.amye.AMEY.MODEL.UsuarioModel;
import com.amye.AMEY.REPOSITORY.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	CandidatoRepository candidatoRepository;
	
	@Autowired
	ProfissoesService profissoesService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Transactional
	public void cadastraCandidato(CandidatoModel candidatoModel, UsuarioModel usuario, int idProfissao) {
		UsuarioModel usuarioModel = usuarioService.cadastraUsuario(usuario);
		ProfissoesModel profissoesModel = profissoesService.getProfissaoPorId(idProfissao);
		candidatoModel.setProfissao(profissoesModel);
		candidatoModel.setUsuario(usuarioModel);
		candidatoRepository.save(candidatoModel);
	}
	
	public void atualizarCandidato(CandidatoModel candidato) {
		candidatoRepository.saveAndFlush(candidato);
	}
	
	public CandidatoModel getCandidatoPorIdUsuario(int id) {
		Optional<CandidatoModel> canditatoOptional = candidatoRepository.findByUsuarioId(id);
		if(canditatoOptional.isPresent()) {
			return canditatoOptional.get();
		}
		return null;
	}

	public void aumentarPontosCandidato(int idCandidato, int quantidadePontos) {
		Optional<CandidatoModel> candidatoModel = candidatoRepository.findById(idCandidato);
		if(candidatoModel.isPresent()) {
			candidatoModel.get().aumentarPontos(quantidadePontos);
			candidatoRepository.save(candidatoModel.get());
		}
	}
	
	public List<CandidatoModel> listarCandidatos(){
		return candidatoRepository.findAll();
	}
}
