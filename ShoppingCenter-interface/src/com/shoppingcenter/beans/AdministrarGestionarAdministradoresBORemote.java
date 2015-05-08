/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.Administrador;
import com.shoppingcenter.entidades.Persona;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 * InterfaceRemota: GestionarAdministradoresBO Esta interface contiene los
 * metodos del bean de negocio GestionarAdministradoresBO
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Remote
public interface AdministrarGestionarAdministradoresBORemote {

    /**
     * Metodo encargado de obtener los Administradores registrados en la base de
     * datos
     *
     * @return Lista de registros administrador
     */
    public List<Administrador> consultarAdministradoresRegistrados();

    /**
     * Metodo encargado de obtener los Administradores registrados en la base de
     * datos por medio de filtros de busqueda
     *
     * @param filtros
     * @return
     */
    public List<Administrador> consultarAdministradoresPorParametro(Map<String, String> filtros);

    /**
     * Metodo encargado de obtener un administrador por medio de su ID
     *
     * @param idAdministrador Id del administrador
     * @return Administrador registrado con el id dado
     */
    public Administrador obtenerAdministradorPorID(BigInteger idAdministrador);

    /**
     * Metodo encargado de actualizar la información de un administrador
     *
     * @param persona Persona a editar
     * @param administrador Administrador a editar
     */
    public void actualizarInformacionAdministrador(Persona persona, Administrador administrador);

    /**
     * Metodo encargado de registrar un administrador en el sistema
     *
     * @param personaNuevo Nueva persona
     * @param administradorNuevo Nuevo administrador
     */
    public void almacenarNuevoAdministradorEnSistema(Persona personaNuevo, Administrador administradorNuevo);

    /**
     * Metodo encargado de obtener un registro persona por su documento
     *
     * @param documento Documento a buscar
     * @return Persona registrado con el documento
     */
    public Persona obtenerPersonaPorNumeroDocumento(String documento);

    /**
     * Metodo encargado de obtener un registro persona por su usuario
     *
     * @param usuario Usuario a buscar
     * @return Persona resgistrado con el usuario
     */
    public Boolean validarUsuarioNuevaPersona(String usuario);
}
