/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shooppingcenter.facede.ProductoFacade;
import com.shoppingcenter.entidades.Producto;
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
public class AdministrarGestionarProductosBO implements AdministrarGestionarProductosBORemote {

    @EJB
    private ProductoFacade productoFacade;

    @Override
    public List<Producto> consultarProductosPorParametro(Map<String, String> filtros) {
        try {
            List<Producto> lista = productoFacade.buscarProductosPorFiltrado(filtros);
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarProductosBO consultarProductosPorParametro : " + e.toString());
            return null;
        }
    }

    @Override
    public Producto obtenerProductoPorID(BigInteger idProducto) {
        try {
            Producto registro = productoFacade.buscarProductoPorID(idProducto);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarProductosBO obtenerProductoPorID : " + e.toString());
            return null;
        }
    }

    @Override
    public void actualizarInformacionProducto(Producto producto) {
        try {
            productoFacade.edit(producto);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarProductosBO actualizarInformacionProductov : " + e.toString());
        }
    }

    @Override
    public void almacenarNuevoProductoEnSistema(Producto productoNuevo) {
        try {
            productoFacade.create(productoNuevo);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarProductosBO almacenarNuevoProductoEnSistema : " + e.toString());
        }
    }

    @Override
    public Producto obtenerProductoPorCodigoYLocal(String codigo, BigInteger local) {
        try {
            Producto registro = productoFacade.buscarProductoPorCodigoYLocal(codigo, local);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarProductosBO obtenerProductoPorCodigoYLocal : " + e.toString());
            return null;
        }
    }
}
