document.getElementById("senhaUsuario").addEventListener("blur", FSenha);
document.getElementById("senhaCUsuario").addEventListener("blur", FCSenha);
function validarFormSenha() {
    var VSenha = FSenha();
    var VCSenha = FCSenha();
    if (VSenha && VCSenha) {
        document.getElementById("formSenha").submit();
    } else {
        console.log("erro");
    }
}
function FSenha() {
    if (document.getElementById("senhaUsuario").value.length === 0) {
        document.getElementById("grpSenha").classList.add("focused");
        document.getElementById("grpSenha").classList.add("error");
        document.getElementById("grpSenha").classList.remove("success");
        document.getElementById("labelSenha").classList.add("text-danger");
        document.getElementById("labelSenha").innerHTML = "Senha - Digite sua Senha!";
        return false;
    } else if (document.getElementById("senhaUsuario").value.length < 4) {
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
    if (document.getElementById("senhaCUsuario").value.length === 0) {
        document.getElementById("grpCSenha").classList.add("focused");
        document.getElementById("grpCSenha").classList.add("error");
        document.getElementById("grpCSenha").classList.remove("success");
        document.getElementById("labelCSenha").classList.add("text-danger");
        document.getElementById("labelCSenha").innerHTML = "Confirmar Senha - Digite sua Senha!";
        return false;
    } else if (document.getElementById("senhaUsuario").value !== document.getElementById("senhaCUsuario").value) {
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