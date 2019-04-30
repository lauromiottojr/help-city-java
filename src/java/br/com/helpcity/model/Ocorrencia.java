package br.com.helpcity.model;

import java.util.Date;

public class Ocorrencia {

    private Integer idOcorrencia;
    private String localizacaoOcorrencia;
    private String latitudeOcorrencia;
    private String longitudeOcorrencia;
    private String descricaoOcorrencia;
    private Date dataCriacaoOcorrencia;
    private String tituloOcorrencia;
    private String statusOcorrencia;
    private String observacaoOcorrencia;
    private Usuario usuarioOcorrencia;
    private Cidade cidadeOcorrencia;
    private Secretaria secretariaOcorrencia;
    private Categoria categoriaOcorrencia;

    public Ocorrencia() {
    }

    public Ocorrencia(Integer idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public Ocorrencia(Integer idOcorrencia, String localizacaoOcorrencia, String latitudeOcorrencia, String longitudeOcorrencia, String descricaoOcorrencia, Date dataCriacaoOcorrencia, String tituloOcorrencia, String statusOcorrencia, String observacaoOcorrencia, Usuario usuarioOcorrencia, Cidade cidadeOcorrencia, Secretaria secretariaOcorrencia, Categoria categoriaOcorrencia) {
        this.idOcorrencia = idOcorrencia;
        this.localizacaoOcorrencia = localizacaoOcorrencia;
        this.latitudeOcorrencia = latitudeOcorrencia;
        this.longitudeOcorrencia = longitudeOcorrencia;
        this.descricaoOcorrencia = descricaoOcorrencia;
        this.dataCriacaoOcorrencia = dataCriacaoOcorrencia;
        this.tituloOcorrencia = tituloOcorrencia;
        this.statusOcorrencia = statusOcorrencia;
        this.observacaoOcorrencia = observacaoOcorrencia;
        this.usuarioOcorrencia = usuarioOcorrencia;
        this.cidadeOcorrencia = cidadeOcorrencia;
        this.secretariaOcorrencia = secretariaOcorrencia;
        this.categoriaOcorrencia = categoriaOcorrencia;
    }

    public Integer getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(Integer idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public String getLocalizacaoOcorrencia() {
        return localizacaoOcorrencia;
    }

    public void setLocalizacaoOcorrencia(String localizacaoOcorrencia) {
        this.localizacaoOcorrencia = localizacaoOcorrencia;
    }

    public String getLatitudeOcorrencia() {
        return latitudeOcorrencia;
    }

    public void setLatitudeOcorrencia(String latitudeOcorrencia) {
        this.latitudeOcorrencia = latitudeOcorrencia;
    }

    public String getLongitudeOcorrencia() {
        return longitudeOcorrencia;
    }

    public void setLongitudeOcorrencia(String longitudeOcorrencia) {
        this.longitudeOcorrencia = longitudeOcorrencia;
    }

    public String getDescricaoOcorrencia() {
        return descricaoOcorrencia;
    }

    public void setDescricaoOcorrencia(String descricaoOcorrencia) {
        this.descricaoOcorrencia = descricaoOcorrencia;
    }

    public Date getDataCriacaoOcorrencia() {
        return dataCriacaoOcorrencia;
    }

    public void setDataCriacaoOcorrencia(Date dataCriacaoOcorrencia) {
        this.dataCriacaoOcorrencia = dataCriacaoOcorrencia;
    }

    public String getTituloOcorrencia() {
        return tituloOcorrencia;
    }

    public void setTituloOcorrencia(String tituloOcorrencia) {
        this.tituloOcorrencia = tituloOcorrencia;
    }

    public String getStatusOcorrencia() {
        return statusOcorrencia;
    }

    public void setStatusOcorrencia(String statusOcorrencia) {
        this.statusOcorrencia = statusOcorrencia;
    }

    public String getObservacaoOcorrencia() {
        return observacaoOcorrencia;
    }

    public void setObservacaoOcorrencia(String observacaoOcorrencia) {
        this.observacaoOcorrencia = observacaoOcorrencia;
    }

    public Usuario getUsuarioOcorrencia() {
        return usuarioOcorrencia;
    }

    public void setUsuarioOcorrencia(Usuario usuarioOcorrencia) {
        this.usuarioOcorrencia = usuarioOcorrencia;
    }

    public Cidade getCidadeOcorrencia() {
        return cidadeOcorrencia;
    }

    public void setCidadeOcorrencia(Cidade cidadeOcorrencia) {
        this.cidadeOcorrencia = cidadeOcorrencia;
    }

    public Secretaria getSecretariaOcorrencia() {
        return secretariaOcorrencia;
    }

    public void setSecretariaOcorrencia(Secretaria secretariaOcorrencia) {
        this.secretariaOcorrencia = secretariaOcorrencia;
    }

    public Categoria getCategoriaOcorrencia() {
        return categoriaOcorrencia;
    }

    public void setCategoriaOcorrencia(Categoria categoriaOcorrencia) {
        this.categoriaOcorrencia = categoriaOcorrencia;
    }

}
