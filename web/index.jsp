<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Help City</title>
        <%@include file="header-site.jsp" %>
    </head>
    <body>
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
            <div class="container">
                <a class="navbar-brand" href="#">
                    <strong>HELP CITY</strong>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#home">HOME
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#sobre">SOBRE NÓS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#recursos">RECURSOS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#valor">PLANO</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contato">CONTATE-NOS</a>
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
        <div id="home" class="view" style="background-image: url('img/cidade.jpg'); background-repeat: no-repeat; background-size: cover;">
            <div class="mask rgba-black-light d-flex justify-content-center align-items-center">
                <div class="text-center white-text mx-5 wow fadeIn">
                    <h1 class="mb-4">
                        <strong>${mensagem}</strong><br>
                        <strong>Ajude sua cidade a melhorar!</strong>
                    </h1>
                    <p>
                        <strong>Apenas alguns passos e você ja está colaborando</strong>
                    </p>
                    <a href="cadastrar.jsp" class="btn btn-white btn-lg">CADASTRE-SE JÁ!
                        <i class="fa fa- ml-2"></i>
                    </a>
                </div>
            </div>
        </div>
        <main>
            <div class="container">
                <br/>
                <br/>
                <section id="sobre">
                    <div class="card mb-4 wow fadeIn">
                        <div class="card-body">
                            <p class="h2 my-4 text-center">Sobre nós!</p>
                            <p class="h5 my-4 text-center">Fazer com que a população seja ouvida!</p>
                            <p class="text-muted text-center my-5">O portal de ouvidoria digital para municípios, Help City, tem como propósito apresentar o envio de reclamações
                                dos problemas de interesse público encontrados na cidade, bem como, identificar as suas necessidades no fortalecimento
                                da cidadania em relação ao seu município. Mediante pesquisas, verificou-se sites que realizam este serviço,
                                mas alguns não são otimizados e tornam o processo desconfortável e trabalhoso. Help City, possui módulos otimizados,
                                na qual o cidadão envia a localização e fotos do local identificado com divergências empregando recursos tecnológicos
                                para tornar o processo simples e ágil. Deste modo, a prefeitura toma ciência dos problemas que muitas vezes
                                passam despercebidos e a partir dos fatos assume as providências para a solução dos problemas.</p>
                        </div>
                    </div>
                </section>
                <hr class="my-5">
                <section id="recursos">
                    <h2 class="my-5 h2 text-center">Recursos</h2>
                    <div class="row features-small mb-5 mt-3 wow fadeIn">
                        <div class="col-md-4">
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">DESIGN INTUITIVO</h6>
                                    <p class="grey-text">Design agradavel e intuitivo aos usuários.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">SIMPLES E RÁPIDO</h6>
                                    <p class="grey-text">Envie suas ocorrência de maneira simples e rápida.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">SUPORTE TÉCNICO ESPECIALIZADO</h6>
                                    <p class="grey-text">Equipe de suporte bem preparada para atender as dúvidas dos usuários.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 flex-center">
                            <img src="<%=request.getContextPath()%>/img/telas.JPG" alt="MDB Magazine Template displayed on iPhone" class="z-depth-0 img-fluid">
                        </div>
                        <div class="col-md-4 mt-2">
                            <!--First row-->
                            <div class="row">
                                <br/>
                                <br/>
                                <br/>
                                <br/>
                                <br/>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">ACOMPANHE SUAS OCORRÊNCIAS</h6>
                                    <p class="grey-text">Consulte suas ocorrência sempre que quiser e veja como está sua situação atual.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">ACESSE DE QUALQUER DISPOSITO</h6>
                                    <p class="grey-text">Help City é um sistema WEB, permitindo que possa ser acessado de qualquer dispositivo, bastar ter conexão
                                        com a internet e um navegador web.
                                    </p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">FEEDBACK PARA O CIDADÃO</h6>
                                    <p class="grey-text">Fique atualizado sobre os acontecimentos sobre sua ocorrência com um feedback dos responsáveis pela sua ocorrência.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <hr class="my-5">
                <section id="valor">
                    <h2 class="my-5 h2 text-center">Valor único, plano completo!</h2>
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-8 text-center">
                            <p class="mb-5">
                                O Help City possui apenas uma versão, que conta com todos os recursos.
                                <br/> O sistema é grátis para o uso dos cidadãos!
                            </p>
                        </div>
                    </div>
                    <div class="row text-center wow fadeIn row justify-content-center">
                        <div class="col-lg-6 col-md-12 mb-4">
                            <div class="card h-product" itemscope itemtype="http://microformats.org/profile/h-product">
                                <div class="card-header">
                                    <h3 class="p-name card-title mb-2 negrito">
                                        <strong>Versão Completa</strong>
                                    </h3>
                                </div>
                                <div class="card-body e-description">
                                    <h4 class="pricing-card-title mb-4 p-price green-text">
                                        <meta itemprop="priceCurrency" content="BRL" />
                                        <meta itemprop="price" content="200.00" />
                                        <i>R$ 500,00</i>
                                        <small class="text-muted">/ mês</small>
                                    </h4>
                                    <hr>
                                    <ol class="list-unstyled mb-4">
                                        <li>SUPORTE TÉCNICO
                                            <i class="fa fa-check green-text ml-1"></i>
                                        </li>
                                        <hr>
                                        <li>QUALQUER QUANTIDADE DE ADMs
                                            <i class="fa fa-check green-text ml-1"></i>
                                        </li>
                                        <hr>
                                        <li>IMPLANTAÇÃO GRÁTIS
                                            <i class="fa fa-check green-text ml-1"></i>
                                        </li>
                                        <hr>
                                        <li>PRIMEIRO TREINAMENTO GRÁTIS
                                            <i class="fa fa-check green-text ml-1"></i>
                                        </li>
                                    </ol>
                                    <button type="button" class="btn btn-lg btn-block btn-success waves-effect">ASSINAR</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <hr class="mb-5">
                <section id="contato">
                    <div class="card">
                        <div class="card-body">
                            <form name="">
                                <h3 class="dark-grey-text text-center">
                                    <strong>Contate-nos:</strong>
                                </h3>
                                <div class="md-form">
                                    <i class="fa fa-user prefix grey-text"></i>
                                    <input type="text" id="form3" class="form-control">
                                    <label for="form3">Nome:</label>
                                </div>
                                <div class="md-form">
                                    <i class="fa fa-envelope prefix grey-text"></i>
                                    <input type="text" id="form2" class="form-control">
                                    <label for="form2">Email:</label>
                                </div>

                                <div class="md-form">
                                    <i class="fa fa-pencil prefix grey-text"></i>
                                    <textarea type="text" id="form8" class="md-textarea"></textarea>
                                    <label for="form8">Mensagem:</label>
                                </div>

                                <div class="text-center">
                                    <button type="submit" class="btn btn-success">Enviar</button>
                                    <button type="reset" class="btn btn-indigo">Limpar</button>
                                    </fieldset>
                                </div>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
        </main>
        <footer class="page-footer text-center font-small mt-4 wow fadeIn">
            <div class="footer-copyright py-3">
                © 2018 Copyright Help City
            </div>
        </footer>
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">ENTRAR</h4>
                        <button type="button" class="close" data-dismiss="modal">×</button>
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
    </body>
</html>