<% if (request.getSession().getAttribute("idUsuario") == null || !request.getSession().getAttribute("tipoUsuario").equals("B") || request.getSession().getAttribute("statusUsuario").equals("I") || request.getSession().getAttribute("statusCidade").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="br.com.helpcity.DAO.GenericDAO"%>
<%@page import="br.com.helpcity.model.Secretaria"%>
<%@page import="br.com.helpcity.DAO.SecretariaDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alterar Secretaria - Help City</title>
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
                    <a href="<%= request.getContextPath()%>/departments"><i class="material-icons">search</i> Consultar Secretaria</a>
                </li>
                <li class="active">
                    <i class="material-icons">assignment</i> Cadastrar Secretaria
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Cadastrar Secretaria</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <form id="formCadastro" name="formCadastro" action="<%= request.getContextPath()%>/editdepartament" method="POST">
                                    <input type="hidden" class="form-control" name="idSecretaria" id="idSecretaria" value="${secretaria.idSecretaria}">
                                    <div class="col-md-12">
                                        <b id="labelNome">Nome da Secretaria</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">work</i>
                                            </span>
                                            <div class="form-line" id="grpNome">
                                                <input type="text" class="form-control" name="nomeSecretaria" id="nomeSecretaria" placeholder="Ex: Pedro Jorge" value="${secretaria.nomeSecretaria}">
                                            </div>
                                        </div>
                                    </div>     
                                    <div class="col-md-6">
                                        <b id="labelEmail">Email da Secretaria</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">alternate_email</i>
                                            </span>
                                            <div class="form-line" id="grpEmail">
                                                <input type="email" class="form-control" name="emailSecretaria" id="emailSecretaria" placeholder="Ex: pedro.jorge@dominio.com" value="${secretaria.emailSecretaria}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <b id="labelTelefone">Telefone da Secretaria</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">phone</i>
                                            </span>
                                            <div class="form-line" id="grpTelefone">
                                                <input type="text" class="form-control" name="telefoneSecretaria" id="telefoneSecretaria" maxlength="14" onkeydown="javascript: fMasc(this, mTel);" placeholder="Ex: (xx)xxxxx-xxxx" value="${secretaria.telefoneSecretaria}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">                                            
                                        <button type="button" onclick="validarFormularioSec();" name="btnEnviar" class="btn btn-block bg-green waves-effect">Enviar</button>
                                    </div>
                                    <div class="col-md-6">                                            

                                        <a href="<%= request.getContextPath()%>/departments"><button type="button" name="btnCancelar" class="btn btn-block bg-red waves-effect">Cancelar</button></a>
                                    </div>
                                </form>    
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</section>
<%@include file="../footer.jsp" %>
<script src="<%= request.getContextPath()%>/js/validar.js"></script>
<script src="<%= request.getContextPath()%>/js/validar-sec.js"></script>
</body>
</html>
