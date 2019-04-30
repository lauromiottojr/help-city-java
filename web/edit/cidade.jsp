<% if (request.getSession().getAttribute("idUsuario") == null || !request.getSession().getAttribute("tipoUsuario").equals("A") || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alterar Cidade - Help City</title>
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
                <li>
                    <a href="<%= request.getContextPath()%>/cities"><i class="material-icons">search</i> Consultar Cidade</a>
                </li>
                <li class="active">
                    <i class="material-icons">edit</i> Alterar Cidade
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Alterar Cidade</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <form id="formCadastro" name="formCadastro" action="<%= request.getContextPath()%>/editcity" method="POST">                                   
                                    <input type="hidden" class="form-control" name="idCidade" id="idCidade" value="${cidade.idCidade}">                                   
                                    <div class="col-md-12">
                                        <b>Estado</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">explicit</i>
                                            </span>
                                            <select class="form-control show-tick" data-live-search="true" name="estadoCidade" id="estadoCidade">
                                                <c:forEach var="estado" items="${estados}">
                                                    <option value="${estado.idEstado}" ${estado.idEstado == 
                                                                     cidade.estadoCidade.idEstado ? "selected" : ""}>${estado.nomeEstado}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>  
                                    <div class="col-md-12">
                                        <b id="labelNome">Nome da Cidade</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">location_city</i>
                                            </span>
                                            <div class="form-line" id="grpNome">
                                                <input type="text" class="form-control" name="nomeCidade" id="nomeCidade" placeholder="Ex: Pedro Jorge" value="${cidade.nomeCidade}">
                                            </div>
                                        </div>
                                    </div>                    
                                    <div class="col-md-12">
                                        <b>Status</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">build</i>
                                            </span>
                                            <div class="demo-radio-button">
                                                <input ${cidade.statusCidade == 'A' ? "checked" : ""} name="statusCidade" type="radio" id="A" value="A" class="radio-col-blue-grey" required=""/>
                                                <label for="A">Ativo</label>
                                                <input ${cidade.statusCidade == 'I' ? "checked" : ""} name="statusCidade" type="radio" id="I" value="I" class="radio-col-blue-grey" required=""/>
                                                <label for="I">Inativo</label>
                                            </div>
                                        </div>
                                    </div>   
                                    <div class="col-md-6">                                            
                                        <button type="button" onclick="validarFormularioCid();" name="btnEnviar" class="btn btn-block bg-green waves-effect">Enviar</button>
                                    </div>
                                    <div class="col-md-6">                                            
                                        <a href="cities"><button type="button" name="btnCancelar" class="btn btn-block bg-red waves-effect">Cancelar</button></a>
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
<script src="<%= request.getContextPath()%>/js/validar-cid.js"></script>
</body>
</html>
