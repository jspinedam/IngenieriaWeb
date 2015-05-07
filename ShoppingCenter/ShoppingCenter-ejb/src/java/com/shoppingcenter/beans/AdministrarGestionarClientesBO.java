/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shooppingcenter.facede.ClienteFacade;
import com.shooppingcenter.facede.PersonaFacade;
import com.shoppingcenter.entidades.Cliente;
import com.shoppingcenter.entidades.Persona;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Pineda
 */
@Stateful
public class AdministrarGestionarClientesBO implements AdministrarGestionarClientesBORemote {

    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private PersonaFacade personaFacade;

    @Override
    public List<Cliente> consultarClientesPorParametro(Map<String, String> filtros) {
        try {
            List<Cliente> lista = clienteFacade.buscarClientesPorFiltrado(filtros);
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarClientesBO consultarClientesPorParametro : " + e.toString());
            return null;
        }
    }

    @Override
    public Cliente obtenerClientePorID(BigInteger idCliente) {
        try {
            Cliente registro = clienteFacade.buscarClientePorID(idCliente);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarClientesBO obtenerClientePorID : " + e.toString());
            return null;
        }
    }

    @Override
    public void actualizarInformacionCliente(Persona persona, Cliente cliente) {
        try {
            personaFacade.edit(persona);
            clienteFacade.edit(cliente);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarClientesBO actualizarInformacionClientev : " + e.toString());
        }
    }

    @Override
    public void almacenarNuevoClienteEnSistema(Persona personaNuevo, Cliente clienteNuevo) {
        //try {
        System.err.println("AdministrarGestionarClienteBO almacenarNuevoCLienteEnSistema");
        System.out.println("almacenarNuevoClienteEnSistema Apellido : " + personaNuevo.getApellido());
        System.out.println("almacenarNuevoClienteEnSistema Correo : " + personaNuevo.getCorreo());
        System.out.println("almacenarNuevoClienteEnSistema Estado : " + personaNuevo.getEstadoactivo());
        System.out.println("almacenarNuevoClienteEnSistema Genero : " + personaNuevo.getGenero());
        System.out.println("almacenarNuevoClienteEnSistema Nombre : " + personaNuevo.getNombre());
        System.out.println("almacenarNuevoClienteEnSistema Usuario : " + personaNuevo.getNombreusuario());
        System.out.println("almacenarNuevoClienteEnSistema Tipo Documento : " + personaNuevo.getTipodocumento());
        System.out.println("almacenarNuevoClienteEnSistema Numero Documento : " + personaNuevo.getNumerodocumento());
        System.out.println("almacenarNuevoClienteEnSistema Password : " + personaNuevo.getPasswordusuario());
        System.out.println("almacenarNuevoClienteEnSistema Telefono : " + personaNuevo.getTelefonocontacto());
        System.out.println("almacenarNuevoClienteEnSistema Cliente Direccion : " + clienteNuevo.getDireccionentrega());
        System.out.println("almacenarNuevoClienteEnSistema Cliente Persona : " + clienteNuevo.getPersona().getNombre());
        String original = personaNuevo.getPasswordusuario();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministrarGestionarClientesBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        personaNuevo.setPasswordusuario(sb.toString());
        System.out.println("almacenarNuevoClienteEnSistema sb : " + sb.toString());
        /*System.out.println("almacenarNuevoClienteEnSistema Apellido : " + personaNuevo.getApellido());
         System.out.println("almacenarNuevoClienteEnSistema Correo : " + personaNuevo.getCorreo());
         System.out.println("almacenarNuevoClienteEnSistema Estado : " + personaNuevo.getEstadoactivo());
         System.out.println("almacenarNuevoClienteEnSistema Genero : " + personaNuevo.getGenero());
         System.out.println("almacenarNuevoClienteEnSistema Nombre : " + personaNuevo.getNombre());
         System.out.println("almacenarNuevoClienteEnSistema Usuario : " + personaNuevo.getNombreusuario());
         System.out.println("almacenarNuevoClienteEnSistema Tipo Documento : " + personaNuevo.getTipodocumento());
         System.out.println("almacenarNuevoClienteEnSistema Numero Documento : " + personaNuevo.getNumerodocumento());
         System.out.println("almacenarNuevoClienteEnSistema Password : " + personaNuevo.getPasswordusuario());
         System.out.println("almacenarNuevoClienteEnSistema Telefono : " + personaNuevo.getTelefonocontacto());
         System.out.println("almacenarNuevoClienteEnSistema Cliente Direccion : " + clienteNuevo.getDireccionentrega());
         System.out.println("almacenarNuevoClienteEnSistema Cliente Persona : " + clienteNuevo.getPersona().getNombre());*/
        personaFacade.create(personaNuevo);
        Persona personaRegistrada = personaFacade.obtenerUltimaPersonaRegistrada();
        clienteNuevo.setPersona(personaRegistrada);
        clienteFacade.create(clienteNuevo);
        /*} catch (Exception e) {
         System.out.println("Error AdministrarGestionarClientesBO almacenarNuevoClienteEnSistema : " + e.toString());
         }*/
    }

    @Override
    public Persona obtenerPersonaPorNumeroDocumento(String documento) {
        try {
            Persona registro = personaFacade.buscarPersonaPorNumeroDocumento(documento);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarClientesBO obtenerPersonaPorNumeroDocumento : " + e.toString());
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
            System.out.println("Error AdministrarGestionarClientesBO obtenerPersonaPorNumeroDocumento : " + e.toString());
            return null;
        }
    }

    @Override
    public String MetodoPrueba() {
        return "funciono ......";
    }
}
