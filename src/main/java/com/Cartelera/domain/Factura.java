/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cartelera.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.math.BigDecimal;
import lombok.Data;


@Data
@Entity
@Table(name = "Factura")
public class Factura implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private Long facturaId;

    @Column(name = "numero_factura", unique = true)
    private String numeroFactura;

    private BigDecimal descuento;
    private BigDecimal subtotal;
    private BigDecimal impuesto;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
        name = "Factura_Productos",
        joinColumns = @JoinColumn(name = "factura_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<Producto> productos;

    @ManyToMany
    @JoinTable(
        name = "Factura_Peliculas",
        joinColumns = @JoinColumn(name = "factura_id"),
        inverseJoinColumns = @JoinColumn(name = "pelicula_id")
    )
    private Set<Pelicula> peliculas;
    public Factura() {
    }

    public Factura(Long facturaId, String numeroFactura, BigDecimal descuento, BigDecimal subtotal, BigDecimal impuesto, BigDecimal total, Usuario usuario, Set<Producto> productos, Set<Pelicula> peliculas) {
        this.facturaId = facturaId;
        this.numeroFactura = numeroFactura;
        this.descuento = descuento;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
        this.usuario = usuario;
        this.productos = productos;
        this.peliculas = peliculas;
    }

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
   
}