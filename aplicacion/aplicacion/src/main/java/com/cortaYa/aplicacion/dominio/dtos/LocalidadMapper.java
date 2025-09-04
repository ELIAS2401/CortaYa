package com.cortaYa.aplicacion.dominio.dtos;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import org.springframework.cglib.core.Local;

public class LocalidadMapper {
    public static LocalidadDTO toDTO(Localidad localidad) {
        return new LocalidadDTO(localidad.getIdLocalidad(), localidad.getNombre());
    }

    public static Localidad fromDTO(LocalidadDTO localidadDTO) {
        return new Localidad(localidadDTO.getNombre());
    }
}
