package com.cortaYa.aplicacion.dominio.services;

import com.cortaYa.aplicacion.dominio.dtos.LocalidadDTO;
import com.cortaYa.aplicacion.dominio.model.Localidad;

import java.util.List;

public interface LocalidadService {
    public List<Localidad> buscarPorNombre(String nombre);
    public List<LocalidadDTO> obtenerTodasLasLocalidades();

    Localidad buscarPorId(Long localidadId);
}
