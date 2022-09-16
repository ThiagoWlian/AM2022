package com.amye.AMEY.SERVICE;

import java.util.List;
import java.util.Optional;

import com.amye.AMEY.MODEL.CandidatoVagasModel;
import com.amye.AMEY.REPOSITORY.CandidatoVagasController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.CandidatoModel;

import com.amye.AMEY.MODEL.VagaModel;
import com.amye.AMEY.REPOSITORY.VagaRepository;

@Service
public class VagasService {
	
	@Autowired
	VagaRepository vagaRepository;
	
	@Autowired
	CandidatoVagasController candidatoVagasController;

	@Autowired
	CandidatoService candidatoService;
	
	@Autowired
	HabilidadesService habilidadesService;
	
	public List<VagaModel> listarVagas(){
		List<VagaModel> vagaList = vagaRepository.findAll();
		return vagaList;
	}
	
	public void cadastrarVaga(VagaModel vaga) {
		vagaRepository.save(vaga);
	}
	
	public List<VagaModel> listarVagasPorCandidato(int id){
		CandidatoModel candidato = candidatoService.getCandidatoPorIdUsuario(id);
		List<VagaModel> vagaList = vagaRepository.findAllByCandidatosId(candidato.getId());
		return vagaList;
	}

	public List<VagaModel> listarVagasPorCandidatoDisponiveis(int id){
		CandidatoModel candidato = candidatoService.getCandidatoPorIdUsuario(id);
		List<VagaModel> vagaList = vagaRepository.findAllByCandidatosIdNot(candidato.getId());
		return vagaList;
	}
	
	public void candidatar(int idCandidato, int idVaga){
		Optional<VagaModel> vaga = vagaRepository.findById(idVaga);
		CandidatoModel candidato = candidatoService.getCandidatoPorIdUsuario(idCandidato);

		CandidatoVagasModel candidatoVagasModel = new CandidatoVagasModel(vaga.get(), candidato, "Análise");
		candidatoVagasController.save(candidatoVagasModel);
	}

	public Optional<VagaModel> buscarVagaPorId(int idBVaga) {
		return vagaRepository.findById(idBVaga);
	}
}
