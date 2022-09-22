package com.amye.AMEY.CONTROLLER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.amye.AMEY.SERVICE.CandidatoService;
import com.amye.AMEY.SERVICE.CurriculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.LoginDto;
import com.amye.AMEY.DTO.UsuarioDo;
import com.amye.AMEY.SERVICE.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@Autowired
	CandidatoService candidatoService;
	
	@Autowired
	CurriculoService curriculoService;
	
	@GetMapping("/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping("/logar")
	public String login(LoginDto loginDto, HttpServletRequest request) {
		if(usuarioService.login(loginDto.transformarEmUsuario())) {
			UsuarioDo usuario = usuarioService.buscarUsuarioPeloLogin(loginDto.transformarEmUsuario());
			HttpSession sessao = request.getSession();
			sessao.setAttribute("user", usuario.getUser());
			sessao.setAttribute("idUser", usuario.getId());
			sessao.setAttribute("candidato", candidatoService.getCandidatoPorIdUsuario(usuario.getId()));
			return "redirect:/vaga";
		}
		return "redirect:/usuario/login";
	}
}
