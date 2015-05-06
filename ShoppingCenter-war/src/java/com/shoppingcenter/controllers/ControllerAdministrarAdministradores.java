/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.controllers;

import com.shoppingcenter.beans.AdministrarGestionarAdministradoresBORemote;
import com.shoppingcenter.entidades.Administrador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Pineda
 */
@WebServlet(name = "ControllerAdministrarAdministradores", urlPatterns = {"/ControllerAdministrarAdministradores"})
public class ControllerAdministrarAdministradores extends HttpServlet implements SessionAware {

    AdministrarGestionarAdministradoresBORemote administrarGestionarAdministradoresBO = lookupAdministrarGestionarAdministradoresBORemote();

    private String parametroNombre, parametroApellido, parametroDocumento, parametroTipoDocumento, parametroCorreo, parametroGenero, parametroUsuario;
    private int parametroEstado;
    private Map<String, String> filtros;
    private List<Administrador> listaAdministradores;
    Map<String, Object> session;
    private String nombreUsuarioConectado;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerAdministrarAdministradores</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerAdministrarAdministradores at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private AdministrarGestionarAdministradoresBORemote lookupAdministrarGestionarAdministradoresBORemote() {
        try {
            Context c = new InitialContext();
            return (AdministrarGestionarAdministradoresBORemote) c.lookup("java:global/ShoppingCenter/ShoppingCenter-ejb/AdministrarGestionarAdministradoresBO!com.shoppingcenter.beans.AdministrarGestionarAdministradoresBORemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombreUsuarioConectado() {
        return nombreUsuarioConectado;
    }

    public void setNombreUsuarioConectado(String nombreUsuarioConectado) {
        this.nombreUsuarioConectado = nombreUsuarioConectado;
    }

}
