package com.amye.AMEY.DTO;

import com.amye.AMEY.MODEL.HabilidadeModel;
import com.amye.AMEY.MODEL.VagaModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class UpdateVagaDto {

	private String idVaga;
	private String nome;
	private String descricao;
	private String salario;
	private String tempo_experiencia;
	private String listaDeHabilidades;
	private String beneficios;
	private String prerequisitos;
	
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
	
	public String getTempo_experiencia() {
		return tempo_experiencia;
	}
	
	public void setTempo_experiencia(String tempo_experiencia) {
		this.tempo_experiencia = tempo_experiencia;
	}
	
	public String getListaDeHabilidades() {
		return listaDeHabilidades;
	}

	public void setListaDeHabilidades(String listaDeHabilidades) {
		this.listaDeHabilidades = listaDeHabilidades;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getPrerequisitos() {
		return prerequisitos;
	}

	public void setPrerequisitos(String prerequisitos) {
		this.prerequisitos = prerequisitos;
	}

	public VagaModel transformaEmVagaModel(VagaModel vaga) {
		vaga.setNome(nome);
		vaga.setDescricao(descricao);
		vaga.setPrerequisitos(prerequisitos);
		vaga.setBeneficios(beneficios);
		vaga.setSalario(salario);
		vaga.setTempo_experiencia(tempo_experiencia);

		return vaga;
	}

	public int getIdVaga() {
		return Integer.valueOf(idVaga);
	}

	public void setIdVaga(int idVaga) {
		this.idVaga = String.valueOf(idVaga);
	}

	public List<HabilidadeModel> listarHabilidades() {
		return getListaHabilidades().stream().map(e -> new HabilidadeModel(e)).collect(Collectors.toList());
	}
	
}
