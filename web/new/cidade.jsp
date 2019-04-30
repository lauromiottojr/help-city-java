<% if (request.getSession().getAttribute("idUsuario") == null || !request.getSession().getAttribute("tipoUsuario").equals("A") || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() +  "/index.jsp");
    }
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li>
                    <a href="dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">assignment</i> Cadastrar Cidade
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Cadastrar Cidade</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <form id="formCadastro" name="formCadastro" action="<%= request.getContextPath()%>/newcity" method="POST">
                                    <div class="col-md-12">
                                        <b>Estado</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">explicit</i>
                                            </span>
                                            <select class="form-control show-tick" data-live-search="true" name="estadoCidade" id="estadoCidade">
                                                <c:forEach var="estado" items="${estados}">
                                                    <option value="${estado.idEstado}">${estado.nomeEstado} - ${estado.ufEstado}</option>                                                    
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
                                                <input type="text" class="form-control" name="nomeCidade" id="nomeCidade" placeholder="Ex: Jales">
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="col-md-6">                                            
                                        <button type="button" onclick="validarFormularioCid();" name="btnEnviar" class="btn btn-block bg-green waves-effect">Enviar</button>
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
<script src="<%= request.getContextPath()%>/js/validar-cid.js"></script>
</body>
</html>
