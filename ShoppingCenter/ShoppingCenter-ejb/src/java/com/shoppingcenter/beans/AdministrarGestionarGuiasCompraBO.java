/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shooppingcenter.facede.GuiaCompraFacade;
import com.shooppingcenter.facede.GuiaCompraLocalFacade;
import com.shooppingcenter.facede.GuiaCompraProductoFacade;
import com.shoppingcenter.entidades.GuiaCompra;
import com.shoppingcenter.entidades.GuiaCompraLocal;
import com.shoppingcenter.entidades.GuiaCompraProducto;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Pineda
 */
@Stateful
public class AdministrarGestionarGuiasCompraBO implements AdministrarGestionarGuiasCompraBORemote {

    @EJB
    private GuiaCompraLocalFacade guiaCompraLocalFacade;
    @EJB
    private GuiaCompraProductoFacade guiaCompraProductoFacade;
    @EJB
    private GuiaCompraFacade guiaCompraFacade;

    @Override
    public List<GuiaCompraLocal> consultarGuiasCompraLocalPorParametro(Map<String, String> filtros) {
        try {
            List<GuiaCompraLocal> lista = guiaCompraLocalFacade.buscarGuiasCompraLocalesPorFiltrado(filtros);
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarGuiasCompraBO consultarGuiasCompraLocalPorParametro : " + e.toString());
            return null;
        }
    }

    @Override
    public List<GuiaCompraProducto> consultarGuiasCompraProductoPorParametro(Map<String, String> filtros) {
        try {
            List<GuiaCompraProducto> lista = guiaCompraProductoFacade.buscarGuiasCompraProductosPorFiltrado(filtros);
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarGuiasCompraBO consultarGuiasCompraProductoPorParametro : " + e.toString());
            return null;
        }
    }

    @Override
    public GuiaCompraLocal obtenerGuiaCompraLocalPorID(BigInteger idGuiaCompra) {
        try {
            GuiaCompraLocal registro = guiaCompraLocalFacade.buscarGuiaCompraLocalPorID(idGuiaCompra);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarGuiasCompraBO obtenerGuiaCompraLocalPorID : " + e.toString());
            return null;
        }
    }

    @Override
    public GuiaCompraProducto obtenerGuiaCompraProductoPorID(BigInteger idGuiaCompra) {
        try {
            GuiaCompraProducto registro = guiaCompraProductoFacade.buscarGuiaCompraProductoPorID(idGuiaCompra);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarGuiasCompraBO obtenerGuiaCompraProductoPorID : " + e.toString());
            return null;
        }
    }

    @Override
    public void actualizarInformacionGuiaCompraLocal(GuiaCompra guiaCompra, GuiaCompraLocal guiaCompraLocal) {
        try {
            guiaCompraFacade.edit(guiaCompra);
            guiaCompraLocalFacade.edit(guiaCompraLocal);;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarGuiasCompraBO actualizarInformacionGuiaCompraLocal : " + e.toString());
        }
    }

    @Override
    public void actualizarInformacionGuiaCompraProducto(GuiaCompra guiaCompra, GuiaCompraProducto guiaCompraProducto) {
        try {
            guiaCompraFacade.edit(guiaCompra);
            guiaCompraProductoFacade.edit(guiaCompraProducto);;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarGuiasCompraBO actualizarInformacionGuiaCompraProducto : " + e.toString());
        }
    }

    @Override
    public void almacenarNuevoGuiaCompraLocalEnSistema(GuiaCompra guiaCompraNuevo, GuiaCompraLocal guiaCompraLocalNuevo) {
        try {
            guiaCompraFacade.create(guiaCompraNuevo);
            GuiaCompra guiaCompraRegistrada = guiaCompraFacade.obtenerUltimaGuiaCompraRegistrada();
            guiaCompraLocalNuevo.setGuiacompra(guiaCompraRegistrada);
            guiaCompraLocalFacade.create(guiaCompraLocalNuevo);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarGuiasCompraBO almacenarNuevoGuiaCompraEnSistema : " + e.toString());
        }
    }

    @Override
    public void almacenarNuevoGuiaCompraProductoEnSistema(GuiaCompra guiaCompraNuevo, GuiaCompraProducto guiaCompraProductoNuevo) {
        try {
            guiaCompraFacade.create(guiaCompraNuevo);
            GuiaCompra guiaCompraRegistrada = guiaCompraFacade.obtenerUltimaGuiaCompraRegistrada();
            guiaCompraProductoNuevo.setGuiacompra(guiaCompraRegistrada);
            guiaCompraProductoFacade.create(guiaCompraProductoNuevo);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarGuiasCompraBO almacenarNuevoGuiaCompraEnSistema : " + e.toString());
        }
    }
}
