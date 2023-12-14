/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cartelera.Service;

import com.Cartelera.domain.Usuario;
import java.util.List;


public interface UsuarioService {
    public List<Usuario> getUsuario();
    public void save(Usuario usuario);
    public void delete(Usuario usuario);
    public Usuario getUsuario(Usuario usuario);
    public Usuario findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena); /* metodo para validar por correo y clave*/
    public Usuario findByEstado(boolean estado); /* metodo para validar por estado activo*/
}
