<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Help City</title>
        <%@include file="header-site.jsp" %>
    </head>
    <body>
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar topbar">
            <div class="container">
                <a class="navbar-brand" href="#" target="_blank">
                    <strong>Help City</strong>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">
                                <i class="fa fa-chevron-left"></i> Voltar</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav nav-flex-icons">
                        <li class="nav-item">
                            <a href="createuser" class="nav-link border border-info rounded btn-index">Cadastrar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link border border-info rounded btn-index" data-toggle="modal" data-target="#myModal" target="_blank">Entrar</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div style="background-image: url('img/cidade.jpg'); background-repeat: no-repeat; background-size: cover;">
            <div class="container">
                <div class="row justify-content-md-center">
                    <div class="col-md-12 col-lg-12">
                        <div class="card mgtop">
                            <br><br>
                            <div class="card-body">
                                <div class="container">
                                    <h2 class="text-center">Cadastre-se</h2><br/>
                                    <form id="formCadastro" name="formCadastro" action="<%= request.getContextPath()%>/newuser" method="POST">
                                        <input type="hidden" class="form-control" name="tipoUsuario" id="tipoUsuario">
                                        <div class="row">
                                            <div class="md-form col-lg-6 col-md-6 col-sm-12">
                                                <i class="fa fa-user prefix grey-text" id="grpNome"></i>
                                                <input type="text" id="nomeUsuario" name="nomeUsuario" class="form-control">
                                                <label for="nomeUsuario" id="labelNome">Nome</label>
                                            </div>
                                            <div class="md-form col-lg-6 col-md-6 col-sm-12">
                                                <i class="fa fa-envelope prefix grey-text" id="grpEmail"></i>
                                                <input type="text" id="emailUsuario" name="emailUsuario" class="form-control">
                                                <label for="emailUsuario" id="labelEmail">Email</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="md-form col-lg-6 col-md-6 col-sm-12">
                                                <i class="fa fa-address-card prefix grey-text" id="grpRg"></i>
                                                <input type="text" class="form-control" name="rgUsuario" id="rgUsuario" onkeydown="javascript: fMasc(this, mRg);">
                                                <label for="rgUsuario" id="labelRg">RG</label>
                                            </div>
                                            <div class="md-form col-lg-6 col-md-6 col-sm-12">
                                                <i class="fa fa-id-card-o prefix grey-text" id="grpCpf"></i>
                                                <input type="text" class="form-control" name="cpfUsuario" id="cpfUsuario" maxlength="14" onkeydown="javascript: fMasc(this, mCPF);">
                                                <label for="cpfUsuario" id="labelCpf">CPF</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="md-form col-lg-3 col-md-6 col-sm-12">
                                                <i class="fa fa-phone prefix grey-text" id="grpTelefone"></i>
                                                <input type="text" class="form-control" name="telefoneUsuario" id="telefoneUsuario" maxlength="14" onkeydown="javascript: fMasc(this, mTel);">
                                                <label for="telefoneUsuario" id="labelTelefone">Telefone</label>
                                            </div>
                                            <div class="md-form col-lg-3 col-md-6 col-sm-12">
                                                <i class="fa fa-calendar prefix grey-text" id="grpDataNascimento"></i>
                                                <input type="text" class="form-control" name="dataNascimentoUsuario" id="dataNascimentoUsuario" maxlength="10" onkeydown="javascript: fMasc(this, mData);">
                                                <label for="dataNascimentoUsuario" id="labelDataNascimento">Nascimento</label>
                                            </div>
                                            <div class="md-form col-lg-6 col-md-6 col-sm-12">
                                                <i class="fa fa-venus-mars grey-text"></i>
                                                <div class="custom-control custom-radio custom-control-inline col-lg-2 col-md-2 col-sm-12">
                                                    <label for="sexo">Sexo:</label>
                                                </div>
                                                <div class="custom-control custom-radio custom-control-inline col-lg-4 col-md-4 col-sm-12">
                                                    <input type="radio" class="custom-control-input" id="M" name="sexoUsuario" value="M" checked="">
                                                    <label class="custom-control-label" for="M">Masculino</label>
                                                </div>
                                                <div class="custom-control custom-radio custom-control-inline col-lg-4 col-md-4 col-sm-12">
                                                    <input type="radio" class="custom-control-input" id="F" name="sexoUsuario" value="F">
                                                    <label class="custom-control-label" for="F">Feminino</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6 col-sm-12 mb-4">
                                                <i class="fa fa-globe prefix grey-text"></i>
                                                <label for="estadoUsuario"> Estado:</label>
                                                <select class="custom-select d-block w-100" name="estadoUsuario" id="estadoUsuario">
                                                    <option value="">Selecione um estado</option>
                                                    <c:forEach var="estado" items="${estados}">
                                                        <option value="${estado.ufEstado}">${estado.nomeEstado}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-lg-6 col-md-6 col-sm-12 mb-4">
                                                <i class="fa fa-map-marker prefix grey-text" id="grpCidade"></i>
                                                <label for="cidadeUsuario" id="labelCidade"> Cidade:</label>
                                                <select class="custom-select d-block w-100" name="cidadeUsuario" id="cidadeUsuario">
                                                    <option value="">Selecione primeiramente o estado</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="md-form col-lg-4 col-md-4 col-sm-12">
                                                <i class="fa fa-user prefix grey-text" id="grpLogin"></i>
                                                <input type="text" class="form-control" name="loginUsuario" id="loginUsuario" onkeydown="javascript: fMasc(this, mRg);">
                                                <label for="loginUsuario" id="labelLogin">Login</label>
                                            </div>
                                            <div class="md-form col-lg-4 col-md-4 col-sm-12">
                                                <i class="fa fa-asterisk prefix grey-text" id="grpSenha"></i>
                                                <input type="password" class="form-control" name="senhaUsuario" id="senhaUsuario" onkeydown="javascript: fMasc(this, mRg);">
                                                <label for="senhaUsuario" id="labelSenha">Senha</label>
                                            </div>
                                            <div class="md-form col-lg-4 col-md-4 col-sm-12">
                                                <i class="fa fa-asterisk prefix grey-text" id="grpCSenha"></i>
                                                <input type="password" class="form-control" name="senhaCUsuario" id="senhaCUsuario" onkeydown="javascript: fMasc(this, mRg);">
                                                <label for="senhaCUsuario" id="labelCSenha">Confirmar Senha</label>
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <button type="button" onclick="validarCid();" name="btnEnviar" class="btn btn-block btn-success waves-effect">Cadastrar</button>
                                            </div>
                                            <div class="col-md-6">
                                                <button type="reset" name="btnLimpar" class="btn btn-block btn-danger bg-red waves-effect">Limpar</button>
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
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 mx-auto">
                                <div class="modal-header">
                                    <h4 class="modal-title">Login</h4>
                                    <button type="button" class="close" data-dismiss="modal">×</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 mx-auto">
                                <div class="modal-body">
                                    <div class="container">
                                        <form name="logar" action="login" method="POST">
                                            <input name="acao" id="acao" type="hidden" value="logar"> 
                                            <div class="md-form">
                                                <i class="fa fa-user prefix grey-text"></i>
                                                <input name="loginUsuario" id="loginUsuario" type="text" placeholder="Digite seu usuário" class="form-control"> 
                                                <label for="loginUsuario">Usuário</label>
                                            </div>
                                            <div class="md-form">
                                                <i class="fa fa-asterisk prefix grey-text"></i>
                                                <input name="senhaUsuario" id="senhaUsuario" type="password" placeholder="Digite sua senha" class="form-control"> 
                                                <label for="senhaUsuario">Senha</label>
                                            </div>
                                        </form>                                    
                                        <div class="modal-footer">
                                            <a href="javascript:logar.submit()">
                                                <button type="button" class="btn btn-success">Login</button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer-site.jsp" %>        
        <script type="text/javascript">
            function validarCid() {
                var VCidade = FCidade();
                FNomeC();
                FEmailC();
                FDataNascimentoC();
                FRgC();
                FCpfC();
                FTelC();
                FLoginC();
                FSenhaC();
                FCSenhaC();
                if (VCidade) {
                    validarFormularioCad();
                }
            }
            document.getElementById("cidadeUsuario").addEventListener("blur", FCidade);
            function FCidade() {
                if (document.getElementById("cidadeUsuario").value.length === 0) {
                    document.getElementById("labelCidade").classList.add("red-ic");
                    document.getElementById("grpCidade").classList.add("red-ic");
                    document.getElementById("labelCidade").innerHTML = "Cidade - Selecione uma cidade!";
                    return false;
                } else {
                    document.getElementById("labelCidade").classList.add("green-ic");
                    document.getElementById("grpCidade").classList.add("green-ic");
                    document.getElementById("labelCidade").classList.remove("red-ic");
                    document.getElementById("grpCidade").classList.remove("red-ic");
                    document.getElementById("labelCidade").innerHTML = "Cidade";
                    return true;
                }
            }
        </script>
    </body>
</html>