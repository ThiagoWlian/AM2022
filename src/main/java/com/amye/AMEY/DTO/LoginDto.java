package com.amye.AMEY.DTO;

import com.amye.AMEY.MODEL.UsuarioModel;

public class LoginDto {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UsuarioModel transformarEmUsuario() {
		return new UsuarioModel(username,password);
	}
}
