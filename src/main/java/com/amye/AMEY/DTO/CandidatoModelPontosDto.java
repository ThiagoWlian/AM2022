package com.amye.AMEY.DTO;

public class CandidatoModelPontosDto {
    private int id;
    private String nome;
    private String sobrenome;
    private int pontos;

    public CandidatoModelPontosDto(int id, String nome, String sobrenome, int pontos) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.pontos = pontos;
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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
