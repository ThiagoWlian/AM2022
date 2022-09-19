package com.amye.AMEY.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RespostasProvaDto {

    int idProva;

    String resposta0 = "";
    String resposta1 = "";
    String resposta2 = "";
    String resposta3 = "";
    String resposta4 = "";
    String resposta5 = "";
    String resposta6 = "";
    String resposta7 = "";
    String resposta8 = "";
    String resposta9 = "";
    String resposta10 = "";
    List<Integer> listaRespostas = new ArrayList<>();

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(String idProva) {
        this.idProva = Integer.valueOf(idProva);
    }

    private void addIfPresent(String resposta) {
        if(!resposta.equals(null) && !(resposta.isEmpty() || resposta.isBlank())) {
            listaRespostas.add(Integer.valueOf(resposta));
        }
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public String getResposta0() {
        return resposta0;
    }

    public void setResposta0(String resposta0) {
        this.resposta0 = resposta0;
    }

    public String getResposta1() {
        return resposta1;
    }

    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
    }

    public String getResposta3() {
        return resposta3;
    }

    public void setResposta3(String resposta3) {
        this.resposta3 = resposta3;
    }

    public String getResposta4() {
        return resposta4;
    }

    public void setResposta4(String resposta4) {
        this.resposta4 = resposta4;
    }

    public String getResposta5() {
        return resposta5;
    }

    public void setResposta5(String resposta5) {
        this.resposta5 = resposta5;
    }

    public String getResposta6() {
        return resposta6;
    }

    public void setResposta6(String resposta6) {
        this.resposta6 = resposta6;
    }

    public String getResposta7() {
        return resposta7;
    }

    public void setResposta7(String resposta7) {
        this.resposta7 = resposta7;
    }

    public String getResposta8() {
        return resposta8;
    }

    public void setResposta8(String resposta8) {
        this.resposta8 = resposta8;
    }

    public String getResposta9() {
        return resposta9;
    }

    public void setResposta9(String resposta9) {
        this.resposta9 = resposta9;
    }

    public String getResposta10() {
        return resposta10;
    }

    public void setResposta10(String resposta10) {
        this.resposta10 = resposta10;
    }

    public List<Integer> getListaRespostas() {
        return listaRespostas;
    }

    public void setListaRespostas(List<Integer> listaRespostas) {
        this.listaRespostas = listaRespostas;
    }

    public List<Integer> converteParaAlternativasIdList() {
        addIfPresent(resposta0);
        addIfPresent(resposta1);
        addIfPresent(resposta2);
        addIfPresent(resposta3);
        addIfPresent(resposta4);
        addIfPresent(resposta5);
        addIfPresent(resposta6);
        addIfPresent(resposta7);
        addIfPresent(resposta8);
        addIfPresent(resposta9);
        addIfPresent(resposta10);
        return listaRespostas;
    }
}
