package com.cortaYa.aplicacion.dominio.repositories;

import com.cortaYa.aplicacion.dominio.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
