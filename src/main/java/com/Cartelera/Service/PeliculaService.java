package com.Cartelera.Service;

import com.Cartelera.domain. Pelicula;
import java.util.List;


public interface PeliculaService {
    public List<Pelicula> getPelicula();
    public void save(Pelicula pelicula);
    public void delete(Pelicula pelicula);
    public Pelicula getPelicula(Pelicula pelicula);  
}
