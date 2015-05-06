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
 *
 * @author Pineda
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {
    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
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

    public Persona obtenerPersonaPorInformacionUsuario(String usuario, String contrasenia) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.nombreusuario=:usuario AND p.passwordusuario=:contrasenia");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("usuario", usuario);
            query.setParameter("contrasenia", contrasenia);
            Persona registro = (Persona) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error obtenerPersonaPorInformacionUsuario PersonaDAO : " + e.toString());
            return null;
        }
    }

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

    public Persona buscarPersonaPorUsuario(String usuario)  {
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
