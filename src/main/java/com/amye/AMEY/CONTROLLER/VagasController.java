package com.amye.AMEY.CONTROLLER;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.amye.AMEY.DTO.FiltroDTO;
import com.amye.AMEY.MODEL.*;
import com.amye.AMEY.SERVICE.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.amye.AMEY.DTO.CadastroVagaDto;

@Controller
@RequestMapping("/vaga")
public class VagasController {
	
	@Autowired
	private VagasService vagasService;

	@Autowired
	private VagaCandidatoService vagaCandidatoService;

	@Autowired
	private CandidatoService candidatoService;
	
	@Autowired
	private HabilidadesService habilidadesService;

	@Autowired
	private CurriculoService curriculoService;

	@Autowired
	TrilhasCandidatoSerivce trilhasCandidatoSerivce;

	@ModelAttribute("habilidades")
	public List<HabilidadeModel> getListHabilidade() {
		return new ArrayList<HabilidadeModel>();
	}
	
	@GetMapping("")
	public String abrirListaTelaVagas(Model model) {
		List<VagaModel> vagasLista = vagasService.listarVagas();
		model.addAttribute("vagas", vagasLista);
		return "vagas";
	}
	
	@GetMapping("/vagaCandidato")
	public String abrirListaTelaVagasCandidato(Model model, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		int id = (int) sessao.getAttribute("idUser");
		CandidatoModel candidato = (CandidatoModel) sessao.getAttribute("candidato");
		List<CandidatoVagasModel> candidatoVagaList = vagaCandidatoService.buscarCandidatoVagaModelPeloCandidato(candidato.getId());
		model.addAttribute("candidatoVagasList", candidatoVagaList);
		return "vagasCandidato";
	}
	
	@GetMapping("/cadastro")
	public String cadastroVagas(Model model) {
		return "cadastroVagas";
	}
	
	@PostMapping("/cadastro")
	public String cadastrarVaga(CadastroVagaDto cadastroVagaDto, @ModelAttribute("habilidades") List<HabilidadeModel> habilidades) {
		List<HabilidadeModel> listaHabilidadesPersistidas = habilidadesService.cadastarListaDeHabilidades(cadastroVagaDto.listarHabilidades());
		VagaModel vagaParaPersistencia = cadastroVagaDto.transformaEmVagaModel();
		vagaParaPersistencia.setHabilidades(listaHabilidadesPersistidas);
		vagasService.cadastrarVaga(vagaParaPersistencia);
		return "redirect:/vaga";
	}
	
	@GetMapping("/candidatar/{idVaga}")
	@Transactional
	public String candidatarVaga(@PathVariable int idVaga, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		int id = (int) sessao.getAttribute("idUser");
		CandidatoModel candidatoModel = (CandidatoModel) sessao.getAttribute("candidato");
		CurriculoModel curriculoModel = curriculoService.buscarCurriculoPeloCandidato(candidatoModel.getId());
		CandidatoVagasModel candidatoVagasModel = vagasService.candidatar(id, idVaga);
		Optional<VagaModel> vaga = vagasService.buscarVagaPorId(idVaga);
		if(vaga.isPresent()) {
			trilhasCandidatoSerivce.salvarTrilhasCandidatoPorListHabilidades(vaga.get().getHabilidades(), candidatoModel);
			vagaCandidatoService.aumentarPontos(candidatoVagasModel,candidatoService.calculaPontuacaoCandidato(curriculoModel.getHabilidades() ,vaga.get().getHabilidades()));
		}
		return "redirect:/vaga/vagaCandidato";
	}

	@GetMapping("/detalhe/{idVaga}")
	public String detalharVaga(@PathVariable int idVaga, Model model) {
		model.addAttribute("vaga", vagasService.buscarVagaPorId(idVaga).get());
		return "VagaDetalhes";
	}
	@GetMapping("/gerencia")
	public String listarVagasAdm(Model model) {
		model.addAttribute("vagas", vagasService.buscarVagasQuantidade());
		return "VagasAdm";
	}

	@GetMapping("/remover/{idVaga}")
	public String removerVaga(@PathVariable int idVaga) {
		vagasService.removerVaga(idVaga);
		return "redirect:/vaga/gerencia";
	}

	@GetMapping("/listarCandidatos/{idVaga}")
	public String listarCandidatosVaga(Model model, @PathVariable int idVaga) {
		model.addAttribute("candidatos", candidatoService.buscarCandidatosVagaOrderByPontos(idVaga));
		model.addAttribute("idVaga", idVaga);
		return "CandidatosVaga";
	}

	@PostMapping("/listarCandidatos/filtro/{idVaga}")
	public String listarCandidatosVagaFiltro(Model model, @PathVariable int idVaga,FiltroDTO filtroDTO) {
		model.addAttribute("candidatos", candidatoService.buscarCandidatosVagaPorFiltroOrderByPontos(idVaga, filtroDTO));
		model.addAttribute("idVaga", idVaga);
		return "CandidatosVaga";
	}

	@PostMapping("/gerencia/filtro")
	public String listarVagasAdmFiltro(Model model, FiltroDTO filtroDTO) {
		model.addAttribute("vagas", vagasService.buscarVagasQuantidadeFiltro(filtroDTO.getFiltro()));
		return "VagasAdm";
	}
}
