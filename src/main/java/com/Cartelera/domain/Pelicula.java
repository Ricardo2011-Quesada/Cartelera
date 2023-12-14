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
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "Peliculas")
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pelicula_id")
    private Long peliculaId;

    private String nombre;
    private String ruta_imagen;
    private Time horario;
    private Date fecha;
    private String asiento;

    @ManyToMany(mappedBy = "peliculas")
    private Set<Factura> facturas;

    public Pelicula() {
    }

    public Pelicula(Long peliculaId, String nombre, String ruta_imagen, Time horario, Date fecha, String asiento, Set<Factura> facturas) {
        this.peliculaId = peliculaId;
        this.nombre = nombre;
        this.ruta_imagen = ruta_imagen;
        this.horario = horario;
        this.fecha = fecha;
        this.asiento = asiento;
        this.facturas = facturas;
    }

    public Long getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Long peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Time getHorario() {
        return horario;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

}
