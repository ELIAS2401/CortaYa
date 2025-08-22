package com.cortaYa.aplicacion.dominio.services;

import com.cortaYa.aplicacion.dominio.model.Localidad;

import java.util.List;

public interface LocalidadService {
    Localidad buscarLocalidad(Long id);

    void registrarLocalidad(Localidad localidadCliente);

    List<Localidad> obtenerLocalidades();
}
