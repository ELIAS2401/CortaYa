package com.cortaYa.aplicacion.presentacion;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.services.DireccionService;
import com.cortaYa.aplicacion.dominio.servicesImpl.LocalidadServiceImpl;
import com.cortaYa.aplicacion.infraestructura.api.ApiDireccionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DireccionController {

    private final ApiDireccionClient apiDireccionClient;
    private final DireccionService direccionService;
    private final LocalidadServiceImpl localidadService;

    @GetMapping("/api/calles")
    public List<String> obtenerCalles(
            @RequestParam Long idLocalidad,
            @RequestParam String query
    ) {
        Localidad localidad = localidadService.buscarPorId(idLocalidad);
        return direccionService.obtenerDireccionesDeTalLocalidad(localidad, query);
    }
}
