package com.cortaYa.aplicacion.dominio.model;

import com.cortaYa.aplicacion.dominio.dtos.LocalidadDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocalidad;
    private String nombre;
    private String codigoPostal;
    private Double localidadLat;
    private Double localidadLon;

    public Localidad(String nombre, String codigoPostal, Double localidadLat, Double localidadLon) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.localidadLat = localidadLat;
        this.localidadLon = localidadLon;
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
    }
}
