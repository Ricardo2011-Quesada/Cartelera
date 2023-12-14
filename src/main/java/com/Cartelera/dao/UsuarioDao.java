/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Cartelera.dao;
import com.Cartelera.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    public Usuario findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena); /* metodo para validar por correo y clave*/
     public Usuario findByEstado(boolean estado); /* metodo para validar por estado y activo*/
 
}