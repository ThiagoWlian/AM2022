package com.amye.AMEY.MODEL;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CURRICULO")
public class CurriculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String link;
    @ManyToOne
    private CandidatoModel candidato;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculo")
    private List<ExperienciaModel> experiencias;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curriculo")
    private List<FormacoesModel> formacoes;

    @ManyToMany
    @JoinTable(name = "HABILIDADES_CURRICULO",
            joinColumns = @JoinColumn(name = "CURRICULO_ID"),
            inverseJoinColumns = @JoinColumn(name = "HABILIDADES_ID"))
    private List<HabilidadeModel> habilidades;

    public CurriculoModel(CandidatoModel candidato) {
        this.candidato = candidato;
    }

    public CurriculoModel(CurriculoModel curriculoModel) {
        this.id = curriculoModel.id;
        this.candidato = curriculoModel.candidato;
    }

    public CurriculoModel() {

    }

    public List<HabilidadeModel> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<HabilidadeModel> habilidades) {
        this.habilidades = habilidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public CandidatoModel getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoModel candidato) {
        this.candidato = candidato;
    }

    public List<ExperienciaModel> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<ExperienciaModel> experiencias) {
        this.experiencias = experiencias;
    }

    public List<FormacoesModel> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(List<FormacoesModel> formacoes) {
        this.formacoes = formacoes;
    }

    public void addFormacao(FormacoesModel formacoesModel) {
        formacoes.add(formacoesModel);
    }

    public void addExperiencia(ExperienciaModel experienciaModel) {
        experiencias.add(experienciaModel);
    }
}
