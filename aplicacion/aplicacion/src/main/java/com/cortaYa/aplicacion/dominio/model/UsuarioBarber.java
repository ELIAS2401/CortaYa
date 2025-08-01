package com.cortaYa.aplicacion.dominio.model;

import jakarta.persistence.Entity;

import java.util.List;
import java.util.Map;

@Entity
public class UsuarioBarber extends Usuario{
    private Integer puntuacionPromedio;
    private List<Pago> pagosRecibidos;
    private Double precioPorKilometro;
    private List<TipoDeServicio> serviciosOfrecidos;
    private Map<String, String> disponibilidad;

//    public void cancelarReserva(Reserva reserva){};
//    public void confirmarReserva(Reserva reserva){};
}
