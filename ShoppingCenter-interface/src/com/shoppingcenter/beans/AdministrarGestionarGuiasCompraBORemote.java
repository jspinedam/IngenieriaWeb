/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.GuiaCompra;
import com.shoppingcenter.entidades.GuiaCompraLocal;
import com.shoppingcenter.entidades.GuiaCompraProducto;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Pineda
 */
@Remote
public interface AdministrarGestionarGuiasCompraBORemote {

    public List<GuiaCompraLocal> consultarGuiasCompraLocalPorParametro(Map<String, String> filtros);

    public List<GuiaCompraProducto> consultarGuiasCompraProductoPorParametro(Map<String, String> filtros);

    public GuiaCompraLocal obtenerGuiaCompraLocalPorID(BigInteger idGuiaCompra);

    public GuiaCompraProducto obtenerGuiaCompraProductoPorID(BigInteger idGuiaCompra);

    public void actualizarInformacionGuiaCompraLocal(GuiaCompra guiaCompra, GuiaCompraLocal guiaCompraLocal);

    public void actualizarInformacionGuiaCompraProducto(GuiaCompra guiaCompra, GuiaCompraProducto guiaCompraProducto);

    public void almacenarNuevoGuiaCompraLocalEnSistema(GuiaCompra guiaCompraNuevo, GuiaCompraLocal guiaCompraLocalNuevo);

    public void almacenarNuevoGuiaCompraProductoEnSistema(GuiaCompra guiaCompraNuevo, GuiaCompraProducto guiaCompraProductoNuevo);
}
