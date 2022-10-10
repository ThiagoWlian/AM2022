package com.amye.AMEY.DTO;

import com.amye.AMEY.MODEL.CandidatoModel;

public class CandidatoAtualizarDTO {
    private int idCandidato;
    private String nome;
    private String sobrenome;
    private String email;

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
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

    public CandidatoModel converterParaCandidatoModel(CandidatoModel candidatoModel) {
        candidatoModel.setNome(nome != null ? nome: candidatoModel.getNome());
        candidatoModel.setSobrenome(sobrenome != null ? sobrenome: candidatoModel.getSobrenome());
        candidatoModel.setEmail(email != null ? email: candidatoModel.getEmail());
        return candidatoModel;
    }
}
