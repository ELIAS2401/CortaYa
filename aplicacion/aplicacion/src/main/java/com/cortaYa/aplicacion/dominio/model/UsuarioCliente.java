package com.cortaYa.aplicacion.dominio.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
public class UsuarioCliente extends Usuario{

    public boolean pagar(Double dinero){return false;}
//    public void realizarReserva(LocalDate fechaCorte, LocalTime horario, String comentario, UsuarioBarber barbero, List<TipoDeServicio> servicios){}
//    public Double calcularPrecioTotal(Double distanciaKmDeBarbero){return null;}
//    public void realizarResenia(){};

}
