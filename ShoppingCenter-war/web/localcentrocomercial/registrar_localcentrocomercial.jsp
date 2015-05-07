
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
                        <!-- /.navbar-collapse -->
                    </div>
                    <!-- /.container -->
                </nav>
            </div>
            <div class="row">
                <br></br>
                <br></br>
                <br></br>
                <br></br>
            </div>
            <div class="row">
                <div class="col-md-12 column">
                    <div class="row">
                        <div class="col-md-8 column">
                            <form action="registrarLocalCentroComercial">
                                <fieldset>
                                    <legend class="text-info">Datos Basicos Local</legend>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputNombre">
                                                Nombre Local*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="30" name="inputNombre" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputRazon">
                                                Razón Social*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="30" name="inputRazon" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputSlogan">
                                                Slogan Local*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="80" name="inputSlogan" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputNumeroLocal">
                                                Número Local*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="5" name="inputNumeroLocal" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputCorreo">
                                                Correo Contacto*
                                            </label> 
                                        </strong>
                                        <div class="input-group">
                                            <input type="email" maxlength="80" name="inputCorreo" required="true" class="form-control"/>
                                            <span class="input-group-addon">@</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputTelefono">
                                                Telefono Local*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="20" name="inputTelefono" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputEncargado">
                                                Encargado Local
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="30" name="inputEncargado" class="form-control"/>
                                    </div>                                    
                                </fieldset>
                                <button type="submit" class="btn btn-success">Registrar</button>
                                <span></span>
                                <span></span>
                            </form>
                        </div>
                        <div class="col-md-4 column">
                            <h2 class="info">
                                Información Registro
                            </h2>
                            <p>
                                Los campos marcados con (*) son obligatorios. Los caracteres especiales estan prohibidos para el registro de la información. 
                            </p>
                            <p>
                                Este registro es unicamente para LOCALES DEL CENTRO COMERCIAL, al momento de ser registrado en el sistema su estado sera ACTIVO, en caso contrario es necesario que un administrador del sistema que gestione el proceso de activacion. 
                            </p>
                        </div>
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="col-md-11">

                    </div>
                    <div class="col-md-1">
                        <form action="consultarLocales">
                            <input type="submit" name="Atras" value="Atras" class="btn btn-danger right"/>
                        </form>
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
