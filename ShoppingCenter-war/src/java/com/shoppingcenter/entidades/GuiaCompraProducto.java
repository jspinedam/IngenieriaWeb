/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pineda
 */
@Entity
@Table(name = "guiacompraproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guiacompraproducto.findAll", query = "SELECT g FROM Guiacompraproducto g"),
    @NamedQuery(name = "Guiacompraproducto.findByIdguiacompraproducto", query = "SELECT g FROM Guiacompraproducto g WHERE g.idguiacompraproducto = :idguiacompraproducto")})
public class GuiaCompraProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idguiacompraproducto")
    private Long idguiacompraproducto;
    @JoinColumn(name = "producto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "guiacompra", referencedColumnName = "idguiacompra")
    @ManyToOne(optional = false)
    private GuiaCompra guiacompra;

    public GuiaCompraProducto() {
    }

    public GuiaCompraProducto(Long idguiacompraproducto) {
        this.idguiacompraproducto = idguiacompraproducto;
    }

    public Long getIdguiacompraproducto() {
        return idguiacompraproducto;
    }

    public void setIdguiacompraproducto(Long idguiacompraproducto) {
        this.idguiacompraproducto = idguiacompraproducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public GuiaCompra getGuiacompra() {
        return guiacompra;
    }

    public void setGuiacompra(GuiaCompra guiacompra) {
        this.guiacompra = guiacompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idguiacompraproducto != null ? idguiacompraproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaCompraProducto)) {
            return false;
        }
        GuiaCompraProducto other = (GuiaCompraProducto) object;
        if ((this.idguiacompraproducto == null && other.idguiacompraproducto != null) || (this.idguiacompraproducto != null && !this.idguiacompraproducto.equals(other.idguiacompraproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Guiacompraproducto[ idguiacompraproducto=" + idguiacompraproducto + " ]";
    }
    
}
