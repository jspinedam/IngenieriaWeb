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
 *
 * @author Pineda
 */
@Remote
public interface AdministrarGestionarAdministradoresBORemote {

    public List<Administrador> consultarAdministradoresRegistrados();

    public List<Administrador> consultarAdministradoresPorParametro(Map<String, String> filtros);

    public Administrador obtenerAdministradorPorID(BigInteger idAdministrador);

    public void actualizarInformacionAdministrador(Persona persona, Administrador administrador);

    public void almacenarNuevoAdministradorEnSistema(Persona personaNuevo, Administrador administradorNuevo);

    public Persona obtenerPersonaPorNumeroDocumento(String documento);

    public Boolean validarUsuarioNuevaPersona(String usuario);
}
