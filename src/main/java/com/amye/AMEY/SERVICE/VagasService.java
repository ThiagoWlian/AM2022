package com.amye.AMEY.SERVICE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.amye.AMEY.DTO.VagasAdmDto;
import com.amye.AMEY.MODEL.CandidatoVagasModel;
import com.amye.AMEY.REPOSITORY.CandidatoVagasRepository;
import com.amye.AMEY.UTIL.CriteriaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.CandidatoModel;

import com.amye.AMEY.MODEL.VagaModel;
import com.amye.AMEY.REPOSITORY.VagaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class VagasService {
	
	@Autowired
	VagaRepository vagaRepository;
	
	@Autowired
	CandidatoVagasRepository candidatoVagasRepository;

	@Autowired
	CandidatoService candidatoService;
	
	@Autowired
	HabilidadesService habilidadesService;
	
	public List<VagaModel> listarVagas(int idCandidato){
		List<VagaModel> vagaList = candidatoVagasRepository.findVagasByCandidatoNaoPossua(idCandidato);
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

	public List<VagaModel> listarVagasPorNome(String filtro) {
		return vagaRepository.findByVagaNome(filtro);
	}


	public List<VagaModel> listarVagasPorCandidatoDisponiveis(int id){
		CandidatoModel candidato = candidatoService.getCandidatoPorIdUsuario(id);
		List<VagaModel> vagaList = vagaRepository.findAllByCandidatosIdNot(candidato.getId());
		return vagaList;
	}
	
	public CandidatoVagasModel candidatar(int idCandidato, int idVaga){
		Optional<VagaModel> vaga = vagaRepository.findById(idVaga);
		CandidatoModel candidato = candidatoService.getCandidatoPorIdUsuario(idCandidato);

		CandidatoVagasModel candidatoVagasModel = new CandidatoVagasModel(vaga.get(), candidato, "Análise");
		return candidatoVagasRepository.save(candidatoVagasModel);
	}

	public void atualizarStatus(int id, String status) {
		Optional<CandidatoVagasModel> vaga = candidatoVagasRepository.findByCandidatoVagasId(id);
		if (vaga.isPresent()) {
			vaga.get().setStatus(status);
			candidatoVagasRepository.save(vaga.get());
		}
	}

	public Optional<VagaModel> buscarVagaPorId(int idBVaga) {
		return vagaRepository.findById(idBVaga);
	}

	public List<VagaModel> listarVagasPorFiltro(String filtro, String valor) {
		CriteriaBuilder cb = CriteriaUtil.getCriteria();
		CriteriaQuery<VagaModel> cq = cb.createQuery(VagaModel.class);
		Root<VagaModel> root = cq.from(VagaModel.class);
		Predicate filtros = cb.and();
		cq.where(cb.equal(root.get(filtro),valor));
		return CriteriaUtil.getEntityManager().createQuery(cq).getResultList();
	}

	public List<VagasAdmDto> buscarVagasQuantidade() {
		return vagaRepository.findAllQuantidade();
	}

	public List<VagasAdmDto> buscarVagasQuantidadeFiltro(String filtro) {
		List<VagasAdmDto> vagas = vagaRepository.findAllQuantidadeFiltro(filtro);
		if(vagas.isEmpty()) {
			return new ArrayList<VagasAdmDto>();
		}
		return vagas;
	}


	public void removerVaga(int id) {
		vagaRepository.deleteById(id);
	}
}
