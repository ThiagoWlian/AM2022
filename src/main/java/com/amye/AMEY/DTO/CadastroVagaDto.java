package com.amye.AMEY.DTO;

import com.amye.AMEY.MODEL.VagaModel;

import net.bytebuddy.asm.Advice.This;

public class CadastroVagaDto {
	private String nome;
	private String descricao;
	private String salario;
	private String experiencia;
	private String listaDeHabilidades;
	
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
	
	public String getListaDeHabilidades() {
		return listaDeHabilidades;
	}

	public void setListaDeHabilidades(String listaDeHabilidades) {
		this.listaDeHabilidades = listaDeHabilidades;
		System.out.println(this.listaDeHabilidades);
	}

	public VagaModel transformaEmVagaModel() {
		return new VagaModel(nome, descricao, salario, experiencia);
	}
	
}
