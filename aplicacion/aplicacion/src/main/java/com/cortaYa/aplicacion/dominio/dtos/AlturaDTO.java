package com.cortaYa.aplicacion.dominio.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlturaDTO {
    private Integer valor;
    private String unidad;
}
