/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.Producto;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Facade: Producto Este facade permite realizar los procesos de persistencia de
 * la tabla producto en la base de datos del sistema
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    /**
     * Contexto de persistencia de la base de datos
     */
    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    /**
     * Metodo encargado de obtener un registro Producto por medio de su id
     *
     * @param idRegistro Id del registro
     * @return Producto referenciado por el id dado
     */
    public Producto buscarProductoPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.idproducto=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            Producto registro = (Producto) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarProductoPorID ProductoDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener un producto por medio de su codigo y del
     * local asociado
     *
     * @param codigo Codigo producto
     * @param local Local al que pertenece el producto
     * @return Producto identificado con los parametros
     */
    public Producto buscarProductoPorCodigoYLocal(String codigo, BigInteger local) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo=:codigo AND p.localcentrocomercial.idlocalcentrocomercial=:local");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("codigo", codigo);
            query.setParameter("local", local);
            Producto registro = (Producto) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarProductoPorCodigoYLocal ProductoDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener los productos asociados a un local
     *
     * @param idLocal Id del local
     * @return Lista de productos
     */
    public List<Producto> buscarProductosPorIDLocal(BigInteger idLocal) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.localcentrocomercial.idlocalcentrocomercial=:idLocal");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idLocal", idLocal);
            List<Producto> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("Error buscarProductoPorIDPersona ProductoDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener registros Producto por medio de parametros de
     * busqueda
     *
     * @param filters Map de parametros de busqueda
     * @return Resultado de la consulta de Productos
     */
    public List<Producto> buscarProductosPorFiltrado(Map<String, String> filters) {
        try {
            final String alias = "a";
            final StringBuilder jpql = new StringBuilder();
            String jpql2;
            jpql.append("SELECT a FROM ").append(Producto.class.getSimpleName()).append(" " + alias);
            //
            jpql2 = adicionarFiltros(jpql.toString(), filters, alias);
            //
            System.out.println("jpql2.toString() : " + jpql2.toString());
            TypedQuery<Producto> tq = em.createQuery(jpql2.toString(), Producto.class);
            tq = asignarValores(tq, filters);
            return tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error buscarProductosPorFiltrado ProductoDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de adicionar los filtros de busqueda a la consulta
     *
     * @param jpql Consulta general (SELECT p FROM Producto p)
     * @param filters Lista de filtros de busqueda
     * @param alias Alias de la tabla (p)
     * @return String de la nueva consulta a realizar
     */
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
                    if ("parametroTipoProducto".equals(entry.getKey())) {
                        wheres.append(alias).append("." + "tipoproducto");
                        wheres.append("= :").append(entry.getKey());
                        camposFiltro++;
                    }
                    if ("parametroNombre".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".nombre")
                                .append(") Like :parametroNombre");
                        camposFiltro++;
                    }
                    if ("parametroCodigo".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".codigo")
                                .append(") Like :parametroCodigo");
                        camposFiltro++;
                    }
                    if ("parametroLocal".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".localcentrocomercial.idlocalcentrocomercial")
                                .append(") Like :parametroLocal");
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

    /**
     * Metodo encargado de asignar los valores la consulta (query)
     *
     * @param tq Consulta a realizar
     * @param filters Filtros de busqueda
     * @return Consulta a realizar con datos asignados
     */
    private TypedQuery<Producto> asignarValores(TypedQuery<Producto> tq, Map<String, String> filters) {
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (null != entry.getValue() && !entry.getValue().isEmpty()) {
                if (("parametroTipoProducto".equals(entry.getKey()))
                        || ("parametroNombre".equals(entry.getKey()))
                        || ("parametroCodigo".equals(entry.getKey()))) {
                    //
                    tq.setParameter(entry.getKey(), "%" + entry.getValue().toUpperCase() + "%");
                }
                if (("parametroLocal".equals(entry.getKey()))) {
                    tq.setParameter(entry.getKey(), new BigInteger(entry.getValue()));
                }
            }
        }
        return tq;
    }

}
