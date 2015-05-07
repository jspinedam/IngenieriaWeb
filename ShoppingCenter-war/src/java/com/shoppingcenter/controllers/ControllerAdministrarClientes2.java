/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarClientesBORemote;
import com.shoppingcenter.entidades.Cliente;
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
public class ControllerAdministrarClientes2 implements Serializable {

    AdministrarGestionarClientesBORemote administrarGestionarClientesBO = lookupAdministrarGestionarClientesBORemote();

    private List<Cliente> listaClientes;

    public ControllerAdministrarClientes2() {
    }

    @PostConstruct
    public void init() {
        listaClientes = administrarGestionarClientesBO.consultarClientesRegistrados();
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

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

}
