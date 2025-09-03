package com.cortaYa.aplicacion.dominio.repositories;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import com.cortaYa.aplicacion.dominio.services.LocalidadService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
    List<Localidad> findByNombreContainingIgnoreCase(String nombre);

    Optional<Localidad> findByNombreAndCodigoPostal(String nombre, String codigoPostal);
}
