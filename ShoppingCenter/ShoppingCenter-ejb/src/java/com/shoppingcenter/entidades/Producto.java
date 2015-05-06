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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "producto")
@XmlRootElement
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Long idproducto;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipoproducto")
    private String tipoproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioadquisicion")
    private int precioadquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioventa")
    private int precioventa;
    @Size(max = 256)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 20)
    @Column(name = "tipoventaproducto")
    private String tipoventaproducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<Promocion> promocionCollection;
    @JoinColumn(name = "localcentrocomercial", referencedColumnName = "idlocalcentrocomercial")
    @ManyToOne(optional = false)
    private LocalCentroComercial localcentrocomercial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<ProductoCompra> productocompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<GuiaCompraProducto> guiacompraproductoCollection;

    public Producto() {
    }

    public Producto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Long idproducto, String nombre, String codigo, String tipoproducto, int precioadquisicion, int precioventa) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipoproducto = tipoproducto;
        this.precioadquisicion = precioadquisicion;
        this.precioventa = precioventa;
    }

    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
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

    public String getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(String tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public int getPrecioadquisicion() {
        return precioadquisicion;
    }

    public void setPrecioadquisicion(int precioadquisicion) {
        this.precioadquisicion = precioadquisicion;
    }

    public int getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(int precioventa) {
        this.precioventa = precioventa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoventaproducto() {
        return tipoventaproducto;
    }

    public void setTipoventaproducto(String tipoventaproducto) {
        this.tipoventaproducto = tipoventaproducto;
    }

    @XmlTransient
    public Collection<Promocion> getPromocionCollection() {
        return promocionCollection;
    }

    public void setPromocionCollection(Collection<Promocion> promocionCollection) {
        this.promocionCollection = promocionCollection;
    }

    public LocalCentroComercial getLocalcentrocomercial() {
        return localcentrocomercial;
    }

    public void setLocalcentrocomercial(LocalCentroComercial localcentrocomercial) {
        this.localcentrocomercial = localcentrocomercial;
    }

    @XmlTransient
    public Collection<ProductoCompra> getProductocompraCollection() {
        return productocompraCollection;
    }

    public void setProductocompraCollection(Collection<ProductoCompra> productocompraCollection) {
        this.productocompraCollection = productocompraCollection;
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
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
