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
 *
 * @author Pineda
 */
@Remote
public interface AdministrarGestionarProductosBORemote {

    public List<Producto> consultarProductosPorParametro(Map<String, String> filtros);

    public Producto obtenerProductoPorID(BigInteger idProducto);

    public void actualizarInformacionProducto(Producto producto);

    public void almacenarNuevoProductoEnSistema(Producto productoNuevo);

    public Producto obtenerProductoPorCodigoYLocal(String codigo, BigInteger local);
}
