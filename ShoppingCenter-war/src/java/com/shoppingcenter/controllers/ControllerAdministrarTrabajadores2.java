/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarTrabajadoresBORemote;
import com.shoppingcenter.entidades.Trabajador;
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
public class ControllerAdministrarTrabajadores2 implements Serializable {

    AdministrarGestionarTrabajadoresBORemote administrarGestionarTrabajadoresBO = lookupAdministrarGestionarTrabajadoresBORemote();

    private List<Trabajador> listaTrabajadores;

    public ControllerAdministrarTrabajadores2() {
    }

    @PostConstruct
    public void init() {
        listaTrabajadores = administrarGestionarTrabajadoresBO.consultarTrabajadoresRegistrados();
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

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

}
