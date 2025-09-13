package com.cortaYa.aplicacion.dominio.model;

import com.cortaYa.aplicacion.dominio.enums.EstadoBarbero;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
public class UsuarioBarber extends Usuario {
    private Integer puntuacionPromedio;
    private Double precioPorKilometro;
    @ElementCollection
    private List<Pago> pagosRecibidos;
    @OneToMany
    private List<TipoDeServicio> serviciosOfrecidos;
    @ElementCollection
    private Map<String, String> disponibilidad;
    private EstadoBarbero estado;

//    public void cancelarReserva(Reserva reserva){};
//    public void confirmarReserva(Reserva reserva){};
}
