<%  if (request.getSession().getAttribute("idUsuario") == null || !((request.getSession().getAttribute("tipoUsuario").toString().equals("B") || request.getSession().getAttribute("tipoUsuario").toString().equals("C")) && request.getSession().getAttribute("statusCidade").equals("A")) || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <h2>Ocorrências Pendentes</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">notification_important</i> Ocorrências Pendentes
                </li>
            </ol>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        ${mensagem}
                        <h2>
                            Tabela de Ocorrências Pendentes
                        </h2>
                    </div>
                    <div class="body">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                <thead>
                                    <tr>
                                        <th>Criador</th>
                                        <% if (typeUser.equalsIgnoreCase("C")) {%><th>Categoria</th><% }%>
                                        <th>Título da Ocorrência</th>
                                        <th>Data de criação</th>
                                        <th>Status</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Criador</th>
                                        <% if (typeUser.equalsIgnoreCase("C")) {%><th>Categoria</th><% }%>
                                        <th>Título da Ocorrência</th>
                                        <th>Data de criação</th>
                                        <th>Status</th>
                                        <th>Opções</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach var="ocorrencia" items="${ocorrencias}">
                                    <td>${ocorrencia.usuarioOcorrencia.nomeUsuario}</td>
                                    <% if (typeUser.equalsIgnoreCase("C")) {%>
                                    <td>${ocorrencia.categoriaOcorrencia.nomeCategoria}</td>
                                    <% }%>
                                    <td>${ocorrencia.tituloOcorrencia}</td>
                                    <td><fmt:formatDate value='${ocorrencia.dataCriacaoOcorrencia}' type='date' pattern='dd/MM/yyyy'/></td>
                                    <td>${ocorrencia.statusOcorrencia}</td>            
                                    <td>
                                        <a onclick="sendPost('<%= request.getContextPath()%>/occurrence', {idOcorrencia: '${ocorrencia.idOcorrencia}'})">
                                            <button type="button" title="Editar" class="btn bg-green h-green waves-effect">
                                                <i class="material-icons">edit</i>
                                            </button>
                                        </a>
                                        ${ocorrencia.statusOcorrencia == 'Cancelada' ? '' : "<span class='js-modal-buttons'><button type='button' data-toggle='modal' data-target='#".concat(ocorrencia.idOcorrencia).concat("' title='Cancelar' class='btn bg-red h-red waves-effect'><i class='material-icons'>delete_forever</i></button></span>")}
                                    </td>
                                    </tr> 
                                    <div class="modal fade" id="${ocorrencia.idOcorrencia}" tabindex="-1" role="dialog">
                                        <div class="modal-dialog modal-lg bg-red" role="document">
                                            <div class="modal-content bg-red">
                                                <div class="modal-header">
                                                    <h4 class="modal-title" id="largeModalLabel">Excluir Ocorrência</h4>
                                                </div>
                                                <div class="modal-body bg-white">
                                                    Tem certeza que deseja cancelar essa ocorrência?<br>
                                                    <strong>${ocorrencia.tituloOcorrencia}</strong>
                                                </div>
                                                <div class="modal-footer bg-white">
                                                    <a onclick="sendPost('<%= request.getContextPath()%>/occurrencestatus', {idOcorrencia: '${ocorrencia.idOcorrencia}'})">
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
<script src="<%= request.getContextPath()%>/js/mapa.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBWvEwkfRQ9HgYJL0IlKxWFzN2_4iDZ8TY"></script>
</body>
</html>
