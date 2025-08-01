package com.cortaYa.aplicacion.dominio.model;

import com.cortaYa.aplicacion.dominio.enums.EstadoReserva;
import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    private LocalDate fechaReserva; //seDebeCrearAutomaticamente
    private LocalDate fechaCorte;
    private LocalTime horario;
    @ManyToOne
    private UsuarioBarber barbero;
    @ManyToOne
    private UsuarioCliente cliente;
    private String comentario;
    @OneToMany
    private List<TipoDeServicio> servicios;
    private EstadoReserva estadoReserva;
}
