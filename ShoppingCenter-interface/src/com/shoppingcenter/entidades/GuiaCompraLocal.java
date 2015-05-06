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
@Table(name = "guiacompralocal")
@XmlRootElement
public class GuiaCompraLocal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idguiacompralocal")
    private Long idguiacompralocal;
    @JoinColumn(name = "localcentrocomercial", referencedColumnName = "idlocalcentrocomercial")
    @ManyToOne(optional = false)
    private LocalCentroComercial localcentrocomercial;
    @JoinColumn(name = "guiacompra", referencedColumnName = "idguiacompra")
    @ManyToOne(optional = false)
    private GuiaCompra guiacompra;

    public GuiaCompraLocal() {
    }

    public GuiaCompraLocal(Long idguiacompralocal) {
        this.idguiacompralocal = idguiacompralocal;
    }

    public Long getIdguiacompralocal() {
        return idguiacompralocal;
    }

    public void setIdguiacompralocal(Long idguiacompralocal) {
        this.idguiacompralocal = idguiacompralocal;
    }

    public LocalCentroComercial getLocalcentrocomercial() {
        return localcentrocomercial;
    }

    public void setLocalcentrocomercial(LocalCentroComercial localcentrocomercial) {
        this.localcentrocomercial = localcentrocomercial;
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
        hash += (idguiacompralocal != null ? idguiacompralocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaCompraLocal)) {
            return false;
        }
        GuiaCompraLocal other = (GuiaCompraLocal) object;
        if ((this.idguiacompralocal == null && other.idguiacompralocal != null) || (this.idguiacompralocal != null && !this.idguiacompralocal.equals(other.idguiacompralocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Guiacompralocal[ idguiacompralocal=" + idguiacompralocal + " ]";
    }
    
}
