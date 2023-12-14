/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cartelera.domain;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
@Table(name = "Productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long productoId;

    private String nombre;
    private String ruta_imagen;
    private BigDecimal precio;
    private int cantidad;

    @ManyToMany(mappedBy = "productos")
    private Set<Factura> facturas;

    public Producto() {
    }

    public Producto(Long productoId, String nombre, String ruta_imagen, BigDecimal precio, int cantidad, Set<Factura> facturas) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.ruta_imagen = ruta_imagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.facturas = facturas;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

}
