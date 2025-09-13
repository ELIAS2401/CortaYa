package com.cortaYa.aplicacion.config;

import com.cortaYa.aplicacion.dominio.dtos.LocalidadMapper;
import com.cortaYa.aplicacion.dominio.repositories.LocalidadRepository;
import com.cortaYa.aplicacion.infraestructura.api.ApiLocalidadClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoaderLocalidades {

    private final LocalidadRepository localidadRepository;
    private final ApiLocalidadClient apiLocalidadClient;

    @PostConstruct
    public void cargarLocalidades() {

        // traemos de la api y guardamos en la BD al arrancar la aplicacion
        if (localidadRepository.count() == 0) { // solo si no hay localidades
            var localidades = apiLocalidadClient.obtenerLocalidadesAMBA();
            localidadRepository.saveAll(
                    localidades.stream()
                            .map(LocalidadMapper::fromDTO)
                            .toList()
            );
            System.out.println("Localidades cargadas en la base de datos: " + localidades.size());
        }
    }
}

