/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.LocalCentroComercial;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Pineda
 */
@Remote
public interface AdministrarGestionarLocalesCentroComercialBORemote {

    public List<LocalCentroComercial> consultarLocalesCentroComercialPorParametro(Map<String, String> filtros);

    public LocalCentroComercial obtenerLocalCentroComercialPorID(BigInteger idLocalCentroComercial);

    public void actualizarInformacionLocalCentroComercial(LocalCentroComercial localCentroComercial);

    public void almacenarNuevoLocalCentroComercialEnSistema(LocalCentroComercial localCentroComercialNuevo);

    public Boolean obtenerLocalPorNumeroLocal(String numeroLocal);
}
