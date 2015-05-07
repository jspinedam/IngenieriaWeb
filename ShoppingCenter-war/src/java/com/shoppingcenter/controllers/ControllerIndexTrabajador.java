/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Pineda
 */
public class ControllerIndexTrabajador extends ActionSupport implements Serializable//, SessionAware {
{

    public String direccionarALocal() {
        String retorno = "succes_TrabajadorAlocal";
        return retorno;
    }

}
