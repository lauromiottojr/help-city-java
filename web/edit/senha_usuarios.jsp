<%  if (request.getSession().getAttribute("idUsuario") == null || !(request.getSession().getAttribute("tipoUsuario").toString().equals("A") || (request.getSession().getAttribute("tipoUsuario").toString().equals("B") && request.getSession().getAttribute("statusCidade").equals("A"))) || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bem-vindo - Help City</title>
        <%@include file="../header.jsp" %>
    </head>
</section>
<section class="content">
    <div class="container-fluid">
        <div class="block-header">
            ${mensagem}
            <h2>Home</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">autorenew</i> Alterar Senha
                </li>
            </ol>
        </div>  
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Alterar Senha - ${usuario.nomeUsuario}</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <form id="formSenha" name="formSenha" action="<%= request.getContextPath()%>/edituserpassword" method="POST">    
                                    <input type="hidden" class="form-control" name="idUsuario" id="idUsuario" value="${usuario.idUsuario}">
                                    <input type="hidden" class="form-control" name="tipoUsuarioAlter" id="tipoUsuarioAlter" value="${usuario.tipoUsuario}">                                                                               
                                    <div class="col-md-6">
                                        <b id="labelSenha">Senha</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">lock</i>
                                            </span>
                                            <div class="form-line" id="grpSenha">
                                                <input type="password" class="form-control" name="senhaUsuario" id="senhaUsuario">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <b id="labelCSenha">Confirmar Senha</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">lock</i>
                                            </span>
                                            <div class="form-line" id="grpCSenha">
                                                <input type="password" class="form-control" name="senhaCUsuario" id="senhaCUsuario">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">                                            
                                        <button type="button" onclick="validarFormSenha();" name="btnEnviar" class="btn btn-block bg-green h-green waves-effect">Enviar</button>
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
<script src="<%= request.getContextPath()%>/js/validar-senha.js" type="text/javascript"></script>
</body>
</html>
