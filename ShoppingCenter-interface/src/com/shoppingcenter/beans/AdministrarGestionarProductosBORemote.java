/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.Producto;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 * InterfaceRemota: GestionarProductosBO Esta interface contiene los metodos del
 * bean de negocio GestionarProductosBO
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Remote
public interface AdministrarGestionarProductosBORemote {

    /**
     * Metodo encargado de obtener los registro Producto por medio de parametros
     * de busqueda
     *
     * @param filtros Parametros de busqueda
     * @return Lista de Producto
     */
    public List<Producto> consultarProductosPorParametro(Map<String, String> filtros);

    /**
     * Metodo encargado de obtener un Producto por su id
     *
     * @param idProducto Id del Producto
     * @return Producto referenciado por el id dado
     */
    public Producto obtenerProductoPorID(BigInteger idProducto);

    /**
     * Metodo encargado de actualizar la informacion de un Producto
     *
     * @param producto Producto a editar
     */
    public void actualizarInformacionProducto(Producto producto);

    /**
     * Metodo encargado de registrar un Producto en la base de datos
     *
     * @param productoNuevo Producto a registrar
     */
    public void almacenarNuevoProductoEnSistema(Producto productoNuevo);

    /**
     * Metodo encarado de obtener un Producto por su codigo y local
     *
     * @param codigo Codigo a buscar
     * @param local Local a buscar
     * @return Producto referenciado por los parametros
     */
    public Producto obtenerProductoPorCodigoYLocal(String codigo, BigInteger local);
}
