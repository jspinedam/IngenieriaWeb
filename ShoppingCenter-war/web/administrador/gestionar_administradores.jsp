<%-- 
    Document   : inicio_administrador
    Created on : 7/04/2015, 10:42:10 AM
    Author     : ANDRES PINEDA
--%>


<%@page import="java.util.HashMap"%>
<%@page import="com.eshopping.utilidades.Utilidades"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <form name="form1" method="post" action="administrador/gestionar_administradores.jsp">
                    <div class="col-md-12">
                        <fieldset style="border: black;border-radius: 10px">
                            <h3><legend style="color: darkblue"><strong>INFORMACIÓN ADMINISTRADOR</strong></legend></h3>
                            <div class="row col-md-12">
                                <fieldset style="border: black;border-radius: 10px; color: black"> 
                                    <legend class="h5">I. Personal</legend>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="parametroNombre">
                                                Nombre Administrador
                                            </label>
                                            <input type="text" maxlength="30" id="parametroNombre" name="parametroNombre" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="parametroApellido">
                                                Apellido Administrador
                                            </label>
                                            <input type="text" maxlength="30" id="parametroApellido" name="parametroApellido" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="parametroDocumento">
                                                Número Identificación
                                            </label>
                                            <input type="text" maxlength="30" id="parametroDocumento" name="parametroDocumento" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="parametroTipoDocumento">
                                                Tipo Documento
                                            </label>
                                            <select class="form-control" name="parametroTipoDocumento"
                                                    id="parametroTipoDocumento">
                                                <option value="CC">Cedula Ciudadania</option>
                                                <option value="CE">Cedula Extrangeria</option>
                                                <option value="PP">Pasaporte</option>
                                                <option value="TI">Tarjeta Identidad</option>
                                                <option value="TODOS">Despreciar Valor</option>
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
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="parametroEstado">
                                            Estado Administrador
                                        </label>
                                        <select class="form-control" name="parametroEstado"
                                                id="parametroEstado">
                                            <option value="1">ACTIVO</option>
                                            <option value="2">INACTIVO</option>
                                            <option value="3">TODOS</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="parametroGenero">
                                            Genero Persona
                                        </label>
                                        <select class="form-control" name="parametroGenero"
                                                id="parametroGenero">
                                            <option value="M">MASCULINO</option>
                                            <option value="F">FEMENINO</option>
                                            <option value="O">OTRO</option>
                                            <option value="TODOS">TODOS</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="parametroUsuario">
                                            Nombre Usuario
                                        </label>
                                        <input type="text" maxlength="20" id="parametroUsuario" name="parametroUsuario" class="form-control"/>
                                    </div>
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
                    </div>
                </form>
                <div id="resultadosBusqueda" class="row clearfix col-md-12">
                    <fieldset style="border: black;border-radius: 10px;">
                        <h3><legend style="color: darkblue"><strong>RESULTADOS DE BUSQUEDA</strong></legend></h3>
                        <div class="row">
                            <table border=1 width="100%">
                                <tr>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Correo</th>
                                </tr>
                                <%@page import="com.eshopping.entidades.Administrador"%>
                                <%@page import="java.util.List"%>
                                <%@page import="java.util.Map"%>
                                <jsp:useBean id="admiController" class="com.eshopping.controllers.ControllerAdministrarAdministradores" />
                                <%
                                    String parametroNombre, parametroApellido, parametroDocumento, parametroTipoDocumento, parametroCorreo, parametroGenero, parametroUsuario;
                                    int parametroEstado = 1;
                                    Map<String, String> filtros;
                                    List<Administrador> listaAdministradores;

                                    parametroNombre = request.getParameter("parametroNombre");
                                    parametroApellido = request.getParameter("parametroApellido");
                                    parametroUsuario = request.getParameter("parametroUsuario");
                                    parametroDocumento = request.getParameter("parametroDocumento");
                                    parametroTipoDocumento = request.getParameter("parametroTipoDocumento");
                                    parametroCorreo = request.getParameter("parametroCorreo");
                                    parametroGenero = request.getParameter("parametroGenero");
                                    String strEstado = request.getParameter("parametroEstado");
                                    if (null != strEstado) {
                                        parametroEstado = Integer.parseInt(strEstado);
                                    }
                                    filtros = new HashMap<String, String>();
                                    filtros.put("parametroNombre", null);
                                    filtros.put("parametroApellido", null);
                                    filtros.put("parametroDocumento", null);
                                    filtros.put("parametroTipoDocumento", null);
                                    filtros.put("parametroCorreo", null);
                                    filtros.put("parametroGenero", null);
                                    filtros.put("parametroUsuario", null);
                                    filtros.put("parametroEstado", null);
                                    if ((Utilidades.validarNulo(parametroNombre) == true) && (!parametroNombre.isEmpty())) {
                                        filtros.put("parametroNombre", parametroNombre);
                                    }
                                    if ((Utilidades.validarNulo(parametroApellido) == true) && (!parametroApellido.isEmpty())) {
                                        filtros.put("parametroApellido", parametroApellido);
                                    }
                                    if ((Utilidades.validarNulo(parametroDocumento) == true) && (!parametroDocumento.isEmpty())) {
                                        filtros.put("parametroDocumento", parametroDocumento);
                                    }
                                    if ((Utilidades.validarNulo(parametroTipoDocumento) == true) && (!parametroTipoDocumento.isEmpty())) {
                                        filtros.put("parametroTipoDocumento", parametroTipoDocumento);
                                    }
                                    if ((Utilidades.validarNulo(parametroCorreo) == true) && (!parametroCorreo.isEmpty())) {
                                        filtros.put("parametroCorreo", parametroCorreo);
                                    }
                                    if ((Utilidades.validarNulo(parametroGenero) == true) && (!parametroGenero.isEmpty())) {
                                        if (!parametroGenero.equalsIgnoreCase("TODOS")) {
                                            filtros.put("parametroGenero", parametroGenero);
                                        }
                                    }
                                    if ((Utilidades.validarNulo(parametroUsuario) == true) && (!parametroUsuario.isEmpty())) {
                                        filtros.put("parametroUsuario", parametroUsuario);
                                    }
                                    if (1 == parametroEstado) { 
                                        filtros.put("parametroEstado", "true");
                                    } else {
                                        if (parametroEstado == 2) {
                                            filtros.put("parametroEstado", "false");
                                        }
                                    }

                                    listaAdministradores = admiController.buscarAdministradores(filtros);
                                    for (int i = 0;
                                            i < listaAdministradores.size();
                                            i++) {
                                        Administrador emp = (Administrador) listaAdministradores.get(i);
                                %>
                                <tr>
                                    <td><%=emp.getPersona().getNombre()%></td>
                                    <td><%=emp.getPersona().getApellido()%></td>
                                    <td><%=emp.getPersona().getCorreo()%></td>
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
                    <form action="registrarAdministrador">
                        <input type="submit" class="btn btn-success" value="Nuevo Administrador"/>                        
                    </form>
                </div>
                <div class="col-md-10"></div>
                <div class="col-md-1">
                    <form action="atrasInicioAdministrador">
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
