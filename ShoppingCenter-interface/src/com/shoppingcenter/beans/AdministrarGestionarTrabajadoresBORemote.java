/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.LocalCentroComercial;
import com.shoppingcenter.entidades.Persona;
import com.shoppingcenter.entidades.Trabajador;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 * InterfaceRemota: GestionarTrabajadoresBO Esta interface contiene los metodos
 * del bean de negocio GestionarTrabajadoresBO
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Remote
public interface AdministrarGestionarTrabajadoresBORemote {

    /**
     * Metodo encargado de obtener los registros Trabajador de la base de datos
     *
     * @return Lista de Trabajador
     */
    public List<Trabajador> consultarTrabajadoresRegistrados();

    /**
     * Metodo encargado de obtener los registros LocalCentroComercial de la base
     * de datos
     *
     * @return Lista de LocalCentroComercial
     */
    public List<LocalCentroComercial> consultarLocalesRegistrados();

    /**
     * Metodo encargado de obtener los registros Trabajador por parametros de
     * busqueda
     *
     * @param filtros Parametros de busqueda
     * @return Lista de Trabajador
     */
    public List<Trabajador> consultarTrabajadoresPorParametro(Map<String, String> filtros);

    /**
     * Metodo encargado de obtener un registro Trabajador por su id
     *
     * @param idTrabajador Id trabajador
     * @return Trabajador referenciado por el id dado
     */
    public Trabajador obtenerTrabajadorPorID(BigInteger idTrabajador);

    /**
     * Metodo encargado de actualizar la informacion de un Trabajador
     *
     * @param persona Persona a editar
     * @param trabajador Trabajador a editar
     */
    public void actualizarInformacionTrabajador(Persona persona, Trabajador trabajador);

    /**
     * Metodo encargado de registrar un Trabajadador en la base de datos
     *
     * @param personaNuevo Persona nueva
     * @param trabajadorNuevo Trabajador nuevo
     */
    public void almacenarNuevoTrabajadorEnSistema(Persona personaNuevo, Trabajador trabajadorNuevo);

    /**
     * Metodo encargado de obtener una Persona por su documento
     *
     * @param documento Documento a buscar
     * @return Persona referenciada por el documento
     */
    public Persona obtenerPersonaPorNumeroDocumento(String documento);

    /**
     * Metodo encargado de validar el usuario de una persona
     *
     * @param usuario Usuario a validar
     * @return true -> usuario no existe / false -> usuario ya existe
     */
    public Boolean validarUsuarioNuevaPersona(String usuario);
}
