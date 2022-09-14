package com.amye.AMEY.MODEL;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CANDIDATO")
public class CandidatoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	@OneToOne
	private ProfissoesModel profissoes;
	@OneToOne
	private UsuarioModel usuario;
	@ManyToMany
	@JoinTable(name = "CANDIDATO_VAGAS",
	joinColumns = @JoinColumn(name = "CANDIDATO_ID"),
	inverseJoinColumns = @JoinColumn(name = "VAGAS_ID"))
	private List<VagaModel> vagas;
	
	public ProfissoesModel getProfissao() {
		return profissoes;
	}

	public void setProfissao(ProfissoesModel profissao) {
		this.profissoes = profissao;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void addVaga(VagaModel vaga) {
		vagas.add(vaga);
	}
	
	public CandidatoModel(int id, String nome, String sobrenome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}
	
	public CandidatoModel(String nome, String sobrenome, String email) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}
	
	
	public CandidatoModel(int id, String nome, String sobrenome, String email, ProfissoesModel profissao,
			UsuarioModel usuario) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.profissoes = profissao;
		this.usuario = usuario;
	}
	
	public CandidatoModel(String nome, String sobrenome, String email, ProfissoesModel profissao,
			UsuarioModel usuario) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.profissoes = profissao;
		this.usuario = usuario;
	}

	public CandidatoModel() {}
	
	
	
}
