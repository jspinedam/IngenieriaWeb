/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.GuiaCompraProducto;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pineda
 */
@Stateless
public class GuiaCompraProductoFacade extends AbstractFacade<GuiaCompraProducto> {
    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaCompraProductoFacade() {
        super(GuiaCompraProducto.class);
    }
    
    public List<GuiaCompraProducto> consultarGuiasCompraPorIDGuia(BigInteger guiaCompra) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM GuiaCompraProducto p WHERE p.guiacompra.idguiacompra=:guiaCompra");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("guiaCompra", guiaCompra);
            List<GuiaCompraProducto> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("Error consultarGuiasCompraProductos GuiaCompraProductoDAO : " + e.toString());
            return null;
        }
    }

    public GuiaCompraProducto buscarGuiaCompraProductoPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM GuiaCompraProducto p WHERE p.idguiacompraproducto=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            GuiaCompraProducto registro = (GuiaCompraProducto) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarGuiaCompraProductoPorID GuiaCompraProductoDAO : " + e.toString());
            return null;
        }
    }

    public List<GuiaCompraProducto> buscarGuiasCompraProductosPorFiltrado(Map<String, String> filters) {
        try {
            final String alias = "a";
            final StringBuilder jpql = new StringBuilder();
            String jpql2;
            jpql.append("SELECT a FROM ").append(GuiaCompraProducto.class.getSimpleName()).append(" " + alias);
            //
            jpql2 = adicionarFiltros(jpql.toString(), filters, alias);
            //
            System.out.println("jpql2.toString() : " + jpql2.toString());
            TypedQuery<GuiaCompraProducto> tq = em.createQuery(jpql2.toString(), GuiaCompraProducto.class);
            tq = asignarValores(tq, filters);
            return tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error buscarGuiasCompraProductosPorFiltrado GuiaCompraProductoDAO : " + e.toString());
            return null;
        }
    }

    private String adicionarFiltros(String jpql, Map<String, String> filters, String alias) {
        final StringBuilder wheres = new StringBuilder();
        int camposFiltro = 0;

        if (null != filters && !filters.isEmpty()) {
            wheres.append(" WHERE ");
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                if (null != entry.getValue() && !entry.getValue().isEmpty()) {
                    if (camposFiltro > 0) {
                        wheres.append(" AND ");
                    }
                    if ("parametroNombre".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".guiacompra.nombre")
                                .append(") Like :parametroNombre");
                        camposFiltro++;
                    }
                    if ("parametroCodigo".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".guiacompra.codigo")
                                .append(") Like :parametroApellido");
                        camposFiltro++;
                    }
                    if ("parametroCaracteristica".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".guiacompra.caracteristicacomun")
                                .append(") Like :parametroCaracteristica");
                        camposFiltro++;
                    }
                    if ("parametroProducto".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".producto.idproducto")
                                .append(") Like :parametroProducto");
                        camposFiltro++;
                    }
                }
            }
        }
        jpql = jpql + wheres /*+ " ORDER BY " + alias + ".id ASC"*/;

        System.out.println(jpql);

        if (jpql.trim()
                .endsWith("WHERE")) {
            jpql = jpql.replace("WHERE", "");
        }
        return jpql;
    }

    private TypedQuery<GuiaCompraProducto> asignarValores(TypedQuery<GuiaCompraProducto> tq, Map<String, String> filters) {

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (null != entry.getValue() && !entry.getValue().isEmpty()) {
                if (("parametroNombre".equals(entry.getKey()))
                        || ("parametroCodigo".equals(entry.getKey()))
                        || ("parametroCaracteristica".equals(entry.getKey()))) {
                    //
                    tq.setParameter(entry.getKey(), "%" + entry.getValue().toUpperCase() + "%");
                }
                if (("parametroProducto".equals(entry.getKey()))) {
                    tq.setParameter(entry.getKey(), new BigInteger(entry.getKey()));
                }
            }
        }
        return tq;
    }
}
