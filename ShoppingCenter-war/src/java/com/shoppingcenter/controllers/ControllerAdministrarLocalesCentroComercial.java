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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ControllerAdministrarLocalesCentroComercial implements Serializable {

    AdministrarGestionarLocalesCentroComercialBORemote administrarGestionarLocalesCentroComercialBO = lookupAdministrarGestionarLocalesCentroComercialBORemote();

    private String parametroNombre, parametroNumeroLocal;
    private String parametroRazon, parametroCorreo;
    private int parametroEstado;
    private Map<String, String> filtros;
    private List<LocalCentroComercial> listaLocalesCentroComercial;

    /**
     * Creates a new instance of ControllerAdministrarLocalesCentroComercial
     */
    public ControllerAdministrarLocalesCentroComercial() {
    }

    @PostConstruct
    public void init() {
        parametroNombre = null;
        parametroNumeroLocal = null;
        parametroRazon = null;
        parametroCorreo = null;
        parametroEstado = 1;
    }

    /**
     * Metodo encargado de inicializar los filtros de busqueda para el proceso
     * de consulta de locales
     */
    private void inicializarFiltros() {
        filtros = new HashMap<String, String>();
        filtros.put("parametroNombre", null);
        filtros.put("parametroNumeroLocal", null);
        filtros.put("parametroRazon", null);
        filtros.put("parametroCorreo", null);
        filtros.put("parametroEstado", null);
        agregarFiltrosAdicionales();
    }

    /**
     * Metodo encargado de agregar los valores al filtro de busqueda
     */
    private void agregarFiltrosAdicionales() {

        if ((Utilidades.validarNulo(parametroNombre) == true) && (!parametroNombre.isEmpty())) {
            filtros.put("parametroNombre", parametroNombre);
        }
        if ((Utilidades.validarNulo(parametroNumeroLocal) == true) && (!parametroNumeroLocal.isEmpty())) {
            filtros.put("parametroNumeroLocal", parametroNumeroLocal);
        }
        if ((Utilidades.validarNulo(parametroRazon) == true) && (!parametroRazon.isEmpty())) {
            filtros.put("parametroRazon", parametroRazon);
        }
        if ((Utilidades.validarNulo(parametroCorreo) == true) && (!parametroCorreo.isEmpty())) {
            filtros.put("parametroCorreo", parametroCorreo);
        }
        if (1 == parametroEstado) {
            filtros.put("parametroEstado", "true");
        } else {
            if (parametroEstado == 2) {
                filtros.put("parametroEstado", "false");
            }
        }
    }

    /**
     * Metodo encargado de buscar los locales por medio de los parametros
     * ingresados por el usuario
     */
    public String buscarLocalesCentroComercialPorParametros() {
        try {
            inicializarFiltros();
            listaLocalesCentroComercial = null;
            //listaLocalesCentroComercial = administrarGestionarLocalesCentroComercialBO.consultarLocalesCentroComercialPorParametro(filtros);
            return null;
        } catch (Exception e) {
            System.out.println("Error ControllerAdministrarLocalesCentroComercial buscarLocalesCentroComercialPorParametros : " + e.toString());
            return null;
        }
    }

    /**
     *
     * Metodo encargado de limpiar los parametros de busqueda
     */
    public void limpiarProcesoBusqueda() {
        parametroNombre = null;
        parametroNumeroLocal = null;
        parametroRazon = null;
        parametroCorreo = null;
        parametroEstado = 1;
        listaLocalesCentroComercial = null;
        inicializarFiltros();
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

    public String getParametroNombre() {
        return parametroNombre;
    }

    public void setParametroNombre(String parametroNombre) {
        this.parametroNombre = parametroNombre;
    }

    public String getParametroNumeroLocal() {
        return parametroNumeroLocal;
    }

    public void setParametroNumeroLocal(String parametroNumeroLocal) {
        this.parametroNumeroLocal = parametroNumeroLocal;
    }

    public String getParametroRazon() {
        return parametroRazon;
    }

    public void setParametroRazon(String parametroRazon) {
        this.parametroRazon = parametroRazon;
    }

    public String getParametroCorreo() {
        return parametroCorreo;
    }

    public void setParametroCorreo(String parametroCorreo) {
        this.parametroCorreo = parametroCorreo;
    }

    public int getParametroEstado() {
        return parametroEstado;
    }

    public void setParametroEstado(int parametroEstado) {
        this.parametroEstado = parametroEstado;
    }

    public Map<String, String> getFiltros() {
        return filtros;
    }

    public void setFiltros(Map<String, String> filtros) {
        this.filtros = filtros;
    }

    public List<LocalCentroComercial> getListaLocalesCentroComercial() {
        return listaLocalesCentroComercial;
    }

    public void setListaLocalesCentroComercial(List<LocalCentroComercial> listaLocalesCentroComercial) {
        this.listaLocalesCentroComercial = listaLocalesCentroComercial;
    }

}
