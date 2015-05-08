/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.LocalCentroComercial;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 * InterfaceRemota: GestionarLocalesCentroComercialBO Esta interface contiene
 * los metodos del bean de negocio GestionarLocalesCentroComercialBO
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Remote
public interface AdministrarGestionarLocalesCentroComercialBORemote {

    /**
     * Metodo encargado de obtener los registros de LocalCentroComercial de la
     * base de datos
     *
     * @return Lista de LocalCentroComercial
     */
    public List<LocalCentroComercial> consultarLocalesCentroComercialRegistrados();

    /**
     * Metodo encargado de obtener los registros de LocalCentroComercial por
     * medio de parametros de busqueda
     *
     * @param filtros Parametros de busqueda
     * @return Lista de LocalCentroComercial
     */
    public List<LocalCentroComercial> consultarLocalesCentroComercialPorParametro(Map<String, String> filtros);

    /**
     * Metodo encargado de obtener un LocalCentroComercial por medio de su id
     *
     * @param idLocalCentroComercial Id del local
     * @return LocalCentroComercial identificado por el id dado
     */
    public LocalCentroComercial obtenerLocalCentroComercialPorID(BigInteger idLocalCentroComercial);

    /**
     * Metodo encargado de actualizar la informacion de un LocalCentroComercial
     *
     * @param localCentroComercial LocalCentroComercial a editar
     */
    public void actualizarInformacionLocalCentroComercial(LocalCentroComercial localCentroComercial);

    /**
     * Metodo encargado de registrar un LocalCentroComercial en la base de datos
     *
     * @param localCentroComercialNuevo LocalCentroComercial a registrar
     */
    public void almacenarNuevoLocalCentroComercialEnSistema(LocalCentroComercial localCentroComercialNuevo);

    /**
     * Metodo encargado de validar si el numero de local ya esta registradp
     *
     * @param numeroLocal Numero local
     * @return true -> no existe / false -> ya existe
     */
    public Boolean obtenerLocalPorNumeroLocal(String numeroLocal);
}
