<% if (request.getSession().getAttribute("idUsuario") == null || !request.getSession().getAttribute("tipoUsuario").equals("B") || request.getSession().getAttribute("statusUsuario").equals("I") || request.getSession().getAttribute("statusCidade").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../header.jsp" %>
    </head>
</section>
<section class="content">
    <div class="container-fluid">
        <div class="block-header">
            <h2>Home</h2>
            <ol class="breadcrumb">
                <li class="active">
                    <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">assignment</i> Cadastrar Categoria
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Cadastrar Categoria</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <form id="formCadastro" name="formCadastro" action="<%= request.getContextPath()%>/newcategory" method="POST">
                                    <input type="hidden" class="form-control" name="idCidade" id="idCidade" value="<%= request.getSession().getAttribute("idCidade")%>">
                                    <div class="col-md-12">
                                        <b id="labelCat">Nome</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">reorder</i>
                                            </span>
                                            <div class="form-line" id="grpCat">
                                                <input type="text" class="form-control" name="nomeCategoria" id="nomeCategoria" placeholder="Ex: Via danificada">
                                            </div>
                                        </div>
                                    </div>    
                                    <div class="col-md-6">                                            
                                        <button type="button" onclick="validarCategoria();" name="btnEnviar" class="btn btn-block bg-green h-green waves-effect">Enviar</button>
                                    </div>
                                    <div class="col-md-6">                                            
                                        <button type="reset" name="btnLimpar" class="btn btn-block bg-red h-red waves-effect">Limpar</button>
                                    </div>
                                </form>                                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="../footer.jsp" %>
<script>
    document.getElementById("nomeCategoria").addEventListener("blur", FCategoria);
    function validarCategoria() {
        var VCategoria = FCategoria();
        if (VCategoria) {
            document.getElementById("formCadastro").submit();
        } else {
            console.log("erro");
        }
    }
    $('#nomeCategoria').blur(function () {
        var url = getContextPath() + "/VerificarNomeCategoria";
        if ($('#nomeCategoria').val().length !== 0) {
            $.ajax({
                type: "POST",
                url: url,
                data: "nome_categoria=" + this.value + "&cidade_categoria=" + document.getElementById("idCidade").value,
                dataType: "json",
                success: function (data) {
                    if (data.nomecategoriaexiste) {
                        document.getElementById("grpCat").classList.add("focused");
                        document.getElementById("grpCat").classList.add("error");
                        document.getElementById("grpCat").classList.remove("success");
                        document.getElementById("labelCat").classList.add("text-danger");
                        document.getElementById("labelCat").innerHTML = "Nome - Categoria existente!";
                        nome_categoria = false;
                    } else {
                        nome_categoria = true;
                    }
                }
            });
        }
    });
    function FCategoria() {
        if (document.formCadastro.nomeCategoria.value.length === 0) {
            document.getElementById("grpCat").classList.add("focused");
            document.getElementById("grpCat").classList.add("error");
            document.getElementById("grpCat").classList.remove("success");
            document.getElementById("labelCat").classList.add("text-danger");
            document.getElementById("labelCat").innerHTML = "Nome - Digite o nome para a Categoria!";
            return false;
        } else if (nome_categoria == false) {
            document.getElementById("grpCat").classList.add("focused");
            document.getElementById("grpCat").classList.add("error");
            document.getElementById("grpCat").classList.remove("success");
            document.getElementById("labelCat").classList.add("text-danger");
            document.getElementById("labelCat").innerHTML = "Nome - Categoria existente!";

        } else {
            document.getElementById("grpCat").classList.add("focused");
            document.getElementById("grpCat").classList.add("success");
            document.getElementById("labelCat").classList.remove("text-danger");
            document.getElementById("labelCat").classList.add("text-success");
            document.getElementById("labelCat").innerHTML = "Nome";
            return true;
        }
    }
</script>
</body>
</html>
