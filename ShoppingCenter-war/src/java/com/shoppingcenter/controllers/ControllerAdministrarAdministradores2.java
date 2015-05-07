/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarAdministradoresBORemote;
import com.shoppingcenter.entidades.Administrador;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author AndresPineda
 */
public class ControllerAdministrarAdministradores2 implements Serializable {

    AdministrarGestionarAdministradoresBORemote administrarGestionarAdministradoresBO = lookupAdministrarGestionarAdministradoresBORemote();

    private List<Administrador> listaAdministradores;

    public ControllerAdministrarAdministradores2() {
    }

    @PostConstruct
    public void init() {
        listaAdministradores = administrarGestionarAdministradoresBO.consultarAdministradoresRegistrados();
    }

    public List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
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
}
