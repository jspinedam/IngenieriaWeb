/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.utilidades;

/**
 *
 * @author Pineda
 */
public class UsuarioLogin {

    private String usuarioConectado;
    private String tipoUsuario;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String usuarioConectado, String tipoUsuario) {
        this.usuarioConectado = usuarioConectado;
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuarioConectado() {
        return usuarioConectado;
    }

    public void setUsuarioConectado(String usuarioConectado) {
        this.usuarioConectado = usuarioConectado;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
