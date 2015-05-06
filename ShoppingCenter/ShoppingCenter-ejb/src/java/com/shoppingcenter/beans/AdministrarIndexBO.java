/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shooppingcenter.facede.AdministradorFacade;
import com.shooppingcenter.facede.ClienteFacade;
import com.shooppingcenter.facede.PersonaFacade;
import com.shooppingcenter.facede.TrabajadorFacade;
import com.shoppingcenter.entidades.Administrador;
import com.shoppingcenter.entidades.Cliente;
import com.shoppingcenter.entidades.Persona;
import com.shoppingcenter.entidades.Trabajador;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Pineda
 */
@Stateful
public class AdministrarIndexBO implements AdministrarIndexBORemote {

    @EJB
    private PersonaFacade personaFacade;
    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private TrabajadorFacade trabajadorFacade;
    @EJB
    private AdministradorFacade administradorFacade;

    @Override
    public Persona obtenerPersonaPorNumeroDocumento(String documento) {
        try {
            Persona registro = personaFacade.buscarPersonaPorNumeroDocumento(documento);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarIndexBO obtenerPersonaPorNumeroDocumento : " + e.toString());
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
            System.out.println("Error AdministrarIndexBO obtenerPersonaPorNumeroDocumento : " + e.toString());
            return null;
        }
    }

    @Override
    public void registrarNuevoCliente(Persona nuevaPersona, Cliente nuevoCliente) {
        try {
            personaFacade.create(nuevaPersona);
            Persona personaRegistrada = personaFacade.obtenerUltimaPersonaRegistrada();
            nuevoCliente.setPersona(personaRegistrada);
            clienteFacade.create(nuevoCliente);
        } catch (Exception e) {
            System.out.println("Error AdministrarIndexBO registrarNuevoCliente : " + e.toString());
        }
    }

    @Override
    public Persona obtenerPersonaPorUserContrasenia(String usuario, String contrasenia) {
        try {
            System.out.println("Ingreso a la capa de negocio");
            String original = contrasenia;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            Persona registro = personaFacade.obtenerPersonaPorInformacionUsuario(usuario, sb.toString());
            if (null != registro) {
                System.out.println("registro : " + registro);
            }
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarIndexBO obtenerPersonaPorUserContrasenia : " + e.toString());
            return null;
        }
    }

    @Override
    public Administrador obtenerAdministradorPorIDPersona(BigInteger idPersona) {
        try {
            Administrador registro = administradorFacade.buscarAdministradorPorIDPersona(idPersona);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarIndexBO obtenerAdministradorPorIDPersona : " + e.toString());
            return null;
        }
    }

    @Override
    public Trabajador obtenerTrabajadorPorIDPersona(BigInteger idPersona) {
        try {
            Trabajador registro = trabajadorFacade.buscarTrabajadorPorIDPersona(idPersona);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarIndexBO obtenerTrabajadorPorIDPersona : " + e.toString());
            return null;
        }
    }

    @Override
    public Cliente obtenerClientePorIDPersona(BigInteger idPersona) {
        try {
            Cliente registro = clienteFacade.buscarClientePorIDPersona(idPersona);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarIndexBO obtenerClientePorIDPersona : " + e.toString());
            return null;
        }
    }

}
