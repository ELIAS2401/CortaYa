package com.cortaYa.aplicacion.dominio.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;
    private String nombre;
    private Integer altura;
    @ManyToOne
    private Localidad localidad;

    public Direccion(String nombreCalle, Integer altura, Localidad localidad) {
        this.nombre = nombreCalle;
        this.altura = altura;
        this.localidad = localidad;
    }
}
