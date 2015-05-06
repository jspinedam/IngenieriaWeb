/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shooppingcenter.facede.PromocionFacade;
import com.shoppingcenter.entidades.Promocion;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Pineda
 */
@Stateful
public class AdministrarGestionarPromocionesBO implements AdministrarGestionarPromocionesBORemote {

    @EJB
    private PromocionFacade promocionFacade;

    @Override
    public List<Promocion> consultarPromocionesPorParametro(Map<String, String> filtros) {
        try {
            List<Promocion> lista = promocionFacade.buscarPromocionesPorFiltrado(filtros);
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarPromocionesBO consultarPromocionesPorParametro : " + e.toString());
            return null;
        }
    }

    @Override
    public Promocion obtenerPromocionPorID(BigInteger idPromocion) {
        try {
            Promocion registro = promocionFacade.buscarPromocionPorID(idPromocion);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarPromocionesBO obtenerPromocionPorID : " + e.toString());
            return null;
        }
    }

    @Override
    public void actualizarInformacionPromocion(Promocion promocion) {
        try {
            promocionFacade.edit(promocion);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarPromocionesBO actualizarInformacionPromocionv : " + e.toString());
        }
    }

    @Override
    public void almacenarNuevoPromocionEnSistema(Promocion promocionNuevo) {
        try {
            promocionFacade.create(promocionNuevo);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarPromocionesBO almacenarNuevoPromocionEnSistema : " + e.toString());
        }
    }

    @Override
    public Promocion obtenerLocalPorCodigo(String codigo) {
        try {
            Promocion registro = promocionFacade.buscarPromocionPorCodigo(codigo);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarPromocionesBO obtenerLocalPorCodigo : " + e.toString());
            return null;
        }
    }
}
