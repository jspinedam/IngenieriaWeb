/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.Cliente;
import com.shoppingcenter.entidades.Persona;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 * InterfaceRemota: GestionarClientesBO Esta interface contiene los metodos del
 * bean de negocio GestionarClientesBO
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Remote
public interface AdministrarGestionarClientesBORemote {

    /**
     * Metodo encargado de obtener todos los registros cliente de la base de
     * datos
     *
     * @return Lista de clientes registrados
     */
    public List<Cliente> consultarClientesRegistrados();

    /**
     * Metodo encargao de obtener todos los registros cliente de la base de
     * datos por medio de los filtros de busqueda
     *
     * @param filtros Filtros de busqueda
     * @return Lista de clientes
     */
    public List<Cliente> consultarClientesPorParametro(Map<String, String> filtros);

    /**
     * Metodo encargado de obtener un cliente por su id
     *
     * @param idCliente Id ciente a buscar
     * @return Cliente referenciado por el id dado
     */
    public Cliente obtenerClientePorID(BigInteger idCliente);

    /**
     * Metodo encargado de actualizar la información de un cliente
     *
     * @param persona Persona a editar
     * @param cliente Cliente a editar
     */
    public void actualizarInformacionCliente(Persona persona, Cliente cliente);

    /**
     * Metdo encargado de registrar un cliente en el sistema
     *
     * @param personaNuevo Nueva persona
     * @param clienteNuevo Nuevo cliente
     */
    public void almacenarNuevoClienteEnSistema(Persona personaNuevo, Cliente clienteNuevo);

    /**
     * Metodo encargado de obtener una persona por su numero documento
     *
     * @param documento Documento a buscar
     * @return Persona identificada por el numero documento
     */
    public Persona obtenerPersonaPorNumeroDocumento(String documento);

    /**
     * Metodo encargado de obtener una persona por su usuario
     *
     * @param usuario Usuario a buscar
     * @return Persona identificada por el usuario
     */
    public Boolean validarUsuarioNuevaPersona(String usuario);

    String MetodoPrueba();
}
