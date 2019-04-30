package br.com.helpcity.model;

public class Estado {

    private Integer idEstado;
    private String nomeEstado;
    private String ufEstado;

    public Estado() {
    }

    public Estado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Estado(Integer idEstado, String nomeEstado, String ufEstado) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.ufEstado = ufEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUfEstado() {
        return ufEstado;
    }

    public void setUfEstado(String ufEstado) {
        this.ufEstado = ufEstado;
    }

}
