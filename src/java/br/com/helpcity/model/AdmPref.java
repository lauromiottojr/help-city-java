package br.com.helpcity.model;

import java.util.Date;

public class AdmPref extends Usuario {

    private Integer idAdmPref;
    private Cidade cidadeAdmPref;

    public AdmPref() {
    }

    public AdmPref(Integer idAdmPref) {
        this.idAdmPref = idAdmPref;
    }

    public AdmPref(Integer idAdmPref, Cidade cidadeAdmPref, Integer idUsuario, String nomeUsuario, String cpfUsuario, String rgUsuario, String emailUsuario, String telefoneUsuario, Date dataNascimentoUsuario, Date dataCadastroUsuario, String statusUsuario, String sexoUsuario, String tipoUsuario, String loginUsuario, String senhaUsuario) {
        super(idUsuario, nomeUsuario, cpfUsuario, rgUsuario, emailUsuario, telefoneUsuario, dataNascimentoUsuario, dataCadastroUsuario, statusUsuario, sexoUsuario, tipoUsuario, loginUsuario, senhaUsuario);
        this.idAdmPref = idAdmPref;
        this.cidadeAdmPref = cidadeAdmPref;
    }

    public Integer getIdAdmPref() {
        return idAdmPref;
    }

    public void setIdAdmPref(Integer idAdmPref) {
        this.idAdmPref = idAdmPref;
    }

    public Cidade getCidadeAdmPref() {
        return cidadeAdmPref;
    }

    public void setCidadeAdmPref(Cidade cidadeAdmPref) {
        this.cidadeAdmPref = cidadeAdmPref;
    }

}
