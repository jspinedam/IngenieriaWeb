/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.LocalCentroComercial;
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
public class LocalCentroComercialFacade extends AbstractFacade<LocalCentroComercial> {
    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalCentroComercialFacade() {
        super(LocalCentroComercial.class);
    }
        public LocalCentroComercial buscarLocalCentroComercialPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM LocalCentroComercial p WHERE p.idlocalcentrocomercial=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            LocalCentroComercial registro = (LocalCentroComercial) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarLocalCentroComercialPorID LocalCentroComercialDAO : " + e.toString());
            return null;
        }
    }

    public LocalCentroComercial buscarLocalCentroComercialPorNumeroLocal(String numeroLocal) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM LocalCentroComercial p WHERE p.numerolocal=:numeroLocal");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("numeroLocal", numeroLocal);
            LocalCentroComercial registro = (LocalCentroComercial) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarLocalCentroComercialPorNumeroLocal LocalCentroComercialDAO : " + e.toString());
            return null;
        }
    }

    public List<LocalCentroComercial> buscarLocalesCentroComercialPorFiltrado(Map<String, String> filters) {
        try {
            final String alias = "a";
            final StringBuilder jpql = new StringBuilder();
            String jpql2;
            jpql.append("SELECT a FROM ").append(LocalCentroComercial.class.getSimpleName()).append(" " + alias);
            //
            jpql2 = adicionarFiltros(jpql.toString(), filters, alias);
            //
            System.out.println("jpql2.toString() : " + jpql2.toString());
            TypedQuery<LocalCentroComercial> tq = em.createQuery(jpql2.toString(), LocalCentroComercial.class);
            tq = asignarValores(tq, filters);
            return tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error buscarLocalesCentroComercialPorFiltrado LocalCentroComercialDAO : " + e.toString());
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
                    if ("parametroEstado".equals(entry.getKey())) {
                        wheres.append(alias).append("." + "estadoActivo");
                        wheres.append("= :").append(entry.getKey());
                        camposFiltro++;
                    }
                    if ("parametroNombre".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".nombre")
                                .append(") Like :parametroNombre");
                        camposFiltro++;
                    }
                    if ("parametroRazon".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".razonsocial")
                                .append(") Like :parametroRazon");
                        camposFiltro++;
                    }
                    if ("parametroCorreo".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".correo")
                                .append(") Like :parametroCorreo");
                        camposFiltro++;
                    }
                    if ("parametroNumeroLocal".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".numerolocal")
                                .append(") Like :parametroNumeroLocal");
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

    private TypedQuery<LocalCentroComercial> asignarValores(TypedQuery<LocalCentroComercial> tq, Map<String, String> filters) {

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (null != entry.getValue() && !entry.getValue().isEmpty()) {
                if (("parametroNumeroLocal".equals(entry.getKey()))
                        || ("parametroCorreo".equals(entry.getKey()))
                        || ("parametroNombre".equals(entry.getKey()))
                        || ("parametroRazon".equals(entry.getKey()))) {
                    //
                    tq.setParameter(entry.getKey(), "%" + entry.getValue().toUpperCase() + "%");
                }
                if (("parametroEstado".equals(entry.getKey()))) {
                    tq.setParameter(entry.getKey(), Boolean.valueOf(entry.getValue()));
                }
            }
        }
        return tq;
    }
}
