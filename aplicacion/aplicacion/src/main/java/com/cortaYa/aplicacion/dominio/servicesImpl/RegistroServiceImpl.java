package com.cortaYa.aplicacion.dominio.servicesImpl;

import com.cortaYa.aplicacion.dominio.model.Direccion;
import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.services.RegistroService;
import org.springframework.stereotype.Service;

@Service
public class RegistroServiceImpl implements RegistroService {


    @Override
    public void registrarCliente(String nombre, String contrasenia, String email, Integer nroCelular, Localidad localidad, Direccion direccion) {

    }

    @Override
    public void registrarBarbero(String nombre, String contrasenia, String email, Integer nroCelular, Localidad localidad, Direccion direccion) {

    }
}
