/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shoppingcenter.utilidades.UsuarioLogin;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Pineda
 */
public class ControllerPaginaInicio extends ActionSupport implements SessionAware {

    private Map session;

    public String obtejerUsuarioConectado() {
        String usuarioMsn = "NADIE";
        session = ActionContext.getContext().getSession();
        if (session.containsKey("SESSION_USER")) {
            UsuarioLogin usuario = (UsuarioLogin) session.get("SESSION_USER");
            System.out.println("usuario : " + usuario);
            usuarioMsn = usuario.getUsuarioConectado();
        }
        return usuarioMsn;
    }

    //--//--//
    public String gestionarAdministrador() {
        return "success_gestionar_administradores";
    }

    //--//--//
    public String gestionarCliente() {
        return "success_gestionar_clientes";
    }

    //--//--//
    public String gestionarTrabajador() {
        return "success_gestionar_trabajadores";
    }

    //--//--//
    public String atrasInicioAdministrador() {
        return "success_inicio_administrador";
    }

    //--//--//
    public String atrasInicioCliente() {
        return "success_inicio_cliente";
    }

    //--//--//
    public String atrasInicioTrabajador() {
        return "success_inicio_trabajador";
    }
    //--//--//

    public String registrarAdministrador() {
        return "success_registrar_administrador";
    }

    //--//--//
    public String registrarTrabajador() {
        return "success_registrar_trabajador";
    }

    //--//--//
    public String registrarCliente() {
        return "success_registrar_cliente";
    }
    //--//--//

    public String consultarLocales() {
        return "success_gestionar_localescentrocomercial";
    }

    //--//--//
    public String registrarLocal() {
        return "success_registrar_localescentrocomercial";
    }

    //--//--//
    public String consultarPromociones() {
        return "success_gestionar_promociones";
    }

    //--//--//
    public String registrarPromocion() {
        return "success_registrar_promocion";
    }
    //--//--//

    //--//--//
    public String consultarGuiaCompraLocal() {
        return "success_gestionar_guiascompralocal";
    }

    //--//--//
    public String consultarGuiaCompraProducto() {
        return "success_gestionar_guiascompraproducto";
    }
    //--//--//

    public String consultarLocalCentroComercial() {
        return "success_consultar_localcentrocomercial";
    }
    //--//--//

    public String consultarPromocion() {
        return "success_consultar_promociones";
    }
    //--//--//

    public String consultarGuiaCompraProductoCliente() {
        return "success_consultar_guiascompraproductos";
    }
    //--//--//

    public String consultarGuiaCompraLocalCliente() {
        return "success_consultar_guiascompralocales";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
