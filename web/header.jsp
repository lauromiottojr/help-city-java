<%
    String path = request.getServletPath().toLowerCase();
    String menu = "";
    String menu_sub = "";
    String title = "";
    String typeUser = request.getSession().getAttribute("tipoUsuario").toString();

    if (path.contains("edit")) {
        if (path.contains("/edit/perfil_usuario.jsp") || path.contains("/edit/senha.jsp")) {
            menu = "per";
        } else {
            menu = "edi";
        }
    } else if (path.contains("new")) {
        menu = "new";
    } else if (path.contains("consult")) {
        menu = "con";
    } else if (path.contains("index")) {
        menu = "ind";
    } else if (path.contains("criar")) {
        menu = "cri";
    } else if (path.contains("encaminhar")) {
        menu = "enc";
    } else if (path.contains("historico")) {
        menu = "his";
    } else if (path.contains("pendentes")) {
        menu = "pen";
    } else if (path.contains("minhas")) {
        menu = "min";
    }

    if (path.equalsIgnoreCase("/consult/adm.jsp")) {
        menu_sub = "con_adm";
    } else if (path.contains("consult/admpref")) {
        menu_sub = "con_admpref";
    } else if (path.contains("consult/funcionario")) {
        menu_sub = "con_func";
    } else if (path.contains("consult/cidadao")) {
        menu_sub = "con_cidadao";
    } else if (path.contains("consult/secretaria")) {
        menu_sub = "con_sec";
    } else if (path.contains("consult/categoria")) {
        menu_sub = "con_cat";
    } else if (path.contains("consult/cidade")) {
        menu_sub = "con_cid";
    } else if (path.equalsIgnoreCase("/new/adm.jsp")) {
        menu_sub = "cad_adm";
    } else if (path.contains("new/admpref")) {
        menu_sub = "cad_admpref";
    } else if (path.contains("new/funcionario")) {
        menu_sub = "cad_func";
    } else if (path.contains("new/cidadao")) {
        menu_sub = "cad_cidadao";
    } else if (path.contains("new/secretaria")) {
        menu_sub = "cad_sec";
    } else if (path.contains("new/categoria")) {
        menu_sub = "cad_cat";
    } else if (path.contains("new/cidade")) {
        menu_sub = "cad_cid";
    } else if (path.contains("occurrences/encaminhar")) {
        menu_sub = "enc_oco";
    }

    if (menu == "min") {
        title = "Minhas Ocorrências";
    } else if (menu == "cri") {
        title = "Nova Ocorrência";
    } else if (menu == "his") {
        title = "Histórico de Ocorrências";
    } else if (menu == "pen") {
        title = "Ocorrências Pendentes";
    } else if (menu == "ind") {
        title = "Home";
    } else if (menu_sub == "cad_admpref") {
        title = "Novo Adm Prefeitura";
    } else if (menu_sub == "cad_adm") {
        title = "Novo Adm";
    } else if (menu_sub == "cad_func") {
        title = "Novo Funcionário";
    } else if (menu_sub == "cad_cidadao") {
        title = "Novo Usuário";
    } else if (menu_sub == "cad_sec") {
        title = "Novo Secretaria";
    } else if (menu_sub == "cad_cat") {
        title = "Novo Categoria";
    } else if (menu_sub == "cad_cid") {
        title = "Nova Cidade";
    } else if (menu_sub == "con_adm") {
        title = "Consultar Adm";
    } else if (menu_sub == "con_admpref") {
        title = "Consultar Adm Prefeitura";
    } else if (menu_sub == "con_func") {
        title = "Consultar Funcionário";
    } else if (menu_sub == "con_cidadao") {
        title = "Consultar Cidadão";
    } else if (menu_sub == "con_sec") {
        title = "Consultar Secretaria";
    } else if (menu_sub == "con_cat") {
        title = "Consultar Categoria";
    } else if (menu_sub == "con_cid") {
        title = "Consultar Cidade";
    } else if (menu_sub == "enc_oco") {
        title = "Encaminhar Ocorrência";
    }
%>
<title><%= title%> - Help City</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="icon" href="<%= request.getContextPath()%>/images/cityscape.png" type="image/x-icon">
<link href="<%= request.getContextPath()%>/css/fonts.css" rel="stylesheet" type="text/css">
<link href="<%= request.getContextPath()%>/css/icons.css" rel="stylesheet" type="text/css">
<link href="<%= request.getContextPath()%>/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%= request.getContextPath()%>/plugins/node-waves/waves.min.css" rel="stylesheet" />
<link href="<%= request.getContextPath()%>/css/style.min.css" rel="stylesheet">
<link href="<%= request.getContextPath()%>/css/themes/all-themes.min.css" rel="stylesheet" />
<link href="<%= request.getContextPath()%>/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" />
<link href="<%= request.getContextPath()%>/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="<%= request.getContextPath()%>/css/mycss.css" type="text/css" rel="stylesheet"/>
<link href="<%= request.getContextPath()%>/plugins/animate-css/animate.css" rel="stylesheet" />
<script type="text/javascript">
    function getContextPath() {
        return "<%=request.getContextPath()%>";
    }
