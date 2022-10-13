package com.amye.AMEY.DTO;

public class StatusDto {

    private int idCandidato;
    private int idVaga;
    private String status;

    public String getStatus() {
        return status;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }
}
