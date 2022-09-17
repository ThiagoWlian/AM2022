package com.amye.AMEY.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RespostasProvaDto {

    int idProva;
    String respostas;

    public RespostasProvaDto(String respostas) {
        this.respostas = respostas;
    }

    public String getRespostas() {
        return respostas;
    }

    public void setRespostas(String respostas) {
        this.respostas = respostas;
    }

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public List<Integer> converteParaAlternativasIdList() {
        return Arrays.asList(respostas.split(";")).stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
    }
}
