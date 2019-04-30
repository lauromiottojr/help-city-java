package br.com.helpcity.model;

public class Imagem {
    private Integer idImagem;
    private String nomeImagem;
    private Ocorrencia ocorrenciaImagem;

    public Imagem() {
    }

    public Imagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public Imagem(Integer idImagem, String nomeImagem, Ocorrencia ocorrenciaImagem) {
        this.idImagem = idImagem;
        this.nomeImagem = nomeImagem;
        this.ocorrenciaImagem = ocorrenciaImagem;
    }

    public Integer getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Ocorrencia getOcorrenciaImagem() {
        return ocorrenciaImagem;
    }

    public void setOcorrenciaImagem(Ocorrencia ocorrenciaImagem) {
        this.ocorrenciaImagem = ocorrenciaImagem;
    }
    
    
}
