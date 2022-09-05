package com.amye.AMEY.DTO;

import com.amye.AMEY.MODEL.VagaModel;

public class CadastroVagaDto {
	private String nome;
	private String descricao;
	private String salario;
	private String experiencia;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getSalario() {
		return salario;
	}
	
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	public String getExperiencia() {
		return experiencia;
	}
	
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
	public VagaModel transformaEmVagaModel() {
		return new VagaModel(nome, descricao, salario, experiencia);
	}
	
}
