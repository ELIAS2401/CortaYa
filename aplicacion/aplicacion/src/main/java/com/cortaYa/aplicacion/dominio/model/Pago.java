package com.cortaYa.aplicacion.dominio.model;

import com.cortaYa.aplicacion.dominio.enums.TipoDePago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pago {
    private Long idPago;
    private LocalDate fechaPago;
    private LocalTime horarioPago;
    private UsuarioBarber barbero;
    private UsuarioCliente cliente;
    private Double monto;
    private TipoDePago tipoDePago;

}
