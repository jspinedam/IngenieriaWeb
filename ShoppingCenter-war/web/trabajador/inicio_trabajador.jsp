<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta name="description" content=""/>
        <meta name="author" content=""/>

        <title>Ingenieria WEB - E.S.C</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/landing-page.css" />

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css"/>
    </head>

    <body style="background-image: url('http://www.ucentral.edu.co/images/template_images/ucentral/fondos/fondo_template_default.jpg'); background-repeat: repeat; background-position: 0% 0%; background-attachment: fixed; background-color: #ffffff;" >
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="row">
                    <!-- Navigation -->
                    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
                        <div class="container topnav">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand">
                                    <img alt="500x100" height="50" width="100" class="img-responsive" src="img/logo-universidad-central.png" />
                                    <a class="navbar-brand topnav" href="#">E-Shopping Center</a>    
                                </a>
                                <p class="navbar-text pull-left ">
                                    <jsp:useBean id="sesion" class="com.shoppingcenter.controllers.ControllerPaginaInicio" scope="page"/>
                                    Conectado como: <label class="text-uppercase" style="color: darkblue;text-transform: uppercase">${sesion.obtejerUsuarioConectado()}</label>
                                </p>
                            </div>
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="#">Configurar Usuario</a>
                                    </li>
                                    <li>
                                        <a href="#" >Cerrar Sesion</a>
                                    </li>
                                </ul>
                            </div>
                            <!-- /.navbar-collapse -->
                        </div>
                        <!-- /.container -->
                    </nav>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <img alt="300x800" class="img-responsive img-rounded" src="http://lorempixel.com/600/200/business">
                        <h1>Local</h1>
                        <p>
                            Cambia la información del establecimiento.
                        </p>
                        <form action="trabajadorAlocal" >
                            <input type="submit" value="Entrar" />
                        </form>
                        <p></p>
                    </div>
                    <form>
                        <div class="col-md-6">
                            <img src="http://pingendo.github.io/pingendo-bootstrap/assets/placeholder.png"
                                 class="img-responsive">
                            <h1>Productos</h1>
                            <p></p>
                            <p>Agrega, edita y elimina productos</p>
                            <input type="submit" value="Entrar" />
                            <p></p>
                        </div>
                    </form>

                </div>
            </div>
        </div>
                                 <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-10">
                        <ul class="list-inline">
                            <li>
                                <a href="#">Home</a>
                            </li>
                        </ul>
                        <p class="copyright text-muted small">Copyright; Your Company 2014. All Rights Reserved</p>
                    </div>
                    <div class="col-lg-2">
                        <div class="right">
                            <img alt="200x300" class="img-responsive img-rounded" src="img/e-shopping-center-logo.jpg" />
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>

</html>