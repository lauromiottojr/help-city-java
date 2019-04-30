package br.com.helpcity.model;

import java.util.Date;

public class Secretaria {

    private Integer idSecretaria;
    private String nomeSecretaria;
    private String telefoneSecretaria;
    private String emailSecretaria;
    private Date dataCadastroSecretaria;
    private Cidade cidadeSecretaria;

    public Secretaria() {
    }

    public Secretaria(Integer idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public Secretaria(Integer idSecretaria, String nomeSecretaria, String telefoneSecretaria, String emailSecretaria, Date dataCadastroSecretaria, Cidade cidadeSecretaria) {
        this.idSecretaria = idSecretaria;
        this.nomeSecretaria = nomeSecretaria;
        this.telefoneSecretaria = telefoneSecretaria;
        this.emailSecretaria = emailSecretaria;
        this.dataCadastroSecretaria = dataCadastroSecretaria;
        this.cidadeSecretaria = cidadeSecretaria;
    }

    public Integer getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(Integer idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public String getNomeSecretaria() {
        return nomeSecretaria;
    }

    public void setNomeSecretaria(String nomeSecretaria) {
        this.nomeSecretaria = nomeSecretaria;
    }

    public String getTelefoneSecretaria() {
        return telefoneSecretaria;
    }

    public void setTelefoneSecretaria(String telefoneSecretaria) {
        this.telefoneSecretaria = telefoneSecretaria;
    }

    public String getEmailSecretaria() {
        return emailSecretaria;
    }

    public void setEmailSecretaria(String emailSecretaria) {
        this.emailSecretaria = emailSecretaria;
    }

    public Date getDataCadastroSecretaria() {
        return dataCadastroSecretaria;
    }

    public void setDataCadastroSecretaria(Date dataCadastroSecretaria) {
        this.dataCadastroSecretaria = dataCadastroSecretaria;
    }

    public Cidade getCidadeSecretaria() {
        return cidadeSecretaria;
    }

    public void setCidadeSecretaria(Cidade cidadeSecretaria) {
        this.cidadeSecretaria = cidadeSecretaria;
    }

}
