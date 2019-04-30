<%  if (request.getSession().getAttribute("idUsuario") == null || !((request.getSession().getAttribute("tipoUsuario").toString().equals("B") || request.getSession().getAttribute("tipoUsuario").toString().equals("C")) && request.getSession().getAttribute("statusCidade").equals("A")) || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <li>
                    <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">send</i> Encaminhar Ocorrência
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Encaminhar Ocorrência</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <form id="formCadastro" name="formCadastro" action="<%= request.getContextPath()%>/editoccurrence" method="POST">
                                    <input type="hidden" class="form-control" name="idOcorrencia" id="idOcorrencia" value="${ocorrencia.idOcorrencia}">
                                    <% if (typeUser.equalsIgnoreCase("C")) {%>
                                    <input type="hidden" class="form-control" name="idCategoria" id="idCategoria" value="${ocorrencia.categoriaOcorrencia.idCategoria}">
                                    <% }%>
                                    <div class="row col-md-6">
                                        <b>Título da Ocorrência</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">title</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" disabled="" class="form-control" name="tituloOcorrencia" id="tituloOcorrencia" value="${ocorrencia.tituloOcorrencia}">
                                            </div>
                                        </div>
                                    </div>     
                                    <div class="row col-md-6">
                                        <b>Data de Criação da Ocorrência</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">date_range</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" disabled="" class="form-control" name="criacaoOcorrencia" id="criacaoOcorrencia" value="<fmt:formatDate value='${ocorrencia.dataCriacaoOcorrencia}' type='date' pattern='dd/MM/yyyy'/>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row col-md-12">
                                        <b>Descrição</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">description</i>
                                            </span>
                                            <div class="form-line">
                                                <textarea id="descricaoOcorrencia" name="descricaoOcorrencia" cols="30" rows="3" disabled class="form-control no-resize">${ocorrencia.descricaoOcorrencia}</textarea>
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="row col-md-6">
                                        <b>Latitude</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">location_on</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" disabled="" class="form-control" name="latitudeOcorrencia" id="latitudeOcorrencia" value="${ocorrencia.latitudeOcorrencia}">
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="row col-md-6">
                                        <b>Longitude</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">location_on</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" disabled="" class="form-control" name="longitudeOcorrencia" id="longitudeOcorrencia" value="${ocorrencia.longitudeOcorrencia}">
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="col-md-12">
                                        <b>Endereço</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">my_location</i>
                                            </span>
                                            <div class="form-line">
                                                <input type="text" class="form-control" name="enderecoOcorrencia" id="enderecoOcorrencia" disabled="" value="${ocorrencia.localizacaoOcorrencia}">
                                            </div>
                                        </div>
                                    </div> 
                                    <div id="mapa"></div>
                                    <% if (typeUser.equalsIgnoreCase("B")) {%>
                                    <div class="col-md-12">
                                        <b>Categoria</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">apps</i>
                                            </span>                                            
                                            <select class="form-control show-tick" data-live-search="true" name="categoriaOcorrencia" id="categoriaOcorrencia">
                                                <c:forEach var="categoria" items="${categorias}">
                                                    <option value="${categoria.idCategoria}" ${categoria.idCategoria == 
                                                                     ocorrencia.categoriaOcorrencia.idCategoria ? "selected" : ""}>${categoria.nomeCategoria}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <% }%>
                                    <div class="col-md-12">
                                        <b>Status</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">done_all</i>
                                            </span>                                            
                                            <select class="form-control show-tick" data-live-search="true" name="statusOcorrencia" id="statusOcorrencia">
                                                <option value="Nova" ${ocorrencia.statusOcorrencia == "Nova" ? "selected" : ""}>Nova</option>
                                                <option value="Encaminhada" ${ocorrencia.statusOcorrencia == "Encaminhada" ? "selected" : ""}>Encaminhada</option>
                                                <option value="Finalizada" ${ocorrencia.statusOcorrencia == "Finalizada" ? "selected" : ""}>Finalizada</option>
                                                <option value="Cancelada" ${ocorrencia.statusOcorrencia == "Cancelada" ? "selected" : ""}>Cancelada</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <b id="labelDescricao">Observação</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">remove_red_eye</i>
                                            </span>
                                            <div class="form-line" id="grpDescricao">
                                                <textarea id="observacaoOcorrencia" name="observacaoOcorrencia" cols="30" rows="3" class="form-control no-resize">${ocorrencia.observacaoOcorrencia}</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <% if (typeUser.equalsIgnoreCase("B")) {%>
                                    <div class="col-md-12">
                                        <b>Encaminhar Para</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">send</i>
                                            </span>                                            
                                            <select class="form-control show-tick" data-live-search="true" name="secretariaOcorrencia" id="secretariaOcorrencia">
                                                <c:forEach var="secretaria" items="${secretarias}">
                                                    <option value="${secretaria.idSecretaria}" ${secretaria.idSecretaria == 
                                                                     ocorrencia.secretariaOcorrencia.idSecretaria ? "selected" : ""}>${secretaria.nomeSecretaria}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <% }%>
                                    <div class="row">
                                        <c:forEach var="imagem" items="${imagens}">
                                            <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12" data-toggle="modal" data-target="#${imagem.idImagem}">                               
                                                <img class="img-responsive thumbnail" src="<%= request.getContextPath()%>/${imagem.nomeImagem}">
                                            </div>
                                            <div class="modal fade" id="${imagem.idImagem}" tabindex="-1" role="dialog">
                                                <div class="modal-dialog modal-lg" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-body">
                                                            <img class="img-modal" src="<%= request.getContextPath()%>/${imagem.nomeImagem}" alt="Imagem carregada pelo usuário">
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">Fechar</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">                                            
                                            <button type="submit" name="btnEnviar" class="btn btn-block bg-green waves-effect">Enviar</button>
                                        </div>
                                        <div class="col-md-6">                                            
                                            <a href="
                                               <% if (typeUser.equalsIgnoreCase("B")) {%><%= request.getContextPath()%>/occurrencehistory"
                                               <% } else if (typeUser.equalsIgnoreCase("C")) {%><%= request.getContextPath()%>/occurrencehistory"
                                               <% }%>><button type="button" name="btnCancelar" class="btn btn-block bg-red waves-effect">Cancelar</button></a>
                                        </div>
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
<script src="<%= request.getContextPath()%>/js/modals.js"></script>
<script src="<%= request.getContextPath()%>/js/mapa.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBWvEwkfRQ9HgYJL0IlKxWFzN2_4iDZ8TY"></script>
<script>
    var la = document.getElementById("latitudeOcorrencia").value;
    var lo = document.getElementById("longitudeOcorrencia").value;
    initialize(la, lo);
</script>
</body>
</html>
