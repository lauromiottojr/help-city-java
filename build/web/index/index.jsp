<%  if (request.getSession().getAttribute("idUsuario") == null || !(request.getSession().getAttribute("tipoUsuario").toString().equals("A") || ((request.getSession().getAttribute("tipoUsuario").toString().equals("B") || request.getSession().getAttribute("tipoUsuario").toString().equals("C") || request.getSession().getAttribute("tipoUsuario").toString().equals("D")) && request.getSession().getAttribute("statusCidade").equals("A"))) || request.getSession().getAttribute("statusUsuario").equals("I")) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../header.jsp" %>
        <link href="<%= request.getContextPath()%>/css/morris.css" rel="stylesheet" />
    </head>
</section>
<section class="content">
    <div class="block-header">
        ${mensagem}
        <h2>Home</h2>
        <ol class="breadcrumb">
            <li class="active">
                <a href="<%= request.getContextPath()%>/dashboard"><i class="material-icons">home</i> Home</a>
            </li>
        </ol>
    </div>
    <div class="block-header">
        <h2>Dados</h2>
    </div>
    <div class="row">
        <% if (typeUser.equalsIgnoreCase("A")) {%>
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
            <div class="info-box bg-blue hover-zoom-effect hover-expand-effect">
                <div class="icon">
                    <i class="material-icons">location_city</i>
                </div>
                <div class="content">
                    <div class="text">Cidades</div>
                    <div class="number count-to" data-from="0" data-to="${somas[0]}" data-speed="1000" data-fresh-interval="20">${somas[0]}</div>
                </div>
            </div>
        </div>
        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
            <% } else if (typeUser.equalsIgnoreCase("B")) {%>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                <% }%>
                <div class="info-box bg-blue hover-zoom-effect hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">person_pin_circle</i>
                    </div>
                    <div class="content">
                        <div class="text">AdmPref</div>
                        <% if (typeUser.equalsIgnoreCase("A")) {%>
                        <div class="number count-to" data-from="0" data-to="${somas[1]}" data-speed="1000" data-fresh-interval="20">${somas[1]}</div>
                        <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                        <div class="number count-to" data-from="0" data-to="${somascidade[0]}" data-speed="1000" data-fresh-interval="20">${somascidade[0]}</div>
                        <% }%>
                    </div>
                </div>
            </div>
            <% if (typeUser.equalsIgnoreCase("A")) {%>
            <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
                <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                    <% }%>
                    <div class="info-box bg-blue hover-zoom-effect hover-expand-effect">
                        <div class="icon">
                            <i class="material-icons">person_pin_circle</i>
                        </div>
                        <div class="content">
                            <div class="text">Funcionários</div>
                            <% if (typeUser.equalsIgnoreCase("A")) {%>
                            <div class="number count-to" data-from="0" data-to="${somas[2]}" data-speed="1000" data-fresh-interval="20">${somas[2]}</div>
                            <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                            <div class="number count-to" data-from="0" data-to="${somascidade[1]}" data-speed="1000" data-fresh-interval="20">${somascidade[1]}</div>
                            <% }%>
                        </div>
                    </div>
                </div>
                <% if (typeUser.equalsIgnoreCase("A")) {%>
                <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12">
                    <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                        <% }%>
                        <div class="info-box bg-blue hover-zoom-effect hover-expand-effect">
                            <div class="icon">
                                <i class="material-icons">person_pin_circle</i>
                            </div>
                            <div class="content">
                                <div class="text">Cidadãos</div>
                                <% if (typeUser.equalsIgnoreCase("A")) {%>
                                <div class="number count-to" data-from="0" data-to="${somas[3]}" data-speed="1000" data-fresh-interval="20">${somas[3]}</div>
                                <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                                <div class="number count-to" data-from="0" data-to="${somascidade[2]}" data-speed="1000" data-fresh-interval="20">${somascidade[2]}</div>
                                <% }%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="info-box bg-purple hover-zoom-effect hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">map</i>
                    </div>
                    <div class="content">
                        <div class="text">Ocorrências</div>
                        <% if (typeUser.equalsIgnoreCase("A")) {%>
                        <div class="number count-to" data-from="0" data-to="${somas[4]}" data-speed="1000" data-fresh-interval="20">${somas[4]}</div>
                        <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                        <div class="number count-to" data-from="0" data-to="${somascidade[3]}" data-speed="1000" data-fresh-interval="20">${somascidade[3]}</div>
                        <% }%>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-amber hover-zoom-effect hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">fiber_new</i>
                    </div>
                    <div class="content">
                        <div class="text">Novas</div>
                        <% if (typeUser.equalsIgnoreCase("A")) {%>
                        <div class="number count-to" data-from="0" data-to="${somas[5]}" data-speed="1000" data-fresh-interval="20">${somas[5]}</div>
                        <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                        <div class="number count-to" data-from="0" data-to="${somascidade[4]}" data-speed="1000" data-fresh-interval="20">${somascidade[4]}</div>
                        <% }%>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-orange hover-zoom-effect hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">send</i>
                    </div>
                    <div class="content">
                        <div class="text">Encaminhadas</div>
                        <% if (typeUser.equalsIgnoreCase("A")) {%>
                        <div class="number count-to" data-from="0" data-to="${somas[6]}" data-speed="1000" data-fresh-interval="20">${somas[6]}</div>
                        <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                        <div class="number count-to" data-from="0" data-to="${somascidade[5]}" data-speed="1000" data-fresh-interval="20">${somascidade[5]}</div>
                        <% }%>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-green hover-zoom-effect hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">check_circle</i>
                    </div>
                    <div class="content">
                        <div class="text">Finalizadas</div>
                        <% if (typeUser.equalsIgnoreCase("A")) {%>
                        <div class="number count-to" data-from="0" data-to="${somas[7]}" data-speed="1000" data-fresh-interval="20">${somas[7]}</div>
                        <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                        <div class="number count-to" data-from="0" data-to="${somascidade[6]}" data-speed="1000" data-fresh-interval="20">${somascidade[6]}</div>
                        <% }%>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="info-box bg-red hover-zoom-effect hover-expand-effect">
                    <div class="icon">
                        <i class="material-icons">block</i>
                    </div>
                    <div class="content">
                        <div class="text">Canceladas</div>
                        <% if (typeUser.equalsIgnoreCase("A")) {%>
                        <div class="number count-to" data-from="0" data-to="${somas[8]}" data-speed="1000" data-fresh-interval="20">${somas[8]}</div>
                        <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                        <div class="number count-to" data-from="0" data-to="${somascidade[7]}" data-speed="1000" data-fresh-interval="20">${somascidade[7]}</div>
                        <% }%>
                    </div>
                </div>
            </div>
        </div>
        <% if (typeUser.equalsIgnoreCase("B")) {%>
        <button class="btn bg-cyan waves-effect m-b-15 col-lg-12 col-md-12 col-sm-12 col-xs-12" type="button" data-toggle="collapse" data-target=".collapseOcr" aria-expanded="false" aria-controls="collapseExample" id="btnOcorrencias" value="<%= request.getSession().getAttribute("idCidade")%>">
            Ocorrências
        </button>
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 collapse collapseOcr">
                <div class="card">
                    <div class="header">
                        <h2>Ocorrências/Categorias</h2>
                    </div>
                    <div class="body">
                        <div id="donutCategoria" class="graph"></div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 collapse collapseOcr">
                <div class="card">
                    <div class="header">
                        <h2>Ocorrências/Secretarias</h2>
                    </div>
                    <div class="body">
                        <div id="donutSecretaria" class="graph"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>
                            Ocorrência por data
                        </h2>
                    </div>
                    <div class="body">
                        <div class="row clearfix">    
                            <div class="col-md-3">
                                <b id="grpStart">Data inicial</b> - <button class="btn btn-black" onclick="currentDate('inicial');">Data atual</button>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="material-icons">date_range</i>
                                    </span>
                                    <div class="form-line">
                                        <input type="text" class="form-control" name="startDate" id="startDate" maxlength="10" onkeydown="javascript: fMasc(this, mData);" placeholder="DD/MM/AAAA">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <b id="grpEnd">Data final</b> - <button class="btn btn-black" onclick="currentDate('final');">Data atual</button>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="material-icons">date_range</i>
                                    </span>
                                    <div class="form-line">
                                        <input type="text" class="form-control" name="endDate" id="endDate" maxlength="10" onkeydown="javascript: fMasc(this, mData);" placeholder="DD/MM/AAAA">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 mtop">
                                <b>Status</b>
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="material-icons">done_all</i>
                                    </span>                                            
                                    <select class="form-control show-tick" data-live-search="true" name="statusOcorrendiaData" id="statusOcorrendiaData">
                                        <option value="Todas" selected>Todas</option>
                                        <option value="Nova">Novas</option>
                                        <option value="Encaminhada">Encaminhadas</option>
                                        <option value="Finalizada">Finalizadas</option>
                                        <option value="Cancelada">Canceladas</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <button class="btn bg-green waves-effect m-b-15 col-lg-12 col-md-12 col-sm-12 col-xs-12" type="button" data-toggle="collapse" data-target="#rowChartDate" aria-expanded="false" aria-controls="collapseExample" id="btnData">
                                    <i class="material-icons">search</i>
                                    <span>Pesquisar</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row collapse" id="rowChartDate">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Ocorrências/Período</h2>
                    </div>
                    <div class="body">
                        <div id="line_chart" class="graph"></div>
                    </div>
                </div>
            </div>
        </div>
        <% }%>
        <% if (typeUser.equalsIgnoreCase("A")) {%>
        <button class="btn bg-cyan waves-effect m-b-15 col-lg-12 col-md-12 col-sm-12 col-xs-12" type="button" data-toggle="collapse" data-target="#ageChart" aria-expanded="false" aria-controls="collapseExample" id="btnIdade">
            Faixa etária de usuários
        </button>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse" id="ageChart">
            <div class="card">
                <div class="header">
                    <h2>Usuários</h2>
                </div>
                <div class="body">
                    <div id="donutIdade" class="graph"></div>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>Filtrar Dados Gerais por Cidade</h2>
                    </div>
                    <div class="body">
                        <div class="demo-masked-input">
                            <div class="row clearfix">
                                <div class="col-md-12">
                                    <b>Cidades</b>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="material-icons">location_city</i>
                                        </span>
                                        <select class="form-control show-tick" data-live-search="true" name="dadosCidade" id="dadosCidade">                                                
                                            <option value="0">Selecione uma cidade</option>
                                            <c:forEach var="cidade" items="${cidades}">
                                                <option value="${cidade.idCidade}">${cidade.nomeCidade} - ${cidade.estadoCidade.nomeEstado}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div> 
                                <div class="hidden" id="valores">
                                    <div class="row">
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                            <div class="info-box bg-blue hover-zoom-effect hover-expand-effect">
                                                <div class="icon">
                                                    <i class="material-icons">person_pin_circle</i>
                                                </div>
                                                <div class="content">
                                                    <div class="text">Adm Prefeitura</div>
                                                    <div class="number count-to" data-from="0" id="adm" data-speed="1000" data-fresh-interval="20"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                            <div class="info-box bg-blue hover-zoom-effect hover-expand-effect">
                                                <div class="icon">
                                                    <i class="material-icons">person_pin_circle</i>
                                                </div>
                                                <div class="content">
                                                    <div class="text">Funcionários</div>
                                                    <div class="number count-to" data-from="0" id="fun" data-speed="1000" data-fresh-interval="20"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                            <div class="info-box bg-blue hover-zoom-effect hover-expand-effect">
                                                <div class="icon">
                                                    <i class="material-icons">person_pin_circle</i>
                                                </div>
                                                <div class="content">
                                                    <div class="text">Cidadãos</div>
                                                    <div class="number count-to" data-from="0" id="cid" data-speed="1000" data-fresh-interval="20"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="info-box bg-purple hover-zoom-effect hover-expand-effect">
                                                <div class="icon">
                                                    <i class="material-icons">map</i>
                                                </div>
                                                <div class="content">
                                                    <div class="text">Ocorrências</div>
                                                    <div class="number count-to" data-from="0" id="oco" data-speed="1000" data-fresh-interval="20"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                            <div class="info-box bg-amber hover-zoom-effect hover-expand-effect">
                                                <div class="icon">
                                                    <i class="material-icons">fiber_new</i>
                                                </div>
                                                <div class="content">
                                                    <div class="text">Novas</div>
                                                    <div class="number count-to" data-from="0" id="nov" data-speed="1000" data-fresh-interval="20"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                            <div class="info-box bg-orange hover-zoom-effect hover-expand-effect">
                                                <div class="icon">
                                                    <i class="material-icons">send</i>
                                                </div>
                                                <div class="content">
                                                    <div class="text">Encaminhadas</div>
                                                    <div class="number count-to" data-from="0" id="enc" data-speed="1000" data-fresh-interval="20"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                            <div class="info-box bg-green hover-zoom-effect hover-expand-effect">
                                                <div class="icon">
                                                    <i class="material-icons">check_circle</i>
                                                </div>
                                                <div class="content">
                                                    <div class="text">Finalizadas</div>
                                                    <div class="number count-to" data-from="0" id="fin" data-speed="1000" data-fresh-interval="20"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                            <div class="info-box bg-red hover-zoom-effect hover-expand-effect">
                                                <div class="icon">
                                                    <i class="material-icons">block</i>
                                                </div>
                                                <div class="content">
                                                    <div class="text">Canceladas</div>
                                                    <div class="number count-to" data-from="0" id="can" data-speed="1000" data-fresh-interval="20"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% }%>
    </div>
</section>
<%@include file="../footer.jsp" %>
<script src="<%= request.getContextPath()%>/js/chartjs/raphael.min.js"></script>
<script src="<%= request.getContextPath()%>/js/chartjs/morris.min.js"></script>
<script src="<%= request.getContextPath()%>/js/validate-data.js"></script>
</body>
</html>
