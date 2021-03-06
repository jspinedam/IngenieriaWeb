/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarClientesBORemote;
import com.shoppingcenter.entidades.Cliente;
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
public class ControllerRegistrarCliente implements Serializable {

    AdministrarGestionarClientesBORemote administrarGestionarClientesBO = lookupAdministrarGestionarClientesBORemote();

    private String inputNombre, inputApellido, inputCorreo, inputID, inputGenero, inputTipoDocumento;
    private String inputUsuario, inputContrasenia, inputContraseniaConfirma, inputTelefono;
    private String inputDireccionEntrega;

    public void ControllerRegistrarCliente() {
    }

    @PostConstruct
    public void init() {
        inputNombre = null;
        inputCorreo = null;
        inputApellido = null;
        inputID = null;
        inputContrasenia = null;
        inputDireccionEntrega = null;
        inputTelefono = null;
        inputContraseniaConfirma = null;
        inputUsuario = null;
        inputGenero = "M";
        inputTipoDocumento = "CC";
    }

    /**
     * Metodo encargado de validar el Nombre y Apellido del nuevo cliente
     *
     * @return true - Campos correctos / false - Campos erroneos
     */
    public boolean validarNombreApellidoCliente() {
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
     * Metodo encargado de validar el correo del cliente
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarCorreoCliente() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputCorreo)) {
            if (Utilidades.validarCorreoElectronico(inputCorreo)) {
            } else {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar el ID del cliente
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarIdentificacionCliente() {
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
    public boolean validarDatosNumericosCliente() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputTelefono)) {
            if ((Utilidades.isNumber(inputTelefono)) == false) {
                retorno = false;
            }
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar la dirección del cliente
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarDireccionCliente() {
        boolean retorno = true;
        System.out.println("ControllerRegistrarCliente validarDireccionCliente InputDireccion " + inputDireccionEntrega);
        if (Utilidades.validarNulo(inputDireccionEntrega)) {
            System.out.println("ControllerRegistrarCliente validarDireccionCliente 1 ");
            if (Utilidades.validarIdentificacionesDirecciones(inputDireccionEntrega)) {
                System.out.println("ControllerRegistrarCliente validarDireccionCliente 2 ");
            } else {
                retorno = false;
            }
        }
        System.out.println("ControllerRegistrarCliente validarDireccionCliente retorno : " + retorno);
        return retorno;
    }

    /**
     * Metodo encargado de validar los campos relacionados el usuario del
     * cliente
     *
     * @return true - Campos correctos / false - Campos erroneos
     */
    public boolean validarDatosUserPassCliente() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputUsuario) && Utilidades.validarNulo(inputContrasenia)
                && Utilidades.validarNulo(inputContraseniaConfirma)) {
            if (inputContrasenia.equals(inputContraseniaConfirma)) {
                Boolean usuarioYaRegitrado = administrarGestionarClientesBO.validarUsuarioNuevaPersona(inputUsuario);
                if (usuarioYaRegitrado == true) {
                    retorno = false;
                }
            } else {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado validar si el cliente registrado ya se encuentra dentro
     * del sistema de información
     *
     * @return true - El usuario no existe / false - El usuario ya existe
     */
    public boolean validarClienteYaRegistrado() {
        boolean retorno = true;
        com.shoppingcenter.entidades.Persona clienteRegistrado = administrarGestionarClientesBO.obtenerPersonaPorNumeroDocumento(inputID);
        if (clienteRegistrado != null) {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado de realizar el registro y validaciones de la información
     * del nuevo cliente
     *
     * @return
     */
    public String registrarNuevoCliente() {
        String mensajeRetorno = "";
        try {
            //RequestContext context = RequestContext.getCurrentInstance();
            System.out.println("LLegue a ControllerRegistrarCliente registrarNuevoCliente");
            if (validarNombreApellidoCliente() == true) {
                if (validarCorreoCliente() == true) {
                    if (validarIdentificacionCliente() == true) {
                        if (validarDatosNumericosCliente() == true) {
                            if (validarDireccionCliente() == true) {
                                System.out.println("5");
                                if (validarDatosUserPassCliente() == true) {
                                    System.out.println("6");
                                    if (validarClienteYaRegistrado() == true) {
                                        System.out.println("7");
                                        almacenarNuevoClienteEnSistema();
                                        mensajeRetorno = "success_inicio";
                                    } else {
                                        //                              context.execute("errorClienteRegistrado.show()");
                                        mensajeRetorno = "failure";
                                    }
                                } else {
                                    //                        context.execute("errorUserPassCliente.show()");
                                    mensajeRetorno = "failure";
                                }
                            } else {
                                //            context.execute("errorDireccionCliente.show()");
                                System.out.println("error en 4");
                                mensajeRetorno = "failure";
                            }
                        } else {
                            //      context.execute("errorNumerosCliente.show()");
                            mensajeRetorno = "failure";
                        }
                    } else {
                        //context.execute("errorDocumentoCliente.show()");
                        mensajeRetorno = "failure";
                    }
                } else {
                    //context.execute("errorEmailCliente.show()");
                    mensajeRetorno = "failure";
                }
            } else {
                //context.execute("errorNombreApellidoCliente.show()");
                mensajeRetorno = "failure";
            }
        } catch (Exception e) {
            mensajeRetorno = "failure";
        }
        return mensajeRetorno;
    }

    private void almacenarNuevoClienteEnSistema() {
        try {
            Persona nuevaPersona = new Persona();
            nuevaPersona.setApellido(inputApellido);
            nuevaPersona.setCorreo(inputCorreo);
            nuevaPersona.setEstadoactivo(true);
            nuevaPersona.setGenero(inputGenero);
            nuevaPersona.setNombre(inputNombre);
            nuevaPersona.setNombreusuario(inputUsuario);
            nuevaPersona.setNumerodocumento(inputID);
            nuevaPersona.setPasswordusuario(inputContrasenia);
            nuevaPersona.setTelefonocontacto(inputTelefono);
            nuevaPersona.setTipodocumento(inputTipoDocumento);
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setDireccionentrega(inputDireccionEntrega);
            administrarGestionarClientesBO.almacenarNuevoClienteEnSistema(nuevaPersona, nuevoCliente);
        } catch (Exception e) {
            System.out.println("Error ControllerRegistrarCliente almacenarNuevoClienteEnSistema : " + e.toString());
        }
    }

    private AdministrarGestionarClientesBORemote lookupAdministrarGestionarClientesBORemote() {
        try {
            Context c = new InitialContext();
            return (AdministrarGestionarClientesBORemote) c.lookup("java:global/ShoppingCenter/ShoppingCenter-ejb/AdministrarGestionarClientesBO!com.shoppingcenter.beans.AdministrarGestionarClientesBORemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    //GET-SET
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

    public String getInputCorreo() {
        return inputCorreo;
    }

    public void setInputCorreo(String inputCorreo) {
        this.inputCorreo = inputCorreo;
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

    public String getInputDireccionEntrega() {
        return inputDireccionEntrega;
    }

    public void setInputDireccionEntrega(String inputDireccionEntrega) {
        this.inputDireccionEntrega = inputDireccionEntrega;
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

}
