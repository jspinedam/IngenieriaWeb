/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.ProductoCompra;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pineda
 */
@Stateless
public class ProductoCompraFacade extends AbstractFacade<ProductoCompra> {

    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoCompraFacade() {
        super(ProductoCompra.class);
    }

    public ProductoCompra buscarProductoCompraPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM ProductoCompra p WHERE p.idproductocompra=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            ProductoCompra registro = (ProductoCompra) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarProductoCompraPorID ProductoCompraDAO : " + e.toString());
            return null;
        }
    }
}
