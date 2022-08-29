package com.amye.AMEY.CONTROLLER;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.MODEL.VagaModel;
import com.amye.AMEY.SERVICE.VagasService;

@Controller
@RequestMapping("/vaga")
public class VagasController {
	
	@Autowired
	private VagasService vagasService;

	@GetMapping
	public String abrirListaTelaVagas(Model model) {
		List<VagaModel> vagasLista = vagasService.listarVagas();
		model.addAttribute("vagas", vagasLista);
		return "vagas";
	}
}
