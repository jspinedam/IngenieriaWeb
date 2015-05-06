/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pineda
 */
@Entity
@Table(name = "promocion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p"),
    @NamedQuery(name = "Promocion.findByIdpromocion", query = "SELECT p FROM Promocion p WHERE p.idpromocion = :idpromocion"),
    @NamedQuery(name = "Promocion.findByNombre", query = "SELECT p FROM Promocion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Promocion.findByCodigo", query = "SELECT p FROM Promocion p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Promocion.findByDescripcion", query = "SELECT p FROM Promocion p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Promocion.findByFechalimite", query = "SELECT p FROM Promocion p WHERE p.fechalimite = :fechalimite"),
    @NamedQuery(name = "Promocion.findByCantidadunidades", query = "SELECT p FROM Promocion p WHERE p.cantidadunidades = :cantidadunidades")})
public class Promocion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpromocion")
    private Long idpromocion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechalimite")
    @Temporal(TemporalType.DATE)
    private Date fechalimite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadunidades")
    private int cantidadunidades;
    @JoinColumn(name = "producto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto producto;

    public Promocion() {
    }

    public Promocion(Long idpromocion) {
        this.idpromocion = idpromocion;
    }

    public Promocion(Long idpromocion, String nombre, String codigo, Date fechalimite, int cantidadunidades) {
        this.idpromocion = idpromocion;
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechalimite = fechalimite;
        this.cantidadunidades = cantidadunidades;
    }

    public Long getIdpromocion() {
        return idpromocion;
    }

    public void setIdpromocion(Long idpromocion) {
        this.idpromocion = idpromocion;
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

    public Date getFechalimite() {
        return fechalimite;
    }

    public void setFechalimite(Date fechalimite) {
        this.fechalimite = fechalimite;
    }

    public int getCantidadunidades() {
        return cantidadunidades;
    }

    public void setCantidadunidades(int cantidadunidades) {
        this.cantidadunidades = cantidadunidades;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromocion != null ? idpromocion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.idpromocion == null && other.idpromocion != null) || (this.idpromocion != null && !this.idpromocion.equals(other.idpromocion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Promocion[ idpromocion=" + idpromocion + " ]";
    }
    
}
