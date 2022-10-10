package com.amye.AMEY.DTO;

public class FiltroDTO {
    String categoria;
    String filtro;

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isHabilidade() {
        return categoria.equalsIgnoreCase("habilidade");
    }

    public boolean isNome() {
        return categoria.equalsIgnoreCase("nome");
    }

    public boolean isSobrenome() {
        return categoria.equalsIgnoreCase("sobrenome");
    }

    public boolean isPontos() {
        return categoria.equalsIgnoreCase("pontos");
    }
}
