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
 *
 * @author Pineda
 */
@Remote
public interface AdministrarGestionarTrabajadoresBORemote {

    public List<Trabajador> consultarTrabajadoresRegistrados();

    public List<LocalCentroComercial> consultarLocalesRegistrados();

    public List<Trabajador> consultarTrabajadoresPorParametro(Map<String, String> filtros);

    public Trabajador obtenerTrabajadorPorID(BigInteger idTrabajador);

    public void actualizarInformacionTrabajador(Persona persona, Trabajador trabajador);

    public void almacenarNuevoTrabajadorEnSistema(Persona personaNuevo, Trabajador trabajadorNuevo);

    public Persona obtenerPersonaPorNumeroDocumento(String documento);

    public Boolean validarUsuarioNuevaPersona(String usuario);
}
