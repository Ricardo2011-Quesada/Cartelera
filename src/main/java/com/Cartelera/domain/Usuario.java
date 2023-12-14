/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cartelera.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;

    private String nombre;
    private String apellidos;

    @Column(name = "documento_identidad", unique = true)
    private String documentoIdentidad;

    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    private String contrasena;
    private String genero;
    private boolean estado;

    public Usuario(Long usuarioId, String nombre, String apellidos, String documentoIdentidad, String correoElectronico, Date fechaNacimiento, String contrasena, String genero, boolean estado, Set<Factura> facturas) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.genero = genero;
        this.estado = estado;
        this.facturas = facturas;
    }

    @OneToMany(mappedBy = "usuario")
    private Set<Factura> facturas;

    public Usuario() {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

}
