package com.cortaYa.aplicacion.dominio.repositories;

import com.cortaYa.aplicacion.dominio.model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
    Optional<Localidad> findByNombreAndCodigoPostal(String nombre, String codigoPostal);
}
