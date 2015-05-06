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
@Table(name = "guiacompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guiacompra.findAll", query = "SELECT g FROM Guiacompra g"),
    @NamedQuery(name = "Guiacompra.findByIdguiacompra", query = "SELECT g FROM Guiacompra g WHERE g.idguiacompra = :idguiacompra"),
    @NamedQuery(name = "Guiacompra.findByNombre", query = "SELECT g FROM Guiacompra g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Guiacompra.findByCodigo", query = "SELECT g FROM Guiacompra g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "Guiacompra.findByDescripcion", query = "SELECT g FROM Guiacompra g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Guiacompra.findByCaracteristicacomun", query = "SELECT g FROM Guiacompra g WHERE g.caracteristicacomun = :caracteristicacomun")})
public class GuiaCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idguiacompra")
    private Long idguiacompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 256)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 60)
    @Column(name = "caracteristicacomun")
    private String caracteristicacomun;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guiacompra")
    private Collection<GuiaCompraLocal> guiacompralocalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guiacompra")
    private Collection<GuiaCompraProducto> guiacompraproductoCollection;

    public GuiaCompra() {
    }

    public GuiaCompra(Long idguiacompra) {
        this.idguiacompra = idguiacompra;
    }

    public GuiaCompra(Long idguiacompra, String nombre, String codigo) {
        this.idguiacompra = idguiacompra;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Long getIdguiacompra() {
        return idguiacompra;
    }

    public void setIdguiacompra(Long idguiacompra) {
        this.idguiacompra = idguiacompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicacomun() {
        return caracteristicacomun;
    }

    public void setCaracteristicacomun(String caracteristicacomun) {
        this.caracteristicacomun = caracteristicacomun;
    }

    @XmlTransient
    public Collection<GuiaCompraLocal> getGuiacompralocalCollection() {
        return guiacompralocalCollection;
    }

    public void setGuiacompralocalCollection(Collection<GuiaCompraLocal> guiacompralocalCollection) {
        this.guiacompralocalCollection = guiacompralocalCollection;
    }

    @XmlTransient
    public Collection<GuiaCompraProducto> getGuiacompraproductoCollection() {
        return guiacompraproductoCollection;
    }

    public void setGuiacompraproductoCollection(Collection<GuiaCompraProducto> guiacompraproductoCollection) {
        this.guiacompraproductoCollection = guiacompraproductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idguiacompra != null ? idguiacompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaCompra)) {
            return false;
        }
        GuiaCompra other = (GuiaCompra) object;
        if ((this.idguiacompra == null && other.idguiacompra != null) || (this.idguiacompra != null && !this.idguiacompra.equals(other.idguiacompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Guiacompra[ idguiacompra=" + idguiacompra + " ]";
    }
    
}
