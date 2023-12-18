/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity // Esta anotación indica que la clase es una entidad JPA.
@Table(name = "personas") // Esta anotación especifica el nombre de la tabla en la base de datos.
public class Persona {

    @Id // Esta anotación indica que el campo es la clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esta anotación especifica la estrategia de generación de claves primarias.
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false) // Esta anotación especifica que el campo no puede ser nulo en la base de datos.
    private String nombre;

    @NotBlank(message = "El apellido paterno no puede estar vacío")
    @Column(nullable = false)
    private String apellidoPaterno;

    // El apellido materno es opcional, por lo que no se necesita la anotación 'nullable = false'.
    private String apellidoMaterno;

    @NotBlank(message = "El campo de identificación no puede estar vacío")
    @Column(nullable = false, unique = true) // 'unique = true' indica que cada identificación debe ser única en la base de datos.
    private String identificacion;

    // Relación OneToMany con Factura
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> facturas = new ArrayList<>();
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    
}
