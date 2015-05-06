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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pineda
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t"),
    @NamedQuery(name = "Trabajador.findByIdtrabajador", query = "SELECT t FROM Trabajador t WHERE t.idtrabajador = :idtrabajador"),
    @NamedQuery(name = "Trabajador.findByCargo", query = "SELECT t FROM Trabajador t WHERE t.cargo = :cargo")})
public class Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtrabajador")
    private Long idtrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cargo")
    private String cargo;
    @JoinColumn(name = "persona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "localcentrocomercial", referencedColumnName = "idlocalcentrocomercial")
    @ManyToOne(optional = false)
    private LocalCentroComercial localcentrocomercial;

    public Trabajador() {
    }

    public Trabajador(Long idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public Trabajador(Long idtrabajador, String cargo) {
        this.idtrabajador = idtrabajador;
        this.cargo = cargo;
    }

    public Long getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(Long idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LocalCentroComercial getLocalcentrocomercial() {
        return localcentrocomercial;
    }

    public void setLocalcentrocomercial(LocalCentroComercial localcentrocomercial) {
        this.localcentrocomercial = localcentrocomercial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrabajador != null ? idtrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.idtrabajador == null && other.idtrabajador != null) || (this.idtrabajador != null && !this.idtrabajador.equals(other.idtrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Trabajador[ idtrabajador=" + idtrabajador + " ]";
    }
    
}
