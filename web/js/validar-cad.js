document.getElementById("nomeUsuario").addEventListener("blur", FNomeC);
document.getElementById("emailUsuario").addEventListener("blur", FEmailC);
document.getElementById("dataNascimentoUsuario").addEventListener("blur", FDataNascimentoC);
document.getElementById("rgUsuario").addEventListener("blur", FRgC);
document.getElementById("cpfUsuario").addEventListener("blur", FCpfC);
document.getElementById("telefoneUsuario").addEventListener("blur", FTelC);
document.getElementById("loginUsuario").addEventListener("blur", FLoginC);
document.getElementById("senhaUsuario").addEventListener("blur", FSenhaC);
document.getElementById("senhaCUsuario").addEventListener("blur", FCSenhaC);
var login;
function validarFormularioCad() {
    var VNome = FNomeC();
    var VEmail = FEmailC();
    var VDataNascimento = FDataNascimentoC();
    var VRg = FRgC();
    var VCpf = FCpfC();
    var VTel = FTelC();
    var VLogin = FLoginC();
    var VSenha = FSenhaC();
    var VCSenha = FCSenhaC();
    if (VNome && VEmail && VDataNascimento && VRg && VCpf && VTel && VLogin && VSenha && VCSenha) {
        document.getElementById("formCadastro").submit();
    } else {
        console.log("erro");
    }
}
$('#loginUsuario').blur(function () {
    var url = getContextPath() + "/VerificarDadosLogin";
    if ($('#loginUsuario').val().length !== 0) {
        $.ajax({
            type: "POST",
            url: url,
            data: "login=" + this.value,
            dataType: "json",
            success: function (data) {
                if (data.loginexiste) {
                    document.getElementById("grpLogin").classList.add("red-ic");
                    document.getElementById("labelLogin").classList.add("red-ic");
                    document.getElementById("grpLogin").classList.remove("green-ic");
                    document.getElementById("labelLogin").classList.remove("green-ic");
                    document.getElementById("labelLogin").innerHTML = "Login - Login ocupado!";
                    login = false;
                } else {
                    login = true;
                }
            }
        });
    }
});
function FNomeC() {
    if (document.formCadastro.nomeUsuario.value.length === 0) {
        document.getElementById("grpNome").classList.add("red-ic");
        document.getElementById("labelNome").classList.add("red-ic");
        document.getElementById("grpNome").classList.remove("green-ic");
        document.getElementById("labelNome").classList.remove("green-ic");
        document.getElementById("labelNome").innerHTML = "Nome - Digite seu Nome!";
        return false;
    } else {
        document.getElementById("grpNome").classList.remove("red-ic");
        document.getElementById("labelNome").classList.remove("red-ic");
        document.getElementById("grpNome").classList.add("green-ic");
        document.getElementById("labelNome").classList.add("green-ic");
        document.getElementById("labelNome").innerHTML = "Nome";
        return true;
    }
}
function FEmailC() {
    var expEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (document.formCadastro.emailUsuario.value.length === 0) {
        document.getElementById("grpEmail").classList.add("red-ic");
        document.getElementById("labelEmail").classList.add("red-ic");
        document.getElementById("grpEmail").classList.remove("green-ic");
        document.getElementById("labelEmail").classList.remove("green-ic");
        document.getElementById("labelEmail").innerHTML = "Email - Digite seu Email!";
        return false;
    } else if (expEmail.test(document.formCadastro.emailUsuario.value) === false) {
        document.getElementById("grpEmail").classList.add("red-ic");
        document.getElementById("labelEmail").classList.add("red-ic");
        document.getElementById("grpEmail").classList.remove("green-ic");
        document.getElementById("labelEmail").classList.remove("green-ic");
        document.getElementById("labelEmail").innerHTML = "Email - Formato de Email Incorreto!";
        return false;
    } else {
        document.getElementById("grpEmail").classList.remove("red-ic");
        document.getElementById("labelEmail").classList.remove("red-ic");
        document.getElementById("grpEmail").classList.add("green-ic");
        document.getElementById("labelEmail").classList.add("green-ic");
        document.getElementById("labelEmail").innerHTML = "Email";
        return true;
    }
}
function FDataNascimentoC() {
    var dataForm = (document.formCadastro.dataNascimentoUsuario.value).split("/");
    var hoje = new Date();
    var ano = dataForm[2];
    var mes = dataForm[1] - 1;
    var dia = dataForm[0];
    var dataInformada = new Date(ano, mes, dia);
    if (document.formCadastro.dataNascimentoUsuario.value.length === 0) {
        document.getElementById("grpDataNascimento").classList.add("red-ic");
        document.getElementById("labelDataNascimento").classList.add("red-ic");
        document.getElementById("grpDataNascimento").classList.remove("green-ic");
        document.getElementById("labelDataNascimento").classList.remove("green-ic");
        document.getElementById("labelDataNascimento").innerHTML = "Nascimento - Digite a Data de seu Nascimento!";
        return false;
    } else if (hoje < dataInformada || document.formCadastro.dataNascimentoUsuario.value.length < 10) {
        document.getElementById("grpDataNascimento").classList.add("red-ic");
        document.getElementById("labelDataNascimento").classList.add("red-ic");
        document.getElementById("grpDataNascimento").classList.remove("green-ic");
        document.getElementById("labelDataNascimento").classList.remove("green-ic");
        document.getElementById("labelDataNascimento").innerHTML = "Nascimento - Data Incorreta!";
        return false;
    } else if (mes > 11 || (dia < 1 || dia > 31)) {
        document.getElementById("grpDataNascimento").classList.add("red-ic");
        document.getElementById("labelDataNascimento").classList.add("red-ic");
        document.getElementById("grpDataNascimento").classList.remove("green-ic");
        document.getElementById("labelDataNascimento").classList.remove("green-ic");
        document.getElementById("labelDataNascimento").innerHTML = "Nascimento - Data Incorreta!";
        return false;
    } else {
        document.getElementById("grpDataNascimento").classList.remove("red-ic");
        document.getElementById("labelDataNascimento").classList.remove("red-ic");
        document.getElementById("grpDataNascimento").classList.add("green-ic");
        document.getElementById("labelDataNascimento").classList.add("green-ic");
        document.getElementById("labelDataNascimento").innerHTML = "Nascimento";
        return true;
    }
}
function FRgC() {
    if (document.formCadastro.rgUsuario.value.length === 0) {
        document.getElementById("grpRg").classList.add("red-ic");
        document.getElementById("labelRg").classList.add("red-ic");
        document.getElementById("grpRg").classList.remove("green-ic");
        document.getElementById("labelRg").classList.remove("green-ic");
        document.getElementById("labelRg").innerHTML = "RG - Digite seu RG!";
        return false;
    } else {
        document.getElementById("grpRg").classList.remove("red-ic");
        document.getElementById("labelRg").classList.remove("red-ic");
        document.getElementById("grpRg").classList.add("green-ic");
        document.getElementById("labelRg").classList.add("green-ic");
        document.getElementById("labelRg").innerHTML = "RG";
        return true;
    }
}
function FCpfC() {
    var expCpf = /^([0-9]){3}\.([0-9]){3}\.([0-9]){3}-([0-9]){2}$/;
    if (document.formCadastro.cpfUsuario.value.length === 0) {
        document.getElementById("grpCpf").classList.add("red-ic");
        document.getElementById("labelCpf").classList.add("red-ic");
        document.getElementById("grpCpf").classList.remove("green-ic");
        document.getElementById("labelCpf").classList.remove("green-ic");
        document.getElementById("labelCpf").innerHTML = "CPF - Digite seu CPF!";
        return false;
    } else if (expCpf.test(document.formCadastro.cpfUsuario.value) === false) {
        document.getElementById("grpCpf").classList.add("red-ic");
        document.getElementById("labelCpf").classList.add("red-ic");
        document.getElementById("grpCpf").classList.remove("green-ic");
        document.getElementById("labelCpf").classList.remove("green-ic");
        document.getElementById("labelCpf").innerHTML = "CPF - Formato do CPF Incorreto!";
        return false;
    } else {
        document.getElementById("grpCpf").classList.remove("red-ic");
        document.getElementById("labelCpf").classList.remove("red-ic");
        document.getElementById("grpCpf").classList.add("green-ic");
        document.getElementById("labelCpf").classList.add("green-ic");
        document.getElementById("labelCpf").innerHTML = "CPF";
        return true;
    }
}
function FTelC() {
    if (document.formCadastro.telefoneUsuario.value.length === 0) {
        document.getElementById("grpTelefone").classList.add("red-ic");
        document.getElementById("labelTelefone").classList.add("red-ic");
        document.getElementById("grpTelefone").classList.remove("green-ic");
        document.getElementById("labelTelefone").classList.remove("green-ic");
        document.getElementById("labelTelefone").innerHTML = "Telefone - Digite seu Telefone!";
        return false;
    } else if (document.formCadastro.telefoneUsuario.value.length !== 14) {
        document.getElementById("grpTelefone").classList.add("red-ic");
        document.getElementById("labelTelefone").classList.add("red-ic");
        document.getElementById("grpTelefone").classList.remove("green-ic");
        document.getElementById("labelTelefone").classList.remove("green-ic");
        document.getElementById("labelTelefone").innerHTML = "Telefone - Formato do Telefone Incorreto!";
        return false;
    } else {
        document.getElementById("grpTelefone").classList.remove("red-ic");
        document.getElementById("labelTelefone").classList.remove("red-ic");
        document.getElementById("grpTelefone").classList.add("green-ic");
        document.getElementById("labelTelefone").classList.add("green-ic");
        document.getElementById("labelTelefone").innerHTML = "Telefone";
        return true;
    }
}
function FLoginC() {
    if (document.formCadastro.loginUsuario.value.length === 0) {
        document.getElementById("grpLogin").classList.add("red-ic");
        document.getElementById("labelLogin").classList.add("red-ic");
        document.getElementById("grpLogin").classList.remove("green-ic");
        document.getElementById("labelLogin").classList.remove("green-ic");
        document.getElementById("labelLogin").innerHTML = "Login - Digite seu Login!";
        return false;
    } else if (login === false) {
        document.getElementById("grpLogin").classList.add("red-ic");
        document.getElementById("labelLogin").classList.add("red-ic");
        document.getElementById("grpLogin").classList.remove("green-ic");
        document.getElementById("labelLogin").classList.remove("green-ic");
        document.getElementById("labelLogin").innerHTML = "Login - Login ocupado!";
        return false;
    } else {
        document.getElementById("grpLogin").classList.remove("red-ic");
        document.getElementById("labelLogin").classList.remove("red-ic");
        document.getElementById("grpLogin").classList.add("green-ic");
        document.getElementById("labelLogin").classList.add("green-ic");
        document.getElementById("labelLogin").innerHTML = "Login";
        return true;
    }
}
function FSenhaC() {
    if (document.formCadastro.senhaUsuario.value.length === 0) {
        document.getElementById("grpSenha").classList.add("red-ic");
        document.getElementById("labelSenha").classList.add("red-ic");
        document.getElementById("grpSenha").classList.remove("green-ic");
        document.getElementById("labelSenha").classList.remove("green-ic");
        document.getElementById("labelSenha").innerHTML = "Senha - Digite sua Senha!";
        return false;
    } else if (document.formCadastro.senhaUsuario.value.length < 4) {
        document.getElementById("grpSenha").classList.add("red-ic");
        document.getElementById("labelSenha").classList.add("red-ic");
        document.getElementById("grpSenha").classList.remove("green-ic");
        document.getElementById("labelSenha").classList.remove("green-ic");
        document.getElementById("labelSenha").innerHTML = "Senha - Deve conter mais de 4 caracteres!";
        return false;
    } else {
        document.getElementById("grpSenha").classList.remove("red-ic");
        document.getElementById("labelSenha").classList.remove("red-ic");
        document.getElementById("grpSenha").classList.add("green-ic");
        document.getElementById("labelSenha").classList.add("green-ic");
        document.getElementById("labelSenha").innerHTML = "Senha";
        return true;
    }
}
function FCSenhaC() {
    if (document.formCadastro.senhaCUsuario.value.length === 0) {
        document.getElementById("grpCSenha").classList.add("red-ic");
        document.getElementById("labelCSenha").classList.add("red-ic");
        document.getElementById("grpCSenha").classList.remove("green-ic");
        document.getElementById("labelCSenha").classList.remove("green-ic");
        document.getElementById("labelCSenha").innerHTML = "Confirmar Senha - Digite sua Senha!";
        return false;
    } else if (document.formCadastro.senhaUsuario.value !== document.formCadastro.senhaCUsuario.value) {
        document.getElementById("grpCSenha").classList.add("red-ic");
        document.getElementById("labelCSenha").classList.add("red-ic");
        document.getElementById("grpCSenha").classList.remove("green-ic");
        document.getElementById("labelCSenha").classList.remove("green-ic");
        document.getElementById("labelCSenha").innerHTML = "Confirmar Senha - As Senhas devem ser iguais!";
        return false;
    } else {
        document.getElementById("grpCSenha").classList.remove("red-ic");
        document.getElementById("labelCSenha").classList.remove("red-ic");
        document.getElementById("grpCSenha").classList.add("green-ic");
        document.getElementById("labelCSenha").classList.add("green-ic");
        document.getElementById("labelCSenha").innerHTML = "Confirmar Senha";
        return true;
    }
}
/* function validaCPF(cpf)
 {
 var numeros, digitos, soma, i, resultado, digitos_iguais;
 digitos_iguais = 1;
 if (cpf.length < 11)
 return false;
 for (i = 0; i < cpf.length - 1; i++)
 if (cpf.charAt(i) != cpf.charAt(i + 1))
 {
 digitos_iguais = 0;
 break;
 }
 if (!digitos_iguais)
 {
 numeros = cpf.substring(0,9);
 digitos = cpf.substring(9);
 soma = 0;
 for (i = 10; i > 1; i--)
 soma += numeros.charAt(10 - i) * i;
 resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
 if (resultado != digitos.charAt(0))
 return false;
 numeros = cpf.substring(0,10);
 soma = 0;
 for (i = 11; i > 1; i--)
 soma += numeros.charAt(11 - i) * i;
 resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
 if (resultado != digitos.charAt(1))
 return false;
 return true;
 }
 else
 return false;
 }*/