
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
    <body style="background-image: url('http://www.ucentral.edu.co/images/template_images/ucentral/fondos/fondo_template_default.jpg'); background-repeat: repeat; background-position: 0% 0%; background-attachment: fixed; background-color: #ffffff;">
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
            <div class="row">
                <br></br>
                <br></br>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tab-content" id="tabs-868824">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#panelUsuarios" data-toggle="tab">Usuarios</a>
                            </li>
                            <li>
                                <a href="#panelLocales" data-toggle="tab">Locales</a>
                            </li>
                            <li>
                                <a href="#panelPromociones" data-toggle="tab">Promociones</a>
                            </li>
                            <li>
                                <a href="#panelGuiasCompra" data-toggle="tab">Guias de Compra</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="panelUsuarios">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="thumbnail">
                                            <img alt="300x200" class="img-responsive img-rounded" src="img/cliente.jpg" />
                                            <div class="caption">
                                                <h3>
                                                    CLIENTES
                                                </h3>
                                                <p>
                                                    Esta opción permite administrar los clientes registrados en el sistema de información. 
                                                </p>
                                                <form action="gestionarCliente">
                                                    <input type="submit" class="btn btn-primary" value="Aceptar">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="thumbnail">
                                            <img alt="300x200" class="img-responsive img-rounded" src="img/trabajador.jpg" />
                                            <div class="caption">
                                                <h3>
                                                    TRABAJADORES
                                                </h3>
                                                <p>
                                                    Esta opción permite administrar los trabajadores registrados en el sistema de información. 
                                                </p>
                                                <form action="gestionarTrabajador">
                                                    <input type="submit" class="btn btn-primary" value="Aceptar">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="thumbnail">
                                            <img alt="300x200" class="img-responsive img-rounded" src="img/administrador.png" />
                                            <div class="caption">
                                                <h3>
                                                    ADMINISTRADORES
                                                </h3>
                                                <p>
                                                    Esta opción permite administrar los administradores registrados en el sistema de información. 
                                                </p>
                                                <p>
                                                <form action="gestionarAdministrador">
                                                    <input type="submit" class="btn btn-primary" value="Aceptar">
                                                </form>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="panelLocales">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="thumbnail">
                                            <img alt="300x400" class="img-responsive img-rounded" src="img/locales.jpg" />
                                            <div class="caption">
                                                <h3>
                                                    Locales
                                                </h3>
                                                <p>
                                                    Por medio de esta opción se puede administrar los locales registrados en el centro comercial.
                                                </p>
                                                <p>
                                                <form action="consultarLocales">
                                                    <input type="submit" name="Atras" class="btn btn-primary"/>
                                                </form>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="thumbnail">
                                            <img alt="300x400" class="img-responsive img-rounded" src="http://lorempixel.com/600/200/city" />
                                            <div class="caption">
                                                <p>
                                                    Información de interes sobre los localres registrados o un banner con informacion
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="panelPromociones"> 
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="thumbnail">
                                            <img alt="300x400" class="img-responsive img-rounded" src="img/promociones.jpg" />
                                            <div class="caption">
                                                <h3>
                                                    Promociones
                                                </h3>
                                                <p>
                                                    Esta opción permite administrar las promociones registradas por los locales.
                                                </p>
                                                <p>
                                                <form action="consultarPromociones">
                                                    <input type="submit" name="Atras" class="btn btn-primary"/>
                                                </form>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="thumbnail">
                                            <img alt="300x400" class="img-responsive img-rounded" src="http://lorempixel.com/600/200/city" />
                                            <div class="caption">
                                                <p>
                                                    Información de interes sobre las promociones registradas o un banner con informacion
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="panelGuiasCompra">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="thumbnail">
                                            <img alt="300x400" class="img-responsive img-rounded" src="http://lorempixel.com/600/200/people" />
                                            <div class="caption">
                                                <h3>
                                                    Guias de Compra de Locales
                                                </h3>
                                                <p>
                                                    Permite administrador la información de las guias de compra referentes a los locales.
                                                </p>
                                                <p>
                                                <form action="consultarGuiaCompraLocal">
                                                    <input type="submit" name="Atras" class="btn btn-primary"/>
                                                </form>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="thumbnail">
                                            <img alt="300x400" class="img-responsive img-rounded" src="http://lorempixel.com/600/200/city" />
                                            <div class="caption">
                                                <p>
                                                    Información de interes sobre las guias de compra registradas o un banner con informacion
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="thumbnail">
                                            <img alt="300x400" class="img-responsive img-rounded" src="img/guia_compra_producto.jpg" />
                                            <div class="caption">
                                                <h3>
                                                    Guias de Compra de Productos
                                                </h3>
                                                <p>
                                                    Permite administrador la información de las guias de compra referentes a los productos.
                                                </p>
                                                <p>
                                                <form action="consultarGuiaCompraProducto">
                                                    <input type="submit" name="Atras" class="btn btn-primary"/>
                                                </form>
                                                </p>
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
