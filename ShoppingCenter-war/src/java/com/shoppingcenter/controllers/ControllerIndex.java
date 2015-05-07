/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shoppingcenter.beans.AdministrarGestionarClientesBORemote;
import com.shoppingcenter.beans.AdministrarIndexBORemote;
import com.shoppingcenter.entidades.Administrador;
import com.shoppingcenter.entidades.Cliente;
import com.shoppingcenter.entidades.Persona;
import com.shoppingcenter.entidades.Trabajador;
import com.shoppingcenter.utilidades.UsuarioLogin;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Pineda
 */
public class ControllerIndex extends ActionSupport implements Serializable, SessionAware {

    AdministrarIndexBORemote administrarIndexBO = lookupAdministrarIndexBORemote();

    private Map session;
    private String usuario, contrasenia;

    /**
     * Creates a new instance of ControllerIndex
     */
    public ControllerIndex() {
    }

    public String loginSistema() {
        String mensajeSiguiente = "";
        if (validarCredencialesLogin() == true) {
            mensajeSiguiente = "failure";
            Persona personaLogin = administrarIndexBO.obtenerPersonaPorUserContrasenia(usuario, contrasenia);
            if (null != personaLogin) {
                if (personaLogin.getTipousuario().equalsIgnoreCase("A")) {
                    Administrador objetoAdministrador = administrarIndexBO.obtenerAdministradorPorIDPersona(personaLogin.getIdpersona());
                    if (null != objetoAdministrador) {
                        UsuarioLogin usuarioLogin = new UsuarioLogin();
                        usuarioLogin.setTipoUsuario("ADMINISTRADOR");
                        usuarioLogin.setUsuarioConectado(objetoAdministrador.getPersona().getNombreusuario());
                        session.put("SESSION_USER", usuarioLogin);
                        ActionContext.getContext().setSession(session);
                        mensajeSiguiente = "success_administrador";
                    }
                } else {
                    if (personaLogin.getTipousuario().equalsIgnoreCase("C")) {
                        Cliente objetoCliente = administrarIndexBO.obtenerClientePorIDPersona(personaLogin.getIdpersona());
                        if (null != objetoCliente) {
                            UsuarioLogin usuarioLogin = new UsuarioLogin();
                            usuarioLogin.setTipoUsuario("CLIENTE");
                            usuarioLogin.setUsuarioConectado(objetoCliente.getPersona().getNombreusuario());
                            session.put("SESSION_USER", usuarioLogin);
                            ActionContext.getContext().setSession(session);
                            mensajeSiguiente = "success_cliente";
                        }
                    } else {
                        Trabajador objetoTrabajador = administrarIndexBO.obtenerTrabajadorPorIDPersona(personaLogin.getIdpersona());
                        if (null != objetoTrabajador) {
                            UsuarioLogin usuarioLogin = new UsuarioLogin();
                            usuarioLogin.setTipoUsuario("TRABAJADOR");
                            usuarioLogin.setUsuarioConectado(objetoTrabajador.getPersona().getNombreusuario());
                            session.put("SESSION_USER", usuarioLogin);
                            ActionContext.getContext().setSession(session);
                            mensajeSiguiente = "success_trabajador";
                        } else {
                            return "failure";
                        }
                    }
                }
            }
        }
        return mensajeSiguiente;
    }

    private boolean validarCredencialesLogin() {
        if ((null != usuario && !usuario.isEmpty())
                && (null != contrasenia && !contrasenia.isEmpty())) {
            return true;
        } else {
            return false;
        }
    }

    //GET-SET
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    private AdministrarIndexBORemote lookupAdministrarIndexBORemote() {
        try {
            Context c = new InitialContext();
            return (AdministrarIndexBORemote) c.lookup("java:global/ShoppingCenter/ShoppingCenter-ejb/AdministrarIndexBO!com.shoppingcenter.beans.AdministrarIndexBORemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
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

}
