/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.Administrador;
import com.shoppingcenter.entidades.Cliente;
import com.shoppingcenter.entidades.Persona;
import com.shoppingcenter.entidades.Trabajador;
import java.math.BigInteger;
import javax.ejb.Remote;

/**
 * InterfaceRemota: IndexBO Esta interface contiene los metodos del bean de
 * negocio IndexBO
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Remote
public interface AdministrarIndexBORemote {

    /**
     * Metodo encargado de obtener una persona por su documento
     *
     * @param documento Documento a buscar
     * @return Persona identificada por el documento dado
     */
    public Persona obtenerPersonaPorNumeroDocumento(String documento);

    /**
     * Metodo encargado de validar si un usuario de una persona ya esta
     * registrado
     *
     * @param usuario Usuario a validar
     * @return true -> el usuario no existe / false -> el usuario ya existe
     */
    public Boolean validarUsuarioNuevaPersona(String usuario);

    /**
     * Metodo encargado de registrar un Cliente en la base de datos
     *
     * @param nuevaPersona Nueva persona
     * @param nuevoCliente Nuevo cliente
     */
    public void registrarNuevoCliente(Persona nuevaPersona, Cliente nuevoCliente);

    /**
     * Metodo encargado de obtener una persona por su usuario y contraseña
     *
     * @param usuario Usuario persona
     * @param contrasenia Contraseña persona
     * @return Persona identificada por los parametros dados
     */
    public Persona obtenerPersonaPorUserContrasenia(String usuario, String contrasenia);

    /**
     * Metodo encargado de obtener un registro Administrador por el id de la
     * Persona
     *
     * @param idPersona Id Persona
     * @return Administrador referenciado por el id persona
     */
    public Administrador obtenerAdministradorPorIDPersona(BigInteger idPersona);

    /**
     * Metodo encargado de obtener un registro Trabajador por el id de la
     * Persona
     *
     * @param idPersona Id Persona
     * @return Trabajador referenciado por el id persona
     */
    public Trabajador obtenerTrabajadorPorIDPersona(BigInteger idPersona);

    /**
     * Metodo encargado de obtener un registro Cliente por el id de la Persona
     *
     * @param idPersona Id Persona
     * @return Cliente referenciado por el id persona
     */
    public Cliente obtenerClientePorIDPersona(BigInteger idPersona);
}
