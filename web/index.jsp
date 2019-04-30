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
                            <a class="nav-link" href="#sobre">SOBRE N�S</a>
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
                        <strong>Apenas alguns passos e voc� ja est� colaborando</strong>
                    </p>
                    <a href="cadastrar.jsp" class="btn btn-white btn-lg">CADASTRE-SE J�!
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
                            <p class="h2 my-4 text-center">Sobre n�s!</p>
                            <p class="h5 my-4 text-center">Fazer com que a popula��o seja ouvida!</p>
                            <p class="text-muted text-center my-5">O portal de ouvidoria digital para munic�pios, Help City, tem como prop�sito apresentar o envio de reclama��es
                                dos problemas de interesse p�blico encontrados na cidade, bem como, identificar as suas necessidades no fortalecimento
                                da cidadania em rela��o ao seu munic�pio. Mediante pesquisas, verificou-se sites que realizam este servi�o,
                                mas alguns n�o s�o otimizados e tornam o processo desconfort�vel e trabalhoso. Help City, possui m�dulos otimizados,
                                na qual o cidad�o envia a localiza��o e fotos do local identificado com diverg�ncias empregando recursos tecnol�gicos
                                para tornar o processo simples e �gil. Deste modo, a prefeitura toma ci�ncia dos problemas que muitas vezes
                                passam despercebidos e a partir dos fatos assume as provid�ncias para a solu��o dos problemas.</p>
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
                                    <p class="grey-text">Design agradavel e intuitivo aos usu�rios.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">SIMPLES E R�PIDO</h6>
                                    <p class="grey-text">Envie suas ocorr�ncia de maneira simples e r�pida.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">SUPORTE T�CNICO ESPECIALIZADO</h6>
                                    <p class="grey-text">Equipe de suporte bem preparada para atender as d�vidas dos usu�rios.</p>
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
                                    <h6 class="feature-title">ACOMPANHE SUAS OCORR�NCIAS</h6>
                                    <p class="grey-text">Consulte suas ocorr�ncia sempre que quiser e veja como est� sua situa��o atual.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-2">
                                    <i class="fa fa-check-circle fa-2x indigo-text"></i>
                                </div>
                                <div class="col-10">
                                    <h6 class="feature-title">ACESSE DE QUALQUER DISPOSITO</h6>
                                    <p class="grey-text">Help City � um sistema WEB, permitindo que possa ser acessado de qualquer dispositivo, bastar ter conex�o
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
                                    <h6 class="feature-title">FEEDBACK PARA O CIDAD�O</h6>
                                    <p class="grey-text">Fique atualizado sobre os acontecimentos sobre sua ocorr�ncia com um feedback dos respons�veis pela sua ocorr�ncia.</p>
                                    <div style="height:15px"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <hr class="my-5">
                <section id="valor">
                    <h2 class="my-5 h2 text-center">Valor �nico, plano completo!</h2>
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-8 text-center">
                            <p class="mb-5">
                                O Help City possui apenas uma vers�o, que conta com todos os recursos.
                                <br/> O sistema � gr�tis para o uso dos cidad�os!
                            </p>
                        </div>
                    </div>
                    <div class="row text-center wow fadeIn row justify-content-center">
                        <div class="col-lg-6 col-md-12 mb-4">
                            <div class="card h-product" itemscope itemtype="http://microformats.org/profile/h-product">
                                <div class="card-header">
                                    <h3 class="p-name card-title mb-2 negrito">
                                        <strong>Vers�o Completa</strong>
                                    </h3>
                                </div>
                                <div class="card-body e-description">
                                    <h4 class="pricing-card-title mb-4 p-price green-text">
                                        <meta itemprop="priceCurrency" content="BRL" />
                                        <meta itemprop="price" content="200.00" />
                                        <i>R$ 500,00</i>
                                        <small class="text-muted">/ m�s</small>
                                    </h4>
                                    <hr>
                                    <ol class="list-unstyled mb-4">
                                        <li>SUPORTE T�CNICO
                                            <i class="fa fa-check green-text ml-1"></i>
                                        </li>
                                        <hr>
                                        <li>QUALQUER QUANTIDADE DE ADMs
                                            <i class="fa fa-check green-text ml-1"></i>
                                        </li>
                                        <hr>
                                        <li>IMPLANTA��O GR�TIS
                                            <i class="fa fa-check green-text ml-1"></i>
                                        </li>
                                        <hr>
                                        <li>PRIMEIRO TREINAMENTO GR�TIS
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
                � 2018 Copyright Help City
            </div>
        </footer>
        <div class="modal fade" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">ENTRAR</h4>
                        <button type="button" class="close" data-dismiss="modal">�</button>
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
                                                <input name="loginUsuario" id="loginUsuario" type="text" placeholder="Digite seu usu�rio" class="form-control"> 
                                                <label for="loginUsuario">Usu�rio</label>
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