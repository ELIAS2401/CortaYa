package com.cortaYa.aplicacion.dominio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UsuarioCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String email;
    private Integer nroCelu;
    @OneToOne
    private Direccion direccion;
    private String contrasenia;
    @OneToMany
    private List<Reserva> reservas;

    public boolean pagar(Double dinero){return false;}
//    public void realizarReserva(LocalDate fechaCorte, LocalTime horario, String comentario, UsuarioBarber barbero, List<TipoDeServicio> servicios){}
//    public Double calcularPrecioTotal(Double distanciaKmDeBarbero){return null;}
//    public void realizarResenia(){};

}
