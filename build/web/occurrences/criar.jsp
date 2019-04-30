<%  if (request.getSession().getAttribute("idUsuario") == null || !((request.getSession().getAttribute("tipoUsuario").toString().equals("B") || request.getSession().getAttribute("tipoUsuario").toString().equals("C") || request.getSession().getAttribute("tipoUsuario").toString().equals("D")) && request.getSession().getAttribute("statusCidade").equals("A")) || request.getSession().getAttribute("statusUsuario").equals("I")) {
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
            <h2>Criar Ocorrência</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">map</i> Criar Ocorrência
                </li>
            </ol>
        </div>                
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>
                            Criar Ocorrência
                        </h2>
                    </div>
                    <div class="body">
                        <form name="criarOcorrencia" id="criarOcorrencia" action="<%= request.getContextPath()%>/newoccurrence" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="idCidade" id="idCidade" value="<%= request.getSession().getAttribute("idCidade")%>"/>
                            <input type="hidden" name="tipoUsuario" id="tipoUsuario" value="<%= request.getSession().getAttribute("tipoUsuario")%>"/>
                            <input type="hidden" name="idUsuario" id="idUsuario" value="<%= request.getSession().getAttribute("idUsuario")%>"/>
                            <div class="row clearfix">
                                <div class="col-md-12">
                                    <b id="labelTitulo">Título da Ocorrência</b>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="material-icons">title</i>
                                        </span>
                                        <div class="form-line" id="grpTitulo">
                                            <input type="text" class="form-control" name="tituloOcorrencia" id="tituloOcorrencia">
                                        </div>
                                    </div>
                                </div>  
                                <div class="col-md-8">
                                    <b id="labelLocalizacao">Localização</b>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="material-icons">add_location</i>
                                        </span>
                                        <div class="form-line" id="grpLocalizacao">
                                            <input id="txtEndereco" name="txtEndereco" type="text" class="form-control">
                                        </div>
                                    </div>
                                </div>  
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <input type="button" onclick="getLocation()" value="Localização atual" class="btn btn-block btn-lg bg-black waves-effect"/> 
                                    </div>
                                </div>
                            </div>
                            <div id="mapa"></div>
                            <div class="col-md-12">
                                <b id="labelDescricao">Descrição</b>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="material-icons">description</i>
                                    </span>
                                    <div class="form-line" id="grpDescricao">
                                        <textarea id="descricaoOcorrencia" name="descricaoOcorrencia" cols="30" rows="5" class="form-control no-resize"></textarea>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" id="txtLatitude" name="txtLatitude"/>
                            <input type="hidden" id="txtLongitude" name="txtLongitude"/>
                            <div class="fallback">
                                <input type="file" name="imagemOcorrencia" id="imagemOcorrencia"  accept=".jpg, .png, .jpeg" multiple>
                            </div><br>
                            <input onclick="validarFormularioOcr();" name="btnEnviar" class="btn btn-block btn-lg bg-green h-green waves-effect" value="Enviar"/>                             
                        </form>  
                    </div>
                </div>
            </div>
        </div>
    </div>            
</section>
<%@include file="../footer.jsp" %>
<script src="<%= request.getContextPath()%>/js/mapa.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBWvEwkfRQ9HgYJL0IlKxWFzN2_4iDZ8TY"></script>
<script type="text/javascript">
                                            var la = -20.2686674;
                                            var lo = -50.54902119999997;
                                            initialize(la, lo);
                                            function validarFormularioOcr() {
                                                var VTitulo = FTitulo();
                                                var VLoc = FLoc();
                                                var VDesc = FDesc();
                                                var VLat = FLat();
                                                var VLon = FLon();
                                                if (VTitulo && VLoc && VDesc && VLat && VLon) {
                                                    document.getElementById("criarOcorrencia").submit();
                                                } else {
                                                    console.log("erro");
                                                }
                                            }

                                            document.getElementById("tituloOcorrencia").addEventListener("blur", FTitulo);
                                            document.getElementById("txtEndereco").addEventListener("blur", FLoc);
                                            document.getElementById("descricaoOcorrencia").addEventListener("blur", FDesc);
                                            document.getElementById("txtLatitude").addEventListener("blur", FLat);
                                            document.getElementById("txtLongitude").addEventListener("blur", FLon);
                                            function FTitulo() {
                                                if (document.criarOcorrencia.tituloOcorrencia.value.length === 0) {
                                                    document.getElementById("grpTitulo").classList.add("focused");
                                                    document.getElementById("grpTitulo").classList.add("error");
                                                    document.getElementById("grpTitulo").classList.remove("success");
                                                    document.getElementById("labelTitulo").classList.add("text-danger");
                                                    document.getElementById("labelTitulo").innerHTML = "Título da Ocorrência - Digite o Título da Ocorrência!";
                                                    return false;
                                                } else {
                                                    document.getElementById("grpTitulo").classList.add("focused");
                                                    document.getElementById("grpTitulo").classList.add("success");
                                                    document.getElementById("labelTitulo").classList.remove("text-danger");
                                                    document.getElementById("labelTitulo").classList.add("text-success");
                                                    document.getElementById("labelTitulo").innerHTML = "Título da Ocorrência";
                                                    return true;
                                                }
                                            }
                                            function FLoc() {
                                                if (document.criarOcorrencia.txtEndereco.value.length === 0) {
                                                    document.getElementById("grpLocalizacao").classList.add("focused");
                                                    document.getElementById("grpLocalizacao").classList.add("error");
                                                    document.getElementById("grpLocalizacao").classList.remove("success");
                                                    document.getElementById("labelLocalizacao").classList.add("text-danger");
                                                    document.getElementById("labelLocalizacao").innerHTML = "Localização - Digite a Localização!";
                                                    return false;
                                                } else {
                                                    document.getElementById("grpLocalizacao").classList.add("focused");
                                                    document.getElementById("grpLocalizacao").classList.add("success");
                                                    document.getElementById("labelLocalizacao").classList.remove("text-danger");
                                                    document.getElementById("labelLocalizacao").classList.add("text-success");
                                                    document.getElementById("labelLocalizacao").innerHTML = "Localização";
                                                    return true;
                                                }
                                            }
                                            function FDesc() {
                                                if (document.criarOcorrencia.descricaoOcorrencia.value.length === 0) {
                                                    document.getElementById("grpDescricao").classList.add("focused");
                                                    document.getElementById("grpDescricao").classList.add("error");
                                                    document.getElementById("grpTitulo").classList.remove("success");
                                                    document.getElementById("labelDescricao").classList.add("text-danger");
                                                    document.getElementById("labelDescricao").innerHTML = "Descrição - Digite a Descrição!";
                                                    return false;
                                                } else {
                                                    document.getElementById("grpDescricao").classList.add("focused");
                                                    document.getElementById("grpDescricao").classList.add("success");
                                                    document.getElementById("labelDescricao").classList.remove("text-danger");
                                                    document.getElementById("labelDescricao").classList.add("text-success");
                                                    document.getElementById("labelDescricao").innerHTML = "Descrição";
                                                    return true;
                                                }
                                            }
                                            function FLat() {
                                                if (document.criarOcorrencia.txtLatitude.value.length === 0) {
                                                    document.getElementById("grpLocalizacao").classList.add("focused");
                                                    document.getElementById("grpLocalizacao").classList.add("error");
                                                    document.getElementById("grpLocalizacao").classList.remove("success");
                                                    document.getElementById("labelLocalizacao").classList.add("text-danger");
                                                    document.getElementById("labelLocalizacao").innerHTML = "Localização - Digite uma Localização válida!";
                                                    return false;
                                                } else {
                                                    document.getElementById("grpLocalizacao").classList.add("focused");
                                                    document.getElementById("grpLocalizacao").classList.add("success");
                                                    document.getElementById("labelLocalizacao").classList.remove("text-danger");
                                                    document.getElementById("labelLocalizacao").classList.add("text-success");
                                                    document.getElementById("labelLocalizacao").innerHTML = "Localização";
                                                    return true;
                                                }
                                            }
                                            function FLon() {
                                                if (document.criarOcorrencia.txtLongitude.value.length === 0) {
                                                    document.getElementById("grpLocalizacao").classList.add("focused");
                                                    document.getElementById("grpLocalizacao").classList.add("error");
                                                    document.getElementById("grpLocalizacao").classList.remove("success");
                                                    document.getElementById("labelLocalizacao").classList.add("text-danger");
                                                    document.getElementById("labelLocalizacao").innerHTML = "Localização - Digite uma Localização válida!";
                                                    return false;
                                                } else {
                                                    document.getElementById("grpLocalizacao").classList.add("focused");
                                                    document.getElementById("grpLocalizacao").classList.add("success");
                                                    document.getElementById("labelLocalizacao").classList.remove("text-danger");
                                                    document.getElementById("labelLocalizacao").classList.add("text-success");
                                                    document.getElementById("labelLocalizacao").innerHTML = "Localização";
                                                    return true;
                                                }
                                            }
</script>
</body>
</html>