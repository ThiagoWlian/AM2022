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

    public CandidatoVagasModel(VagaModel vaga, CandidatoModel candidato, String status) {
        this.vagas = vaga;
        this.candidato = candidato;
        this.status = status;
    }

    public CandidatoVagasModel() {}

    public VagaModel getVaga() {
        return vagas;
    }

    public void setVaga(VagaModel vaga) {
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
}
