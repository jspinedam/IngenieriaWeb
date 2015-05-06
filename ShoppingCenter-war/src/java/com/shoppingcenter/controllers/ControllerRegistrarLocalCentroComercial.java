/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarLocalesCentroComercialBORemote;
import com.shoppingcenter.entidades.LocalCentroComercial;
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
public class ControllerRegistrarLocalCentroComercial implements Serializable {

    AdministrarGestionarLocalesCentroComercialBORemote administrarGestionarLocalesCentroComercialBO = lookupAdministrarGestionarLocalesCentroComercialBORemote();

    private String inputNombre, inputRazon, inputCorreo, inputSlogan;
    private String inputTelefono, inputNumeroLocal, inputEncargado;

    public ControllerRegistrarLocalCentroComercial() {
    }

    @PostConstruct
    public void init() {
        inputNombre = null;
        inputRazon = null;
        inputCorreo = null;
        inputSlogan = null;
        inputTelefono = null;
        inputNumeroLocal = null;
        inputEncargado = null;
    }

    public boolean validarNombreLocal() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputNombre)) {
            if (!Utilidades.validarIdentificacionesDirecciones(inputNombre)) {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

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

    public boolean validarRazonSloganLocal() {
        boolean retorno = true;
        if ((Utilidades.validarNulo(inputRazon)) && (Utilidades.validarNulo(inputSlogan))) {
            if (!Utilidades.validarCaracterString(inputRazon)) {
                retorno = false;
            }
            if (!Utilidades.validarCaracterString(inputSlogan)) {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    public boolean validarDatosNumericosCliente() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputTelefono)) {
            if ((Utilidades.isNumber(inputTelefono)) == false) {
                retorno = false;
            }
        }
        return retorno;
    }

    public boolean validarNumLocal() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputNumeroLocal)) {
            if (!Utilidades.validarIdentificacionesDirecciones(inputNumeroLocal)) {
                Boolean validar = administrarGestionarLocalesCentroComercialBO.obtenerLocalPorNumeroLocal(inputNumeroLocal);
                if (validar == false) {
                    retorno = false;
                }
            }
        }
        return retorno;
    }

    public boolean validarEncargadoLocal() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputEncargado)) {
            if (!Utilidades.validarCaracterString(inputEncargado)) {
                retorno = false;
            }
        } else {
            retorno = false;
        }

        return retorno;
    }

    public String registrarNuevoLocal() {
        //RequestContext context = RequestContext.getCurrentInstance();
        String mensajeRetorno = "";
        if (validarNombreLocal() == true) {
            if (validarCorreoCliente() == true) {
                if (validarRazonSloganLocal() == true) {
                    if (validarDatosNumericosCliente() == true) {
                        if (validarNumLocal() == true) {
                            if (validarEncargadoLocal() == true) {
                                almacenarNuevoLocalEnSistema();
                                mensajeRetorno = "success_gestionar_localescentrocomercial";
                            } else {
                                //                        context.execute("errorUserPassCliente.show()");
                                mensajeRetorno = "failure";
                            }
                        } else {
                            //            context.execute("errorDireccionCliente.show()");
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
        return mensajeRetorno;
    }

    private void almacenarNuevoLocalEnSistema() {
        try {
            LocalCentroComercial localNuevo = new LocalCentroComercial();
            localNuevo.setCorreo(inputCorreo);
            localNuevo.setEstadoactivo(true);
            localNuevo.setNombre(inputNombre);
            localNuevo.setNombreencargado(inputEncargado);
            localNuevo.setNumerolocal(inputNumeroLocal);
            localNuevo.setRazonsocial(inputRazon);
            localNuevo.setSlogan(inputSlogan);
            localNuevo.setTelefono(inputTelefono);
            administrarGestionarLocalesCentroComercialBO.almacenarNuevoLocalCentroComercialEnSistema(localNuevo);
        } catch (Exception e) {
            System.out.println("Error ControllerRegistrarCliente almacenarNuevoLocalEnSistema : " + e.toString());
        }
    }

    //GET-SET
    public String getInputNombre() {
        return inputNombre;
    }

    public void setInputNombre(String inputNombre) {
        this.inputNombre = inputNombre;
    }

    public String getInputRazon() {
        return inputRazon;
    }

    public void setInputRazon(String inputRazon) {
        this.inputRazon = inputRazon;
    }

    public String getInputCorreo() {
        return inputCorreo;
    }

    public void setInputCorreo(String inputCorreo) {
        this.inputCorreo = inputCorreo;
    }

    public String getInputSlogan() {
        return inputSlogan;
    }

    public void setInputSlogan(String inputSlogan) {
        this.inputSlogan = inputSlogan;
    }

    public String getInputTelefono() {
        return inputTelefono;
    }

    public void setInputTelefono(String inputTelefono) {
        this.inputTelefono = inputTelefono;
    }

    public String getInputNumeroLocal() {
        return inputNumeroLocal;
    }

    public void setInputNumeroLocal(String inputNumeroLocal) {
        this.inputNumeroLocal = inputNumeroLocal;
    }

    public String getInputEncargado() {
        return inputEncargado;
    }

    public void setInputEncargado(String inputEncargado) {
        this.inputEncargado = inputEncargado;
    }

    private AdministrarGestionarLocalesCentroComercialBORemote lookupAdministrarGestionarLocalesCentroComercialBORemote() {
        try {
            Context c = new InitialContext();
            return (AdministrarGestionarLocalesCentroComercialBORemote) c.lookup("java:global/ShoppingCenter/ShoppingCenter-ejb/AdministrarGestionarLocalesCentroComercialBO!com.shoppingcenter.beans.AdministrarGestionarLocalesCentroComercialBORemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
