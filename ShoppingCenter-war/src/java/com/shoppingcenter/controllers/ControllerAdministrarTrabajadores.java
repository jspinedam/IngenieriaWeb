/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarTrabajadoresBORemote;
import com.shoppingcenter.entidades.Trabajador;
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
public class ControllerAdministrarTrabajadores implements Serializable {

    AdministrarGestionarTrabajadoresBORemote administrarGestionarTrabajadoresBO = lookupAdministrarGestionarTrabajadoresBORemote();

    private String parametroNombre, parametroApellido, parametroDocumento;
    private String parametroTipoDocumento, parametroCorreo, parametroUsuario;
    private int parametroEstado, parametroGenero;
    private Map<String, String> filtros;
    private List<Trabajador> listaTrabajadores;

    /**
     * Creates a new instance of ControllerAdministrarTrabajadores
     */
    public ControllerAdministrarTrabajadores() {
    }

    @PostConstruct
    public void init() {
        parametroNombre = null;
        parametroApellido = null;
        parametroDocumento = null;
        parametroCorreo = null;
        parametroTipoDocumento = null;
        parametroUsuario = null;
        parametroEstado = 1;
        parametroTipoDocumento = "CC";
        parametroGenero = 1;
    }

    /**
     * Metodo encargado de inicializar los filtros de busqueda para el proceso
     * de consulta de trabajadores
     */
    private void inicializarFiltros() {
        filtros = new HashMap<String, String>();
        filtros.put("parametroNombre", null);
        filtros.put("parametroApellido", null);
        filtros.put("parametroDocumento", null);
        filtros.put("parametroTipoDocumento", null);
        filtros.put("parametroCorreo", null);
        filtros.put("parametroUsuario", null);
        filtros.put("parametroEstado", null);
        filtros.put("parametroGenero", null);
        agregarFiltrosAdicionales();
    }

    /**
     * Metodo encargado de agregar los valores al filtro de busqueda
     */
    private void agregarFiltrosAdicionales() {
        if ((Utilidades.validarNulo(parametroUsuario) == true) && (!parametroUsuario.isEmpty())) {
            filtros.put("parametroUsuario", parametroUsuario);
        }
        if ((Utilidades.validarNulo(parametroNombre) == true) && (!parametroNombre.isEmpty())) {
            filtros.put("parametroNombre", parametroNombre);
        }
        if ((Utilidades.validarNulo(parametroApellido) == true) && (!parametroApellido.isEmpty())) {
            filtros.put("parametroApellido", parametroApellido);
        }
        if ((Utilidades.validarNulo(parametroDocumento) == true) && (!parametroDocumento.isEmpty())) {
            filtros.put("parametroDocumento", parametroDocumento);
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
        if (1 == parametroGenero) {
            filtros.put("parametroGenero", "M");
        } else {
            if (parametroGenero == 2) {
                filtros.put("parametroGenero", "F");
            }
        }
        if (!"TODOS".equalsIgnoreCase(parametroTipoDocumento)) {
            filtros.put("parametroTipoDocumento", parametroTipoDocumento);
        }
    }

    /**
     * Metodo encargado de buscar los trabajadores por medio de los parametros
     * ingresados por el usuario
     */
    public String buscarTrabajadoresPorParametros() {
        try {
            inicializarFiltros();
            listaTrabajadores = null;
            //listaTrabajadores = administrarGestionarTrabajadoresBO.consultarTrabajadoresPorParametro(filtros);
            return null;
        } catch (Exception e) {
            System.out.println("Error ControllerAdministrarTrabajadores buscarTrabajadoresPorParametros : " + e.toString());
            return null;
        }
    }

    /**
     *
     * Metodo encargado de limpiar los parametros de busqueda
     */
    public void limpiarProcesoBusqueda() {
        parametroEstado = 1;
        parametroNombre = null;
        parametroApellido = null;
        parametroDocumento = null;
        parametroTipoDocumento = null;
        parametroCorreo = null;
        parametroUsuario = null;
        parametroEstado = 1;
        parametroGenero = 1;
        listaTrabajadores = null;
        inicializarFiltros();
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

    public String getParametroNombre() {
        return parametroNombre;
    }

    public void setParametroNombre(String parametroNombre) {
        this.parametroNombre = parametroNombre;
    }

    public String getParametroApellido() {
        return parametroApellido;
    }

    public void setParametroApellido(String parametroApellido) {
        this.parametroApellido = parametroApellido;
    }

    public String getParametroDocumento() {
        return parametroDocumento;
    }

    public void setParametroDocumento(String parametroDocumento) {
        this.parametroDocumento = parametroDocumento;
    }

    public String getParametroTipoDocumento() {
        return parametroTipoDocumento;
    }

    public void setParametroTipoDocumento(String parametroTipoDocumento) {
        this.parametroTipoDocumento = parametroTipoDocumento;
    }

    public String getParametroCorreo() {
        return parametroCorreo;
    }

    public void setParametroCorreo(String parametroCorreo) {
        this.parametroCorreo = parametroCorreo;
    }

    public String getParametroUsuario() {
        return parametroUsuario;
    }

    public void setParametroUsuario(String parametroUsuario) {
        this.parametroUsuario = parametroUsuario;
    }

    public int getParametroEstado() {
        return parametroEstado;
    }

    public void setParametroEstado(int parametroEstado) {
        this.parametroEstado = parametroEstado;
    }

    public int getParametroGenero() {
        return parametroGenero;
    }

    public void setParametroGenero(int parametroGenero) {
        this.parametroGenero = parametroGenero;
    }

    public Map<String, String> getFiltros() {
        return filtros;
    }

    public void setFiltros(Map<String, String> filtros) {
        this.filtros = filtros;
    }

    public List<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(List<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

}
