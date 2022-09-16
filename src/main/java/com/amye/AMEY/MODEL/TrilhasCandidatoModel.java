package com.amye.AMEY.MODEL;

import javax.persistence.*;

@Entity
@Table(name = "TRILHAS_CANDIDATO")
public class TrilhasCandidatoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private TrilhaModel trilhas;

    @ManyToOne
    private CandidatoModel candidato;

    private boolean status;

    public TrilhasCandidatoModel(TrilhaModel trilhas, CandidatoModel candidato, boolean status) {
        this.trilhas = trilhas;
        this.candidato = candidato;
        this.status = status;
    }

    public TrilhasCandidatoModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrilhaModel getTrilhas() {
        return trilhas;
    }

    public void setTrilhas(TrilhaModel trilhas) {
        this.trilhas = trilhas;
    }

    public CandidatoModel getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoModel candidato) {
        this.candidato = candidato;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
