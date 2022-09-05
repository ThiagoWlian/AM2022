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
import com.amye.AMEY.MODEL.ProvaModel;
import com.amye.AMEY.MODEL.TrilhaModel;
import com.amye.AMEY.SERVICE.ProvaService;
import com.amye.AMEY.SERVICE.TrilhaService;

@Controller
@RequestMapping("/prova")
public class ProvaController {

	@Autowired
	private TrilhaService trilhaService;
	
	@Autowired
	private ProvaService provaService;
	
	@GetMapping("/cadastro")
	public String telaCadastarProvas(Model model) {
		List<TrilhaModel> lista = trilhaService.listarTrilhas();
		model.addAttribute("trilhas", lista);
		return "cadastroProva";
	}
	
	@PostMapping
	@Transactional
	public String cadastrarProva(CadastroProvaDto cadastroProvaDto) {
		ProvaModel prova = provaService.cadastrarProva(cadastroProvaDto.converterParaProvaModel());
		trilhaService.atualizarProvaTrilha(cadastroProvaDto.getId(), prova);
		return "redirect:/trilha";
	}
}
