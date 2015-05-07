/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shooppingcenter.facede.AdministradorFacade;
import com.shooppingcenter.facede.PersonaFacade;
import com.shoppingcenter.entidades.Administrador;
import com.shoppingcenter.entidades.Persona;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Pineda
 */
@Stateful
public class AdministrarGestionarAdministradoresBO implements AdministrarGestionarAdministradoresBORemote {

    @EJB
    private AdministradorFacade administradorFacade;
    @EJB
    private PersonaFacade personaFacade;
    
    @Override
    public List<Administrador> consultarAdministradoresRegistrados(){
        try {
            List<Administrador> lista = administradorFacade.buscarAdministradoresRegistrados();
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarAdministradoresBO consultarAdministradoresRegistrados : " + e.toString());
            return null;
        }
    }

    @Override
    public List<Administrador> consultarAdministradoresPorParametro(Map<String, String> filtros) {
        try {
            List<Administrador> lista = administradorFacade.buscarAdministradorsPorFiltrado(filtros);
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarAdministradoresBO consultarAdministradoresPorParametro : " + e.toString());
            return null;
        }
    }

    @Override
    public Administrador obtenerAdministradorPorID(BigInteger idAdministrador) {
        try {
            Administrador registro = administradorFacade.buscarAdministradorPorID(idAdministrador);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarAdministradoresBO obtenerAdministradorPorID : " + e.toString());
            return null;
        }
    }

    @Override
    public void actualizarInformacionAdministrador(Persona persona, Administrador administrador) {
        try {
            personaFacade.edit(persona);
            administradorFacade.edit(administrador);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarAdministradoresBO actualizarInformacionAdministradorv : " + e.toString());
        }
    }

    @Override
    public void almacenarNuevoAdministradorEnSistema(Persona personaNuevo, Administrador administradorNuevo) {
        try {
            String original = personaNuevo.getPasswordusuario();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            personaNuevo.setPasswordusuario(sb.toString());
            personaFacade.create(personaNuevo);
            Persona personaRegistrada = personaFacade.obtenerUltimaPersonaRegistrada();
            System.out.println("personaRegistrada : " + personaRegistrada);
            administradorNuevo.setPersona(personaRegistrada);
            administradorFacade.create(administradorNuevo);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarAdministradoresBO almacenarNuevoAdministradorEnSistema : " + e.toString());
        }
    }

    @Override
    public Persona obtenerPersonaPorNumeroDocumento(String documento) {
        try {
            Persona registro = personaFacade.buscarPersonaPorNumeroDocumento(documento);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarAdministradoresBO obtenerPersonaPorNumeroDocumento : " + e.toString());
            return null;
        }
    }

    @Override
    public Boolean validarUsuarioNuevaPersona(String usuario) {
        try {
            Persona registro = personaFacade.buscarPersonaPorUsuario(usuario);
            if (null == registro) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarAdministradoresBO obtenerPersonaPorNumeroDocumento : " + e.toString());
            return null;
        }
    }
}
