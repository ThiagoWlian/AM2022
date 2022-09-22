package com.amye.AMEY.CONTROLLER;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.amye.AMEY.MODEL.CandidatoModel;
import com.amye.AMEY.SERVICE.TrilhasCandidatoSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.CadastroVagaDto;
import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.MODEL.VagaModel;
import com.amye.AMEY.SERVICE.HabilidadesService;
import com.amye.AMEY.SERVICE.VagasService;

@Controller
@RequestMapping("/vaga")
public class VagasController {
	
	@Autowired
	private VagasService vagasService;
	
	@Autowired
	private HabilidadesService habilidadesService;

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
		List<VagaModel> vagasLista = vagasService.listarVagasPorCandidato(id);
		model.addAttribute("vagas", vagasLista);
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
	public String candidatrVaga(@PathVariable int idVaga, HttpServletRequest request) {
		HttpSession sessao = request.getSession();
		int id = (int) sessao.getAttribute("idUser");
		CandidatoModel candidatoModel = (CandidatoModel) sessao.getAttribute("candidato");
		vagasService.candidatar(id, idVaga);
		Optional<VagaModel> vaga = vagasService.buscarVagaPorId(idVaga);
		if(vaga.isPresent()) {
			trilhasCandidatoSerivce.salvarTrilhasCandidatoPorListHabilidades(vaga.get().getHabilidades(), candidatoModel);
		}
		return "redirect:/vaga/vagaCandidato";
	}
}
