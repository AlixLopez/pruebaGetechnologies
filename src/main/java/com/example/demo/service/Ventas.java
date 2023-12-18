/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Factura;
import com.example.demo.repository.FacturaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ventas {

    private final FacturaRepository facturaRepository;

    @Autowired
    public Ventas(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public List<Factura> obtenerTodasFacturas() {
        return facturaRepository.findAll();
    }

    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}