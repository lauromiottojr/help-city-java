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
            <h2>Consultar Cidadão</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">search</i> Consultar Cidadão
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        ${mensagem}
                        <h2>
                            Tabela de Cidadãos
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
                                        <th>Opções</th>
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
                                        <th>Opções</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach var="cidadao" items="${cidadaos}">
                                        <tr>
                                            <td>${cidadao.nomeUsuario}</td>
                                            <td>${cidadao.cpfUsuario}</td>
                                            <td>${cidadao.emailUsuario}</td>
                                            <td>${cidadao.telefoneUsuario}</td>
                                            <td><fmt:formatDate value='${cidadao.dataCadastroUsuario}' type='date' pattern='dd/MM/yyyy'/></td>
                                            <td>${cidadao.statusUsuario == 'A' ? 'Ativo' : 'Inativo'}</td>
                                            <% if (typeUser.equalsIgnoreCase("A")) {%>
                                            <td>${cidadao.cidadeCidadao.nomeCidade}</td>
                                            <td>${cidadao.cidadeCidadao.estadoCidade.ufEstado}</td>
                                            <% }%>
                                            <td>
                                                <a onclick="sendPost('<%= request.getContextPath()%>/citizen', {idUsuario: '${cidadao.idUsuario}'})">
                                                    <button type="button" title="Editar" class="btn bg-green h-green waves-effect">
                                                        <i class="material-icons">edit</i>
                                                        
                                                    </button>
                                                </a>
                                                <a onclick="sendPost('<%= request.getContextPath()%>/userpass', {idUsuario: '${cidadao.idUsuario}'})">
                                                    <button type="button" title="Alterar Senha" class="btn bg-orange h-orange waves-effect">
                                                        <i class="material-icons">autorenew</i>
                                                    </button>
                                                </a>
                                                ${cidadao.statusUsuario == 'A' ? "<span class='js-modal-buttons'><button type='button' data-toggle='modal' data-target='#".concat(cidadao.idUsuario).concat("' title='Excluir' class='btn bg-red h-red waves-effect'><i class='material-icons'>delete_forever</i></button></span>") : ''}
                                            </td>
                                        </tr> 
                                    <div class="modal fade" id="${cidadao.idUsuario}" tabindex="-1" role="dialog">
                                        <div class="modal-dialog modal-lg bg-red" role="document">
                                            <div class="modal-content bg-red">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="largeModalLabel">Excluir Usuário</h4>
                                                </div>
                                                <div class="modal-body bg-white">
                                                    Tem certeza que deseja excluir esse usuário?<br>
                                                    <strong>${cidadao.nomeUsuario}</strong>
                                                </div>
                                                <div class="modal-footer bg-white">
                                                    <a onclick="sendPost('<%= request.getContextPath()%>/userstatus', {idUsuario: '${cidadao.idUsuario}', tipoUsuarioAlter: '${cidadao.tipoUsuario}'})">
                                                        <button type="button" class="btn btn-link waves-effect">SIM</button>
                                                    </a>
                                                    <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">NÃO</button>
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