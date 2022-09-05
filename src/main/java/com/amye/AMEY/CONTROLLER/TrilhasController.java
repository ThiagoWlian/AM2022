package com.amye.AMEY.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.CadastroTrilhaDto;
import com.amye.AMEY.MODEL.TrilhaModel;
import com.amye.AMEY.SERVICE.TrilhaService;

@Controller
@RequestMapping("/trilha")
public class TrilhasController {

	@Autowired
	TrilhaService trilhaService;
	
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
	
	@PostMapping("/cadastrar")
	public String CadastroTrilha(CadastroTrilhaDto cadastroTrilhaDto) {
		trilhaService.cadastrarTrilha(cadastroTrilhaDto.converterParaTrilhaModel());
		return "redirect:/trilha";
	}
}
