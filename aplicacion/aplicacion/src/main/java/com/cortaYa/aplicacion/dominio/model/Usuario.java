package com.cortaYa.aplicacion.dominio.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

//crean todos los setters y getters
@Getter
@Setter
@NoArgsConstructor //se agrega el constructor vacio
@AllArgsConstructor //se agrega el constructor con todos los elementos
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

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
}
