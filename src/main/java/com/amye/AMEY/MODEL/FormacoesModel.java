package com.amye.AMEY.MODEL;

import com.amye.AMEY.DTO.JSONCONVERT.Education;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "FORMACOES")
public class FormacoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String organizacao;
    private String descricao;
    @Column(name = "DATA_INICIO")
    private Date dataInicio;
    @Column(name = "DATA_FIM")
    private Date dataFim;
    @ManyToOne
    private CurriculoModel curriculo;

    public FormacoesModel(Education education) {
        this.titulo = education.getEducation();
        this.organizacao = education.getOrganization();
        if(education.getDatas().getCompletionDate() != null) {
            this.dataFim = Date.valueOf(education.getDatas().getCompletionDate());
        }
        if(education.getDatas().getStartDate() != null) {
            this.dataInicio = Date.valueOf(education.getDatas().getStartDate());
        }
    }

    public FormacoesModel(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public CurriculoModel getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(CurriculoModel curriculo) {
        this.curriculo = curriculo;
    }
}
