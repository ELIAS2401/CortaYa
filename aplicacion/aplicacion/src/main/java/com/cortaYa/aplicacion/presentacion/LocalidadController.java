package com.cortaYa.aplicacion.presentacion;

import com.cortaYa.aplicacion.dominio.dtos.LocalidadDTO;
import com.cortaYa.aplicacion.dominio.services.LocalidadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocalidadController {

    private final LocalidadService localidadService;

    public LocalidadController(LocalidadService localidadService) {
        this.localidadService = localidadService;
    }

    @GetMapping("/localidades")
    public List<LocalidadDTO> obtenerLocalidades() {
        return localidadService.obtenerTodasLasLocalidades();
    }
}
