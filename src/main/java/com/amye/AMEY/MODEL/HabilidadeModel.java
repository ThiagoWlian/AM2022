package com.amye.AMEY.MODEL;

import com.amye.AMEY.DTO.JSONCONVERT.Skills;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HABILIDADES")
public class HabilidadeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;

	@ManyToMany(mappedBy = "habilidades")
	private List<VagaModel> vagas;

	@ManyToMany(mappedBy = "habilidades")
	private List<TrilhaModel> trilhas;

	@ManyToMany(mappedBy = "habilidades")
	private List<CurriculoModel> curriculo;

	public HabilidadeModel() {}

	public HabilidadeModel(Skills skills) {
		this.nome = skills.getName();
	}


	public HabilidadeModel(String nome) {
		super();
		this.nome = nome;
	}

	public List<CurriculoModel> getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(List<CurriculoModel> curriculo) {
		this.curriculo = curriculo;
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

	public List<VagaModel> getVagas() {
		return vagas;
	}

	public void setVagas(List<VagaModel> vagas) {
		this.vagas = vagas;
	}

    public List<TrilhaModel> getTrilhas() {
        return trilhas;
    }

    public void setTrilhas(List<TrilhaModel> trilhas) {
        this.trilhas = trilhas;
    }
	public void addCurriculo(CurriculoModel curriculoModel) {
		curriculo.add(curriculoModel);
	}
    public void addVaga(VagaModel vaga) {
		vagas.add(vaga);
	}
}
