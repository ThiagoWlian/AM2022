package com.amye.AMEY.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amye.AMEY.DTO.LoginDto;
import com.amye.AMEY.SERVICE.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping("/logar")
	public String login(LoginDto loginDto) {
		if(usuarioService.login(loginDto.transformarEmUsuario())) {
			return "vagas";
		}
		return "login";
	}
}
