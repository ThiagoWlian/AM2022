package com.amye.AMEY.SERVICE;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amye.AMEY.MODEL.UsuarioModel;
import com.amye.AMEY.REPOSITORY.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioModel cadastraUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Boolean login (UsuarioModel usuario) {
		Optional<UsuarioModel> usuarioResult = usuarioRepository.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
		if(usuarioResult.isPresent()) {
			return true;
		}
		return false;
	}
}
