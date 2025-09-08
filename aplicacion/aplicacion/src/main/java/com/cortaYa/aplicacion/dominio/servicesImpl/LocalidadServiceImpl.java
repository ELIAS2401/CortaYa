package com.cortaYa.aplicacion.dominio.servicesImpl;

import com.cortaYa.aplicacion.dominio.dtos.LocalidadDTO;
import com.cortaYa.aplicacion.dominio.dtos.LocalidadMapper;
import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.repositories.LocalidadRepository;
import com.cortaYa.aplicacion.dominio.services.LocalidadService;
import com.cortaYa.aplicacion.infraestructura.api.ApiLocalidadClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class LocalidadServiceImpl implements LocalidadService {
    private final LocalidadRepository localidadRepository;
    private final ApiLocalidadClient apiLocalidadClient;

    public List<Localidad> buscarPorNombre(String nombre) {
        return localidadRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<LocalidadDTO> obtenerTodasLasLocalidades() {
        List<LocalidadDTO> localidades = localidadRepository.findAll()
                .stream()
                .map(LocalidadMapper::toDTO)// si tenés entidad Localidad
                .toList();

        if (localidades.isEmpty()) {
            // si no hay datos en la DB, traemos de la API y guardamos
            localidades = apiLocalidadClient.obtenerLocalidadesAMBA();
            localidadRepository.saveAll(
                    localidades.stream()
                            .map(LocalidadMapper::fromDTO)
                            .toList()
            );
        }

        return localidades;
    }

    public List<Localidad> obtenerLocalidades() {
        return localidadRepository.findAll();
    }

    @Override
    public Localidad buscarPorId(Long idLocalidad) {
        return localidadRepository.findById(idLocalidad)
                .orElseThrow(() -> new RuntimeException("Localidad no encontrada"));
    }


}
