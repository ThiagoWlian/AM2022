package com.amye.AMEY.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.MODEL.VagaModel;


public class CadastroVagaDto {
	private String nome;
	private String descricao;
	private String salario;
	private String experiencia;
	private String listaDeHabilidades;
	
	private List<String> getListaHabilidades(){
		return new ArrayList<String>(Arrays.asList(listaDeHabilidades.split(";")));
	}
	
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
	}

	public VagaModel transformaEmVagaModel() {
		return new VagaModel(nome, descricao, salario, experiencia);
	}
	
	public List<HabilidadeModel> listarHabilidades() {
		return getListaHabilidades().stream().map(e -> new HabilidadeModel(e)).collect(Collectors.toList());
	}
	
}
