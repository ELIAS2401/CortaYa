package com.cortaYa.aplicacion.dominio.servicesImpl;

import com.cortaYa.aplicacion.dominio.model.Direccion;
import com.cortaYa.aplicacion.dominio.services.DireccionService;
import org.springframework.stereotype.Service;

@Service
public class DireccionServiceImpl implements DireccionService {
    @Override
    public Direccion buscarDireccion(Double direccionLat, Double direccionLon) {
        return null;
    }

    @Override
    public void registrarDireccion(Direccion direccionCliente) {

    }
}
