package com.cortaYa.aplicacion.dominio.servicesImpl;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.repositories.LocalidadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadSyncService {

    private final LocalidadRepository localidadRepository;

    public LocalidadSyncService(LocalidadRepository localidadRepository) {
        this.localidadRepository = localidadRepository;
    }

    @Transactional
    public void syncLocalidades(List<Localidad> localidadesApi) {
        for (Localidad apiLoc : localidadesApi) {
            // Buscar si ya existe por algún identificador único, por ejemplo nombre + código postal
            Optional<Localidad> existente = localidadRepository.findByNombreAndCodigoPostal(
                    apiLoc.getNombre(), apiLoc.getCodigoPostal());

            if (existente.isPresent()) {
                // Actualizar solo los campos que cambian
                Localidad loc = existente.get();
                loc.setLocalidadLat(apiLoc.getLocalidadLat());
                loc.setLocalidadLon(apiLoc.getLocalidadLon());
                localidadRepository.save(loc);
            } else {
                // Insertar nueva localidad
                localidadRepository.save(apiLoc);
            }
        }
    }
}

