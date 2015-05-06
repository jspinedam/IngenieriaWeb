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
 *
 * @author Pineda
 */
@Remote
public interface AdministrarIndexBORemote {

    public Persona obtenerPersonaPorNumeroDocumento(String documento);

    public Boolean validarUsuarioNuevaPersona(String usuario);

    public void registrarNuevoCliente(Persona nuevaPersona, Cliente nuevoCliente);

    public Persona obtenerPersonaPorUserContrasenia(String usuario, String contrasenia);

    public Administrador obtenerAdministradorPorIDPersona(BigInteger idPersona);

    public Trabajador obtenerTrabajadorPorIDPersona(BigInteger idPersona);

    public Cliente obtenerClientePorIDPersona(BigInteger idPersona);
}
