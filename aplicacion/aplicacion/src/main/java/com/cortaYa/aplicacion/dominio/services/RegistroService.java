package com.cortaYa.aplicacion.dominio.services;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
public interface RegistroService {
    void registrarCliente(String nombre, String contrasenia, String email, Integer nroCelular, Localidad localidad);

    void registrarBarbero(String nombre, String contrasenia, String email, Integer nroCelular, Localidad localidad);
}
