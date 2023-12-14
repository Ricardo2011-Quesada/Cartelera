/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cartelera.domain;

import com.Cartelera.Service.PeliculaService;
import com.Cartelera.dao.PeliculaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaDao PeliculaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> getPelicula() {
        return (List<Pelicula>) PeliculaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Pelicula Pelicula) {
        PeliculaDao.save(Pelicula);
    }

    @Override
    @Transactional
    public void delete(Pelicula Pelicula) {
        PeliculaDao.delete(Pelicula);
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula getPelicula(Pelicula Pelicula) {
        return PeliculaDao.findById(Pelicula.getPeliculaId()).orElse(null);
    }    
}
