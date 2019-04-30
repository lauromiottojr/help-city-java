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