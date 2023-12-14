package com.Cartelera.Service;

import com.Cartelera.domain.Factura;
import java.util.List;


public interface FacturaService {
    public List<Factura> getfactura();
    public void save(Factura factura);
    public void delete(Factura factura);
    public Factura getfactura(Factura factura);
 
}
