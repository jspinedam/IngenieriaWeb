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
 * InterfaceRemota: GestionarGuiasCompraBO Esta interface contiene los metodos
 * del bean de negocio GestionarGuiasCompraBO
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Remote
public interface AdministrarGestionarGuiasCompraBORemote {

    /**
     * Metodo encargado de obtener la lista de GuiaCompraProducto registrados en
     * la base de datos
     *
     * @return Lista de GuiaCompraProducto
     */
    public List<GuiaCompraProducto> consultarGuiasCompraProductoRegistradas();

    /**
     * Metodo encargado de obtener la lista de GuiaCompraLocal registrados en la
     * base de datos
     *
     * @return Lista de GuiaCompraLocal
     */
    public List<GuiaCompraLocal> consultarGuiasCompraLocalRegistradas();

    /**
     * Metodo encargado de obtener la lista de GuiaCompraLocal por medio de
     * parametros de busqueda
     *
     * @param filtros Parametros de busqueda
     * @return Lista de GuiaCompraLocal
     */
    public List<GuiaCompraLocal> consultarGuiasCompraLocalPorParametro(Map<String, String> filtros);

    /**
     * Metodo encargado de obtener la lista de GuiaCompraProducto por medio de
     * parametros de busqueda
     *
     * @param filtros Parametros de busqueda
     * @return Lista de GuiaCompraProducto
     */
    public List<GuiaCompraProducto> consultarGuiasCompraProductoPorParametro(Map<String, String> filtros);

    /**
     * Metodo encargado de obtener una GuiaCompraLocal por su id
     *
     * @param idGuiaCompra Id a buscar
     * @return GuiaCompraLocal referenciado por el id dado
     */
    public GuiaCompraLocal obtenerGuiaCompraLocalPorID(BigInteger idGuiaCompra);

    /**
     * Metodo encargado de obtener una GuiaCompraProducto por su id
     *
     * @param idGuiaCompra Id a buscar
     * @return GuiaCompraProducto referenciado por el id dado
     */
    public GuiaCompraProducto obtenerGuiaCompraProductoPorID(BigInteger idGuiaCompra);

    /**
     * Metodo encargado de actualizar la informacion de una guiacompralocal
     *
     * @param guiaCompra GuiaCompra a editar
     * @param guiaCompraLocal GuiaCompraLocal a editar
     */
    public void actualizarInformacionGuiaCompraLocal(GuiaCompra guiaCompra, GuiaCompraLocal guiaCompraLocal);

    /**
     * Metodo encargado de actializar la informacion de una guiacompraproducto
     *
     * @param guiaCompra GuiaCompra a editar
     * @param guiaCompraProducto GuiaCompraProducto a editar
     */
    public void actualizarInformacionGuiaCompraProducto(GuiaCompra guiaCompra, GuiaCompraProducto guiaCompraProducto);

    /**
     * Metodo encargado de registrar una guiacompralocal en la base de datos
     *
     * @param guiaCompraNuevo Nueva GuiaCompra
     * @param guiaCompraLocalNuevo Nueva GuiaCompraLocal
     */
    public void almacenarNuevoGuiaCompraLocalEnSistema(GuiaCompra guiaCompraNuevo, GuiaCompraLocal guiaCompraLocalNuevo);

    /**
     * Metodo encargado de registrar una guiacompraproducto en la base de datos
     *
     * @param guiaCompraNuevo Nueva GuiaCompra
     * @param guiaCompraProductoNuevo Nueva GuiaCompraProducto
     */
    public void almacenarNuevoGuiaCompraProductoEnSistema(GuiaCompra guiaCompraNuevo, GuiaCompraProducto guiaCompraProductoNuevo);
}
