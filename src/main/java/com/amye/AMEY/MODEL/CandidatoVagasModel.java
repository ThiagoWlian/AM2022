package com.amye.AMEY.MODEL;

import javax.persistence.*;

@Entity
@Table(name = "CANDIDATO_VAGAS")
public class CandidatoVagasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private VagaModel vagas;
    @ManyToOne
    private CandidatoModel candidato;
    private String status;
    private int pontos;

    public CandidatoVagasModel(VagaModel vaga, CandidatoModel candidato, String status) {
        this.vagas = vaga;
        this.candidato = candidato;
        this.status = status;
    }

    public CandidatoVagasModel() {}

    public VagaModel getVagas() {
        return vagas;
    }

    public void setVagas(VagaModel vaga) {
        this.vagas = vaga;
    }

    public CandidatoModel getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoModel candidato) {
        this.candidato = candidato;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void aumentarPontos(int pontos) {
        this.pontos += pontos;
    }

    public int calcularLevel() {
        return pontos/100;
    }

    public int calcularPontosRestantes() {
        return pontos%100;
    }
}
