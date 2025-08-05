package com.cortaYa.aplicacion.dominio.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Map;

@Entity
public class UsuarioBarber extends UsuarioCliente {
    private Integer puntuacionPromedio;
    @ElementCollection
    private List<Pago> pagosRecibidos;
    private Double precioPorKilometro;
    @OneToMany
    private List<TipoDeServicio> serviciosOfrecidos;
    @ElementCollection
    private Map<String, String> disponibilidad;

//    public void cancelarReserva(Reserva reserva){};
//    public void confirmarReserva(Reserva reserva){};
}
