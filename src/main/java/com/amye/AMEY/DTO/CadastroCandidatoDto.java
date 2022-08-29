package com.amye.AMEY.DTO;

import com.amye.AMEY.MODEL.CandidatoModel;
import com.amye.AMEY.MODEL.UsuarioModel;

public class CadastroCandidatoDto {
	private String username;
	private String password;
	private String passwordRepeat;
	private String email;
	private String nome;
	private String sobrenome;
	private int profissao;
	
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
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getProfissao() {
		return profissao;
	}
	public void setProfissao(int profissao) {
		this.profissao = profissao;
	}
	
	public CandidatoModel transformarEmCandidato() {
		return new CandidatoModel(nome, sobrenome, email);
	}
	
	public UsuarioModel transformarEmUsuario() {
		return new UsuarioModel(username,password);
	}
}
