/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.Directorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/directorio")
public class DirectorioRestService {

    private final Directorio directorio;

    @Autowired
    public DirectorioRestService(Directorio directorio) {
        this.directorio = directorio;
    }

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> obtenerTodasPersonas() {
        List<Persona> personas = directorio.obtenerTodasPersonas();
        return ResponseEntity.ok(personas);
    }

    @PostMapping("/personas")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = directorio.guardarPersona(persona);
        return ResponseEntity.ok(nuevaPersona);
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        return directorio.obtenerPersonaPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        directorio.eliminarPersona(id);
        return ResponseEntity.ok().build();
    }
}