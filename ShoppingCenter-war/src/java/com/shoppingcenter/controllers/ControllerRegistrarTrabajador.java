/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.shoppingcenter.beans.AdministrarGestionarTrabajadoresBORemote;
import com.shoppingcenter.entidades.LocalCentroComercial;
import com.shoppingcenter.entidades.Persona;
import com.shoppingcenter.entidades.Trabajador;
import com.shoppingcenter.utilidades.Utilidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class ControllerRegistrarTrabajador extends ActionSupport implements Serializable {

    AdministrarGestionarTrabajadoresBORemote administrarGestionarTrabajadoresBO = lookupAdministrarGestionarTrabajadoresBORemote();

    private String inputNombre, inputApellido, inputCorreo, inputID, inputGenero, inputTipoDocumento;
    private String inputUsuario, inputContrasenia, inputContraseniaConfirma, inputTelefono;
    private String inputCargo;
    private LocalCentroComercial inputLocal;
    private List<LocalCentroComercial> listaLocales;
    private List<String> listaStringLocal;
    private String nombreLocal;

    public void ControllerRegistrarTrabajador() {
    }

    @PostConstruct
    public void init() {
        inputNombre = null;
        inputCorreo = null;
        inputApellido = null;
        inputID = null;
        inputContrasenia = null;
        inputCargo = null;
        inputTelefono = null;
        inputContraseniaConfirma = null;
        inputUsuario = null;
        inputGenero = "M";
        inputTipoDocumento = "CC";
        inputGenero = "M";
        inputTipoDocumento = "CC";
        inputLocal = null;
        cargarListaStringLocal();
    }

    private void cargarListaStringLocal() {
        listaLocales = administrarGestionarTrabajadoresBO.consultarLocalesRegistrados();
        listaStringLocal = new ArrayList<String>();
        if (null != listaLocales) {
            for (int i = 0; i < listaLocales.size(); i++) {
                listaStringLocal.add(listaLocales.get(i).getNombre());
            }
        }
    }

    /**
     * Metodo encargado de validar el Nombre y Apellido del nuevo trabajador
     *
     * @return true - Campos correctos / false - Campos erroneos
     */
    public boolean validarNombreApellidoTrabajador() {
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
     * Metodo encargado de validar el correo del trabajador
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarCorreoTrabajador() {
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
     * Metodo encargado de validar el ID del trabajador
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarIdentificacionTrabajador() {
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
    public boolean validarDatosNumericosTrabajador() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputTelefono)) {
            if ((Utilidades.isNumber(inputTelefono)) == false) {
                retorno = false;
            }
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar la dirección del trabajador
     *
     * @return true - Campo correcto / false - Campo erroneo
     */
    public boolean validarCargoTrabajador() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputCargo)) {
            if (Utilidades.validarCaracterString(inputCargo)) {
            } else {
                retorno = false;
            }
        }
        return retorno;
    }

    /**
     * Metodo encargado de validar los campos relacionados el usuario del
     * trabajador
     *
     * @return true - Campos correctos / false - Campos erroneos
     */
    public boolean validarDatosUserPassTrabajador() {
        boolean retorno = true;
        if (Utilidades.validarNulo(inputUsuario) && Utilidades.validarNulo(inputContrasenia)
                && Utilidades.validarNulo(inputContraseniaConfirma)) {
            if (inputContrasenia.equals(inputContraseniaConfirma)) {
            } else {
                retorno = false;
            }

            Boolean usuarioYaRegitrado = administrarGestionarTrabajadoresBO.validarUsuarioNuevaPersona(inputUsuario);
            if (usuarioYaRegitrado == true) {
                retorno = false;
            }
        } else {
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo encargado validar si el trabajador registrado ya se encuentra
     * dentro del sistema de información
     *
     * @return true - El usuario no existe / false - El usuario ya existe
     */
    public boolean validarTrabajadorYaRegistrado() {
        boolean retorno = true;
        inputLocal = localSeleccionadoPorUsuario();
        Persona trabajadorRegistrado = administrarGestionarTrabajadoresBO.obtenerPersonaPorNumeroDocumento(inputID);
        if (trabajadorRegistrado != null) {
            retorno = false;
        }
        if (null == inputLocal) {
            retorno = false;
        }
        return retorno;
    }

    private LocalCentroComercial localSeleccionadoPorUsuario() {
        LocalCentroComercial seleccionado = null;
        getListaLocales();
        if (null != listaLocales) {
            for (int i = 0; i < listaLocales.size(); i++) {
                if (listaLocales.get(i).getNombre().equals(nombreLocal)) {
                    seleccionado = listaLocales.get(i);
                    break;
                }
            }
        }
        return seleccionado;
    }

    /**
     * Metodo encargado de realizar el registro y validaciones de la información
     * del nuevo trabajador
     *
     * @return
     */
    public String registrarNuevoTrabajador() {
        //RequestContext context = RequestContext.getCurrentInstance();
        String mensajeRetorno = "";
        System.out.println("etrno al controllador");
        if (validarNombreApellidoTrabajador() == true) {
            if (validarCorreoTrabajador() == true) {
                if (validarIdentificacionTrabajador() == true) {
                    if (validarDatosNumericosTrabajador() == true) {
                        if (validarCargoTrabajador() == true) {
                            if (validarDatosUserPassTrabajador() == true) {
                                if (validarTrabajadorYaRegistrado() == true) {
                                    almacenarNuevoTrabajadorEnSistema();
                                    mensajeRetorno = "succes_gestionar_trabajadores";
                                } else {
                                    //                              context.execute("errorTrabajadorRegistrado.show()");
                                    mensajeRetorno = "failure";
                                }
                            } else {
                                //                        context.execute("errorUserPassTrabajador.show()");
                                mensajeRetorno = "failure";
                            }
                        } else {
                            //            context.execute("errorDireccionTrabajador.show()");
                            mensajeRetorno = "failure";
                        }
                    } else {
                        //      context.execute("errorNumerosTrabajador.show()");
                        mensajeRetorno = "failure";
                    }
                } else {
                    //context.execute("errorDocumentoTrabajador.show()");
                    mensajeRetorno = "failure";
                }
            } else {
                //context.execute("errorEmailTrabajador.show()");
                mensajeRetorno = "failure";
            }
        } else {
            //context.execute("errorNombreApellidoTrabajador.show()");
            mensajeRetorno = "failure";
        }
        return mensajeRetorno;
    }

    private void almacenarNuevoTrabajadorEnSistema() {
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
            Trabajador nuevoTrabajador = new Trabajador();
            nuevoTrabajador.setLocalcentrocomercial(inputLocal);
            nuevoTrabajador.setCargo(inputCargo);
            administrarGestionarTrabajadoresBO.almacenarNuevoTrabajadorEnSistema(nuevaPersona, nuevoTrabajador);
        } catch (Exception e) {
            System.out.println("Error ControllerRegistrarTrabajador almacenarNuevoTrabajadorEnSistema : " + e.toString());

        }
    }

    public void SelectAction() {
        listaLocales = administrarGestionarTrabajadoresBO.consultarLocalesRegistrados();
        cargarListaStringLocal();
    }

    public String display() {
        return "NONE";
    }

    private AdministrarGestionarTrabajadoresBORemote lookupAdministrarGestionarTrabajadoresBORemote() {
        try {
            Context c = new InitialContext();
            return (AdministrarGestionarTrabajadoresBORemote) c.lookup("java:global/ShoppingCenter/ShoppingCenter-ejb/AdministrarGestionarTrabajadoresBO!com.shoppingcenter.beans.AdministrarGestionarTrabajadoresBORemote");
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

    public LocalCentroComercial getInputLocal() {
        return inputLocal;
    }

    public void setInputLocal(LocalCentroComercial inputLocal) {
        this.inputLocal = inputLocal;
    }

    public List<LocalCentroComercial> getListaLocales() {
        if (null == listaLocales) {
            listaLocales = administrarGestionarTrabajadoresBO.consultarLocalesRegistrados();
        }
        return listaLocales;
    }

    public void setListaLocales(List<LocalCentroComercial> listaLocales) {
        this.listaLocales = listaLocales;
    }

    public List<String> getListaStringLocal() {
        cargarListaStringLocal();
        return listaStringLocal;
    }

    public void setListaStringLocal(List<String> listaStringLocal) {
        this.listaStringLocal = listaStringLocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
}
