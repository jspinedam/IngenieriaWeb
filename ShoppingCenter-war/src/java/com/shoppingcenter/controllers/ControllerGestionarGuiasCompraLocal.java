/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarGuiasCompraBORemote;
import com.shoppingcenter.entidades.GuiaCompraLocal;
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
public class ControllerGestionarGuiasCompraLocal implements Serializable {

    AdministrarGestionarGuiasCompraBORemote administrarGestionarGuiasCompraBO = lookupAdministrarGestionarGuiasCompraBORemote();

    private List<GuiaCompraLocal> listaGuiasCompra;

    public ControllerGestionarGuiasCompraLocal() {
    }

    @PostConstruct
    public void init() {
        listaGuiasCompra = administrarGestionarGuiasCompraBO.consultarGuiasCompraLocalRegistradas();
    }

    private AdministrarGestionarGuiasCompraBORemote lookupAdministrarGestionarGuiasCompraBORemote() {
        try {
            Context c = new InitialContext();
            return (AdministrarGestionarGuiasCompraBORemote) c.lookup("java:global/ShoppingCenter/ShoppingCenter-ejb/AdministrarGestionarGuiasCompraBO!com.shoppingcenter.beans.AdministrarGestionarGuiasCompraBORemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public List<GuiaCompraLocal> getListaGuiasCompra() {
        return listaGuiasCompra;
    }

    public void setListaGuiasCompra(List<GuiaCompraLocal> listaGuiasCompra) {
        this.listaGuiasCompra = listaGuiasCompra;
    }

}
