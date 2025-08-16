package com.cortaYa.aplicacion.dominio.services;

import com.cortaYa.aplicacion.dominio.model.Direccion;

public interface DireccionService {
    Direccion buscarDireccion(Double direccionLat, Double direccionLon);

    void registrarDireccion(Direccion direccionCliente);
}
