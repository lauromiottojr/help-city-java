<% if (request.getSession().getAttribute("idUsuario") == null || !request.getSession().getAttribute("tipoUsuario").equals("A") || request.getSession().getAttribute("statusUsuario").equals("I")) {
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
            <h2>Consultar Cidade</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">search</i> Consultar Cidade
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        ${mensagem}
                        <h2>
                            Tabela de Cidades 
                        </h2>
                    </div>
                    <div class="body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                <thead>
                                    <tr>
                                        <th>Cidade</th>
                                        <th>Status</th>
                                        <th>Estado</th>
                                        <th>Data Cadastro</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Cidade</th>
                                        <th>Status</th>
                                        <th>Estado</th>
                                        <th>Data Cadastro</th>
                                        <th>Opções</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach var="cidade" items="${cidades}">                                                
                                    <tr>
                                        <td>${cidade.nomeCidade}</td>
                                        <td>${cidade.statusCidade == 'A' ? 'Ativo' : 'Inativo'}</td>
                                        <td>${cidade.estadoCidade.nomeEstado}</td>
                                        <td><fmt:formatDate value='${cidade.dataCadastroCidade}' type='date' pattern='dd/MM/yyyy'/></td>
                                    <td>
                                        <a onclick="sendPost('<%= request.getContextPath()%>/city', {idCidade: '${cidade.idCidade}'})">
                                            <button type="button" title="Editar" class="btn bg-green h-green waves-effect">
                                                <i class="material-icons">edit</i>
                                            </button>
                                        </a>                                                
                                        ${cidade.statusCidade == 'A' ? "<span class='js-modal-buttons'><button type='button' data-toggle='modal' data-target='#".concat(cidade.idCidade).concat("' title='Excluir' class='btn bg-red h-red waves-effect'><i class='material-icons'>delete_forever</i></button></span>") : ''}
                                    </td>
                                    </tr>
                                    <div class="modal fade" id="${cidade.idCidade}" tabindex="-1" role="dialog">
                                        <div class="modal-dialog modal-lg bg-red" role="document">
                                            <div class="modal-content bg-red">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="largeModalLabel">Excluir Cidade</h4>
                                                </div>
                                                <div class="modal-body bg-white">
                                                    Tem certeza que deseja excluir essa cidade?<br>
                                                    <strong>${cidade.nomeCidade} - ${cidade.estadoCidade.nomeEstado}</strong>
                                                </div>
                                                <div class="modal-footer bg-white">
                                                    <a onclick="sendPost('<%= request.getContextPath()%>/citystatus', {idCidade: '${cidade.idCidade}'})">
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
