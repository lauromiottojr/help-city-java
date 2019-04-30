$('#dadosCidade').change(function () {
    var url = getContextPath() + "/CarregarDadosCidade";
    $.ajax({
        type: "POST",
        url: url,
        data: "cidade=" + this.value,
        dataType: "json",
        success: function (data) {
            if (data.dadoscidade) {
                document.getElementById("valores").classList.remove("hidden");
                $('#adm').countTo({from: 0, to: data.dadoscidade[0]});
                $('#fun').countTo({from: 0, to: data.dadoscidade[1]});
                $('#cid').countTo({from: 0, to: data.dadoscidade[2]});
                $('#oco').countTo({from: 0, to: data.dadoscidade[3]});
                $('#nov').countTo({from: 0, to: data.dadoscidade[4]});
                $('#enc').countTo({from: 0, to: data.dadoscidade[5]});
                $('#fin').countTo({from: 0, to: data.dadoscidade[6]});
                $('#can').countTo({from: 0, to: data.dadoscidade[7]});
            }
        }
    });
});
$('#btnOcorrencias').one('click', function () {
    var url = getContextPath() + "/CarregarOcorrenciasCategorias";
    $.ajax({
        type: "POST",
        url: url,
        data: "cidade=" + this.value,
        dataType: "json",
        success: function (data) {
            var dados = [];
            var total = 0;
            for (key in data.dadoscategorias) {
                total += data.dadoscategorias[key][1];
            }
            for (key in data.dadoscategorias) {
                var value = {};
                value.label = data.dadoscategorias[key][0];
                value.value = (data.dadoscategorias[key][1] / total * 100).toFixed(2);
                dados.push(value);
//                    for (i = 0; i < data.dadoscategorias[key].length; i++) {
//                        if (contador === 0) {
//                            dataChart += '{"label": "' + data.dadoscategorias[key][i] + '",';
//                            contador++;
//                        } else {
//                            dataChart += '"value": ' + data.dadoscategorias[key][i] + '},';
//                            contador = 0;
//                        }
//                    }
            }
            Morris.Donut({
                element: 'donutCategoria',
                data: dados,
                colors: ["#8080ff", "#ff80ff", "#ff8080", "#ffff80", "#99e699", "#bfbfbf", "#ffbf80", "#80bfff"],
                formatter: function (y) {
                    return y + '%'
                }
            });
        }
    });
});
$('#btnOcorrencias').one('click', function () {
    var url = getContextPath() + "/CarregarOcorrenciasSecretarias";
    $.ajax({
        type: "POST",
        url: url,
        data: "cidade=" + this.value,
        dataType: "json",
        success: function (data) {
            var dados = [];
            var total = 0;
            for (key in data.dadossecretarias) {
                total += data.dadossecretarias[key][1];
            }
            for (key in data.dadossecretarias) {
                var value = {};
                value.label = data.dadossecretarias[key][0];
                value.value = (data.dadossecretarias[key][1] / total * 100).toFixed(2);
                dados.push(value);
            }
            Morris.Donut({
                element: 'donutSecretaria',
                data: dados,
                colors: ["#8080ff", "#ff80ff", "#ff8080", "#ffff80", "#99e699", "#bfbfbf", "#ffbf80", "#80bfff"],
                formatter: function (y) {
                    return y + '%'
                }
            });
        }
    });
});
$('#btnIdade').one('click', function () {
    var url = getContextPath() + "/CarregarIdades";
    $.ajax({
        type: "POST",
        url: url,
        data: '',
        dataType: "json",
        success: function (data) {
            var total = data.dadosidades[0] + data.dadosidades[1] + data.dadosidades[2] + data.dadosidades[3];
            Morris.Donut({
                element: 'donutIdade',
                data: [{
                        label: '< 18 ',
                        value: (data.dadosidades[0] / total * 100).toFixed(2)
                    }, {
                        label: '18 - 35',
                        value: (data.dadosidades[1] / total * 100).toFixed(2)
                    }, {
                        label: '36 - 50',
                        value: (data.dadosidades[2] / total * 100).toFixed(2)
                    }, {
                        label: '> 50 ',
                        value: (data.dadosidades[3] / total * 100).toFixed(2)
                    }, ],
                colors: ["#8080ff", "#ff80ff", "#ff8080", "#ffff80"],
                formatter: function (y) {
                    return y + '%'
                }
            });
        }
    });
});
$('#btnData').click(function () {
    if (validarData()) {
        $("#line_chart").empty();
        var url = getContextPath() + "/OcorrenciaData";
        var startDate = document.getElementById("startDate").value;
        var endDate = document.getElementById("endDate").value;
        var status = document.getElementById("statusOcorrendiaData").value;
        var color = [];
        if (status === 'Todas')
            color = ['blue'];
        else if (status === 'Nova')
            color = ['#ffc107'];
        else if (status === 'Encaminhada')
            color = ['#ff9800'];
        else if (status === 'Finalizada')
            color = ['#4caf50'];
        else if (status === 'Cancelada')
            color = ['#f44336'];
        $.ajax({
            type: "POST",
            url: url,
            data: {'startDate': startDate, 'endDate': endDate, 'status': status},
            dataType: "json",
            success: function (data) {
                var dados = [];
                for (key in data.dadosperiodo) {
                    var value = {};
                    value.period = data.dadosperiodo[key][0];
                    value.value = data.dadosperiodo[key][1];
                    dados.push(value);
                }
                Morris.Line({
                    element: line_chart,
                    data: dados,
                    xkey: 'period',
                    ykeys: ['value'],
                    xLabelFormat: function (d) {
                        return ("0" + d.getDate()).slice(-2) + '-' + ("0" + (d.getMonth() + 1)).slice(-2) + '-' + d.getFullYear();
                    },
                    labels: ['Quantidade'],
                    lineColors: color,
                    lineWidth: 3
                });
            }
        });
    }
    else {
        $("#line_chart").empty();
    }
});