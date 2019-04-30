<% if (request.getSession().getAttribute("idUsuario") == null || !request.getSession().getAttribute("tipoUsuario").equals("D") || request.getSession().getAttribute("statusUsuario").equals("I") || request.getSession().getAttribute("statusCidade").equals("I")) {
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
            <h2>Home</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="dashboard"><i class="material-icons">home</i> Home</a>
                </li>
                <li class="active">
                    <i class="material-icons">textsms</i> Minhas Ocorrências
                </li>
            </ol>
        </div>     
        <div class="row clearfix">
            <c:forEach var="ocorrencia" items="${ocorrencias}">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        ${ocorrencia.statusOcorrencia == "Finalizada" ? '<div class="header bg-green">' : (ocorrencia.statusOcorrencia == "Cancelada" ? '<div class="header bg-red">' : '<div class="header bg-orange">')}                                             
                        <h2>
                            ${ocorrencia.tituloOcorrencia} <small><strong>Status: ${ocorrencia.statusOcorrencia}
                                    ${ocorrencia.statusOcorrencia == "Encaminhada" ? 'para <u>'.concat(ocorrencia.secretariaOcorrencia.nomeSecretaria).concat('</u>') : ''}</strong>
                        <p><strong>Cidade:</strong> ${ocorrencia.cidadeOcorrencia.nomeCidade} - ${ocorrencia.cidadeOcorrencia.estadoCidade.ufEstado}</p></small>
                        </h2>                        
                        <!--                        <ul class="header-dropdown m-r--5">
                                                    <li class="dropdown">
                                                        <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                                            <i class="material-icons">more_vert</i>
                                                        </a>
                                                        <ul class="dropdown-menu pull-right">
                                                            <li><a href="javascript:void(0);">Action</a></li>
                                                            <li><a href="javascript:void(0);">Another action</a></li>
                                                            <li><a href="javascript:void(0);">Something else here</a></li>
                                                        </ul>
                                                    </li>
                                                </ul>-->
                    </div>
                    <div class="body">  
                        <p><strong>Endereço:</strong> ${ocorrencia.localizacaoOcorrencia}</p>
                        <p><strong>Descrição:</strong> ${ocorrencia.descricaoOcorrencia}</p>
                        <p><strong>Data de Criação:</strong> <fmt:formatDate value='${ocorrencia.dataCriacaoOcorrencia}' type='date' pattern='dd/MM/yyyy'/></p>                    
                        <div class="row">
                            <c:forEach var="imagem" items="${imagens}">   
                                ${imagem.ocorrenciaImagem.idOcorrencia == ocorrencia.idOcorrencia ? "<div class='col-lg-3 col-md-4 col-sm-6 col-xs-12' data-toggle='modal' data-target='#".concat(imagem.idImagem).concat("'><img class='img-responsive thumbnail' src='").concat(pageContext.request.contextPath).concat("/").concat(imagem.nomeImagem).concat("'></div>") : ""}         
                                <div class="modal fade" id="${imagem.idImagem}" tabindex="-1" role="dialog">
                                    <div class="modal-dialog modal-lg" role="document">
                                        <div class="modal-content">
                                            <div class="modal-body">
                                                <img class="img-modal" src="<%= request.getContextPath()%>/${imagem.nomeImagem}" alt="Imagem carregada pelo usuário">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">Fechar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<%@include file="../footer.jsp" %>
<script src="<%= request.getContextPath()%>/js/modals.js"></script>
</body>
</html>
