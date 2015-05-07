/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.Administrador;
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
public class AdministradorFacade extends AbstractFacade<Administrador> {

    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }

    public Administrador buscarAdministradorPorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Administrador p WHERE p.idadministrador=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            Administrador registro = (Administrador) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarAdministradorPorID AdministradorDAO : " + e.toString());
            return null;
        }
    }

    public Administrador buscarAdministradorPorIDPersona(BigInteger idPersona) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Administrador p WHERE p.persona.idpersona=:idPersona");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idPersona", idPersona);
            Administrador registro = (Administrador) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarAdministradorPorIDPersona AdministradorDAO : " + e.toString());
            return null;
        }
    }

    public List<Administrador> buscarAdministradoresRegistrados() {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Administrador p");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List<Administrador> registros = query.getResultList();
            return registros;
        } catch (Exception e) {
            System.out.println("Error buscarAdministradoresRegistrados AdministradorDAO : " + e.toString());
            return null;
        }
    }

    public List<Administrador> buscarAdministradorsPorFiltrado(Map<String, String> filters) {
        try {
            final String alias = "a";
            final StringBuilder jpql = new StringBuilder();
            String jpql2;
            jpql.append("SELECT a FROM ").append(Administrador.class.getSimpleName()).append(" " + alias);
            //
            jpql2 = adicionarFiltros(jpql.toString(), filters, alias);
            //
            System.out.println("jpql2.toString() : " + jpql2.toString());
            TypedQuery<Administrador> tq = em.createQuery(jpql2.toString(), Administrador.class);
            tq = asignarValores(tq, filters);
            return tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error buscarAdministradorsPorFiltrado AdministradorDAO : " + e.toString());
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
                        wheres.append(alias).append("." + "persona.estadoactivo");
                        wheres.append("= :").append(entry.getKey());
                        camposFiltro++;
                    }
                    if ("parametroNombre".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".persona.nombre")
                                .append(") Like :parametroNombre");
                        camposFiltro++;
                    }
                    if ("parametroApellido".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".persona.apellido")
                                .append(") Like :parametroApellido");
                        camposFiltro++;
                    }
                    if ("parametroDocumento".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".persona.numerodocumento")
                                .append(") Like :parametroDocumento");
                        camposFiltro++;
                    }
                    if ("parametroTipoDocumento".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".persona.tipodocumento")
                                .append(") Like :parametroDocumento");
                        camposFiltro++;
                    }
                    if ("parametroCorreo".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".persona.correo")
                                .append(") Like :parametroCorreo");
                        camposFiltro++;
                    }
                    if ("parametroUsuario".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".persona.nombreUsuario")
                                .append(") Like :parametroUsuario");
                        camposFiltro++;
                    }
                    if ("parametroGenero".equals(entry.getKey())) {
                        wheres.append("UPPER(").append(alias)
                                .append(".persona.genero")
                                .append(") Like :parametroGenero");
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

    private TypedQuery<Administrador> asignarValores(TypedQuery<Administrador> tq, Map<String, String> filters) {

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            if (null != entry.getValue() && !entry.getValue().isEmpty()) {
                if (("parametroGenero".equals(entry.getKey()))
                        || ("parametroUsuario".equals(entry.getKey()))
                        || ("parametroCorreo".equals(entry.getKey()))
                        || ("parametroTipoDocumento".equals(entry.getKey()))
                        || ("parametroNombre".equals(entry.getKey()))
                        || ("parametroApellido".equals(entry.getKey()))
                        || ("parametroDocumento".equals(entry.getKey()))) {
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
