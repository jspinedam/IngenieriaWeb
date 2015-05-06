
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <body>


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
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#about">About</a>
                        </li>
                        <li>
                            <a href="#servicio">Servicios</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <!-- Header -->
        <a name="about"></a>
        <div class="intro-header" style="background: url(img/intro-bg.jpg)">
            <div class="container">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <h1>E-Shopping Center</h1>
                            <h3>Pineda Software</h3>
                            <hr class="intro-divider"/>
                            <ul class="list-inline intro-social-buttons">
                                <li>
                                    <a href="#modal-login" class="btn btn-primary btn-lg" data-toggle="modal">
                                        <span class="network-name">
                                            Ingresar
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="cliente/registrar_cliente.jsp" class="btn btn-default btn-lg"><span class="network-name">Registrarse</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.intro-header -->

        <!-- Page Content -->
        <div class="modal fade" id="modal-login" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <form action="iniciarLogin">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                Login E-Shopping Center
                            </h4>
                        </div>
                        <div class="modal-body">
                            <label for="usuario">
                                Correo Institucional
                            </label>
                            <input type="text" maxlength="45" required="true" name="usuario" class="form-control"/>
                            <br></br>
                            <label for="inputContrasenia">
                                Contraseña
                            </label>
                            <input type="password" maxlength="45" required="true" name="contrasenia" class="form-control"/>
                        </div>
                        <div class="modal-footer">
                            <a class="forgot" href="#">¿Olvidaste tu contraseña?</a>
                            <span></span>
                            <span class="separator">---</span>
                            <span></span>
                            <input type="submit" class="btn btn-success right" value="Ingresar"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!-- Page Content -->

        <a  name="servicio"></a>
        <div class="content-section-a">

            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-sm-6">
                        <hr class="section-heading-spacer"/>
                        <div class="clearfix"></div>
                        <h2 class="section-heading">¿Qué es E-Shopping Center?</h2>
                        <p class="lead">Es una herramienta que permite administrar las funciones de los laboratorios de ingenieria de la Universidad, administrando los procesos de usuarios, recursos, prestamos e indicadores.</p>
                    </div>
                    <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                        <img class="img-responsive" src="img/ipad.png" alt=""/>
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.content-section-a -->

        <div class="content-section-b">

            <div class="container">

                <div class="row">
                    <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
                        <hr class="section-heading-spacer"/>
                        <div class="clearfix"></div>
                        <h2 class="section-heading">3D Device Mockups<br/>by PSDCovers</h2>
                        <p class="lead">Turn your 2D designs into high quality, 3D product shots in seconds using free Photoshop actions by <a target="_blank" href="http://www.psdcovers.com/">PSDCovers</a>! Visit their website to download some of their awesome, free photoshop actions!</p>
                    </div>
                    <div class="col-lg-5 col-sm-pull-6  col-sm-6">
                        <img class="img-responsive" src="img/dog.png" alt=""/>
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.content-section-b -->

        <div class="content-section-a">

            <div class="container">

                <div class="row">
                    <div class="col-lg-5 col-sm-6">
                        <hr class="section-heading-spacer"/>
                        <div class="clearfix"></div>
                        <h2 class="section-heading">Google Web Fonts and<br/>Font Awesome Icons</h2>
                        <p class="lead">This template features the 'Lato' font, part of the <a target="_blank" href="http://www.google.com/fonts">Google Web Font library</a>, as well as <a target="_blank" href="http://fontawesome.io">icons from Font Awesome</a>.</p>
                    </div>
                    <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                        <img class="img-responsive" src="img/phones.png" alt=""/>
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.content-section-a -->


        <!-- Footer -->
        <footer style="background: white">
            <div class="container">
                <div class="row">
                    <div class="col-lg-10">
                        <ul class="list-inline">
                            <li>
                                <a href="#">Home</a>
                            </li>
                            <li>
                                <a href="#about">About</a>
                            </li>
                            <li>
                                <a href="#servicio">Servicios</a>
                            </li>
                        </ul>
                        <p class="copyright text-muted small">Copyright; Your Company 2014. All Rights Reserved</p>
                    </div>
                    <div class="col-lg-2">
                        <div class="right">
                            <img alt="300x400" class="img-responsive img-rounded" src="img/e-shopping-center-logo.jpg" />
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