</script>
<style>
    .img-modal{
        width: 100%;
    }
</style>
<script src="<%= request.getContextPath()%>/js/sendPost.js" type="text/javascript"></script>
<body class="theme-purple">
    <div class="page-loader-wrapper">
        <div class="loader">
            <div class="preloader">
                <div class="spinner-layer pl-red">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
            </div>
            <p>Loading...</p>
        </div>
    </div>
    <div class="overlay"></div>
    <nav class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                <a href="javascript:void(0);" class="bars"></a>
                <a class="navbar-brand">HELP CITY <%= path%></a>
            </div>                
        </div>
    </nav>   
    <section>
        <aside id="leftsidebar" class="sidebar">
            <div class="user-info">
                <% if ((typeUser.equalsIgnoreCase("A"))) {%>
                <div class="image">
                    <img src="<%= request.getContextPath()%>/images/adm.png" width="48" height="48" alt="User" />
                </div>
                <% } %>
                <% if ((typeUser.equalsIgnoreCase("B")) && (request.getSession().getAttribute("sexoUsuario").equals("M"))) {%>
                <div class="image">
                    <img src="<%= request.getContextPath()%>/images/admpref-m.png" width="48" height="48" alt="User" />
                </div>
                <% } %>
                <% if ((typeUser.equalsIgnoreCase("B")) && (request.getSession().getAttribute("sexoUsuario").equals("F"))) {%>
                <div class="image">
                    <img src="<%= request.getContextPath()%>/images/admpref-f.png" width="48" height="48" alt="User" />
                </div>
                <% } %>
                <% if ((typeUser.equalsIgnoreCase("C")) && (request.getSession().getAttribute("sexoUsuario").equals("M"))) {%>
                <div class="image">
                    <img src="<%= request.getContextPath()%>/images/func-m.png" width="48" height="48" alt="User" />
                </div>
                <% } %>
                <% if ((typeUser.equalsIgnoreCase("C")) && (request.getSession().getAttribute("sexoUsuario").equals("F"))) {%>
                <div class="image">
                    <img src="<%= request.getContextPath()%>/images/func-f.png" width="48" height="48" alt="User"/>
                </div>
                <% } %>
                <% if ((typeUser.equalsIgnoreCase("D")) && (request.getSession().getAttribute("sexoUsuario").equals("M"))) {%>
                <div class="image">
                    <img src="<%= request.getContextPath()%>/images/cid-m.png" width="48" height="48" alt="User"/>
                </div>

                <% } %>
                <% if ((typeUser.equalsIgnoreCase("D")) && (request.getSession().getAttribute("sexoUsuario").equals("F"))) {%>
                <div class="image">
                    <img src="<%= request.getContextPath()%>/images/cid-f.png" width="48" height="48" alt="User" />
                </div>
                <% }%>
                <div class="info-container">
                    <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%= request.getSession().getAttribute("nomeUsuario")%></div>
                    <% if (typeUser.equalsIgnoreCase("A")) {%>
                    <div class="email">ADM</div>
                    <% } else if (typeUser.equalsIgnoreCase("B")) {%>
                    <div class="email">ADM Prefeitura - <%= request.getSession().getAttribute("nomeCidade")%></div>
                    <% } else if (typeUser.equalsIgnoreCase("C")) {%>
                    <div class="email"><%= request.getSession().getAttribute("nomeSecretariaFuncionario")%> - <%= request.getSession().getAttribute("nomeCidade")%></div>
                    <% } else if (typeUser.equalsIgnoreCase("D")) {%>
                    <div class="email"><%= request.getSession().getAttribute("nomeCidade")%></div>
                    <% }%>
                    <div class="btn-group user-helper-dropdown">
                        <i class="material-icons drop" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="<%= request.getContextPath()%>/userprofile"><i class="material-icons">person</i>Perfil</a></li>                                
                            <li><a href="<%= request.getContextPath()%>/edit/senha.jsp"><i class="material-icons">autorenew</i>Alterar Senha</a></li>
                            <li class="divider"></li>
                            <li>
                                <form id="formLogout" name="formLogout" action="<%= request.getContextPath()%>/logout" method="POST">
                                    <input type="hidden" name="acao" value="logout"/>                                    
                                </form>
                                <a href='javascript:formLogout.submit()'><i class="material-icons">power_settings_new</i>Sair</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>                                    
            <div class="menu">
                <ul class="list">
                    <li class="header">MENU DE NAVEGAÇÃO</li>
                    <li <% if (menu == "ind" || menu == "per") {%> class="active" <% }%>>
                        <a href="<%= request.getContextPath()%>/dashboard">
                            <i class="material-icons">home</i>
                            <span>Home</span>
                        </a>
                    </li>
                    <% if (!typeUser.equalsIgnoreCase("A")) { %>
                    <li <% if (menu == "cri") {%> class="active" <% }%>>
                        <a href="<%= request.getContextPath()%>/occurrences/criar.jsp">
                            <i class="material-icons">map</i>
                            <span>Criar Ocorrência</span>
                        </a>
                    </li>
                    <% }%>
                    <% if (typeUser.equalsIgnoreCase("D")) {%>
                    <li <% if (menu == "min") {%> class="active" <% }%>>
                        <a href="<%= request.getContextPath()%>/myoccurrences">
                            <i class="material-icons">textsms</i>
                            <span>Minhas Ocorrências</span>
                        </a>
                    </li>
                    <% }%>
                    <% if (typeUser.equalsIgnoreCase("B") || typeUser.equalsIgnoreCase("C")) {%>
                    <li <% if (menu == "pen" || menu == "enc") {%> class="active" <% }%>>
                        <a href="<%= request.getContextPath()%>/occurrencepending">
                            <i class="material-icons">notification_important</i>
                            <span>Ocorrências Pendentes</span>
                        </a>
                    </li>
                    <li <% if (menu == "his") {%> class="active" <% }%>>
                        <a href="<%= request.getContextPath()%>/occurrencehistory">
                            <i class="material-icons">history</i>
                            <span>Histórico de Ocorrências</span>
                        </a>
                    </li>
                    <% }%>
                    <% if (typeUser.equalsIgnoreCase("A") || typeUser.equalsIgnoreCase("B")) {%>
                    <li <% if (menu == "con" || menu == "edi") {%> class="active" <% }%>>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">search</i>
                            <span>Consultar</span>
                        </a>
                        <ul class="ml-menu">
                            <% if (typeUser.equalsIgnoreCase("A")) {%>
                            <li <% if (menu_sub == "con_adm") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/adms">Adm</a>
                            </li>
                            <% }%>
                            <li <% if (menu_sub == "con_admpref") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/admprefs">Adm Prefeitura</a>
                            </li>
                            <li <% if (menu_sub == "con_func") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/employees">Funcionário</a>
                            </li>
                            <li <% if (menu_sub == "con_cidadao") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/citizens">Cidadão</a>
                            </li>
                            <% if (typeUser.equalsIgnoreCase("B")) {%>
                            <li <% if (menu_sub == "con_sec") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/departments">Secretaria</a>
                            </li>
                            <li <% if (menu_sub == "con_cat") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/categories">Categoria</a>
                            </li>
                            <% }%>
                            <% if (typeUser.equalsIgnoreCase("A")) {%>
                            <li <% if (menu_sub == "con_cid") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/cities">Cidade</a>
                            </li>
                            <% }%>
                        </ul>
                    </li>
                    <li <% if (menu == "new") {%> class="active" <% }%>>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">assignment</i>
                            <span>Novo</span>
                        </a>
                        <ul class="ml-menu">
                            <% if (typeUser.equalsIgnoreCase("A")) {%>
                            <li <% if (menu_sub == "cad_adm") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/new/adm.jsp">Adm</a>
                            </li>
                            <% }%>
                            <li <% if (menu_sub == "cad_admpref") {%> class="active" <% }%>>
                                <a 
                                    <% if (typeUser.equalsIgnoreCase("A")) {%> href="<%= request.getContextPath()%>/loadfields" <% }%>
                                    <% if (typeUser.equalsIgnoreCase("B")) {%> href="<%= request.getContextPath()%>/new/admpref.jsp" <% }%>
                                    >Adm Prefeitura</a>
                            </li>
                            <% if (typeUser.equalsIgnoreCase("B")) {%>
                            <li <% if (menu_sub == "cad_func") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/createemployee">Funcionário</a>
                            </li>
                            <li <% if (menu_sub == "cad_cidadao") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/new/cidadao.jsp">Cidadão</a>
                            </li>
                            <li <% if (menu_sub == "cad_sec") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/new/secretaria.jsp">Secretaria</a>
                            </li>
                            <li <% if (menu_sub == "cad_cat") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/new/categoria.jsp">Categoria</a>
                            </li>
                            <% }%> 
                            <% if (typeUser.equalsIgnoreCase("A")) {%>
                            <li <% if (menu_sub == "cad_cid") {%> class="active" <% }%>>
                                <a href="<%= request.getContextPath()%>/createcity">Cidade</a>
                            </li>
                            <% }%> 
                        </ul>
                    </li>
                    <% }%>
                </ul>
            </div>
            <div class="legal">
                <div class="copyright">
                    &copy; 2018 <a href="javascript:void(0);">HELP CITY</a>
                </div>
                <div class="version">
                    <b>Versão </b> 1.0
                </div>
            </div>
        </aside>