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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pineda
 */
@Entity
@Table(name = "productocompra")
@XmlRootElement
public class ProductoCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproductocompra")
    private Long idproductocompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valortotal")
    private long valortotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productocompra")
    private Collection<Venta> ventaCollection;
    @JoinColumn(name = "producto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto producto;

    public ProductoCompra() {
    }

    public ProductoCompra(Long idproductocompra) {
        this.idproductocompra = idproductocompra;
    }

    public ProductoCompra(Long idproductocompra, int cantidad, long valortotal) {
        this.idproductocompra = idproductocompra;
        this.cantidad = cantidad;
        this.valortotal = valortotal;
    }

    public Long getIdproductocompra() {
        return idproductocompra;
    }

    public void setIdproductocompra(Long idproductocompra) {
        this.idproductocompra = idproductocompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getValortotal() {
        return valortotal;
    }

    public void setValortotal(long valortotal) {
        this.valortotal = valortotal;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
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
        hash += (idproductocompra != null ? idproductocompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCompra)) {
            return false;
        }
        ProductoCompra other = (ProductoCompra) object;
        if ((this.idproductocompra == null && other.idproductocompra != null) || (this.idproductocompra != null && !this.idproductocompra.equals(other.idproductocompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Productocompra[ idproductocompra=" + idproductocompra + " ]";
    }

}
