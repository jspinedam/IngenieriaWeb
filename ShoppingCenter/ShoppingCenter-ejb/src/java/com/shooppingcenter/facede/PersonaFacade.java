/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.Persona;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Facade: Persona Este facade permite realizar los procesos de persistencia de
 * la tabla persona en la base de datos del sistema
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    /**
     * Contexto de persistencia de la base de datos
     */
    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    /**
     * Metodo encargado de obtener un registro Persona por medio de su id
     *
     * @param idRegistro Id del registro
     * @return Persona referenciado por el id dado
     */
    public Persona buscarPersonaPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.idpersona=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            Persona registro = (Persona) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarPersonaPorID PersonaDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener el ultimo registro Persona registrado en la
     * base de datos
     *
     * @return Ultimo registro persona
     */
    public Persona obtenerUltimaPersonaRegistrada() {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Persona p");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List<Persona> lista = query.getResultList();
            Persona registro = null;
            if (null != lista) {
                int tam = lista.size();
                System.out.println("tam : " + tam);
                registro = lista.get(tam - 1);
            }
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarPersonaPorID PersonaDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener una persona por medio de su usuario y
     * contraseña
     *
     * @param usuario Usuario persona
     * @param contrasenia Contraseña persona
     * @return Registro identificado con los parametros dados
     */
    public Persona obtenerPersonaPorInformacionUsuario(String usuario, String contrasenia) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.nombreusuario=:usuario AND p.passwordusuario=:contrasenia");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("usuario", usuario);
            query.setParameter("contrasenia", contrasenia);
            Persona registro = (Persona) query.getSingleResult();
            System.out.println("usuario " + usuario);
            System.out.println("contrasennia " + contrasenia);
            System.out.println("usuario " + registro.getNombreusuario());
            System.out.println("passwoedUsuario " + registro.getPasswordusuario());
            return registro;
        } catch (Exception e) {
            System.out.println("Error obtenerPersonaPorInformacionUsuario PersonaDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener una persona por medio de su documento
     *
     * @param documento Documento persona
     * @return Persona identificada con el documento dado
     */
    public Persona buscarPersonaPorNumeroDocumento(String documento) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.numerodocumento=:documento");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("documento", documento);
            Persona registro = (Persona) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarPersonaPorNumeroDocumento PersonaDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener una persona por medio del usuario de ingreso
     *
     * @param usuario Usuario a consultar
     * @return Persona identificada con el usuario
     */
    public Persona buscarPersonaPorUsuario(String usuario) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.nombreusuario=:usuario");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("usuario", usuario);
            Persona registro = (Persona) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarPersonaPorUsuario PersonaDAO : " + e.toString());
            return null;
        }
    }
}
