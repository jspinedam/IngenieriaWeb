/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcenter.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdventa", query = "SELECT v FROM Venta v WHERE v.idventa = :idventa"),
    @NamedQuery(name = "Venta.findByFechaventa", query = "SELECT v FROM Venta v WHERE v.fechaventa = :fechaventa"),
    @NamedQuery(name = "Venta.findByIndicativoventa", query = "SELECT v FROM Venta v WHERE v.indicativoventa = :indicativoventa"),
    @NamedQuery(name = "Venta.findBySubtotal", query = "SELECT v FROM Venta v WHERE v.subtotal = :subtotal"),
    @NamedQuery(name = "Venta.findByValoriva", query = "SELECT v FROM Venta v WHERE v.valoriva = :valoriva"),
    @NamedQuery(name = "Venta.findByTotalcompra", query = "SELECT v FROM Venta v WHERE v.totalcompra = :totalcompra"),
    @NamedQuery(name = "Venta.findByTotalganado", query = "SELECT v FROM Venta v WHERE v.totalganado = :totalganado")})
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idventa")
    private Long idventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaventa")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "indicativoventa")
    private String indicativoventa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoriva")
    private BigDecimal valoriva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalcompra")
    private BigDecimal totalcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalganado")
    private BigDecimal totalganado;
    @JoinColumn(name = "productocompra", referencedColumnName = "idproductocompra")
    @ManyToOne(optional = false)
    private ProductoCompra productocompra;
    @JoinColumn(name = "cliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long idventa) {
        this.idventa = idventa;
    }

    public Venta(Long idventa, Date fechaventa, String indicativoventa, BigDecimal subtotal, BigDecimal valoriva, BigDecimal totalcompra, BigDecimal totalganado) {
        this.idventa = idventa;
        this.fechaventa = fechaventa;
        this.indicativoventa = indicativoventa;
        this.subtotal = subtotal;
        this.valoriva = valoriva;
        this.totalcompra = totalcompra;
        this.totalganado = totalganado;
    }

    public Long getIdventa() {
        return idventa;
    }

    public void setIdventa(Long idventa) {
        this.idventa = idventa;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public String getIndicativoventa() {
        return indicativoventa;
    }

    public void setIndicativoventa(String indicativoventa) {
        this.indicativoventa = indicativoventa;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getValoriva() {
        return valoriva;
    }

    public void setValoriva(BigDecimal valoriva) {
        this.valoriva = valoriva;
    }

    public BigDecimal getTotalcompra() {
        return totalcompra;
    }

    public void setTotalcompra(BigDecimal totalcompra) {
        this.totalcompra = totalcompra;
    }

    public BigDecimal getTotalganado() {
        return totalganado;
    }

    public void setTotalganado(BigDecimal totalganado) {
        this.totalganado = totalganado;
    }

    public ProductoCompra getProductocompra() {
        return productocompra;
    }

    public void setProductocompra(ProductoCompra productocompra) {
        this.productocompra = productocompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shoppingcenter.entidades.Venta[ idventa=" + idventa + " ]";
    }
    
}
