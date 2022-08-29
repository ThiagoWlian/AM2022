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
	
	public CandidatoModel getCandidatoPorId(int id) {
		Optional<CandidatoModel> canditatoOptional = candidatoRepository.findById(id);
		if(canditatoOptional.isPresent()) {
			return canditatoOptional.get();
		}
		return null;
	}
	
	public List<CandidatoModel> listarCandidatos(){
		return candidatoRepository.findAll();
	}
}
