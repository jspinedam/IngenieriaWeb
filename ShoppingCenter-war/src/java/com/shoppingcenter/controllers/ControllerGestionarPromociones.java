/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarPromocionesBORemote;
import com.shoppingcenter.entidades.Promocion;
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
public class ControllerGestionarPromociones implements Serializable {

    AdministrarGestionarPromocionesBORemote administrarGestionarPromocionesBO = lookupAdministrarGestionarPromocionesBORemote();

    private List<Promocion> listaPromociones;

    public ControllerGestionarPromociones() {
    }

    @PostConstruct
    public void init() {
        listaPromociones = administrarGestionarPromocionesBO.consultarPromocionesRegistradas();
    }

    public List<Promocion> getListaPromociones() {
        return listaPromociones;
    }

    public void setListaPromociones(List<Promocion> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }

    private AdministrarGestionarPromocionesBORemote lookupAdministrarGestionarPromocionesBORemote() {
        try {
            Context c = new InitialContext();
            return (AdministrarGestionarPromocionesBORemote) c.lookup("java:global/ShoppingCenter/ShoppingCenter-ejb/AdministrarGestionarPromocionesBO!com.shoppingcenter.beans.AdministrarGestionarPromocionesBORemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
