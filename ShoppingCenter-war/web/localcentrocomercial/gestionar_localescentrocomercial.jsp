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
                                <jsp:useBean id="sesion" class="com.eshopping.controllers.ControllerPaginaInicio" scope="page"/>
                                Conectado como: <label class="text-uppercase" style="color: darkblue;text-transform: uppercase">${sesion.obtejerUsuarioConectado()}</label>                          
                            </p>
                        </div>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
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
                    <form action="consultarLocales">
                        <fieldset style="border: black;border-radius: 10px">
                            <h3><legend style="color: darkblue"><strong>INFORMACIÓN LOCALES</strong></legend></h3>
                            <div class="row col-md-12">
                                <fieldset style="border: black;border-radius: 10px; color: black"> 
                                    <legend class="h5">I. Basica del Local</legend>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="parametroNombre">
                                                Nombre Local
                                            </label>
                                            <input type="text" maxlength="30" id="parametroNombre" name="parametroNombre" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="parametroNumeroLocal">
                                                Numero Local
                                            </label>
                                            <input type="text" maxlength="5" id="parametroNumeroLocal" name="parametroNumeroLocal" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="parametroRazon">
                                                Razón Social
                                            </label>
                                            <input type="text" maxlength="30" id="parametroRazon" name="parametroRazon" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="parametroEstado">
                                                Estado Local
                                            </label>
                                            <select class="form-control" name="parametroEstado"
                                                    id="parametroEstado">
                                                <option value="1">ACTIVOS</option>
                                                <option value="2">INACTIVOS</option>
                                                <option value="3">TODOS</option>
                                            </select>
                                        </div>
                                    </div>
                                </fieldset>
                            </div> 
                            <div class="row col-md-12">
                                <div class="col-md-3">
                                    <label for="parametroCorreo">
                                        Correo Contacto
                                    </label>
                                    <div class="input-group">
                                        <input type="text" maxlength="80" id="parametroCorreo" name="parametroCorreo" class="form-control"/>
                                        <span class="input-group-addon">@</span>
                                    </div>
                                </div>
                                <div class="col-md-9">

                                </div>
                            </div>
                        </fieldset>
                        <br></br>
                        <div class="col-md-12">
                            <div class="col-md-10">
                            </div> 
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-primary right">Consultar</button>
                            </div>
                            <div class="col-md-1">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div id="resultadosBusqueda" class="row clearfix">
                <fieldset style="border: black;border-radius: 10px;">
                    <h3><legend style="color: darkblue"><strong>RESULTADOS DE BUSQUEDA</strong></legend></h3>
                    <div class="row">
                        Aqui va la tabla
                    </div><!--/.row-->
                </fieldset>
            </div>
            <br></br>
            <div class="row">
                <div class="col-md-1">
                    <form action="registrarLocal">
                        <input type="submit" value="Nuevo Local C.C." class="btn btn-success"/>
                    </form>
                </div>
                <div class="col-md-10"></div>
                <div class="col-md-1">
                    <form action="atrasInicioAdministrador">
                        <input value="Atras" type="submit" class="btn btn-danger"/>
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
