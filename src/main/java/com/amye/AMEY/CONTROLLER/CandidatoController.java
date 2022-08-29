package com.amye.AMEY.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.CadastroCandidatoDto;
import com.amye.AMEY.MODEL.CandidatoModel;
import com.amye.AMEY.MODEL.UsuarioModel;
import com.amye.AMEY.SERVICE.CandidatoService;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	@Autowired
	CandidatoService candidatoService;
	
	@GetMapping("/telaCadastro")
	public String telaCadastro() {
		return "cadastroInicial";
	}
	
	@PostMapping("/cadastro")
	public String cadastro(CadastroCandidatoDto candidatoRequisicao) {
		CandidatoModel candidatoModel = candidatoRequisicao.transformarEmCandidato();
		UsuarioModel usuario = candidatoRequisicao.transformarEmUsuario();
		candidatoService.cadastraCandidato(candidatoModel, usuario, candidatoRequisicao.getProfissao());
		return "cadastroInicial";
	}
}
