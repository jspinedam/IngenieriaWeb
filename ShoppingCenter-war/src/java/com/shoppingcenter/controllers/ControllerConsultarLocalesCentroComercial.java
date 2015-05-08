/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarLocalesCentroComercialBORemote;
import com.shoppingcenter.entidades.LocalCentroComercial;
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
public class ControllerConsultarLocalesCentroComercial implements Serializable {

    AdministrarGestionarLocalesCentroComercialBORemote administrarGestionarLocalesCentroComercialBO = lookupAdministrarGestionarLocalesCentroComercialBORemote();

    private List<LocalCentroComercial> listaLocalesCentroComercial;

    public ControllerConsultarLocalesCentroComercial() {
    }

    @PostConstruct
    public void init() {
        listaLocalesCentroComercial = administrarGestionarLocalesCentroComercialBO.consultarLocalesCentroComercialRegistrados();
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

    public List<LocalCentroComercial> getListaLocalesCentroComercial() {
        return listaLocalesCentroComercial;
    }

    public void setListaLocalesCentroComercial(List<LocalCentroComercial> listaLocalesCentroComercial) {
        this.listaLocalesCentroComercial = listaLocalesCentroComercial;
    }

}
