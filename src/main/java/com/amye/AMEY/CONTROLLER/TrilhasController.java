package com.amye.AMEY.CONTROLLER;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.amye.AMEY.MODEL.CandidatoModel;
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
	public String abrirListaTrilhasVagas(Model model, HttpServletRequest request) {
		CandidatoModel candidato = (CandidatoModel) request.getSession().getAttribute("candidato");
		List<TrilhaModel> listarTrilhas = trilhaService.listarTrilhas(candidato.getId(), false);
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

	@GetMapping("/filtro/{nome}")
	public String abrirListaTrilhasVagasFiltroNome(Model model, HttpServletRequest request, @PathVariable String nome) {
		CandidatoModel candidato = (CandidatoModel) request.getSession().getAttribute("candidato");
		List<TrilhaModel> listarTrilhas = trilhaService.buscarTrilhaPorNome(candidato.getId(), false, nome);
		model.addAttribute("listarTrilhas", listarTrilhas);
		return "trilhas";
	}

	@GetMapping("/gerencia")
	public String abrirListaTrilhasADM(Model model, HttpServletRequest request) {
		CandidatoModel candidato = (CandidatoModel) request.getSession().getAttribute("candidato");
		List<TrilhaModel> listaTrilhas = trilhaService.buscarTrilhas();
		model.addAttribute("listarTrilhas", listaTrilhas);
		model.addAttribute("candidato", candidato);
		return "trilhasADM";
	}

	@GetMapping("/telaAtualizar/{idTrilha}")
	public String abrirTelaAtualizar(@PathVariable int idTrilha, Model model) {
		model.addAttribute("trilha", trilhaService.buscarTrilhaPorId(idTrilha).get());
		return "atualizarTrilhas";
	}
}
