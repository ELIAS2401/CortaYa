package com.cortaYa.aplicacion.dominio.servicesImpl;

import com.cortaYa.aplicacion.dominio.model.Direccion;
import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.services.DireccionService;
import com.cortaYa.aplicacion.infraestructura.api.ApiDireccionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DireccionServiceImpl implements DireccionService {

    private final ApiDireccionClient apiDireccionClient;

    @Override
    public List<String> obtenerDireccionesDeTalLocalidad(Localidad localidad, String query) {
        return apiDireccionClient.obtenerDirecciones(localidad, query);
    }
}
