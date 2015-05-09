<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>

        <!-- Custom CSS -->
        <link rel="stylesheet" href="../css/landing-page.css" />

        <!-- Custom Fonts -->
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-image: url('http://www.ucentral.edu.co/images/template_images/ucentral/fondos/fondo_template_default.jpg'); background-repeat: repeat; background-position: 0% 0%; background-attachment: fixed; background-color: #ffffff;">
        <% ResourceBundle resource = ResourceBundle.getBundle("i18n.registrarcliente", request.getLocale());%>
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
                                <img alt="500x100" height="50" width="100" class="img-responsive" src="../img/logo-universidad-central.png" />
                                <a class="navbar-brand topnav" href="#">E-Shopping Center</a>    
                            </a>
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
                            <form action="registrarCliente">
                                <fieldset>
                                    <legend class="text-info"><%=resource.getString("datos")%></legend>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputNombre">
                                                <%=resource.getString("nombre")%>*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="30" name="inputNombre" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputApellido">
                                                <%=resource.getString("apellido")%>*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="30" name="inputApellido" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputGenero">
                                                <%=resource.getString("genero")%>*
                                            </label> 
                                        </strong>
                                        <select name="inputGenero" required="true" class="form-control">
                                            <option value="M"><%=resource.getString("masculino")%></option>
                                            <option value="F"><%=resource.getString("femenino")%></option>
                                            <option value="O"><%=resource.getString("otro")%></option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputTipoDocumento">
                                                <%=resource.getString("tipoId")%>*
                                            </label> 
                                        </strong>
                                        <select name="inputTipoDocumento" required="true" class="form-control">
                                            <option value="CC"><%=resource.getString("cc")%></option>
                                            <option value="CE"><%=resource.getString("ce")%></option>
                                            <option value="PP"><%=resource.getString("pp")%></option>
                                            <option value="TI"><%=resource.getString("ti")%></option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputID">
                                                <%=resource.getString("numero")%>*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="30" name="inputID" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputCorreo">
                                                <%=resource.getString("correo")%>*
                                            </label> 
                                        </strong>
                                        <div class="input-group">
                                            <input type="email" maxlength="80" name="inputCorreo" required="true" class="form-control"/>
                                            <span class="input-group-addon">@</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputDireccionEntrega">
                                                <%=resource.getString("direccion")%>*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="60" name="inputDireccionEntrega" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputTelefono">
                                                <%=resource.getString("telefono")%>
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="10" name="inputTelefono" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputUsuario">
                                                <%=resource.getString("usuario")%>*
                                            </label> 
                                        </strong>
                                        <input type="text" maxlength="20" name="inputUsuario" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputContrasenia">
                                                <%=resource.getString("contraseña")%>*
                                            </label> 
                                        </strong>
                                        <input type="password" maxlength="20" name="inputContrasenia" required="true" class="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>
                                            <label for="inputContraseniaConfirma">
                                                <%=resource.getString("conectado")%>*
                                            </label> 
                                        </strong>
                                        <input type="password" maxlength="45" name="inputContraseniaConfirma" required="true" class="form-control"/>
                                    </div>
                                </fieldset>
                                <button type="submit" class="btn btn-success"><%=resource.getString("registrar")%></button>
                                <span></span>
                                <span></span>
                            </form>
                        </div>
                        <div class="col-md-4 column">
                            <h2 class="info">
                                <%=resource.getString("infoRegistro")%>
                            </h2>
                            <p>
                               <%=resource.getString("infoRegistro2")%> 
                            </p>
                        </div>
                    </div>
                </div>
                <div class="row col-md-12">
                    <div class="col-md-11">
                    </div>
                    <div class="col-md-1">
                        <form action="atrasInicioCliente">
                            <input type="submit" name="Atras" class="btn btn-danger right" value="<%=resource.getString("atras")%>"/>
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
