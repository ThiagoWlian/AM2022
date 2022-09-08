package com.amye.AMEY.CONTROLLER;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.CadastroProvaDto;
import com.amye.AMEY.DTO.QuestaoAlternativaDto;
import com.amye.AMEY.MODEL.AlternativaModel;
import com.amye.AMEY.MODEL.ProvaModel;
import com.amye.AMEY.MODEL.QuestaoModel;
import com.amye.AMEY.MODEL.TrilhaModel;
import com.amye.AMEY.SERVICE.AlternativaService;
import com.amye.AMEY.SERVICE.ProvaService;
import com.amye.AMEY.SERVICE.QuestaoService;
import com.amye.AMEY.SERVICE.TrilhaService;

@Controller
@RequestMapping("/prova")
public class ProvaController {

	@Autowired
	private TrilhaService trilhaService;
	
	@Autowired
	private ProvaService provaService;
	
	@Autowired
	private AlternativaService alternativaService;
	
	@Autowired
	private QuestaoService questaoService;
	
	@GetMapping
	public String getTelaProva(Model model) {
		model.addAttribute("provas", provaService.obterProva(17));
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
		
		for(QuestaoAlternativaDto questaoDto : questoes) {
			
			QuestaoModel questao = questaoDto.getQuestaoModel();
			questao.setProva(prova);
			questaoService.salvarQuestaoModel(questao);
			
			List<AlternativaModel> alternativas = questaoDto.getListAlternativaModel();
			alternativas.forEach(e -> e.setQuestao(questao));
			alternativaService.salvarListaAlternativasModel(alternativas);
		}
		
		return "redirect:/trilha";
	}
}
