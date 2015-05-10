<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.ResourceBundle"%>
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
        <% ResourceBundle resource = ResourceBundle.getBundle("i18n.consultaguiascompraslocales", request.getLocale());%>
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
                                <%=resource.getString("conectado")%> <label class="text-uppercase" style="color: darkblue;text-transform: uppercase">${sesion.obtejerUsuarioConectado()}</label>                          
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
            <div class="row">
                <div id="resultadosBusqueda" class="row clearfix col-md-12">
                    <fieldset style="border: black;border-radius: 10px;">
                        <h3><legend style="color: darkblue"><strong><%=resource.getString("resultado")%></strong></legend></h3>
                        <div class="row">
                            <table border=1 width="100%">
                                <tr>
                                    <th><%=resource.getString("nombre")%></th>
                                    <th><%=resource.getString("codigo")%></th>
                                    <th><%=resource.getString("caracteristica")%></th>
                                    <th><%=resource.getString("nombreLocal")%></th>
                                    <th><%=resource.getString("nLocal")%></th>
                                    <th><%=resource.getString("telefono")%></th>

                                </tr>
                                <%@page import="com.shoppingcenter.entidades.GuiaCompraLocal"%>
                                <%@page import="java.util.List"%>
                                <%@page import="java.util.Map"%>
                                <jsp:useBean id="guiaController" class="com.shoppingcenter.controllers.ControllerConsultarGuiasCompraLocales" />
                                <%
                                    List<GuiaCompraLocal> listaGuiasCompraLocal = null;
                                    listaGuiasCompraLocal = guiaController.getListaGuiasCompraLocal();
                                    for (int i = 0;
                                            i < listaGuiasCompraLocal.size();
                                            i++) {
                                        GuiaCompraLocal emp = (GuiaCompraLocal) listaGuiasCompraLocal.get(i);
                                %>
                                <tr>
                                    <td><%=emp.getGuiacompra().getNombre()%></td>
                                    <td><%=emp.getGuiacompra().getCodigo()%></td>
                                    <td><%=emp.getGuiacompra().getCaracteristicacomun()%></td>
                                    <td><%=emp.getLocalcentrocomercial().getNombre()%></td>
                                    <td><%=emp.getLocalcentrocomercial().getNumerolocal()%></td>
                                    <td><%=emp.getLocalcentrocomercial().getTelefono()%></td>
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
                <div class="col-md-11"></div>
                <div class="col-md-1">
                    <form action="atrasInicioCiente">
                        <input value="<%=resource.getString("atras")%>" type="submit" class="btn btn-danger"/>
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
