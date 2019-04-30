<%  if (request.getSession().getAttribute("idUsuario") == null || !(request.getSession().getAttribute("tipoUsuario").toString().equals("A") || (request.getSession().getAttribute("tipoUsuario").toString().equals("B") && request.getSession().getAttribute("statusCidade").equals("A"))) || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <% if (typeUser.equalsIgnoreCase("A")) {%>
                <li>
                    <a href="dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <% } else {%>
                <li>
                    <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <% }%>
                <li class="active">
                    <i class="material-icons">assignment</i> Cadastrar Adm Prefeitura
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Cadastrar Adm Prefeitura</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <form id="formCadastro" name="formCadastro" action="<%= request.getContextPath()%>/newadmpref" method="POST">
                                    <div class="col-md-12">
                                        <b id="labelNome">Nome</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">person</i>
                                            </span>
                                            <div class="form-line" id="grpNome">
                                                <input type="text" class="form-control" name="nomeUsuario" id="nomeUsuario" placeholder="Ex: Pedro Jorge">
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
                                                <input type="email" class="form-control" name="emailUsuario" id="emailUsuario" placeholder="Ex: pedro.jorge@dominio.com">
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
                                                <input type="text" class="form-control" name="dataNascimentoUsuario" id="dataNascimentoUsuario" maxlength="10" onkeydown="javascript: fMasc(this, mData);" placeholder="DD/MM/AAAA">
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
                                                <input type="text" class="form-control" name="rgUsuario" id="rgUsuario" placeholder="Inserir sem pontuação" onkeydown="javascript: fMasc(this, mRg);">
                                            </div>
                                        </div>
                                    </div><div class="col-md-6">
                                        <b id="labelCpf">CPF</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">fingerprint</i>
                                            </span>
                                            <div class="form-line" id="grpCpf">
                                                <input type="text" class="form-control" name="cpfUsuario" id="cpfUsuario" maxlength="14" onkeydown="javascript: fMasc(this, mCPF);" placeholder="Ex: xxx.xxx.xxx-xx">
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="col-md-6">
                                        <b id="labelTelefone">Telefone</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">phone</i>
                                            </span>
                                            <div class="form-line" id="grpTelefone">
                                                <input type="text" class="form-control" name="telefoneUsuario" id="telefoneUsuario" maxlength="14" onkeydown="javascript: fMasc(this, mTel);" placeholder="Ex: (xx)xxxxx-xxxx">
                                            </div>
                                        </div>
                                    </div>                          
                                    <div class="col-md-6">
                                        <b>Sexo</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">wc</i>
                                            </span>
                                            <div class="demo-radio-button">
                                                <input name="sexoUsuario" type="radio" id="M" value="M" class="radio-col-blue-grey" required="" checked=""/>
                                                <label for="M">Masculino</label>
                                                <input name="sexoUsuario" type="radio" id="F" value="F" class="radio-col-blue-grey" required=""/>
                                                <label for="F">Feminino</label>
                                            </div>
                                        </div>
                                    </div> 
                                    <% if (typeUser.equalsIgnoreCase("A")) { %>
                                    <div class="col-md-12">
                                        <b>Estados</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">explicit</i>
                                            </span>
                                            <select class="form-control show-tick" data-live-search="true" name="estadoUsuario" id="estadoUsuario">                                                
                                                <option value="">Selecione um estado</option>
                                                <c:forEach var="estado" items="${estados}">
                                                    <option value="${estado.ufEstado}">${estado.nomeEstado}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <b id="labelCidade">Cidade</b>
                                        <div class="input-group" id="cidade">
                                            <span class="input-group-addon">
                                                <i class="material-icons">location_city </i>
                                            </span>
                                            <select class="form-control show-tick" data-live-search="true" name="cidadeUsuario" id="cidadeUsuario">
                                                <option value="">Selecione primeiramente o estado</option>
                                            </select>
                                        </div>
                                    </div>
                                    <% }%>
                                    <div class="col-md-12">
                                        <b id="labelLogin">Login</b>
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">people</i>
                                            </span>
                                            <div class="form-line" id="grpLogin">
                                                <input type="text" class="form-control" name="loginUsuario" id="loginUsuario">
                                            </div>
                                        </div>
                                    </div>                                             
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
                                        <button type="button" onclick="<% if (typeUser.equalsIgnoreCase("A")) {%> validarCid(); <% } else {%>  validarFormulario();<% }%>" name="btnEnviar" class="btn btn-block bg-green waves-effect">Enviar</button>
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
<script src="<%= request.getContextPath()%>/js/validar.js"></script>
<% if (typeUser.equalsIgnoreCase("A")) {%>
<script src="<%= request.getContextPath()%>/js/gson-cidade.js" type="text/javascript"></script>
<script type="text/javascript">
                                                    function validarCid() {
                                                        var VCidade = FCidade();
                                                        FNome();
                                                        FEmail();
                                                        FDataNascimento();
                                                        FRg();
                                                        FCpf();
                                                        FTel();
                                                        FLogin();
                                                        FSenha();
                                                        FCSenha();
                                                        if (VCidade) {
                                                            validarFormulario();
                                                        }
                                                    }
                                                    document.getElementById("cidadeUsuario").addEventListener("blur", FCidade);
                                                    function FCidade() {
                                                        if (document.getElementById("cidadeUsuario").value.length === 0) {
                                                            document.getElementById("labelCidade").classList.add("text-danger");
                                                            document.getElementById("labelCidade").innerHTML = "Cidade - Selecione uma cidade!";
                                                            return false;
                                                        } else {
                                                            document.getElementById("labelCidade").classList.add("text-success");
                                                            document.getElementById("labelCidade").classList.remove("text-danger");
                                                            document.getElementById("labelCidade").innerHTML = "Cidade";
                                                            return true;
                                                        }
                                                    }
</script>
<% }%>
</body>
</html>
