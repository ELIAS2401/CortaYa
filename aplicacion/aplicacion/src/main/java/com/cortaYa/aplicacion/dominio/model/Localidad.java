package com.cortaYa.aplicacion.dominio.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Localidad {
    private Long idLocalidad;
    private String nombre;
    private Integer codigoPostal;
}
