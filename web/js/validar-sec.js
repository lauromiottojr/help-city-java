function validarFormularioSec(){
    var VNome = FNome();
    var VEmail = FEmail();
    var VTel = FTel();
    
    if(VNome && VEmail && VTel){
        document.getElementById("formCadastro").submit();
    }else{
        console.log("erro");
    }
}
document.getElementById("nomeSecretaria").addEventListener("blur", FNome);
document.getElementById("emailSecretaria").addEventListener("blur", FEmail);
document.getElementById("telefoneSecretaria").addEventListener("blur", FTel);
function FNome() {
    if (document.formCadastro.nomeSecretaria.value.length === 0) {
        document.getElementById("grpNome").classList.add("focused");
        document.getElementById("grpNome").classList.add("error");        
        document.getElementById("grpNome").classList.remove("success");
        document.getElementById("labelNome").classList.add("text-danger");
        document.getElementById("labelNome").innerHTML = "Nome da Secretaria - Digite o Nome da Secretaria!";
        return false;
    } else {
        document.getElementById("grpNome").classList.add("focused");
        document.getElementById("grpNome").classList.add("success");
        document.getElementById("labelNome").classList.remove("text-danger");
        document.getElementById("labelNome").classList.add("text-success");
        document.getElementById("labelNome").innerHTML = "Nome da Secretaria";
        return true;
    }
}
function FEmail() {
    var expEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (document.formCadastro.emailSecretaria.value.length === 0) {
        document.getElementById("grpEmail").classList.add("focused");
        document.getElementById("grpEmail").classList.add("error");
        document.getElementById("grpEmail").classList.remove("success");
        document.getElementById("labelEmail").classList.add("text-danger");
        document.getElementById("labelEmail").innerHTML = "Email da Secretaria - Digite o Email da Secretaria!";
        return false;
    } else if (expEmail.test(document.formCadastro.emailSecretaria.value) === false) {
        document.getElementById("grpEmail").classList.add("focused");
        document.getElementById("grpEmail").classList.add("error");
        document.getElementById("grpEmail").classList.remove("success");
        document.getElementById("labelEmail").classList.add("text-danger");
        document.getElementById("labelEmail").innerHTML = "Email da Secretaria - Formato de Email Incorreto!";
        return false;
    } else {
        document.getElementById("grpEmail").classList.add("focused");
        document.getElementById("grpEmail").classList.add("success");
        document.getElementById("labelEmail").classList.add("text-success");
        document.getElementById("labelEmail").classList.remove("text-danger");
        document.getElementById("labelEmail").innerHTML = "Email da Secretaria";
        return true;
    }
}
function FTel() {
    if (document.formCadastro.telefoneSecretaria.value.length === 0) {
        document.getElementById("grpTelefone").classList.add("focused");
        document.getElementById("grpTelefone").classList.add("error");
        document.getElementById("grpTelefone").classList.remove("success");
        document.getElementById("labelTelefone").classList.add("text-danger");
        document.getElementById("labelTelefone").innerHTML = "Telefone da Secretaria - Digite o Telefone da Secretaria!";
        return false;
    } else if (document.formCadastro.telefoneSecretaria.value.length !== 14) {
        document.getElementById("grpTelefone").classList.add("focused");
        document.getElementById("grpTelefone").classList.add("error");
        document.getElementById("grpTelefone").classList.remove("success");
        document.getElementById("labelTelefone").classList.add("text-danger");
        document.getElementById("labelTelefone").innerHTML = "Telefone da Secretaria - Formato do Telefone Incorreto!";
        return false;
    } else {
        document.getElementById("grpTelefone").classList.add("focused");
        document.getElementById("grpTelefone").classList.add("success");
        document.getElementById("labelTelefone").classList.add("text-success");
        document.getElementById("labelTelefone").classList.remove("text-danger");
        document.getElementById("labelTelefone").innerHTML = "Telefone da Secretaria";
        return true;
    }
}
    