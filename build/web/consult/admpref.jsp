<%  if (request.getSession().getAttribute("idUsuario") == null || !(request.getSession().getAttribute("tipoUsuario").toString().equals("A") || (request.getSession().getAttribute("tipoUsuario").toString().equals("B") && request.getSession().getAttribute("statusCidade").equals("A"))) || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../header.jsp" %>
    </head>
</section>
<section class="content">
    <div class="container-fluid">
        <div class="block-header">
            <h2>Consultar Adm Prefeitura</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">search</i> Consultar Adm Prefeitura
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        ${mensagem}
                        <h2>
                            Tabela de Adm Prefeitura
                        </h2>
                    </div>
                    <div class="body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>CPF</th>
                                        <th>Email</th>
                                        <th>Telefone</th>
                                        <th>Data Cadastro</th>
                                        <th>Status</th>   
                                        <% if (typeUser.equalsIgnoreCase("A")) {%><th>Cidade</th><th>Estado</th><% }%>
                                        <th>Op��es</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Nome</th>
                                        <th>CPF</th>
                                        <th>Email</th>
                                        <th>Telefone</th>
                                        <th>Data Cadastro</th>
                                        <th>Status</th>   
                                        <% if (typeUser.equalsIgnoreCase("A")) {%><th>Cidade</th><th>Estado</th><% }%>
                                        <th>Op��es</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach var="admpref" items="${admprefs}">
                                        <tr>
                                            <td>${admpref.nomeUsuario}</td>
                                            <td>${admpref.cpfUsuario}</td>
                                            <td>${admpref.emailUsuario}</td>
                                            <td>${admpref.telefoneUsuario}</td>
                                            <td><fmt:formatDate value='${admpref.dataCadastroUsuario}' type='date' pattern='dd/MM/yyyy'/></td>
                                            <td>${admpref.statusUsuario == 'A' ? 'Ativo' : 'Inativo'}</td>
                                            <% if (typeUser.equalsIgnoreCase("A")) {%>
                                            <td>${admpref.cidadeAdmPref.nomeCidade}</td>
                                            <td>${admpref.cidadeAdmPref.estadoCidade.ufEstado}</td>
                                            <% }%>
                                            <td>
                                                <a onclick="sendPost('<%= request.getContextPath()%>/admpref', {idUsuario: '${admpref.idUsuario}'})">
                                                    <button type="button" title="Editar" class="btn bg-green h-green waves-effect">
                                                        <i class="material-icons">edit</i>
                                                    </button>
                                                </a>
                                                <a onclick="sendPost('<%= request.getContextPath()%>/userpass', {idUsuario: '${admpref.idUsuario}'})">
                                                    <button type="button" title="Alterar Senha" class="btn bg-orange h-orange waves-effect">
                                                        <i class="material-icons">autorenew</i>
                                                    </button>
                                                </a>
                                                ${admpref.statusUsuario == 'A' ? "<span class='js-modal-buttons'><button type='button' data-toggle='modal' data-target='#".concat(admpref.idUsuario).concat("' title='Excluir' class='btn bg-red h-red waves-effect'><i class='material-icons'>delete_forever</i></button></span>") : ''}     
                                            </td>
                                        </tr> 
                                    <div class="modal fade" id="${admpref.idUsuario}" tabindex="-1" role="dialog">
                                        <div class="modal-dialog modal-lg bg-red" role="document">
                                            <div class="modal-content bg-red">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="largeModalLabel">Excluir Usu�rio</h4>
                                                </div>
                                                <div class="modal-body bg-white">
                                                    Tem certeza que deseja excluir esse usu�rio?<br>
                                                    <strong>${admpref.nomeUsuario}</strong>
                                                </div>
                                                <div class="modal-footer bg-white">
                                                    <a onclick="sendPost('<%= request.getContextPath()%>/userstatus', {idUsuario: '${admpref.idUsuario}', tipoUsuarioAlter: '${admpref.tipoUsuario}'})">
                                                        <button type="button" class="btn btn-link waves-effect">SIM</button>
                                                    </a>
                                                    <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">N�O</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>    
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="../footer.jsp" %>
<script src="<%= request.getContextPath()%>/js/modals.js"></script>
</body>
</html>
