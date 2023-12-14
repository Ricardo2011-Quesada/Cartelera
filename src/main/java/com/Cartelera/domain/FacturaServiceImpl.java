/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Cartelera.domain;

import com.Cartelera.Service.FacturaService;
import com.Cartelera.dao.FacturaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> getfactura() {
        return (List<Factura>) facturaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void delete(Factura factura) {
        facturaDao.delete(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura getfactura(Factura factura) {
        return facturaDao.findById(factura.getFacturaId()).orElse(null);
    }    
}
