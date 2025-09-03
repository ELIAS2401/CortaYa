package com.cortaYa.aplicacion.dominio.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalidadResponseDTO {
    private List<LocalidadDTO> localidades;
}
