document.getElementById("nomeUsuario").addEventListener("blur", FNome);
document.getElementById("emailUsuario").addEventListener("blur", FEmail);
document.getElementById("dataNascimentoUsuario").addEventListener("blur", FDataNascimento);
document.getElementById("rgUsuario").addEventListener("blur", FRg);
document.getElementById("cpfUsuario").addEventListener("blur", FCpf);
document.getElementById("telefoneUsuario").addEventListener("blur", FTel);
document.getElementById("loginUsuario").addEventListener("blur", FLogin);
document.getElementById("senhaUsuario").addEventListener("blur", FSenha);
document.getElementById("senhaCUsuario").addEventListener("blur", FCSenha);
//var cpf;
var login;
var nome_categoria;
//var email;
function validarFormulario() {
    var VNome = FNome();
    var VEmail = FEmail();
    var VDataNascimento = FDataNascimento();
    var VRg = FRg();
    var VCpf = FCpf();
    var VTel = FTel();
    var VLogin = FLogin();
    var VSenha = FSenha();
    var VCSenha = FCSenha();
    if (VNome && VEmail && VDataNascimento && VRg && VCpf && VTel && VLogin && VSenha && VCSenha) {
        document.getElementById("formCadastro").submit();
    } else {
        console.log("erro");
    }
}
function validarForm() {
    var VNome = FNome();
    var VEmail = FEmail();
    var VDataNascimento = FDataNascimento();
    var VRg = FRg();
    var VCpf = FCpf();
    var VTel = FTel();
    if (VNome && VEmail && VDataNascimento && VRg && VCpf && VTel) {
        document.getElementById("formCadastro").submit();
    } else {
        console.log("erro");
    }
}
//$('#cpfUsuario').blur(function () {
//    var url = getContextPath() + "/VerificarDadosCpf";
//    if ($('#cpfUsuario').val().length === 14) {
//        $.ajax({
//            type: "POST",
//            url: url,
//            data: "cpf=" + this.value,
//            dataType: "json",
//            success: function (data) {
//                if (data.cpfexiste) {
//                    document.getElementById("grpCpf").classList.add("focused");
//                    document.getElementById("grpCpf").classList.add("error");
//                    document.getElementById("grpCpf").classList.remove("success");
//                    document.getElementById("labelCpf").classList.add("text-danger");
//                    document.getElementById("labelCpf").innerHTML = "CPF - CPF ocupado!";
//                    cpf = false;
//                } else {
//                    cpf = true;
//                }
//            }
//        });
//    }
//});
//$('#emailUsuario').blur(function () {
//    var url = getContextPath() + "/VerificarDadosEmail";
//    if ($('#emailUsuario').val().length !== 0) {
//        $.ajax({
//            type: "POST",
//            url: url,
//            data: "email=" + this.value,
//            dataType: "json",
//            success: function (data) {
//                if (data.emailexiste) {
//                    document.getElementById("grpEmail").classList.add("focused");
//                    document.getElementById("grpEmail").classList.add("error");
//                    document.getElementById("grpEmail").classList.remove("success");
//                    document.getElementById("labelEmail").classList.add("text-danger");
//                    document.getElementById("labelEmail").innerHTML = "Email - Email ocupado!";
//                    email = false;
//                } else {
//                    email = true;
//                }
//            }
//        });
//    }
//});
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
                    document.getElementById("grpLogin").classList.add("focused");
                    document.getElementById("grpLogin").classList.add("error");
                    document.getElementById("grpLogin").classList.remove("success");
                    document.getElementById("labelLogin").classList.add("text-danger");
                    document.getElementById("labelLogin").innerHTML = "Login - Login ocupado!";
                    login = false;
                } else {
                    login = true;
                }
            }
        });
    }
});
function FNome() {
    if (document.formCadastro.nomeUsuario.value.length === 0) {
        document.getElementById("grpNome").classList.add("focused");
        document.getElementById("grpNome").classList.add("error");
        document.getElementById("grpNome").classList.remove("success");
        document.getElementById("labelNome").classList.add("text-danger");
        document.getElementById("labelNome").innerHTML = "Nome - Digite seu Nome!";
        return false;
    } else {
        document.getElementById("grpNome").classList.add("focused");
        document.getElementById("grpNome").classList.add("success");
        document.getElementById("labelNome").classList.remove("text-danger");
        document.getElementById("labelNome").classList.add("text-success");
        document.getElementById("labelNome").innerHTML = "Nome";
        return true;
    }
}
function FEmail() {
    var expEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (document.formCadastro.emailUsuario.value.length === 0) {
        document.getElementById("grpEmail").classList.add("focused");
        document.getElementById("grpEmail").classList.add("error");
        document.getElementById("grpEmail").classList.remove("success");
        document.getElementById("labelEmail").classList.add("text-danger");
        document.getElementById("labelEmail").innerHTML = "Email - Digite seu Email!";
        return false;
    } else if (expEmail.test(document.formCadastro.emailUsuario.value) === false) {
        document.getElementById("grpEmail").classList.add("focused");
        document.getElementById("grpEmail").classList.add("error");
        document.getElementById("grpEmail").classList.remove("success");
        document.getElementById("labelEmail").classList.add("text-danger");
        document.getElementById("labelEmail").innerHTML = "Email - Formato de Email Incorreto!";
        return false;
    }
//    else if (email === false) {
//        document.getElementById("grpEmail").classList.add("focused");
//        document.getElementById("grpEmail").classList.add("error");
//        document.getElementById("grpEmail").classList.remove("success");
//        document.getElementById("labelEmail").classList.add("text-danger");
//        document.getElementById("labelEmail").innerHTML = "Email - Email ocupado!";
//        return false;
//    } 
    else {
        document.getElementById("grpEmail").classList.add("focused");
        document.getElementById("grpEmail").classList.add("success");
        document.getElementById("labelEmail").classList.add("text-success");
        document.getElementById("labelEmail").classList.remove("text-danger");
        document.getElementById("labelEmail").innerHTML = "Email";
        return true;
    }
}
function FDataNascimento() {
    var dataForm = (document.formCadastro.dataNascimentoUsuario.value).split("/");
    var hoje = new Date();
    var ano = dataForm[2];
    var mes = dataForm[1] - 1;
    var dia = dataForm[0];
    var dataInformada = new Date(ano, mes, dia);
    if (document.formCadastro.dataNascimentoUsuario.value.length === 0) {
        document.getElementById("grpDataNascimento").classList.add("focused");
        document.getElementById("grpDataNascimento").classList.add("error");
        document.getElementById("grpDataNascimento").classList.remove("success");
        document.getElementById("labelDataNascimento").classList.add("text-danger");
        document.getElementById("labelDataNascimento").innerHTML = "Data de Nascimento - Digite a Data de seu Nascimento!";
        return false;
    } else if (hoje < dataInformada || document.formCadastro.dataNascimentoUsuario.value.length < 10) {
        document.getElementById("grpDataNascimento").classList.add("focused");
        document.getElementById("grpDataNascimento").classList.add("error");
        document.getElementById("grpDataNascimento").classList.remove("success");
        document.getElementById("labelDataNascimento").classList.add("text-danger");
        document.getElementById("labelDataNascimento").innerHTML = "Data de Nascimento - Data Invalida!";
        return false;
    } else if (mes > 11 || (dia < 1 || dia > 31)) {
        document.getElementById("grpDataNascimento").classList.add("focused");
        document.getElementById("grpDataNascimento").classList.add("error");
        document.getElementById("grpDataNascimento").classList.remove("success");
        document.getElementById("labelDataNascimento").classList.add("text-danger");
        document.getElementById("labelDataNascimento").innerHTML = "Data de Nascimento - Data Invalida!";
        return false;
    } else {
        document.getElementById("grpDataNascimento").classList.add("focused");
        document.getElementById("grpDataNascimento").classList.add("success");
        document.getElementById("labelDataNascimento").classList.add("text-success");
        document.getElementById("labelDataNascimento").classList.remove("text-danger");
        document.getElementById("labelDataNascimento").innerHTML = "Data de Nascimento";
        return true;
    }
}
function FRg() {
    if (document.formCadastro.rgUsuario.value.length === 0) {
        document.getElementById("grpRg").classList.add("focused");
        document.getElementById("grpRg").classList.add("error");
        document.getElementById("grpRg").classList.remove("success");
        document.getElementById("labelRg").classList.add("text-danger");
        document.getElementById("labelRg").innerHTML = "RG - Digite seu RG!";
        return false;
    } else {
        document.getElementById("grpRg").classList.add("focused");
        document.getElementById("grpRg").classList.add("success");
        document.getElementById("labelRg").classList.add("text-success");
        document.getElementById("labelRg").classList.remove("text-danger");
        document.getElementById("labelRg").innerHTML = "RG";
        return true;
    }
}
function FCpf() {
    var expCpf = /^([0-9]){3}\.([0-9]){3}\.([0-9]){3}-([0-9]){2}$/;
    if (document.formCadastro.cpfUsuario.value.length === 0) {
        document.getElementById("grpCpf").classList.add("focused");
        document.getElementById("grpCpf").classList.add("error");
        document.getElementById("grpCpf").classList.remove("success");
        document.getElementById("labelCpf").classList.add("text-danger");
        document.getElementById("labelCpf").innerHTML = "CPF - Digite seu CPF!";
        return false;
    } else if (expCpf.test(document.formCadastro.cpfUsuario.value) === false) {
        document.getElementById("grpCpf").classList.add("focused");
        document.getElementById("grpCpf").classList.add("error");
        document.getElementById("grpCpf").classList.remove("success");
        document.getElementById("labelCpf").classList.add("text-danger");
        document.getElementById("labelCpf").innerHTML = "CPF - Formato do CPF Incorreto!";
        return false;
    }
//    else if (cpf === false) {
//        document.getElementById("grpCpf").classList.add("focused");
//        document.getElementById("grpCpf").classList.add("error");
//        document.getElementById("grpCpf").classList.remove("success");
//        document.getElementById("labelCpf").classList.add("text-danger");
//        document.getElementById("labelCpf").innerHTML = "CPF - CPF ocupado!";
//        return false;
//    } 
    else {
        document.getElementById("grpCpf").classList.add("focused");
        document.getElementById("grpCpf").classList.add("success");
        document.getElementById("labelCpf").classList.add("text-success");
        document.getElementById("labelCpf").classList.remove("text-danger");
        document.getElementById("labelCpf").innerHTML = "CPF";
        return true;
    }
}
function FTel() {
    if (document.formCadastro.telefoneUsuario.value.length === 0) {
        document.getElementById("grpTelefone").classList.add("focused");
        document.getElementById("grpTelefone").classList.add("error");
        document.getElementById("grpTelefone").classList.remove("success");
        document.getElementById("labelTelefone").classList.add("text-danger");
        document.getElementById("labelTelefone").innerHTML = "Telefone - Digite seu Telefone!";
        return false;
    } else if (document.formCadastro.telefoneUsuario.value.length !== 14) {
        document.getElementById("grpTelefone").classList.add("focused");
        document.getElementById("grpTelefone").classList.add("error");
        document.getElementById("grpTelefone").classList.remove("success");
        document.getElementById("labelTelefone").classList.add("text-danger");
        document.getElementById("labelTelefone").innerHTML = "Telefone - Formato do Telefone Incorreto!";
        return false;
    } else {
        document.getElementById("grpTelefone").classList.add("focused");
        document.getElementById("grpTelefone").classList.add("success");
        document.getElementById("labelTelefone").classList.add("text-success");
        document.getElementById("labelTelefone").classList.remove("text-danger");
        document.getElementById("labelTelefone").innerHTML = "Telefone";
        return true;
    }
}
function FLogin() {
    if (document.formCadastro.loginUsuario.value.length === 0) {
        document.getElementById("grpLogin").classList.add("focused");
        document.getElementById("grpLogin").classList.add("error");
        document.getElementById("grpLogin").classList.remove("success");
        document.getElementById("labelLogin").classList.add("text-danger");
        document.getElementById("labelLogin").innerHTML = "Login - Digite seu Login!";
        return false;
    } else if (login === false) {
        document.getElementById("grpLogin").classList.add("focused");
        document.getElementById("grpLogin").classList.add("error");
        document.getElementById("grpLogin").classList.remove("success");
        document.getElementById("labelLogin").classList.add("text-danger");
        document.getElementById("labelLogin").innerHTML = "Login - Login ocupado!";
        return false;
    } else {
        document.getElementById("grpLogin").classList.add("focused");
        document.getElementById("grpLogin").classList.add("success");
        document.getElementById("labelLogin").classList.add("text-success");
        document.getElementById("labelLogin").classList.remove("text-danger");
        document.getElementById("labelLogin").innerHTML = "Login";
        return true;
    }
}
function FSenha() {
    if (document.formCadastro.senhaUsuario.value.length === 0) {
        document.getElementById("grpSenha").classList.add("focused");
        document.getElementById("grpSenha").classList.add("error");
        document.getElementById("grpSenha").classList.remove("success");
        document.getElementById("labelSenha").classList.add("text-danger");
        document.getElementById("labelSenha").innerHTML = "Senha - Digite sua Senha!";
        return false;
    } else if (document.formCadastro.senhaUsuario.value.length < 4) {
        document.getElementById("grpSenha").classList.add("focused");
        document.getElementById("grpSenha").classList.add("error");
        document.getElementById("grpSenha").classList.remove("success");
        document.getElementById("labelSenha").classList.add("text-danger");
        document.getElementById("labelSenha").innerHTML = "Senha - Deve conter mais de 4 caracteres!";
        return false;
    } else {
        document.getElementById("grpSenha").classList.add("focused");
        document.getElementById("grpSenha").classList.add("success");
        document.getElementById("labelSenha").classList.add("text-success");
        document.getElementById("labelSenha").classList.remove("text-danger");
        document.getElementById("labelSenha").innerHTML = "Senha";
        return true;
    }
}
function FCSenha() {
    if (document.formCadastro.senhaCUsuario.value.length === 0) {
        document.getElementById("grpCSenha").classList.add("focused");
        document.getElementById("grpCSenha").classList.add("error");
        document.getElementById("grpCSenha").classList.remove("success");
        document.getElementById("labelCSenha").classList.add("text-danger");
        document.getElementById("labelCSenha").innerHTML = "Confirmar Senha - Digite sua Senha!";
        return false;
    } else if (document.formCadastro.senhaUsuario.value !== document.formCadastro.senhaCUsuario.value) {
        document.getElementById("grpCSenha").classList.add("focused");
        document.getElementById("grpCSenha").classList.add("error");
        document.getElementById("grpCSenha").classList.remove("success");
        document.getElementById("labelCSenha").classList.add("text-danger");
        document.getElementById("labelCSenha").innerHTML = "Confirmar Senha - As Senhas devem ser iguais!";
        return false;
    } else {
        document.getElementById("grpCSenha").classList.add("focused");
        document.getElementById("grpCSenha").classList.add("success");
        document.getElementById("labelCSenha").classList.add("text-success");
        document.getElementById("labelCSenha").classList.remove("text-danger");
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