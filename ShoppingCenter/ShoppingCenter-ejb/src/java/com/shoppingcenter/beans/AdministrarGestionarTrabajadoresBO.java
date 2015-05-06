/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shooppingcenter.facede.LocalCentroComercialFacade;
import com.shooppingcenter.facede.PersonaFacade;
import com.shooppingcenter.facede.TrabajadorFacade;
import com.shoppingcenter.entidades.LocalCentroComercial;
import com.shoppingcenter.entidades.Persona;
import com.shoppingcenter.entidades.Trabajador;
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
public class AdministrarGestionarTrabajadoresBO implements AdministrarGestionarTrabajadoresBORemote {

    @EJB
    private TrabajadorFacade trabajadorFacade;
    @EJB
    private PersonaFacade personaFacade;
    @EJB
    private LocalCentroComercialFacade localCentroComercialFacade;

    @Override
    public List<LocalCentroComercial> consultarLocalesRegistrados() {
        try {
            List<LocalCentroComercial> lista = localCentroComercialFacade.findAll();
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarTrabajadoresBO consultarLocalesRegistrados : " + e.toString());
            return null;
        }
    }

    @Override
    public List<Trabajador> consultarTrabajadoresPorParametro(Map<String, String> filtros) {
        try {
            List<Trabajador> lista = trabajadorFacade.buscarTrabajadoresPorFiltrado(filtros);
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarTrabajadoresBO consultarTrabajadoresPorParametro : " + e.toString());
            return null;
        }
    }

    @Override
    public Trabajador obtenerTrabajadorPorID(BigInteger idTrabajador) {
        try {
            Trabajador registro = trabajadorFacade.buscarTrabajadorPorID(idTrabajador);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarTrabajadoresBO obtenerTrabajadorPorID : " + e.toString());
            return null;
        }
    }

    @Override
    public void actualizarInformacionTrabajador(Persona persona, Trabajador trabajador) {
        try {
            personaFacade.edit(persona);
            trabajadorFacade.edit(trabajador);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarTrabajadoresBO actualizarInformacionTrabajadorv : " + e.toString());
        }
    }

    @Override
    public void almacenarNuevoTrabajadorEnSistema(Persona personaNuevo, Trabajador trabajadorNuevo) {
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
            trabajadorNuevo.setPersona(personaRegistrada);
            trabajadorFacade.create(trabajadorNuevo);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarTrabajadoresBO almacenarNuevoTrabajadorEnSistema : " + e.toString());
        }
    }

    @Override
    public Persona obtenerPersonaPorNumeroDocumento(String documento) {
        try {
            Persona registro = personaFacade.buscarPersonaPorNumeroDocumento(documento);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarTrabajadoresBO obtenerPersonaPorNumeroDocumento : " + e.toString());
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
            System.out.println("Error AdministrarGestionarTrabajadoresBO obtenerPersonaPorNumeroDocumento : " + e.toString());
            return null;
        }
    }
}
