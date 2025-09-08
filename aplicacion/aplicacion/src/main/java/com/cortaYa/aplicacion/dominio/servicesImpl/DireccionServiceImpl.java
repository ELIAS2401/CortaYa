package com.cortaYa.aplicacion.dominio.servicesImpl;

import com.cortaYa.aplicacion.dominio.model.Direccion;
import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.repositories.DireccionRepository;
import com.cortaYa.aplicacion.dominio.repositories.LocalidadRepository;
import com.cortaYa.aplicacion.dominio.services.DireccionService;
import com.cortaYa.aplicacion.dominio.services.LocalidadService;
import com.cortaYa.aplicacion.infraestructura.api.ApiDireccionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Collections.replaceAll;

@Transactional
@Service
@RequiredArgsConstructor
public class DireccionServiceImpl implements DireccionService {

    private final ApiDireccionClient apiDireccionClient;
    private final DireccionRepository direccionRepository;
    private final LocalidadService localidadService;

    @Override
    public List<String> obtenerDireccionesDeTalLocalidad(Localidad localidad, String query) {
        return apiDireccionClient.obtenerDirecciones(localidad, query);
    }

    @Override
    public Direccion crearNuevaDireccion(String calleAltura, Long idLocalidad) {
        String nombreCalle = calleAltura.replaceAll("[^a-zA-Z]", "");
        Integer altura = Integer.valueOf(calleAltura.replaceAll("[^0-9]", ""));
        Localidad localidad = localidadService.buscarPorId(idLocalidad);
        Direccion direccion = new Direccion(nombreCalle, altura, localidad);
        direccionRepository.save(direccion);
        return direccion;
    }
}
