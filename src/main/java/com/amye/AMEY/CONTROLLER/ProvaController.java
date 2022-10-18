package com.amye.AMEY.CONTROLLER;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.amye.AMEY.DTO.RespostasProvaDto;
import com.amye.AMEY.MODEL.*;
import com.amye.AMEY.SERVICE.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.CadastroProvaDto;
import com.amye.AMEY.DTO.QuestaoAlternativaDto;

@Controller
@RequestMapping("/prova")
public class ProvaController {

	@Autowired
	private TrilhaService trilhaService;
	
	@Autowired
	private ProvaService provaService;

	@Autowired
	private  CandidatoService candidatoService;
	@Autowired
	private TrilhasCandidatoSerivce trilhasCandidatoSerivce;
	
	@Autowired
	private AlternativaService alternativaService;

	@Autowired
	private VagaCandidatoService vagaCandidatoService;

	@Autowired
	private QuestaoService questaoService;

	List<Integer> respostas;
	
	@GetMapping("/{idProva}")
	public String getTelaProva(Model model,@PathVariable int idProva, HttpServletRequest request) {
		respostas = new ArrayList<>();
		CandidatoModel candidato = (CandidatoModel) request.getSession().getAttribute("candidato");
		model.addAttribute("provas", provaService.obterProva(idProva));
		model.addAttribute("respostas", respostas);
		model.addAttribute("candidato", candidato);
		return "prova";
	}
	
	@GetMapping("/cadastro")
	public String telaCadastarProvas(Model model) {
		List<TrilhaModel> lista = trilhaService.listarTrilhas();
		model.addAttribute("trilhas", lista);
		return "cadastroProva";
	}
	
	@PostMapping
	@Transactional
	public String cadastrarProva(CadastroProvaDto cadastroProvaDto) {
		List<QuestaoAlternativaDto> questoes = cadastroProvaDto.listaQuestaoAlternativaDto();
		
		ProvaModel prova = provaService.cadastrarProva(cadastroProvaDto.converterParaProvaModel());
		trilhaService.atualizarProvaTrilha(cadastroProvaDto.getId(), prova);

		boolean alternativaAprovada = false;

		for(QuestaoAlternativaDto questaoDto : questoes) {
			alternativaAprovada = false;

			QuestaoModel questao = questaoDto.getQuestaoModel();
			List<AlternativaModel> alternativas = questaoDto.getListAlternativaModel();
			questao.setProva(prova);

			for (AlternativaModel alternativa : alternativas) {
				if(!alternativaAprovada) {
					alternativa.setTipo(true);
					alternativaAprovada = true;
				} else {
					alternativa.setTipo(false);
				}
			}
			questaoService.salvarQuestaoModel(questao);
			alternativas.forEach(e -> e.setQuestao(questao));
			alternativaService.salvarListaAlternativasModel(alternativas);
		}
		return "redirect:/trilha/gerencia";
	}


	@PostMapping("/enviarProva")
	public String envioProva(RespostasProvaDto respostasProvaDto, HttpServletRequest request) {
		List<Integer> listaIdQuestoes = respostasProvaDto.converteParaAlternativasIdList();
		int porcentagemAcertos = provaService.avaliarProvaEmPorcentagemAcertos(alternativaService.transformaListaAlternativaIdEmModel(listaIdQuestoes));
		HttpSession sessao = request.getSession();
		CandidatoModel candidatoModel = (CandidatoModel) sessao.getAttribute("candidato");
		TrilhaModel trilha = trilhaService.buscarTrilhaPorProva(respostasProvaDto.getIdProva()).get();
		if (porcentagemAcertos >= 60) {
			trilhasCandidatoSerivce.atualizarStatusParaTrue(candidatoModel.getId(), trilha.getId());
			candidatoService.aumentarPontosCandidato(candidatoModel.getId(), porcentagemAcertos);
			List<CandidatoVagasModel> candidatoVagasModelList = vagaCandidatoService.buscarCandidatosVagas(trilha.getHabilidades() ,candidatoModel);
			vagaCandidatoService.aumentarPontos(candidatoVagasModelList,porcentagemAcertos);
		}
		return "redirect:/vaga/vagaCandidato";
	}
}
