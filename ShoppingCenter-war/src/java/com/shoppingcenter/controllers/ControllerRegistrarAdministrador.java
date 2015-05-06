/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarAdministradoresBORemote;
import com.shoppingcenter.entidades.Administrador;
import com.shoppingcenter.entidades.Persona;
import com.shoppingcenter.utilidades.Utilidades;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Pineda
 */
public class ControllerRegistrarAdministrador implements Serializable {

    AdministrarGestionarAdministradoresBORemote administrarGestionarAdministradoresBO = lookupAdministrarGestionarAdministradoresBORemote();

    private String inputNombre, inputApellido, inputEmail, inputID, inputGenero, inputTipoDocumento;
    private String inputUsuario, inputContrasenia, inputContraseniaConfirma, inputTelefono;
    private String inputCargo;

    public void ControllerRegistrarAdministrador() {
    }

    @PostConstruct
    public void init() {
        inputNombre = null;
        inputEmail = null;
        inputApellido = null;
        inputID = null;
        inputContrasenia = null;
        inputCargo = null;
        inputTelefono = null;
        inputContraseniaConfirma = null;
        inputUsuario = null;
        inputGenero = "M";
        inputTipoDocumento = "CC";
    }

    /**
     * Metodo encargado de validar el Nombre y Apellido del nuevo administrador
     *
     * @return true - Campos correctos / false - Campos erroneos
     */
    public boolean validarNombreApellidoAdministrador() {
        boolean retorno = true;
        if ((Utilidades.validarNulo(inputNombre)) && (Utilidades.validarNulo(inputApellido))) {
            if (!Utilidades.validarCaracterString(inputNombre)) {
                retorno = false;
            }
            if (!Utilidades.validarCaracterString(inputApellido)) {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar el correo del administrador
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarCorreoAdministrador() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputEmail)) {
            System.out.println("Aca");
            System.out.println("inputCorreo : " + inputEmail);
            if (Utilidades.validarCorreoElectronico(inputEmail)) {
                System.out.println("bien");
            } else {
                System.out.println("mal");
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar el ID del administrador
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarIdentificacionAdministrador() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputID)) {
            if (Utilidades.validarIdentificacionesDirecciones(inputID)) {
            } else {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar los campos numericos de telefonos
     *
     * @return true - Campos correctos / false - Campos erroneos
     */
    public boolean validarDatosNumericosAdministrador() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputTelefono)) {
            if ((Utilidades.isNumber(inputTelefono)) == false) {
                retorno = false;
            }
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar la dirección del administrador
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarCargoAdministrador() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputCargo)) {
            if (Utilidades.validarIdentificacionesDirecciones(inputCargo)) {
            } else {
                retorno = false;
            }
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar los campos relacionados el usuario del
     * administrador
     *
     * @return true - Campos correctos / false - Campos erroneos
     */
    public boolean validarDatosUserPassAdministrador() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputUsuario) && Utilidades.validarNulo(inputContrasenia)
                && Utilidades.validarNulo(inputContraseniaConfirma)) {
            if (inputContrasenia.equals(inputContraseniaConfirma)) {
            } else {
                retorno = false;
            }
            Boolean usuarioYaRegitrado = administrarGestionarAdministradoresBO.validarUsuarioNuevaPersona(inputUsuario);
            if (usuarioYaRegitrado == true) {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado validar si el administrador registrado ya se encuentra
     * dentro del sistema de información
     *
     * @return true - El usuario no existe / false - El usuario ya existe
     */
    public boolean validarAdministradorYaRegistrado() {
        boolean retorno = true;
        Persona administradorRegistrado = administrarGestionarAdministradoresBO.obtenerPersonaPorNumeroDocumento(inputID);
        if (administradorRegistrado != null) {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado de realizar el registro y validaciones de la información
     * del nuevo administrador
     *
     * @return
     */
    public String registrarNuevoAdministrador() {
        String mensajeRetorno = "";
        if (validarNombreApellidoAdministrador() == true) {
            if (validarCorreoAdministrador() == true) {
                if (validarIdentificacionAdministrador() == true) {
                    if (validarDatosNumericosAdministrador() == true) {
                        if (validarCargoAdministrador() == true) {
                            if (validarDatosUserPassAdministrador() == true) {
                                if (validarAdministradorYaRegistrado() == true) {
                                    System.out.println("Ok");
                                    almacenarNuevoAdministradorEnSistema();
                                    mensajeRetorno = "success_gestionar_administradores";
                                } else {
                                    System.out.println("fallo 1");
                                    //                              context.execute("errorAdministradorRegistrado.show()");
                                    mensajeRetorno = "failure";
                                }
                            } else {
                                System.out.println("fallo 2");
                                //                        context.execute("errorUserPassAdministrador.show()");
                                mensajeRetorno = "failure";
                            }
                        } else {
                            System.out.println("fallo 3");
                            //            context.execute("errorDireccionAdministrador.show()");
                            mensajeRetorno = "failure";
                        }
                    } else {
                        System.out.println("fallo 4");
                        //      context.execute("errorNumerosAdministrador.show()");
                        mensajeRetorno = "failure";
                    }
                } else {
                    System.out.println("fallo 5");
                    //context.execute("errorDocumentoAdministrador.show()");
                    mensajeRetorno = "failure";
                }
            } else {
                System.out.println("fallo 6");
                //context.execute("errorEmailAdministrador.show()");
                mensajeRetorno = "failurerrorEmailAdministradore";
            }
        } else {
            System.out.println("fallo 7");
            //context.execute("errorNombreApellidoAdministrador.show()");
            mensajeRetorno = "failure";
        }
        return mensajeRetorno;
    }

    private void almacenarNuevoAdministradorEnSistema() {
        try {
            Persona nuevaPersona = new Persona();
            nuevaPersona.setApellido(inputApellido);
            nuevaPersona.setCorreo(inputEmail);
            nuevaPersona.setEstadoactivo(true);
            nuevaPersona.setGenero(inputGenero);
            nuevaPersona.setNombre(inputNombre);
            nuevaPersona.setNombreusuario(inputUsuario);
            nuevaPersona.setNumerodocumento(inputID);
            nuevaPersona.setPasswordusuario(inputContrasenia);
            nuevaPersona.setTelefonocontacto(inputTelefono);
            nuevaPersona.setTipodocumento(inputTipoDocumento);
            Administrador nuevoAdministrador = new Administrador();
            nuevoAdministrador.setCargo(inputCargo);
            administrarGestionarAdministradoresBO.almacenarNuevoAdministradorEnSistema(nuevaPersona, nuevoAdministrador);
        } catch (Exception e) {
            System.out.println("Error ControllerRegistrarAdministrador almacenarNuevoAdministradorEnSistema : " + e.toString());
        }
    }

    private AdministrarGestionarAdministradoresBORemote lookupAdministrarGestionarAdministradoresBORemote() {
        try {
            Context c = new InitialContext();
            return (AdministrarGestionarAdministradoresBORemote) c.lookup("java:global/ShoppingCenter/ShoppingCenter-ejb/AdministrarGestionarAdministradoresBO!com.shoppingcenter.beans.AdministrarGestionarAdministradoresBORemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public String getInputNombre() {
        return inputNombre;
    }

    public void setInputNombre(String inputNombre) {
        this.inputNombre = inputNombre;
    }

    public String getInputApellido() {
        return inputApellido;
    }

    public void setInputApellido(String inputApellido) {
        this.inputApellido = inputApellido;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public String getInputID() {
        return inputID;
    }

    public void setInputID(String inputID) {
        this.inputID = inputID;
    }

    public String getInputGenero() {
        return inputGenero;
    }

    public void setInputGenero(String inputGenero) {
        this.inputGenero = inputGenero;
    }

    public String getInputTipoDocumento() {
        return inputTipoDocumento;
    }

    public void setInputTipoDocumento(String inputTipoDocumento) {
        this.inputTipoDocumento = inputTipoDocumento;
    }

    public String getInputUsuario() {
        return inputUsuario;
    }

    public void setInputUsuario(String inputUsuario) {
        this.inputUsuario = inputUsuario;
    }

    public String getInputContrasenia() {
        return inputContrasenia;
    }

    public void setInputContrasenia(String inputContrasenia) {
        this.inputContrasenia = inputContrasenia;
    }

    public String getInputContraseniaConfirma() {
        return inputContraseniaConfirma;
    }

    public void setInputContraseniaConfirma(String inputContraseniaConfirma) {
        this.inputContraseniaConfirma = inputContraseniaConfirma;
    }

    public String getInputTelefono() {
        return inputTelefono;
    }

    public void setInputTelefono(String inputTelefono) {
        this.inputTelefono = inputTelefono;
    }

    public String getInputCargo() {
        return inputCargo;
    }

    public void setInputCargo(String inputCargo) {
        this.inputCargo = inputCargo;
    }

}
