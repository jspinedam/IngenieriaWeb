/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.beans;

import com.shoppingcenter.entidades.Promocion;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author Pineda
 */
@Remote
public interface AdministrarGestionarPromocionesBORemote {
    public List<Promocion> consultarPromocionesPorParametro(Map<String, String> filtros);
    public Promocion obtenerPromocionPorID(BigInteger idPromocion) ;
    public void actualizarInformacionPromocion(Promocion promocion);
    public void almacenarNuevoPromocionEnSistema(Promocion promocionNuevo);
    public Promocion obtenerLocalPorCodigo(String codigo) ;
}
