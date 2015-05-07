
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
                        <!-- /.navbar-collapse -->
                    </div>
                    <!-- /.container -->
                </nav>
            </div>
            <div class="row">
                <br></br>
                <br></br>
            </div>
            <div class="row col-md-12">
                <div id="resultadosBusqueda" class="row clearfix col-md-12">
                    <fieldset style="border: black;border-radius: 10px;">
                        <h3><legend style="color: darkblue"><strong>RESULTADOS DE BUSQUEDA</strong></legend></h3>
                        <div class="row">
                            <table border=1 width="100%">
                                <tr>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correo</th>
                                    <th>Usuario</th>
                                    <th>Cargo</th>
                                    <th>Local</th>
                                </tr>
                                <%@page import="com.shoppingcenter.entidades.Trabajador"%>
                                <%@page import="java.util.List"%>
                                <%@page import="java.util.Map"%>
                                <jsp:useBean id="trabController" class="com.shoppingcenter.controllers.ControllerAdministrarTrabajadores2" />
                                <%
                                    List<Trabajador> listaTrabajadores = null;
                                    listaTrabajadores = trabController.getListaTrabajadores();
                                    for (int i = 0;
                                            i < listaTrabajadores.size();
                                            i++) {
                                        Trabajador emp = (Trabajador) listaTrabajadores.get(i);
                                %>
                                <tr>
                                    <td><%=emp.getPersona().getNombre()%></td>
                                    <td><%=emp.getPersona().getApellido()%></td>
                                    <td><%=emp.getPersona().getCorreo()%></td>
                                    <td><%=emp.getPersona().getNombreusuario()%></td>
                                    <td><%=emp.getCargo()%></td>
                                    <td><%=emp.getLocalcentrocomercial().getNombre()%></td>
                                </tr>
                                <%
                                    }
                                %>
                            </table>
                        </div><!--/.row-->
                    </fieldset>
                </div>
            </div>
            <br></br>
            <div class="row">
                <div class="col-md-1">
                    <form action="registrarTrabajador">
                        <input type="submit" class="btn btn-success" value="Nuevo Trabajador"/>                        
                    </form>
                </div>
                <div class="col-md-10"></div>
                <div class="col-md-10"></div>
                <div class="col-md-1">
                    <form action="atrasInicioTrabajador">
                        <input type="submit" class="btn btn-danger" value="Atras"/>                        
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
