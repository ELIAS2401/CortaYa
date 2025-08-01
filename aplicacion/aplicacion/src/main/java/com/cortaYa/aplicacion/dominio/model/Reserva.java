package com.cortaYa.aplicacion.dominio.model;

import com.cortaYa.aplicacion.dominio.enums.EstadoReserva;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva {
    private Integer idReserva;
    private LocalDate fechaReserva; //seDebeCrearAutomaticamente
    private LocalDate fechaCorte;
    private LocalTime horario;
    private UsuarioBarber barbero;
    private UsuarioCliente cliente;
    private String comentario;
    private List<TipoDeServicio> servicios;
    private EstadoReserva estadoReserva;
}
