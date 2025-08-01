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
public class Direccion {
    private Long idDireccion;
    private String nombre;
    private Integer nro;
    private Localidad localidad;
}
