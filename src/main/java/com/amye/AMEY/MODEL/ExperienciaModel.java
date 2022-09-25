package com.amye.AMEY.MODEL;

import com.amye.AMEY.DTO.JSONCONVERT.ExperienciaProfissionalDto;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EXPERIENCIAS")
public class ExperienciaModel {
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

    public ExperienciaModel(ExperienciaProfissionalDto experienciaProfissionalDto) {
        this.titulo = experienciaProfissionalDto.getJobTitle();
        this.descricao = experienciaProfissionalDto.getJobDescription();
        this.organizacao = experienciaProfissionalDto.getOrganization();
        if(experienciaProfissionalDto.getDates().getStartDate() != null) {
            this.dataInicio = Date.valueOf(experienciaProfissionalDto.getDates().getStartDate());
        }
        if(experienciaProfissionalDto.getDates().getEndDate() != null) {
            dataFim = Date.valueOf(experienciaProfissionalDto.getDates().getEndDate());
        }
    }

    public ExperienciaModel() {

    }

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

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }
}
