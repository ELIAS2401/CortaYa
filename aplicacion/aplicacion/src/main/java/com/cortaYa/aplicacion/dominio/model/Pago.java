package com.cortaYa.aplicacion.dominio.model;

import com.cortaYa.aplicacion.dominio.enums.TipoDePago;
import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;
    private LocalDate fechaPago;
    private LocalTime horarioPago;
    @ManyToOne
    private UsuarioBarber barbero;
    @ManyToOne
    private UsuarioCliente cliente;
    private Double monto;
    private TipoDePago tipoDePago;
}
