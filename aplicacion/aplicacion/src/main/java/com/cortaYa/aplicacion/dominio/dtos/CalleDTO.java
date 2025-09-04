package com.cortaYa.aplicacion.dominio.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalleDTO {
    private String id;
    private String nombre;
    private String categoria;
}
