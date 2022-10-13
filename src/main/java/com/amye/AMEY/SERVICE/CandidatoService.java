package com.amye.AMEY.SERVICE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.amye.AMEY.DTO.CandidatoAtualizarDTO;
import com.amye.AMEY.DTO.CandidatoModelPontosDto;
import com.amye.AMEY.DTO.FiltroDTO;
import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.UTIL.CriteriaUtil;
import org.hibernate.Criteria;
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
	public CandidatoModel cadastraCandidato(CandidatoModel candidatoModel, UsuarioModel usuario, int idProfissao) {
		UsuarioModel usuarioModel = usuarioService.cadastraUsuario(usuario);
		ProfissoesModel profissoesModel = profissoesService.getProfissaoPorId(idProfissao);
		candidatoModel.setProfissao(profissoesModel);
		candidatoModel.setUsuario(usuarioModel);
		return candidatoRepository.save(candidatoModel);
	}

	public List<CandidatoModel> buscarCandidatos() {
		return candidatoRepository.findAll();
	}

	public CandidatoModel getCandidatoPorId(int id) {
		return candidatoRepository.findById(id).get();
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

	public int gerarLevel(CandidatoModel candidatoModel) {
		int pontos = candidatoModel.getPontos();
		return pontos/100;
	}

	public int gerarPontosRestante(CandidatoModel candidatoModel) {
		int pontos = candidatoModel.getPontos();
		return pontos%100;
	}
	
	public List<CandidatoModel> listarCandidatos(){
		return candidatoRepository.findAll();
	}

	public List<CandidatoModel> listarCandidatoPorFiltro(String filtro, String valor) {
		CriteriaBuilder cb = CriteriaUtil.getCriteria();
		CriteriaQuery<CandidatoModel> cq = cb.createQuery(CandidatoModel.class);
		Root<CandidatoModel> root = cq.from(CandidatoModel.class);
		Predicate filtros = cb.and();
		cq.where(cb.equal(root.get(filtro),valor));
		return CriteriaUtil.getEntityManager().createQuery(cq).getResultList();
	}

	public int calculaPontuacaoCandidato(List<HabilidadeModel> habilidadesCandidato, List<HabilidadeModel> habilidadesVaga) {
		List<HabilidadeModel> listaPercorrida = habilidadesCandidato.size() > habilidadesVaga.size() ? habilidadesCandidato : habilidadesVaga;
		List<HabilidadeModel> listaProcurada = habilidadesCandidato.size() < habilidadesVaga.size() ? habilidadesCandidato : habilidadesVaga;
		int pontuacao = 0;

		for(HabilidadeModel habilidade : listaPercorrida) {
			for (HabilidadeModel habilidadeProcurada : listaProcurada) {
				if(habilidadeProcurada.getNome().contains(habilidade.getNome()) || habilidade.getNome().contains(habilidadeProcurada.getNome())) {
					pontuacao =+ 50;
				}
			}
		}
		return pontuacao;
	}

	public List<CandidatoModelPontosDto> buscarCandidatosVagaOrderByPontos(int idVaga) {
		return candidatoRepository.findByVagasOrderByPontosDesc(idVaga);
	}

	public List<CandidatoModel> buscarCandidatosVagaPorFiltroOrderByPontos(int idVaga, FiltroDTO filtroDTO) {
		if(filtroDTO.isHabilidade()) {
			return candidatoRepository.findByVagasHabilidadeOrderByPontosDesc(idVaga, filtroDTO.getFiltro());
		}
		if(filtroDTO.isNome()) {
			return candidatoRepository.findByVagasCandidatoNomeOrderByPontosDesc(idVaga, filtroDTO.getFiltro());
		}
		if(filtroDTO.isSobrenome()) {
			return candidatoRepository.findByVagasCandidatoSobrenomeOrderByPontosDesc(idVaga, Integer.valueOf(filtroDTO.getFiltro()));
		}
		if(filtroDTO.isPontos()) {
			return candidatoRepository.findByVagasCandidatoPontosOrderByPontosDesc(idVaga, filtroDTO.getFiltro());
		}
		return new ArrayList<CandidatoModel>();
	}

	public void atualizarCandidato(CandidatoAtualizarDTO candidatoAtualizarDTO) {
		Optional<CandidatoModel> candidatoModel = candidatoRepository.findById(candidatoAtualizarDTO.getIdCandidato());
		if(candidatoModel.isPresent()) {
			candidatoRepository.save(candidatoAtualizarDTO.converterParaCandidatoModel(candidatoModel.get()));
		}
	}
}
