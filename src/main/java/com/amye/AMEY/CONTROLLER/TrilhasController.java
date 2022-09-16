package com.amye.AMEY.CONTROLLER;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.CadastroTrilhaDto;
import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.MODEL.TrilhaModel;
import com.amye.AMEY.SERVICE.HabilidadesService;
import com.amye.AMEY.SERVICE.TrilhaService;

@Controller
@RequestMapping("/trilha")
public class TrilhasController {

	@Autowired
	TrilhaService trilhaService;
	
	@Autowired
	HabilidadesService habilidadesService;
	
	@GetMapping
	public String abrirListaTrilhasVagas(Model model) {
		List<TrilhaModel> listarTrilhas = trilhaService.listarTrilhas();
		model.addAttribute("listarTrilhas", listarTrilhas);
		return "trilhas";
	}
	
	@GetMapping("/cadastro")
	public String telaCadastroTrilha(Model model) {
		return "cadastroTrilhas";
	}
	
	@GetMapping("/conteudo/{idConteudo}")
	public String telaConteudoTrilha(Model model, @PathVariable int idConteudo) {
		model.addAttribute("nomeTrilha", trilhaService.buscarTrilhaPorId(idConteudo).get().getNome());
		model.addAttribute("conteudoLista", trilhaService.listarConteudoTrilhaPorIdProva(idConteudo));
		return "trilhaConteudo";
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public String CadastroTrilha(CadastroTrilhaDto cadastroTrilhaDto) {
		List<HabilidadeModel> listaHabilidades = habilidadesService.cadastarListaDeHabilidades(cadastroTrilhaDto.listarHabilidades());
		trilhaService.cadastrarTrilha(cadastroTrilhaDto.converterParaTrilhaModel(), cadastroTrilhaDto.converterParaListaDto(), listaHabilidades);
		return "redirect:/prova/cadastro";
	}
}
