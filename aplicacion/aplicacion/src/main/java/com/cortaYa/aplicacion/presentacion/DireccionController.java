package com.cortaYa.aplicacion.presentacion;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.servicesImpl.LocalidadServiceImpl;
import com.cortaYa.aplicacion.infraestructura.api.ApiDireccionClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DireccionController {

    private final ApiDireccionClient apiDireccionClient;
    private final LocalidadServiceImpl localidadService;

    public DireccionController(ApiDireccionClient apiDireccionClient, LocalidadServiceImpl localidadService) {
        this.apiDireccionClient = apiDireccionClient;
        this.localidadService = localidadService;
    }

    @GetMapping("/api/calles")
    public List<String> obtenerCalles(
            @RequestParam Long idLocalidad,
            @RequestParam String query
    ) {
        Localidad localidad = localidadService.buscarPorId(idLocalidad);
        System.out.println(apiDireccionClient.obtenerDirecciones(localidad, query));
        return apiDireccionClient.obtenerDirecciones(localidad, query);
    }
}
