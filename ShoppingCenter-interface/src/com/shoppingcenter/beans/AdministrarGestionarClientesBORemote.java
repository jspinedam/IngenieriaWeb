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
 *
 * @author Pineda
 */
@Remote
public interface AdministrarGestionarClientesBORemote {

    public List<Cliente> consultarClientesRegistrados();

    public List<Cliente> consultarClientesPorParametro(Map<String, String> filtros);

    public Cliente obtenerClientePorID(BigInteger idCliente);

    public void actualizarInformacionCliente(Persona persona, Cliente cliente);

    public void almacenarNuevoClienteEnSistema(Persona personaNuevo, Cliente clienteNuevo);

    public Persona obtenerPersonaPorNumeroDocumento(String documento);

    public Boolean validarUsuarioNuevaPersona(String usuario);

    String MetodoPrueba();
}
