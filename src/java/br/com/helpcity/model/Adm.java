package br.com.helpcity.model;

import java.util.Date;

public class Adm extends Usuario {

    private Integer idAdm;

    public Adm() {
    }

    public Adm(Integer idAdm) {
        this.idAdm = idAdm;
    }

    public Adm(Integer idAdm, Integer idUsuario, String nomeUsuario, String cpfUsuario, String rgUsuario, String emailUsuario, String telefoneUsuario, Date dataNascimentoUsuario, Date dataCadastroUsuario, String statusUsuario, String sexoUsuario, String tipoUsuario, String loginUsuario, String senhaUsuario) {
        super(idUsuario, nomeUsuario, cpfUsuario, rgUsuario, emailUsuario, telefoneUsuario, dataNascimentoUsuario, dataCadastroUsuario, statusUsuario, sexoUsuario, tipoUsuario, loginUsuario, senhaUsuario);
        this.idAdm = idAdm;
    }

    public Integer getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(Integer idAdm) {
        this.idAdm = idAdm;
    }

}
