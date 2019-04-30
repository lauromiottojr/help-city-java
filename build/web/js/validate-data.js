document.getElementById("startDate").addEventListener("blur", FDataStart);
document.getElementById("endDate").addEventListener("blur", FDataEnd);
function validarData() {
    var VDataS = FDataStart();
    var VDataE = FDataEnd();
    if (VDataS && VDataE) {
        return true;
    } else {
        return false;
        console.log("erro");
    }
}
function FDataStart() {
    var start = (document.getElementById("startDate").value).split("/");
    var hoje = new Date();
    var ano = start[2];
    var mes = start[1] - 1;
    var dia = start[0];
    var dataInformada = new Date(ano, mes, dia);
    if (document.getElementById("startDate").value.length === 0) {
        document.getElementById("grpStart").classList.add("text-danger");
        document.getElementById("grpStart").classList.remove("text-success");
        document.getElementById("grpStart").innerHTML = "Data inicial - Digite a Data inicial!";
        return false;
    } else if (hoje < dataInformada || document.getElementById("startDate").value.length < 10 || mes > 11 || (dia < 1 || dia > 31)) {
        document.getElementById("grpStart").classList.add("text-danger");
        document.getElementById("grpStart").classList.remove("text-success");
        document.getElementById("grpStart").innerHTML = "Data inicial - Data Incorreta!";
        return false;
    } else {
        document.getElementById("grpStart").classList.remove("text-danger");
        document.getElementById("grpStart").classList.add("text-success");
        document.getElementById("grpStart").innerHTML = "Data inicial";
        return true;
    }
}
function FDataEnd() {
    var start = (document.getElementById("startDate").value).split("/");
    var end = (document.getElementById("endDate").value).split("/");
    var anos = start[2];
    var mess = start[1] - 1;
    var dias = start[0];
    var anoe = end[2];
    var mese = end[1] - 1;
    var diae = end[0];
    var sDate = new Date(anos, mess, dias);
    var eDate = new Date(anoe, mese, diae);
    if (document.getElementById("endDate").value.length === 0) {
        document.getElementById("grpEnd").classList.add("text-danger");
        document.getElementById("grpEnd").classList.remove("text-success");
        document.getElementById("grpEnd").innerHTML = "Data final - Digite a Data final!";
        return false;
    } else if (document.getElementById("endDate").value.length < 10 || mese > 11 || (diae < 1 || diae > 31)) {
        document.getElementById("grpEnd").classList.add("text-danger");
        document.getElementById("grpEnd").classList.remove("text-success");
        document.getElementById("grpEnd").innerHTML = "Data final - Data Incorreta!";
        return false;
    } else if (sDate > eDate) {
        document.getElementById("grpEnd").classList.add("text-danger");
        document.getElementById("grpEnd").classList.remove("text-success");
        document.getElementById("grpEnd").innerHTML = "Data final - Data inicial maior que a Data final!";
        return false;
    } else {
        document.getElementById("grpEnd").classList.remove("text-danger");
        document.getElementById("grpEnd").classList.add("text-success");
        document.getElementById("grpEnd").innerHTML = "Data final";
        return true;
    }
}
function currentDate(campo) {
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();
    today = dd + '/' + mm + '/' + yyyy;
    if (campo === 'inicial') {
        document.getElementById("startDate").value = today;
        FDataStart()
    } else {
        document.getElementById("endDate").value = today;
        FDataEnd()
    }
}