package com.amye.AMEY.CONTROLLER;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.amye.AMEY.DTO.*;
import com.amye.AMEY.MODEL.*;
import com.amye.AMEY.SERVICE.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping
	public String abrirListaTelaVagas(Model model, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		int id = (int) sessao.getAttribute("idUser");
		CandidatoModel candidato = (CandidatoModel) sessao.getAttribute("candidato");
		List<VagaModel> vagasLista = vagasService.listarVagas(candidato.getId());
		model.addAttribute("vagas", vagasLista);
		model.addAttribute("candidato", candidato);
		return "vagas";
	}
	
	@GetMapping("/vagaCandidato")
	public String abrirListaTelaVagasCandidato(Model model, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		int id = (int) sessao.getAttribute("idUser");
		CandidatoModel candidato = (CandidatoModel) sessao.getAttribute("candidato");
		List<CandidatoVagasModel> candidatoVagaList = vagaCandidatoService.buscarCandidatoVagaModelPeloCandidato(candidato.getId());
		model.addAttribute("candidatoVagasList", candidatoVagaList);
		model.addAttribute("candidato", candidato);
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
		return "redirect:/vaga/gerencia";
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
	public String detalharVaga(@PathVariable int idVaga, Model model, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		CandidatoModel candidato = (CandidatoModel) sessao.getAttribute("candidato");
		model.addAttribute("vaga", vagasService.buscarVagaPorId(idVaga).get());
		model.addAttribute("candidato", candidato);
		return "VagaDetalhes";
	}

	@GetMapping("/detalheadm/{idVaga}")
	public String detalharVagaadm(@PathVariable int idVaga, Model model, HttpServletRequest request) {
		model.addAttribute("vaga", vagasService.buscarVagaPorId(idVaga).get());
		return "VagaDetalhesadm";
	}
	@GetMapping("/gerencia")
	public String listarVagasAdm(Model model, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		CandidatoModel candidato = (CandidatoModel) sessao.getAttribute("candidato");
		model.addAttribute("candidato", candidato);
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
	public String listarVagasAdmFiltro(Model model, FiltroDTO filtroDTO, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		CandidatoModel candidato = (CandidatoModel) sessao.getAttribute("candidato");
		model.addAttribute("candidato", candidato);

		List<VagasAdmDto> listaVagasConsulta = vagasService.buscarVagasQuantidadeFiltro(filtroDTO.getFiltro());

		model.addAttribute("vagas", listaVagasConsulta);
		return "VagasAdm";
	}

	@GetMapping("/telaAtualizar/{idVaga}")
	public String telaUpdate(Model model, @PathVariable int idVaga) {
		VagaModel vaga = vagasService.buscarVagaPorId(idVaga).get();
		model.addAttribute("vaga", vagasService.buscarVagaPorId(idVaga).get());
		return "updateVagas";
	}

	@PostMapping("/atualizar/{id}")
	public String atualizarDados(UpdateVagaDto updateVagaDto, @PathVariable int id) {
		List<HabilidadeModel> listaHabilidadesPersistidas = habilidadesService.cadastarListaDeHabilidades(updateVagaDto.listarHabilidades());
		VagaModel vaga = vagasService.buscarVagaPorId(id).get();
		VagaModel vagaParaPersistencia = updateVagaDto.transformaEmVagaModel(vaga);
		vagaParaPersistencia.setHabilidades(listaHabilidadesPersistidas);
		vagasService.cadastrarVaga(vagaParaPersistencia);
		return "redirect:/vaga/gerencia";
	}

	@PostMapping("/status")
	public String atualizarStatus(StatusDto statusDto) {
		vagaCandidatoService.atualizarstatus(statusDto.getStatus(), statusDto.getIdCandidato(), statusDto.getIdVaga());
		return "redirect:/vaga/gerencia";
	}

}
