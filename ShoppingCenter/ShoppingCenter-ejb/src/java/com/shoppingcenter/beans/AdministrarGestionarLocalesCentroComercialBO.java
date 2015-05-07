/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shooppingcenter.facede.LocalCentroComercialFacade;
import com.shoppingcenter.entidades.LocalCentroComercial;
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
public class AdministrarGestionarLocalesCentroComercialBO implements AdministrarGestionarLocalesCentroComercialBORemote {

    @EJB
    private LocalCentroComercialFacade localCentroComercialFacade;

    @Override
    public List<LocalCentroComercial> consultarLocalesCentroComercialRegistrados() {
        try {
            List<LocalCentroComercial> lista = localCentroComercialFacade.buscarLocalesCentroComercialRegistrados();
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarLocalesCentroComercialBO consultarLocalesCentroComercialRegistrados : " + e.toString());
            return null;
        }
    }
    
    @Override
    public List<LocalCentroComercial> consultarLocalesCentroComercialPorParametro(Map<String, String> filtros) {
        try {
            List<LocalCentroComercial> lista = localCentroComercialFacade.buscarLocalesCentroComercialPorFiltrado(filtros);
            return lista;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarLocalesCentroComercialBO consultarLocalesCentroComercialPorParametro : " + e.toString());
            return null;
        }
    }

    @Override
    public LocalCentroComercial obtenerLocalCentroComercialPorID(BigInteger idLocalCentroComercial) {
        try {
            LocalCentroComercial registro = localCentroComercialFacade.buscarLocalCentroComercialPorID(idLocalCentroComercial);
            return registro;
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarLocalesCentroComercialBO obtenerLocalCentroComercialPorID : " + e.toString());
            return null;
        }
    }

    @Override
    public void actualizarInformacionLocalCentroComercial(LocalCentroComercial localCentroComercial) {
        try {
            localCentroComercialFacade.edit(localCentroComercial);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarLocalesCentroComercialBO actualizarInformacionLocalCentroComercialv : " + e.toString());
        }
    }

    @Override
    public void almacenarNuevoLocalCentroComercialEnSistema(LocalCentroComercial localCentroComercialNuevo) {
        try {
            localCentroComercialFacade.create(localCentroComercialNuevo);
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarLocalesCentroComercialBO almacenarNuevoLocalCentroComercialEnSistema : " + e.toString());
        }
    }

    @Override
    public Boolean obtenerLocalPorNumeroLocal(String numeroLocal) {
        try {
            LocalCentroComercial registro = localCentroComercialFacade.buscarLocalCentroComercialPorNumeroLocal(numeroLocal);
            if (null != registro) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error AdministrarGestionarLocalesCentroComercialBO obtenerLocalPorNumeroLocal : " + e.toString());
            return null;
        }
    }
}
