package com.cortaYa.aplicacion.dominio.dtos;

import com.cortaYa.aplicacion.dominio.model.Direccion;
import com.cortaYa.aplicacion.infraestructura.api.ApiDireccionClient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DireccionResponseDTO {
    private List<DireccionDTO> direcciones;
}
