/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

/**
 *
 * @author alixn
 */

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Directorio {

    private final PersonaRepository personaRepository;

    @Autowired
    public Directorio(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> obtenerTodasPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}