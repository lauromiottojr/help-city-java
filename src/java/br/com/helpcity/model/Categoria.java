package br.com.helpcity.model;

public class Categoria {

    private Integer idCategoria;
    private String nomeCategoria;
    private Cidade cidadeCategoria;

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Integer idCategoria, String nomeCategoria, Cidade cidadeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.cidadeCategoria = cidadeCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Cidade getCidadeCategoria() {
        return cidadeCategoria;
    }

    public void setCidadeCategoria(Cidade cidadeCategoria) {
        this.cidadeCategoria = cidadeCategoria;
    }

}
