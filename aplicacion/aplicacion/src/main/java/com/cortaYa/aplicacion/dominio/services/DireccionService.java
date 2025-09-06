package com.cortaYa.aplicacion.dominio.services;

import com.cortaYa.aplicacion.dominio.model.Direccion;
import com.cortaYa.aplicacion.dominio.model.Localidad;

import java.util.List;

public interface DireccionService {
    List<String> obtenerDireccionesDeTalLocalidad(Localidad localidad, String query);

    Direccion crearNuevaDireccion(String calleAltura, Long idLocalidad);
}
