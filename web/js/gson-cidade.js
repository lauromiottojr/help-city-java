$('#estadoUsuario').change(function () {
    var url = getContextPath() + "/ListarCidadeEstado";
    $.ajax({
        type: "POST",
        url: url,
        data: "estado=" + this.value,
        dataType: "json",
        success: function (data) {
            $("#cidadeUsuario").empty().append(new Option("Selecione uma cidade", ""));
            for (var i in data.cidadesestado) {
                $("#cidadeUsuario").append(new Option(data.cidadesestado[i].nomeCidade, data.cidadesestado[i].idCidade));
            }
            $('#cidadeUsuario').selectpicker('refresh');
        }
    });
});
$('#cidadeUsuario').change(function () {
    var url = getContextPath() + "/ListarSecretariaCidadeAuto";
    $.ajax({
        type: "POST",
        url: url,
        //data: "cidade=" + this.value,
        dataType: "json",
        success: function (data) {
            $("#secretariaFuncionario").empty().append(new Option("Selecione uma secretaria", ""));
            for (var i in data.secretariacidade) {
                $("#secretariaFuncionario").append(new Option(data.secretariacidade[i].nomeSecretaria, data.secretariacidade[i].idSecretaria));
            }
            $('#secretariaFuncionario').selectpicker('refresh');
        }
    });
});