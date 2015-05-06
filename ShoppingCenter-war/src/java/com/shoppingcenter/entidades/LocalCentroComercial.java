/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pineda
 */
@Entity
@Table(name = "localcentrocomercial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localcentrocomercial.findAll", query = "SELECT l FROM Localcentrocomercial l"),
    @NamedQuery(name = "Localcentrocomercial.findByIdlocalcentrocomercial", query = "SELECT l FROM Localcentrocomercial l WHERE l.idlocalcentrocomercial = :idlocalcentrocomercial"),
    @NamedQuery(name = "Localcentrocomercial.findByNombre", query = "SELECT l FROM Localcentrocomercial l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Localcentrocomercial.findByRazonsocial", query = "SELECT l FROM Localcentrocomercial l WHERE l.razonsocial = :razonsocial"),
    @NamedQuery(name = "Localcentrocomercial.findByCorreo", query = "SELECT l FROM Localcentrocomercial l WHERE l.correo = :correo"),
    @NamedQuery(name = "Localcentrocomercial.findBySlogan", query = "SELECT l FROM Localcentrocomercial l WHERE l.slogan = :slogan"),
    @NamedQuery(name = "Localcentrocomercial.findByTelefono", query = "SELECT l FROM Localcentrocomercial l WHERE l.telefono = :telefono"),
    @NamedQuery(name = "Localcentrocomercial.findByNumerolocal", query = "SELECT l FROM Localcentrocomercial l WHERE l.numerolocal = :numerolocal"),
    @NamedQuery(name = "Localcentrocomercial.findByEstadoactivo", query = "SELECT l FROM Localcentrocomercial l WHERE l.estadoactivo = :estadoactivo"),
    @NamedQuery(name = "Localcentrocomercial.findByNombreencargado", query = "SELECT l FROM Localcentrocomercial l WHERE l.nombreencargado = :nombreencargado")})
public class LocalCentroComercial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocalcentrocomercial")
    private Long idlocalcentrocomercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "razonsocial")
    private String razonsocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "slogan")
    private String slogan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "numerolocal")
    private String numerolocal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoactivo")
    private boolean estadoactivo;
    @Size(max = 30)
    @Column(name = "nombreencargado")
    private String nombreencargado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localcentrocomercial")
    private Collection<Trabajador> trabajadorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localcentrocomercial")
    private Collection<Producto> productoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localcentrocomercial")
    private Collection<GuiaCompraLocal> guiacompralocalCollection;

    public LocalCentroComercial() {
    }

    public LocalCentroComercial(Long idlocalcentrocomercial) {
        this.idlocalcentrocomercial = idlocalcentrocomercial;
    }

    public LocalCentroComercial(Long idlocalcentrocomercial, String nombre, String razonsocial, String correo, String slogan, String telefono, String numerolocal, boolean estadoactivo) {
        this.idlocalcentrocomercial = idlocalcentrocomercial;
        this.nombre = nombre;
        this.razonsocial = razonsocial;
        this.correo = correo;
        this.slogan = slogan;
        this.telefono = telefono;
        this.numerolocal = numerolocal;
        this.estadoactivo = estadoactivo;
    }

    public Long getIdlocalcentrocomercial() {
        return idlocalcentrocomercial;
    }

    public void setIdlocalcentrocomercial(Long idlocalcentrocomercial) {
        this.idlocalcentrocomercial = idlocalcentrocomercial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumerolocal() {
        return numerolocal;
    }

    public void setNumerolocal(String numerolocal) {
        this.numerolocal = numerolocal;
    }

    public boolean getEstadoactivo() {
        return estadoactivo;
    }

    public void setEstadoactivo(boolean estadoactivo) {
        this.estadoactivo = estadoactivo;
    }

    public String getNombreencargado() {
        return nombreencargado;
    }

    public void setNombreencargado(String nombreencargado) {
        this.nombreencargado = nombreencargado;
    }

    @XmlTransient
    public Collection<Trabajador> getTrabajadorCollection() {
        return trabajadorCollection;
    }

    public void setTrabajadorCollection(Collection<Trabajador> trabajadorCollection) {
        this.trabajadorCollection = trabajadorCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<GuiaCompraLocal> getGuiacompralocalCollection() {
        return guiacompralocalCollection;
    }

    public void setGuiacompralocalCollection(Collection<GuiaCompraLocal> guiacompralocalCollection) {
        this.guiacompralocalCollection = guiacompralocalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocalcentrocomercial != null ? idlocalcentrocomercial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalCentroComercial)) {
            return false;
        }
        LocalCentroComercial other = (LocalCentroComercial) object;
        if ((this.idlocalcentrocomercial == null && other.idlocalcentrocomercial != null) || (this.idlocalcentrocomercial != null && !this.idlocalcentrocomercial.equals(other.idlocalcentrocomercial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Localcentrocomercial[ idlocalcentrocomercial=" + idlocalcentrocomercial + " ]";
    }
    
}
