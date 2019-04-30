package br.com.helpcity.model;

import java.util.Date;

public class Cidade {

    private Integer idCidade;
    private String nomeCidade;
    private Date dataCadastroCidade;
    private String statusCidade;
    private Estado estadoCidade;

    public Cidade() {
    }

    public Cidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Cidade(Integer idCidade, String nomeCidade, Date dataCadastroCidade, String statusCidade, Estado estadoCidade) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.dataCadastroCidade = dataCadastroCidade;
        this.statusCidade = statusCidade;
        this.estadoCidade = estadoCidade;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Date getDataCadastroCidade() {
        return dataCadastroCidade;
    }

    public void setDataCadastroCidade(Date dataCadastroCidade) {
        this.dataCadastroCidade = dataCadastroCidade;
    }

    public String getStatusCidade() {
        return statusCidade;
    }

    public void setStatusCidade(String statusCidade) {
        this.statusCidade = statusCidade;
    }

    public Estado getEstadoCidade() {
        return estadoCidade;
    }

    public void setEstadoCidade(Estado estadoCidade) {
        this.estadoCidade = estadoCidade;
    }

}
