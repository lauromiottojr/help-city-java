function validarFormularioCid(){
    var VNome = FNome();
    
    if(VNome){
        document.getElementById("formCadastro").submit();
    }else{
        console.log("erro");
    }
}
document.getElementById("nomeCidade").addEventListener("blur", FNome);
function FNome() {
    if (document.formCadastro.nomeCidade.value.length === 0) {
        document.getElementById("grpNome").classList.add("focused");
        document.getElementById("grpNome").classList.add("error");        
        document.getElementById("grpNome").classList.remove("success");
        document.getElementById("labelNome").classList.add("text-danger");
        document.getElementById("labelNome").innerHTML = "Nome da Cidade - Digite o Nome da Cidade!";
        return false;
    } else {
        document.getElementById("grpNome").classList.add("focused");
        document.getElementById("grpNome").classList.add("success");
        document.getElementById("labelNome").classList.remove("text-danger");
        document.getElementById("labelNome").classList.add("text-success");
        document.getElementById("labelNome").innerHTML = "Nome da Cidade";
        return true;
    }
}
    