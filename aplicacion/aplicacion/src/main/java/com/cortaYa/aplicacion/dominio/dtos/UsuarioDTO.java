package com.cortaYa.aplicacion.dominio.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {
    private String nombre;
    private String email;
    private Integer nroCelular;
    private String contrasenia;
    private String confirmarContrasenia;
    private String rol;
    private String localidad;
    private Long idLocalidad;
    private String calleAltura;
    // getters y setters
}
