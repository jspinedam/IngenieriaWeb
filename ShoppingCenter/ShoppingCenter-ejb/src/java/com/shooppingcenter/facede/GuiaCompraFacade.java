/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.GuiaCompra;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Facade: GuiaCompra Este facade permite realizar los procesos de persistencia
 * de la tabla guiacompra en la base de datos del sistema
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Stateless
public class GuiaCompraFacade extends AbstractFacade<GuiaCompra> {

    /**
     * Contexto de persistencia de la base de datos
     */
    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaCompraFacade() {
        super(GuiaCompra.class);
    }

    /**
     * Metodo encargado de obtener un registro GuiaCompra por medio de su id
     *
     * @param idRegistro Id del registro
     * @return GuiaCompra referenciado por el id dado
     */
    public GuiaCompra buscarGuiaCompraPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM GuiaCompra p WHERE p.idguiacompra=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            GuiaCompra registro = (GuiaCompra) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarGuiaCompraPorID GuiaCompraDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener el ultimo registro GuiaCompra registrado en
     * la base de datos
     *
     * @return Ultimo registro GuiaCompra
     */
    public GuiaCompra obtenerUltimaGuiaCompraRegistrada() {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM GuiaCompra p");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List<GuiaCompra> lista = query.getResultList();
            GuiaCompra registro = null;
            if (null != lista) {
                int tam = lista.size();
                registro = lista.get(tam - 1);
            }
            return registro;
        } catch (Exception e) {
            System.out.println("Error obtenerUltimaGuiaCompraRegistrada GuiaCompraDAO : " + e.toString());
            return null;
        }
    }
}
