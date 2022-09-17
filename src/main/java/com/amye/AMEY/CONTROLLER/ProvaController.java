package com.amye.AMEY.CONTROLLER;

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
	private QuestaoService questaoService;
	
	@GetMapping("/{idProva}")
	public String getTelaProva(Model model,@PathVariable int idProva) {
		model.addAttribute("provas", provaService.obterProva(idProva));
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

		boolean questaoAprovada = false;

		for(QuestaoAlternativaDto questaoDto : questoes) {
			
			QuestaoModel questao = questaoDto.getQuestaoModel();
			questao.setProva(prova);
			if(!questaoAprovada) {
				questao.setTipo(true);
				questaoAprovada = true;
			} else {
				questao.setTipo(false);
			}
			questaoService.salvarQuestaoModel(questao);
			
			List<AlternativaModel> alternativas = questaoDto.getListAlternativaModel();
			alternativas.forEach(e -> e.setQuestao(questao));
			alternativaService.salvarListaAlternativasModel(alternativas);
		}
		return "redirect:/trilha";
	}

	@PostMapping("/enviarProva")
	public void envioProva(RespostasProvaDto respostasProvaDto, HttpServletRequest request) {
		List<Integer> listaIdQuestoes = respostasProvaDto.converteParaAlternativasIdList();
		int porcentagemAcertos = provaService.avaliarProvaEmPorcentagemAcertos(questaoService.transformaListaQustaoIdEmModel(listaIdQuestoes));
		HttpSession sessao = request.getSession();
		CandidatoModel candidatoModel = (CandidatoModel) sessao.getAttribute("candidato");
		if (porcentagemAcertos >= 60) {
			trilhasCandidatoSerivce.atualizarStatusParaTrue(candidatoModel.getId(), respostasProvaDto.getIdProva());
			candidatoService.aumentarPontosCandidato(candidatoModel.getId(), porcentagemAcertos);
		}
	}
}
