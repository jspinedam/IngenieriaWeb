/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.Promocion;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 * InterfaceRemota: GestionarPromocionesBO Esta interface contiene los metodos
 * del bean de negocio GestionarPromocionesBO
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Remote
public interface AdministrarGestionarPromocionesBORemote {

    /**
     * Metodo encargado de obtener los registros Promocion de la base de datos
     *
     * @return Lista de Promocion
     */
    public List<Promocion> consultarPromocionesRegistradas();

    /**
     * Metodo encargado de obtener los registros Promocion por medio de
     * parametros de busqueda
     *
     * @param filtros Parametros de busqueda
     * @return Lista de Promocion
     */
    public List<Promocion> consultarPromocionesPorParametro(Map<String, String> filtros);

    /**
     * Metodo encargado de obtener un registro Promocion por su id
     *
     * @param idPromocion Id de la Promocion
     * @return Promocion referenciado por el id dado
     */
    public Promocion obtenerPromocionPorID(BigInteger idPromocion);

    /**
     * Metodo encargado de actualizar la informacion de un registro Promocion
     *
     * @param promocion Promocion a editar
     */
    public void actualizarInformacionPromocion(Promocion promocion);

    /**
     * Metodo encargado de registrar un Promocion en la base de datos
     *
     * @param promocionNuevo Promocion a registrar
     */
    public void almacenarNuevoPromocionEnSistema(Promocion promocionNuevo);

    /**
     * Metodo encargado de obtener una promocion por su codigo
     *
     * @param codigo Codigo a buscar
     * @return Promocion referenciado por el codigo dado
     */
    public Promocion obtenerLocalPorCodigo(String codigo);
}
