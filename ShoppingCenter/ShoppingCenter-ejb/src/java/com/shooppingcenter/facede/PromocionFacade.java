/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.Promocion;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Facade: Promocion Este facade permite realizar los procesos de persistencia
 * de la tabla promocion en la base de datos del sistema
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Stateless
public class PromocionFacade extends AbstractFacade<Promocion> {

    /**
     * Contexto de persistencia de la base de datos
     */
    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromocionFacade() {
        super(Promocion.class);
    }

    /**
     * Metodo encargado de obtener un registro Promocion por medio de su id
     *
     * @param idRegistro Id del registro
     * @return Promocion referenciado por el id dado
     */
    public Promocion buscarPromocionPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Promocion p WHERE p.idpromocion=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            Promocion registro = (Promocion) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarPromocionPorID PromocionDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener una promocion por medio de su codigo
     *
     * @param codigo Codigo promocion
     * @return Promocion referenciada por el codigo
     */
    public Promocion buscarPromocionPorCodigo(String codigo) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Promocion p WHERE p.codigo=:codigo");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("codigo", codigo);
            Promocion registro = (Promocion) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarPromocionPorID PromocionDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener registros Promocion por medio de parametros
     * de busqueda
     *
     * @param filters Map de parametros de busqueda
     * @return Resultado de la consulta de Promociones
     */
    public List<Promocion> buscarPromocionesPorFiltrado(Map<String, String> filters) {
        try {
            final String alias = "a";
            final StringBuilder jpql = new StringBuilder();
            String jpql2;
            jpql.append("SELECT a FROM ").append(Promocion.class.getSimpleName()).append(" " + alias);
            //
            jpql2 = adicionarFiltros(jpql.toString(), filters, alias);
            //
            System.out.println("jpql2.toString() : " + jpql2.toString());
            TypedQuery<Promocion> tq = em.createQuery(jpql2.toString(), Promocion.class);
            tq = asignarValores(tq, filters);
            return tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error buscarPromocionesPorFiltrado PromocionDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de adicionar los filtros de busqueda a la consulta
     *
     * @param jpql Consulta general (SELECT p FROM Promocion p)
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
                    if ("parametroProducto".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".producto.idproducto")
                                .append(") Like :parametroProducto");
                        camposFiltro++;
                    }
                    if ("parametroLocal".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".producto.localcentrocomercial.idlocalcentrocomercial")
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
    private TypedQuery<Promocion> asignarValores(TypedQuery<Promocion> tq, Map<String, String> filters) {

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (null != entry.getValue() && !entry.getValue().isEmpty()) {
                if (("parametroTipoPromocion".equals(entry.getKey()))
                        || ("parametroCodigo".equals(entry.getKey()))) {
                    //
                    tq.setParameter(entry.getKey(), "%" + entry.getValue().toUpperCase() + "%");
                }
                if (("parametroProducto".equals(entry.getKey()))
                        || ("parametroLocal".equals(entry.getKey()))) {
                    tq.setParameter(entry.getKey(), new BigInteger(entry.getValue()));
                }
            }
        }
        return tq;
    }
}
