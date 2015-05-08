/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shooppingcenter.facede;

import com.shoppingcenter.entidades.Cliente;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Facade: Cliente Este facade permite realizar los procesos de persistencia de
 * la tabla cliente en la base de datos del sistema
 *
 * @author PinedaSoftware
 * @version 1.0
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    /**
     * Contexto de persistencia de la base de datos
     */
    @PersistenceContext(unitName = "ShoppingCenter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    /**
     * Metodo encargado de obtener un registro Cliente por medio de su id
     *
     * @param idRegistro Id del registro
     * @return Cliente referenciado por el id dado
     */
    public Cliente buscarClientePorID(BigInteger idRegistro) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.idcliente=:idRegistro");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idRegistro", idRegistro);
            Cliente registro = (Cliente) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarClientePorID ClienteDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener un registro Cliente por medio del id del
     * atributo Persona
     *
     * @param idPersona Id de la persona
     * @return Cliente referenciado por el id persona dado
     */
    public Cliente buscarClientePorIDPersona(BigInteger idPersona) {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Cliente p WHERE p.persona.idpersona=:idPersona");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("idPersona", idPersona);
            Cliente registro = (Cliente) query.getSingleResult();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarClientePorIDPersona ClienteDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encagado de buscar todos los registro Cliente registrados en la
     * base de datos
     *
     * @return Lista de registros clientes
     */
    public List<Cliente> buscarClientesRegistrados() {
        try {
            em.clear();
            Query query = em.createQuery("SELECT p FROM Cliente p");
            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List<Cliente> registro = query.getResultList();
            return registro;
        } catch (Exception e) {
            System.out.println("Error buscarClientesRegistrados ClienteDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de obtener registros CLiente por medio de parametros de
     * busqueda
     *
     * @param filters Map de parametros de busqueda
     * @return Resultado de la consulta de Clientes
     */
    public List<Cliente> buscarClientesPorFiltrado(Map<String, String> filters) {
        try {
            final String alias = "a";
            final StringBuilder jpql = new StringBuilder();
            String jpql2;
            jpql.append("SELECT a FROM ").append(Cliente.class.getSimpleName()).append(" " + alias);
            //
            jpql2 = adicionarFiltros(jpql.toString(), filters, alias);
            //
            System.out.println("jpql2.toString() : " + jpql2.toString());
            TypedQuery<Cliente> tq = em.createQuery(jpql2.toString(), Cliente.class);
            tq = asignarValores(tq, filters);
            return tq.getResultList();
        } catch (Exception e) {
            System.out.println("Error buscarClientesPorFiltrado ClienteDAO : " + e.toString());
            return null;
        }
    }

    /**
     * Metodo encargado de adicionar los filtros de busqueda a la consulta
     *
     * @param jpql Consulta general (SELECT p FROM Cliente p)
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

    /**
     * Metodo encargado de asignar los valores la consulta (query)
     *
     * @param tq Consulta a realizar
     * @param filters Filtros de busqueda
     * @return Consulta a realizar con datos asignados
     */
    private TypedQuery<Cliente> asignarValores(TypedQuery<Cliente> tq, Map<String, String> filters) {
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
