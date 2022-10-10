package com.amye.AMEY.DTO;

public class VagasAdmDto {
    private int idVaga;
    private String nome;
    private long numeroCandidaturas;

    public VagasAdmDto(int idVaga, String nome, long numeroCandidaturas) {
        this.idVaga = idVaga;
        this.nome = nome;
        this.numeroCandidaturas = numeroCandidaturas;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumeroCandidaturas() {
        return numeroCandidaturas;
    }

    public void setNumeroCandidaturas(long numeroCandidaturas) {
        this.numeroCandidaturas = numeroCandidaturas;
    }
}
