package br.com.helpcity.model;

import java.util.Date;

public class Cidadao extends Usuario {

    private Integer idCidadao;
    private Cidade cidadeCidadao;

    public Cidadao() {
    }

    public Cidadao(Integer idCidadao) {
        this.idCidadao = idCidadao;
    }

    public Cidadao(Integer idCidadao, Cidade cidadeCidadao, Integer idUsuario, String nomeUsuario, String cpfUsuario, String rgUsuario, String emailUsuario, String telefoneUsuario, Date dataNascimentoUsuario, Date dataCadastroUsuario, String statusUsuario, String sexoUsuario, String tipoUsuario, String loginUsuario, String senhaUsuario) {
        super(idUsuario, nomeUsuario, cpfUsuario, rgUsuario, emailUsuario, telefoneUsuario, dataNascimentoUsuario, dataCadastroUsuario, statusUsuario, sexoUsuario, tipoUsuario, loginUsuario, senhaUsuario);
        this.idCidadao = idCidadao;
        this.cidadeCidadao = cidadeCidadao;
    }

    public Integer getIdCidadao() {
        return idCidadao;
    }

    public void setIdCidadao(Integer idCidadao) {
        this.idCidadao = idCidadao;
    }

    public Cidade getCidadeCidadao() {
        return cidadeCidadao;
    }

    public void setCidadeCidadao(Cidade cidadeCidadao) {
        this.cidadeCidadao = cidadeCidadao;
    }

}
