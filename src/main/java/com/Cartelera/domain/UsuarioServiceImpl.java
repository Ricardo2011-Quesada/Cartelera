/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cartelera.domain;

import com.Cartelera.Service.UsuarioService;
import com.Cartelera.dao.UsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getUsuarioId()).orElse(null);
    }    

    @Override
    public Usuario findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena) {
        return usuarioDao.findByCorreoElectronicoAndContrasena(correoElectronico, contrasena);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findByEstado(boolean estado) {
        return usuarioDao.findByEstado(estado);
    }
}
