<% if (request.getSession().getAttribute("idUsuario") == null || !request.getSession().getAttribute("tipoUsuario").equals("A") || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alterar Usuário - Help City</title>
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
                    <a href="<%= request.getContextPath()%>/adms"><i class="material-icons">search</i> Consultar Adm</a>
                </li>
                <li class="active">
                    <i class="material-icons">edit</i> Alterar adm
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Alterar adm</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <form id="formCadastro" name="formCadastro" action="<%= request.getContextPath()%>/editadm" method="POST">
                                    <input type="hidden" class="form-control" name="idAdm" id="idAdm" value="${adm.idAdm}">
                                    <input type="hidden" class="form-control" name="idUsuario" id="idUsuario" value="${adm.idUsuario}">
                                    <div class="col-md-12">
                                        <b id="labelNome">Nome</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">person</i>
                                            </span>
                                            <div class="form-line" id="grpNome">
                                                <input type="text" class="form-control" name="nomeUsuario" id="nomeUsuario" placeholder="Ex: Pedro Jorge" value="${adm.nomeUsuario}">
                                            </div>
                                        </div>
                                    </div>  
                                    <div class="col-md-6">
                                        <b id="labelEmail">Email</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">alternate_email</i>
                                            </span>
                                            <div class="form-line" id="grpEmail">
                                                <input type="email" class="form-control" name="emailUsuario" id="emailUsuario" placeholder="Ex: pedro.jorge@dominio.com" value="${adm.emailUsuario}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <b id="labelDataNascimento">Data de Nascimento</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">date_range</i>
                                            </span>
                                            <div class="form-line" id="grpDataNascimento">
                                                <input type="text" class="form-control" name="dataNascimentoUsuario" id="dataNascimentoUsuario" maxlength="10" onkeydown="javascript: fMasc(this, mData);" placeholder="DD/MM/AAAA" value="<fmt:formatDate value='${adm.dataNascimentoUsuario}' type='date' pattern='dd/MM/yyyy'/> "/>
                                            </div>
                                        </div>
                                    </div>                                            
                                    <div class="col-md-6">
                                        <b id="labelRg">RG</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">fingerprint</i>
                                            </span>
                                            <div class="form-line" id="grpRg">
                                                <input type="text" class="form-control" name="rgUsuario" id="rgUsuario" placeholder="Inserir sem pontuação" onkeydown="javascript: fMasc(this, mRg);" value="${adm.rgUsuario}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <b id="labelCpf">CPF</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">fingerprint</i>
                                            </span>
                                            <div class="form-line" id="grpCpf">
                                                <input type="text" class="form-control" name="cpfUsuario" id="cpfUsuario" maxlength="14" onkeydown="javascript: fMasc(this, mCPF);" placeholder="Ex: xxx.xxx.xxx-xx" value="${adm.cpfUsuario}">
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="col-md-4">
                                        <b id="labelTelefone">Telefone</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">phone</i>
                                            </span>
                                            <div class="form-line" id="grpTelefone">
                                                <input type="text" class="form-control" name="telefoneUsuario" id="telefoneUsuario" maxlength="14" onkeydown="javascript: fMasc(this, mTel);" placeholder="Ex: (xx)xxxxx-xxxx" value="${adm.telefoneUsuario}">
                                            </div>
                                        </div>
                                    </div>                          
                                    <div class="col-md-4">
                                        <b>Status</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">build</i>
                                            </span>
                                            <div class="demo-radio-button">
                                                <input ${adm.statusUsuario == 'A' ? "checked" : ""} name="statusUsuario" type="radio" id="A" value="A" class="radio-col-blue-grey" required=""/>
                                                <label for="A">Ativo</label>
                                                <input ${adm.statusUsuario == 'I' ? "checked" : ""} name="statusUsuario" type="radio" id="I" value="I" class="radio-col-blue-grey" required=""/>
                                                <label for="I">Inativo</label>
                                            </div>
                                        </div>
                                    </div>                         
                                    <div class="col-md-4">
                                        <b>Sexo</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">wc</i>
                                            </span>
                                            <div class="demo-radio-button">
                                                <input ${adm.sexoUsuario == 'M' ? "checked" : ""} name="sexoUsuario" type="radio" id="M" value="M" class="radio-col-blue-grey" required=""/>
                                                <label for="M">Masculino</label>
                                                <input ${adm.sexoUsuario == 'F' ? "checked" : ""} name="sexoUsuario" type="radio" id="F" value="F" class="radio-col-blue-grey" required=""/>
                                                <label for="F">Feminino</label>
                                            </div>
                                        </div>
                                    </div>     
                                    <div class="col-md-12">                                            
                                        <div class="col-md-6">                                            
                                            <button type="button" onclick="validarForm();" name="btnEnviar" class="btn btn-block bg-green h-green waves-effect">Enviar</button>
                                        </div>
                                        <div class="col-md-6">                                            
                                            <a href="adms"><button type="button" name="btnCancelar" class="btn btn-block bg-red waves-effect">Cancelar</button></a>
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
<script src="<%= request.getContextPath()%>/js/validar.js"></script>
</body>
</html>
