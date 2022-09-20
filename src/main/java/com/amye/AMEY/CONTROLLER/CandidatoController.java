package com.amye.AMEY.CONTROLLER;

import com.amye.AMEY.DTO.JSONCONVERT.Data;
import com.amye.AMEY.MODEL.CurriculoModel;
import com.amye.AMEY.MODEL.FormacoesModel;
import com.amye.AMEY.SERVICE.CurriculoService;
import com.amye.AMEY.SERVICE.ExperienciaService;
import com.amye.AMEY.SERVICE.FormacaoService;
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

	@Autowired
	FormacaoService formacaoService;

	@Autowired
	ExperienciaService experienciaService;

	@Autowired
	CurriculoService curriculoService;

	
	@GetMapping("/telaCadastro")
	public String telaCadastro() {
		return "cadastroInicial";
	}
	
	@PostMapping("/cadastro")
	public String cadastro(CadastroCandidatoDto candidatoRequisicao) {
		CandidatoModel candidatoModel = candidatoRequisicao.transformarEmCandidato();
		UsuarioModel usuario = candidatoRequisicao.transformarEmUsuario();
		CandidatoModel candidatoCadastrado = candidatoService.cadastraCandidato(candidatoModel, usuario, candidatoRequisicao.getProfissao());

		CurriculoModel curriculoCadastrado = curriculoService.criarNovoCurriculo(new CurriculoModel(candidatoCadastrado));
		FormacoesModel formacoesModel = formacaoService.cadastrarFormacao(new FormacoesModel());


		return "cadastroInicial";
	}
}
