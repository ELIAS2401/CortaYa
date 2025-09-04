package com.cortaYa.aplicacion.dominio.dtos;

import com.cortaYa.aplicacion.infraestructura.api.ApiDireccionClient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DireccionDTO {
    private AlturaDTO altura;
    private CalleDTO calle;
}
