package com.amye.AMEY.CONTROLLER;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@ModelAttribute("habilidades")
	public List<HabilidadeModel> getListHabilidade() {
		return new ArrayList<HabilidadeModel>();
	}
	
	@GetMapping
	public String abrirListaTelaVagas(Model model) {
		List<VagaModel> vagasLista = vagasService.listarVagas();
		model.addAttribute("vagas", vagasLista);
		return "vagas";
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
}
