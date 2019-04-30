package br.com.helpcity.model;

import java.util.Date;

public class Funcionario extends Usuario {

    private Integer idFuncionario;
    private Secretaria secretariaFuncionario;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(Integer idFuncionario, Secretaria secretariaFuncionario, Integer idUsuario, String nomeUsuario, String cpfUsuario, String rgUsuario, String emailUsuario, String telefoneUsuario, Date dataNascimentoUsuario, Date dataCadastroUsuario, String statusUsuario, String sexoUsuario, String tipoUsuario, String loginUsuario, String senhaUsuario) {
        super(idUsuario, nomeUsuario, cpfUsuario, rgUsuario, emailUsuario, telefoneUsuario, dataNascimentoUsuario, dataCadastroUsuario, statusUsuario, sexoUsuario, tipoUsuario, loginUsuario, senhaUsuario);
        this.idFuncionario = idFuncionario;
        this.secretariaFuncionario = secretariaFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Secretaria getSecretariaFuncionario() {
        return secretariaFuncionario;
    }

    public void setSecretariaFuncionario(Secretaria secretariaFuncionario) {
        this.secretariaFuncionario = secretariaFuncionario;
    }

}
